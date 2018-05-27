import db_connection
import subprocess
import os
import sys
from time import sleep
import time


class SubmitProcessor:
    def __init__(self, working_directory):
        """
        :param working_directory: IMPORTANT: User running SubmitProcessor must have read/write permissions to working_directory
        """
        self.working_directory = working_directory

    def process_submit(self, submit_id, problem_id):
        """
        :param submit_id: integer field from database
        :param problem_id: integer field from database
        :return: None
        """
        is_transaction_committed = self.wait_for_submit_transaction_commit(submit_id)
        if not is_transaction_committed:
            return
        directory = os.path.join(self.working_directory, str(submit_id))
        if os.path.exists(directory):
            self.remove_directory_with_source(directory)
        os.makedirs(directory)
        self.create_a_file(directory, submit_id)
        compilation_outcome = self.compile_java(directory)
        self.save_compilation_outcome_to_submit(compilation_outcome, submit_id)
        compilation_return_code = compilation_outcome[0]
        if compilation_return_code != 0:
            self.remove_directory_with_source(directory)
            return
        self.run_tests_java(directory, problem_id, submit_id)
        self.remove_directory_with_source(directory)
        self.set_submit_as_processed_in_database(submit_id)
        self.increment_problem_number_of_accepted_solutions(problem_id, submit_id)

    def wait_for_submit_transaction_commit(self, submit_id):
        """
        :param submit_id: integer field from database
        :return: True if transaction committed, False if not
        """
        conn = db_connection.get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        query = 'SELECT id FROM get_unprocessed_submit(%s);'
        transaction_committed = False
        endless_loop_protection = 100
        result = []
        while not transaction_committed and endless_loop_protection > 0:
            cur.execute(query, (submit_id,))
            result = cur.fetchall()
            if result is True:
                transaction_committed = True
            endless_loop_protection -= 1
            sleep(0.1)
        conn.close()
        if endless_loop_protection == 0 and not result:
            return False
        return True

    def create_a_file(self, directory, unprocessed_submit_id):
        """
        :param directory: Directory to process particular submit in.
        :param unprocessed_submit_id: integer field from database
        :return: None
        """
        java_file_path = os.path.join(directory, 'Main.java')
        file = open(java_file_path, mode='w+', encoding='utf-8')
        conn = db_connection.get_connection()
        cur = conn.cursor()
        query = 'SELECT _code_content FROM get_code_content_from_submit(%s);'
        cur.execute(query, (unprocessed_submit_id,))
        code_content = cur.fetchall()[0][0]
        conn.close()
        file.write(code_content)
        file.close()

    def compile_java(self, directory):
        """
        javac must be in PATH environment variable
        :param directory: Directory to process particular submit in.
        :return: Tuple (return_code, stdout, stderr)
        """
        java_file_path = os.path.join(directory, 'Main.java')
        if sys.platform == 'win32':
            time_now = time.clock
        else:
            time_now = time.time
        t0 = time_now()
        process = subprocess.Popen(['javac', java_file_path], encoding='utf-8', stdout=subprocess.PIPE,
                                   stderr=subprocess.PIPE)
        process.wait()
        t1 = time_now()
        compilation_time = t1 - t0
        compilation_time_ms = int(round(compilation_time * 1000))
        process_return_code = process.returncode
        stdout, stderr = process.communicate()
        return process_return_code, stdout, stderr, compilation_time_ms

    def run_tests_java(self, directory, problem_id, submit_id):
        """
        java must be in PATH environment variable
        """
        tests = self.get_tests(problem_id)
        if sys.platform == 'win32':
            time_now = time.clock
        else:
            time_now = time.time
        for test in tests:
            test_id, test_input, maximum_execution_time_ms = test
            maximum_execution_time_sec = round(maximum_execution_time_ms/1000)
            t0 = time_now()
            process = subprocess.Popen(['java', 'Main'], cwd=directory, encoding='utf-8', stdin=subprocess.PIPE,
                                       stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            try:
                stdout, stderr = process.communicate(input=test_input, timeout=maximum_execution_time_sec)
                process_return_code = process.returncode
            except subprocess.TimeoutExpired:
                process.kill()
                stdout = process.stdout.read()
                stderr = process.stderr.read()
                process_return_code = -1

            t1 = time_now()
            execution_time = t1 - t0
            execution_time_ms = int(round(execution_time * 1000))
            test_outcome = (process_return_code, stdout, stderr, execution_time_ms)
            self.save_test_outcome_to_submit_result(submit_id, test_id, test_outcome)

    def save_compilation_outcome_to_submit(self, compilation_outcome, submit_id):
        conn = db_connection.get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        compilation_return_code, compilation_stdout, compilation_stderr, compilation_time_ms = compilation_outcome
        query = """UPDATE submit
                   SET compilation_return_code = %s,
                       compilation_stdout = %s,
                       compilation_stderr = %s,
                       compilation_time_ms = %s
                   WHERE id = %s;"""
        cur.execute(query,
                    (compilation_return_code, compilation_stdout, compilation_stderr, compilation_time_ms, submit_id))
        conn.close()

    def save_test_outcome_to_submit_result(self, submit_id, test_id, test_outcome):
        conn = db_connection.get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        execution_error_code, execution_stdout, execution_stderr, execution_time_ms = test_outcome
        query = """INSERT INTO submit_result (submit_id, test_id, execution_return_code, execution_stdout, execution_stderr, execution_time_ms)
            VALUES (%s, %s, %s, %s, %s, %s);"""
        cur.execute(query,
                    (submit_id, test_id, execution_error_code, execution_stdout, execution_stderr, execution_time_ms))
        conn.close()

    def remove_directory_with_source(self, directory):
        java_file_path = os.path.join(directory, "Main.java")
        class_file_path = os.path.join(directory, "Main.class")
        os.remove(java_file_path)
        os.remove(class_file_path)
        os.rmdir(directory)

    def get_tests(self, problem_id):
        conn = db_connection.get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        query = """SELECT
                 id,
                 input, maximum_execution_time_ms
               FROM test
               WHERE problem_id = %s;"""
        cur.execute(query, (problem_id,))
        tests = cur.fetchall()
        conn.close()
        return tests

    def set_submit_as_processed_in_database(self, submit_id):
        conn = db_connection.get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        query = 'SELECT set_submit_as_processed(%s);'
        cur.execute(query, (submit_id,))
        conn.close()

    def increment_problem_number_of_accepted_solutions(self, problem_id, submit_id):
        conn = db_connection.get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        cur.callproc('increment_problem_number_of_accepted_solutions', (problem_id, submit_id))
        conn.close()

import db_connection
import subprocess
import os
from time import sleep


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
        file = open(directory + '/Main.java', mode='w+', encoding='utf-8')
        conn = db_connection.get_connection()
        cur = conn.cursor()
        query = 'SELECT _code_content FROM get_code_content_from_submit(%s);'
        cur.execute(query, (unprocessed_submit_id,))
        code_content = cur.fetchall()[0][0]
        conn.close()
        file.write(code_content)

    def compile_java(self, directory):
        """
        javac must be in PATH environment variable
        :param directory: Directory to process particular submit in.
        :return: Tuple (return_code, stdout, stderr)
        """
        process = subprocess.Popen(['javac', directory + '/Main.java'], encoding='utf-8', stdout=subprocess.PIPE,
                                   stderr=subprocess.PIPE)
        process.wait()
        process_return_code = process.returncode
        stdout, stderr = process.communicate()

        return process_return_code, stdout, stderr

    def run_tests_java(self, directory, problem_id, submit_id):
        """
        java must be in PATH environment variable
        """
        tests = self.get_tests(problem_id)
        for test in tests:
            test_id, test_input = test
            process = subprocess.Popen(['java', 'Main'], cwd=directory, encoding='utf-8', stdin=subprocess.PIPE,
                                       stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            stdout, stderr = process.communicate(input=test_input)
            process.wait()
            process_return_code = process.returncode
            test_outcome = (process_return_code, stdout, stderr)
            self.save_test_outcome_to_submit_result(submit_id, test_id, test_outcome)

    def save_compilation_outcome_to_submit(self, compilation_outcome, submit_id):
        conn = db_connection.get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        compilation_return_code, compilation_stdout, compilation_stderr = compilation_outcome
        query = 'SELECT save_compilation_outcome_to_submit(%s,%s,%s,%s);'
        cur.execute(query, (compilation_return_code, compilation_stdout, compilation_stderr, submit_id))
        conn.close()

    def save_test_outcome_to_submit_result(self, submit_id, test_id, test_outcome):
        conn = db_connection.get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        execution_error_code, execution_stdout, execution_stderr = test_outcome

        query = 'SELECT save_test_outcome_to_submit_result(%s, %s, %s, %s, %s);'
        cur.execute(query, (submit_id, test_id, execution_error_code, execution_stdout, execution_stderr))
        conn.close()

    def remove_directory_with_source(self, directory):
        os.remove(directory + "/Main.java")
        os.remove(directory + "/Main.class")
        os.rmdir(directory)

    def get_tests(self, problem_id):
        conn = db_connection.get_connection()
        conn.autocommit = True
        cur = conn.cursor()
        query = 'SELECT _id, _input FROM get_test(%s);'
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
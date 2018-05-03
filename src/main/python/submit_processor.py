import db_connection
import subprocess
import os


class SubmitProcessor:

    def get_unprocessed_submits(self):
        conn = db_connection.get_connection()
        cur = conn.cursor()
        query = 'SELECT id, problem_id FROM submit WHERE processed IS NOT TRUE;'
        cur.execute(query)

        unprocessed_submits = cur.fetchall()
        conn.commit()
        conn.close()
        print('uprocessed submits')
        print(unprocessed_submits)
        return unprocessed_submits

    def process_submits(self, unprocessed_submits):
        for unprocessed_submit in unprocessed_submits:
            submit_id = unprocessed_submit[0]
            problem_id = unprocessed_submit[1]
            os.makedirs(str(submit_id))
            directory = './' + str(submit_id)
            self.create_a_file(directory, submit_id)
            compilation_outcome = self.compile_java(directory)
            self.save_compilation_outcome_to_database(compilation_outcome, submit_id)
            compilation_return_code = compilation_outcome[0]

            if compilation_return_code != 0:
                self.remove_directory_with_source(directory)
                return
            self.run_tests_java(directory, problem_id, submit_id)
            self.remove_directory_with_source(directory)

    def create_a_file(self, directory, unprocessed_submit_id):
        file = open(directory + '/Main.java', mode='w+', encoding='utf-8')
        conn = db_connection.get_connection()
        cur = conn.cursor()
        query = 'SELECT code_content FROM submit WHERE id = ' + str(unprocessed_submit_id)
        cur.execute(query)
        code_content = cur.fetchall()[0][0]
        conn.close()
        file.write(code_content)

    def compile_java(self, directory):
        process = subprocess.Popen(['javac', directory + '/Main.java'], encoding='utf-8', stdout=subprocess.PIPE,
                                   stderr=subprocess.PIPE)
        process.wait()
        process_return_code = process.returncode
        stdout, stderr = process.communicate()

        return process_return_code, stdout, stderr

    def run_tests_java(self, directory, problem_id, submit_id):
        tests = self.get_tests(problem_id)
        for test in tests:
            print(test)
            test_id, test_input = test
            process = subprocess.Popen(['java', 'Main'], cwd=directory, encoding='utf-8', stdin=subprocess.PIPE,
                                       stdout=subprocess.PIPE, stderr=subprocess.PIPE)

            stdout, stderr = process.communicate(input=test_input)
            process.wait()
            process_return_code = process.returncode
            test_outcome = (process_return_code, stdout, stderr)
            self.save_test_outcome_to_submit_results(submit_id, test_id, test_outcome)
            # return process_return_code, stdout, stderr

    def save_compilation_outcome_to_database(self, compilation_outcome, submit_id):
        conn = db_connection.get_connection()
        cur = conn.cursor()
        compilation_return_code, compilation_stdout, compilation_stderr = compilation_outcome
        query = "UPDATE submit SET compilation_return_code = " + str(
            compilation_return_code) + ", compilation_stdout = \'" + compilation_stdout + "\', compilation_stderr = \'" + compilation_stderr + "\' WHERE id = " + str(
            submit_id) + ";"
        cur.execute(query)
        conn.commit()
        conn.close()

    def save_test_outcome_to_submit_results(self, submit_id, test_id, test_outcome):
        conn = db_connection.get_connection()
        cur = conn.cursor()
        execution_error_code, execution_stdout, execution_stderr = test_outcome

        query = "INSERT INTO submit_result (submit_id, test_id, execution_return_code, execution_stdout, execution_stderr) VALUES ({0:d}, {1:d}, {2:d}, '{3:s}', '{4:s}')".format(
            submit_id, test_id, execution_error_code, execution_stdout, execution_stderr)
        cur.execute(query)
        conn.commit()
        conn.close()

    def remove_directory_with_source(self, directory):
        os.remove(directory + "/Main.java")
        os.remove(directory + "/Main.class")
        os.rmdir(directory)

    def get_tests(self, problem_id):
        conn = db_connection.get_connection()
        cur = conn.cursor()
        query = 'SELECT id, input FROM test WHERE problem_id = ' + str(problem_id) + ';'
        cur.execute(query)
        tests = cur.fetchall()
        conn.commit()
        conn.close()
        return tests

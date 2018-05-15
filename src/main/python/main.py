from submit_processor import SubmitProcessor
import sys


def main():
    working_directory = sys.argv[3]
    submit_processor = SubmitProcessor(working_directory)
    submit_id = sys.argv[1]
    problem_id = sys.argv[2]
    submit_processor.process_submit(submit_id, problem_id)


if __name__ == "__main__":
    main()

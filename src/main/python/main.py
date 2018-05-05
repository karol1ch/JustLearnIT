from submit_processor import SubmitProcessor
import sys

def main():
    submit_processor = SubmitProcessor()
    submit_id = sys.argv[1]
    problem_id = sys.argv[2]
    submit_processor.process_submit(submit_id, problem_id)


if __name__ == "__main__":
    main()

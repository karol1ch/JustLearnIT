import subprocess
import psycopg2
import sys
from submit_processor import SubmitProcessor



def main():
    # for x in sys.path:
    #    print (x)
    submit_processor = SubmitProcessor()

    unprocessed_submits = submit_processor.get_unprocessed_submits()
    submit_processor.process_submits(unprocessed_submits)

    # print('uprocessed submits:')
    # print(unprocessed_submits)


if __name__ == "__main__":
    main()

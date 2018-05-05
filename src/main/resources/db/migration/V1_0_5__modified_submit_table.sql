ALTER TABLE public.problem
  DROP COLUMN category;

ALTER TABLE public.category DROP COLUMN id;

ALTER TABLE public.category
  ADD PRIMARY KEY (name);

ALTER TABLE public.problem
  ADD COLUMN category_name character varying(50) REFERENCES public.category(name);

ALTER TABLE public.available_programming_language
  DROP COLUMN programming_language_id;

ALTER TABLE public.submit
  DROP COLUMN programming_language_id,
  DROP COLUMN compiler_output;

ALTER TABLE public.programming_language
  DROP COLUMN id;

ALTER TABLE programming_language
  ADD PRIMARY KEY (name);

ALTER TABLE public.available_programming_language
  ADD COLUMN programming_language_name character varying(50) REFERENCES public.programming_language(name);

ALTER TABLE public.available_programming_language
  ADD PRIMARY KEY (problem_id, programming_language_name);

ALTER TABLE public.submit
  ADD COLUMN programming_language_name character varying(50) REFERENCES public.programming_language(name);


ALTER TABLE public.submit
  RENAME COLUMN pending TO processed;

ALTER TABLE public.submit
  ALTER COLUMN processed SET NOT NULL,
  ADD COLUMN code_content character varying,
  ADD COLUMN compilation_return_code integer,
  ADD COLUMN compilation_stdout character varying,
  ADD COLUMN compilation_stderr character varying,
  ALTER COLUMN code_content SET NOT NULL,
  ALTER COLUMN problem_id SET NOT NULL,
  ALTER COLUMN author SET NOT NULL,
  ALTER COLUMN programming_language_name SET NOT NULL;

ALTER TABLE public.problem
  ALTER COLUMN author SET NOT NULL,
  ALTER COLUMN category_name SET NOT NULL;

ALTER TABLE public.test
  ALTER COLUMN problem_id SET NOT NULL;

ALTER TABLE public.submit_result
  DROP COLUMN output,
  ALTER COLUMN is_correct DROP NOT NULL,
  ADD COLUMN execution_return_code integer,
  ADD COLUMN execution_stdout character varying,
  ADD COLUMN execution_stderr character varying;

CREATE OR REPLACE FUNCTION submit_result_evaluate_if_test_passed() RETURNS trigger AS $$
  BEGIN
    IF NEW.execution_stdout = (SELECT output FROM test t WHERE t.id = NEW.test_id)
    THEN
        NEW.is_correct := true;
    ELSE
        NEW.is_correct := false;
    END IF;
  RETURN NEW;
  END
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER submit_result_insert_trigger
BEFORE INSERT ON submit_result
FOR EACH ROW
EXECUTE PROCEDURE submit_result_evaluate_if_test_passed();


--CREATE PROCEDURAL LANGUAGE 'plpythonu' HANDLER plpython_call_handler;

CREATE EXTENSION IF NOT EXISTS plpythonu;

CREATE OR REPLACE FUNCTION run_submit_processor_py(submit_id integer, problem_id integer)
  RETURNS void AS $$
import subprocess
python_path = '/home/addme/IdeaProjects/justlearnit_us0005/venv/bin/python3.6'
submit_processor_path = '/home/addme/IdeaProjects/justlearnit_us0005/src/main/python/main.py'
parameter1 = str(submit_id)
parameter2 = str(problem_id)
process = subprocess.Popen([python_path, submit_processor_path, parameter1, parameter2 ], stdin=None, stdout=None, stderr=None, close_fds=True)
$$ LANGUAGE plpythonu;


CREATE OR REPLACE FUNCTION run_submit_processor_function() RETURNS trigger AS $$
BEGIN
  PERFORM run_submit_processor_py(NEW.id, NEW.problem_id);
  RETURN NEW;
END
$$ LANGUAGE 'plpgsql';


CREATE CONSTRAINT TRIGGER run_submit_processor_py
  AFTER INSERT ON submit
  DEFERRABLE INITIALLY IMMEDIATE
  FOR EACH ROW
  EXECUTE PROCEDURE run_submit_processor_function();


INSERT INTO programming_language (name)
  VALUES ('Java'), ('C++');



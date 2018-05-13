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
  DROP COLUMN programming_language_id;

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
  ADD COLUMN code_content character varying(50000),
  ADD COLUMN compilation_return_code INTEGER,
  ADD COLUMN compilation_stdout character varying(50000),
  ADD COLUMN compilation_stderr character varying(50000),
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
  ADD COLUMN execution_return_code INTEGER,
  ADD COLUMN execution_stdout character varying(50000),
  ADD COLUMN execution_stderr character varying(50000);

--CREATE OR REPLACE TRIGGER

INSERT INTO programming_language (name)
  VALUES ('Java'), ('C++');



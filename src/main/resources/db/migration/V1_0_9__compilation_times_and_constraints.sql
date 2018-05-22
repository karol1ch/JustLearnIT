ALTER TABLE test
  ADD COLUMN maximum_execution_time_ms INTEGER NOT NULL DEFAULT 10000;


CREATE TABLE submit_result_status (
  name character varying NOT NULL PRIMARY KEY
);

INSERT INTO submit_result_status (name)
VALUES ('Passed'), ('Wrong answer'), ('Time limit exceeded'), ('Runtime error');

ALTER TABLE submit
  ADD COLUMN compilation_time_ms integer;

ALTER TABLE submit_result
  ADD COLUMN execution_time_ms integer,
  ADD COLUMN status character varying NOT NULL REFERENCES submit_result_status (name);

CREATE OR REPLACE FUNCTION submit_result_evaluate_status()
  RETURNS trigger AS $$
BEGIN
  IF NEW.execution_time_ms > (SELECT maximum_execution_time_ms
                                 FROM test
                                 where test.id = NEW.test_id)
    THEN
      NEW.status := 'Time limit exceeded';
  ELSIF NEW.execution_return_code != 0
    THEN
      NEW.status := 'Runtime error';
  ELSIF NEW.execution_stdout = (SELECT output
                             FROM test t
                             WHERE t.id = NEW.test_id)
  THEN
    NEW.status := 'Passed';
  ELSE
    NEW.status := 'Wrong answer';
  END IF;
  RETURN NEW;
END
$$
LANGUAGE 'plpgsql';

DROP TRIGGER submit_result_insert_trigger
ON public.submit_result;

DROP FUNCTION submit_result_evaluate_if_test_passed();

CREATE TRIGGER submit_result_insert_trigger
  BEFORE INSERT
  ON submit_result
  FOR EACH ROW
EXECUTE PROCEDURE submit_result_evaluate_status();

ALTER TABLE submit_result
  DROP COLUMN is_correct;

DROP FUNCTION save_compilation_outcome_to_submit( integer, character varying, character varying, integer );
DROP FUNCTION save_test_outcome_to_submit_result ( integer, integer, integer, character varying, character varying );
DROP FUNCTION get_test( integer );

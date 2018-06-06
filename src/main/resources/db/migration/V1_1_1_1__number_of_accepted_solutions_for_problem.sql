CREATE OR REPLACE FUNCTION increment_problem_number_of_accepted_solutions(
  _problem_id integer,
  _submit_id  integer
)
  RETURNS void AS $$
DECLARE
  how_many_accepted_tests integer := 0;
  how_many_tests          integer := 0;
BEGIN
  SELECT count(*)
  FROM submit_result sr
  WHERE sr.submit_id = _submit_id AND status = 'Passed'
  INTO how_many_accepted_tests;

  SELECT count(*)
  FROM test t
  WHERE t.problem_id = _problem_id
  INTO how_many_tests;

  IF how_many_tests = how_many_accepted_tests
  THEN
    UPDATE problem
    SET number_of_accepted_solutions = number_of_accepted_solutions + 1
    WHERE id = _problem_id;
  END IF;
END
$$
LANGUAGE 'plpgsql';
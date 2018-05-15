ALTER TABLE public.problem
  ADD COLUMN input_description VARCHAR NOT NULL,
  ADD COLUMN output_description VARCHAR NOT NULL,
  ADD COLUMN number_of_accepted_solutions INT NOT NULL DEFAULT(0),
  ADD COLUMN difficulty VARCHAR(10) NOT NULL;

ALTER TABLE public.category
  ADD COLUMN description VARCHAR NOT NULL;
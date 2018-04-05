CREATE SEQUENCE person_seq;
CREATE TABLE person
(
  id integer NOT NULL DEFAULT nextval('person_seq'),
  first_name character varying (255),
  last_name character varying (255),
  date_of_birth date,
  password character varying(255),
  username character varying(255),
  CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO person (first_name, last_name, username, password) VALUES ('Dawid', 'Dudek', 'dawid', 'dawid');
INSERT INTO person (first_name, last_name, username, password) VALUES ('Marcin', 'Holota', 'marcin', 'marcin');
INSERT INTO person (first_name, last_name, username, password) VALUES ('Karol', 'Chomoncik', 'karol', 'karol');
INSERT INTO person (first_name, last_name, username, password) VALUES ('Szymon', 'Smykała', 'szymon', 'szymon');
INSERT INTO person (first_name, last_name, username, password) VALUES ('Antonina', 'Moskal', 'tonia', 'tonia');
CREATE SEQUENCE programming_language_seq;

CREATE TABLE programming_language
(
  id INTEGER DEFAULT nextval('programming_language_seq') PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);


CREATE SEQUENCE category_seq;

CREATE TABLE category
(
  id INTEGER DEFAULT nextval('category_seq') PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);


CREATE SEQUENCE problem_seq;

CREATE TABLE problem
(
  id INTEGER NOT NULL DEFAULT nextval('problem_seq') PRIMARY KEY,
  name VARCHAR (50) NOT NULL,
  author VARCHAR(50) REFERENCES users(username),
  category INTEGER REFERENCES category(id),
  content VARCHAR NOT NULL
);


CREATE TABLE available_programming_language
(
  problem_id INTEGER REFERENCES problem(id),
  programming_language_id INTEGER REFERENCES  programming_language(id),
  PRIMARY KEY (problem_id, programming_language_id)
);


CREATE SEQUENCE test_seq;

CREATE TABLE test
(
  id INTEGER DEFAULT nextval('test_seq') PRIMARY KEY,
  problem_id INTEGER REFERENCES problem(id),
  number INTEGER NOT NULL,
  is_open BOOLEAN NOT NULL DEFAULT FALSE,
  input VARCHAR NOT NULL,
  output VARCHAR NOT NULL
);


CREATE SEQUENCE submit_seq;

CREATE TABLE submit
(
  id INTEGER NOT NULL DEFAULT nextval('submit_seq') PRIMARY KEY,
  author VARCHAR(50) REFERENCES users(username),
  problem_id INTEGER REFERENCES problem(id),
  received_time TIMESTAMP WITHOUT TIME ZONE DEFAULT (CURRENT_TIMESTAMP AT TIME ZONE 'UTC'),
  pending BOOLEAN DEFAULT FALSE,
  compiler_output VARCHAR,
  programming_language_id INTEGER REFERENCES programming_language(id)
);


CREATE TABLE submit_result
(
  submit_id INTEGER REFERENCES submit(id),
  test_id INTEGER REFERENCES test(id),
  output VARCHAR NOT NULL,
  is_correct BOOLEAN NOT NULL,
  PRIMARY KEY (submit_id, test_id)
);


CREATE SEQUENCE programming_languages_seq;
CREATE TABLE programming_languages
(
  id INTEGER DEFAULT nextval('programming_languages_seq') PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE SEQUENCE categories_seq;
CREATE TABLE categories
(
  id INTEGER DEFAULT nextval('categories_seq') PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE SEQUENCE problems_seq;
CREATE TABLE problems
(
  id INTEGER NOT NULL DEFAULT nextval('problems_seq') PRIMARY KEY,
  name VARCHAR (50) NOT NULL,
  author VARCHAR(50) REFERENCES users(username),
  category INTEGER REFERENCES categories(id),
  content VARCHAR NOT NULL
);

CREATE TABLE available_programming_languages
(
  problem_id INTEGER REFERENCES problems(id),
  programming_language_id INTEGER REFERENCES  programming_languages(id),
  PRIMARY KEY (problem_id, programming_language_id)
);

CREATE SEQUENCE tests_seq;
CREATE TABLE tests
(
  id INTEGER DEFAULT nextval('tests_seq') PRIMARY KEY,
  problem_id INTEGER REFERENCES problems(id),
  number INTEGER NOT NULL,
  is_open BOOLEAN NOT NULL DEFAULT FALSE,
  input VARCHAR NOT NULL,
  output VARCHAR NOT NULL
);

CREATE SEQUENCE submits_seq;
CREATE TABLE submits
(
  id INTEGER NOT NULL DEFAULT nextval('submits_seq') PRIMARY KEY,
  author VARCHAR(50) REFERENCES users(username),
  problem_id INTEGER REFERENCES problems(id),
  received_time TIMESTAMP WITHOUT TIME ZONE DEFAULT (CURRENT_TIMESTAMP AT TIME ZONE 'UTC'),
  pending BOOLEAN DEFAULT FALSE,
  compiler_output VARCHAR,
  programming_language_id INTEGER REFERENCES programming_languages(id)
);

CREATE TABLE submits_results
(
  submit_id INTEGER REFERENCES submits(id),
  test_id INTEGER REFERENCES tests(id),
  output VARCHAR NOT NULL,
  is_correct BOOLEAN NOT NULL,
  PRIMARY KEY (submit_id, test_id)
);


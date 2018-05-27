CREATE SEQUENCE topic_seq;
CREATE TABLE topic
(
    id INTEGER NOT NULL DEFAULT nextval('topic_seq') PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    category_name VARCHAR(50) REFERENCES category(name),
    theory VARCHAR NOT NULL
);

CREATE SEQUENCE code_example_seq;
CREATE TABLE code_example
(
    id INTEGER NOT NULL DEFAULT nextval('code_example_seq') PRIMARY KEY,
    topic_id INTEGER REFERENCES topic(id),
    code_content VARCHAR NOT NULL,
    code_explanation VARCHAR NOT NULL
);

CREATE SEQUENCE test_question_seq;
CREATE TABLE test_question
(
    id INTEGER NOT NULL DEFAULT nextval('test_question_seq') PRIMARY KEY,
    topic_id INTEGER REFERENCES topic(id),
    question VARCHAR NOT NULL,
    answer_a VARCHAR NOT NULL,
    answer_b VARCHAR NOT NULL,
    answer_c VARCHAR NOT NULL,
    answer_d VARCHAR NOT NULL,
    correct_answer VARCHAR(1) NOT NULL
);

CREATE TABLE user_selected_category
(
    username VARCHAR(50) REFERENCES users(username),
    category_name VARCHAR(50) REFERENCES category(name),
    completed BOOLEAN NOT NULL DEFAULT(FALSE),
    PRIMARY KEY(username, category_name)
);

CREATE TABLE user_completed_topic
(
    topic_id INTEGER REFERENCES topic(id),
    username VARCHAR(50) REFERENCES users(username),
    percentage_score INTEGER NOT NULL,
    PRIMARY KEY(topic_id, username)
);
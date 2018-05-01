
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  enabled  int         NOT NULL,
  PRIMARY KEY (username)
);


INSERT INTO users
VALUES
  ('szymon', '{noop}szymon', 1),
  ('marcin', 'marcin', 1),
  ('tosia', 'tosia', 1),
  ('karol', 'karol', 1),
  ('dawid', 'dawid', 1),
  ('user', 'user', 1);


DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities (
  username  varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,

  CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
);


INSERT INTO authorities
VALUES
  ('szymon', 'ROLE_ADMIN'),
  ('marcin', 'ROLE_ADMIN'),
  ('marcin', 'ROLE_USER'),
  ('tosia', 'ROLE_ADMIN'),
  ('tosia', 'ROLE_USER'),
  ('karol', 'ROLE_ADMIN'),
  ('dawid', 'ROLE_ADMIN'),
  ('user','ROLE_USER');



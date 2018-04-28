

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  enabled int NOT NULL,
  PRIMARY KEY (username)
);

--
-- Inserting data for table `users`
--

INSERT INTO users
VALUES
  ('szymon','{noop}szymon',1),
  ('marcin','marcin',1),
  ('tosia','tosia',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,

  CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
);

--
-- Inserting data for table `authorities`
--

INSERT INTO authorities
VALUES
  ('szymon','ROLE_EMPLOYEE'),
  ('marcin','ROLE_EMPLOYEE'),
  ('marcin','ROLE_MANAGER'),
  ('tosia','ROLE_EMPLOYEE'),
  ('tosia','ROLE_ADMIN');



DROP TABLE IF EXISTS user_detail;
CREATE TABLE public.user_detail
(
  username character varying(50) NOT NULL,
  first_name character varying(50) NOT NULL,
  last_name character varying(50) NOT NULL,
  email character varying(50) NOT NULL,
  country character varying(50) NOT NULL,
  PRIMARY KEY(username),
  FOREIGN KEY (username)
  REFERENCES public.users (username)
);
INSERT INTO user_detail (username, first_name, last_name, email, country) VALUES ('karol', 'karol', 'karol', 'karol', 'karol');
INSERT INTO user_detail (username, first_name, last_name, email, country) VALUES ('marcin', 'marcin', 'marcin', 'marcin', 'marcin');
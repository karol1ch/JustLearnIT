CREATE OR REPLACE FUNCTION users_add_user_to_authorities()
  RETURNS trigger AS $$
BEGIN
  INSERT INTO authorities (username, authority) VALUES (NEW.username, 'ROLE_USER');
  RETURN NEW;
END
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER users_insert_trigger
  AFTER INSERT
  ON users
  FOR EACH ROW
EXECUTE PROCEDURE users_add_user_to_authorities();
CREATE TABLE user (
  user_id varchar(36) NOT NULL,
  enabled bit(1) NOT NULL,
  password varchar(64) NOT NULL,
  username varchar(50) NOT NULL,
  role varchar(50) NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY (username)
);

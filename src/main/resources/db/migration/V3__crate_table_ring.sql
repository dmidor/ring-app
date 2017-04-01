CREATE TABLE ring (
  ring_id varchar(36) NOT NULL,
  owner_id varchar(36) NOT NULL,
  name varchar(50) NOT NULL,
  PRIMARY KEY (ring_id),
  UNIQUE KEY (ring_id)
);

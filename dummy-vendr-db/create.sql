CREATE TABLE users(
  user_id CHAR(36),
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  gender VARCHAR(6),
  min_age SMALLINT,
  max_age SMALLINT,
  likes INTEGER,
  dislikes INTEGER
);

CREATE TABLE userstat(
  user_id CHAR(36),
  level INTEGER,
  points INTEGER,
  likes INTEGER,
  dislikes INTEGER
);

CREATE TABLE ad(
  id BIGINT,
  merchant_id CHAR(36) REFERENCES merchant.merchant_id,
  price_in_cents INTEGER,
  category VARCHAR(36)
);

CREATE TABLE user_like_ad(
  user_id CHAR(36),
  ad_id BIGINT,
  did_like BOOLEAN,
  time_of_like DATE
);

CREATE TABLE merchant(
  merchant_id CHAR(36),
  name VARCHAR(255),
  password VARCHAR(255)
);

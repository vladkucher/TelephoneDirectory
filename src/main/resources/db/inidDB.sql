USE phonebook;

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id            INT AUTO_INCREMENT PRIMARY KEY,
  login         VARCHAR(255) NOT NULL,
  password      VARCHAR(255) NOT NULL,
  info          VARCHAR(255) NOT NULL,
  name          VARCHAR(25) NOT NULL,
  surname       VARCHAR(25) NOT NULL,
  patronymic    VARCHAR(25) NOT NULL,
  mobile_phone  VARCHAR(25) NOT NULL,
  home_phone    VARCHAR(25),
  email         VARCHAR(255),
  address       VARCHAR(45),
  registered    TIMESTAMP DEFAULT now(),
  enabled       BOOL DEFAULT TRUE
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (login);

CREATE TABLE user_roles
(
  user_id INT NOT NULL,
  role    VARCHAR(25),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE phone_book
(
  id            INT AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(25) NOT NULL,
  surname       VARCHAR(25),
  mobile_phone  VARCHAR(25) NOT NULL,
  home_phone    VARCHAR(25),
  user_id       INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);


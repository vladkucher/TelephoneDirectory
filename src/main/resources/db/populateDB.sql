DELETE FROM user_roles;
DELETE FROM phone_book;
DELETE FROM users;
ALTER TABLE users AUTO_INCREMENT = 1;
ALTER TABLE phone_book AUTO_INCREMENT = 1;


/*INSERT INTO users
VALUES (NULL ,'user', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni',
  'information','vlad','shevchenko','vlad','380975660000','380445660000',
  'email@gmail.com','kyiv',NULL ,NULL);

INSERT INTO user_roles VALUES
  (1, 'ROLE_USER');

INSERT INTO phone_book VALUES
  (NULL, 'mark' , 'tarasov','380975660001',NULL ,1);*/

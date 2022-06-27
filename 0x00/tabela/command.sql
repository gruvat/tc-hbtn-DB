CREATE TABLE CLIENTE (
   id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
   nome VARCHAR(80) NOT NULL,
   email VARCHAR(40) NOT NULL,
   telefone INTEGER
);

INSERT INTO CLIENTE VALUES (1, "Betty", "betty@techcamps.com", 12345678);

-------------------------- SQLite cli output
-- .output Cliente.txt
-- .headers on
-- SELECT * FROM CLIENTE;
BEGIN;

DROP TABLE IF EXISTS Product CASCADE;
CREATE TABLE Product (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO Product (title, price) VALUES
('box', 10),
('sphere', 20),
('maul', 100),
('door', 50),
('door2', 250),
('camera', 500);


COMMIT;
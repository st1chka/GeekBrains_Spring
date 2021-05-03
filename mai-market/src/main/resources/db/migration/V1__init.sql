CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO products (title, price) VALUES
('Сыр', 50),
('Хлеб', 40),
('Хлеб 2', 30),
('Хлеб 3', 20),
('Молоко', 10);

COMMIT;
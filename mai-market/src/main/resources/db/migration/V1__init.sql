create table categories (id bigserial primary key, title varchar(255));
insert into categories (title) values ('Food');

create table products (id bigserial primary key, title varchar(255), price int, category_id bigint references categories (id));
insert into products (title, price, category_id) values

('Сыр', 50,1),
('Хлеб', 40,1),
('Хлеб 2', 30,1),
('Хлеб 3', 20,1),
('Молоко', 10,1);



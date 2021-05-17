create table users (
  id                    bigserial,
  username              varchar(30) not null unique,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  primary key (id)
);
create table admins (
  id                    bigserial,
  adminsname              varchar(30) not null unique,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  primary key (id)
);

-- create table roles (
--   id                    serial,
--   name                  varchar(50) not null,
--   primary key (id)
-- );
--
-- CREATE TABLE users_roles (
--   user_id               bigint not null,
--   role_id               int not null,
--   primary key (user_id, role_id),
--   foreign key (user_id) references users (id),
--   foreign key (role_id) references roles (id)
-- );

create table permission (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_permissions (
  user_id                     bigint not null,
  permissions_id               int not null,
  primary key (user_id, permissions_id),
  foreign key (user_id) references users (id),
  foreign key (permissions_id) references permission (id)
);

CREATE TABLE admins_permissions (
  admin_id                     bigint not null,
  permissions_id               int not null,
  primary key (admin_id, permissions_id),
  foreign key (admin_id) references admins (id),
  foreign key (permissions_id) references permission (id)
);
--
-- insert into roles (name)
-- values
-- ('ROLE_USER'), ('ROLE_ADMIN');
--

insert into permission (name)
values
('PERMISSION_DELETE_USERS'), ('PERMISSION_CREATE_USERS'),
('PERMISSION_MODIFY_PRODUCTS'),('PERMISSION_CHECK_PRODUCTS');


insert into users (username, password, email)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),/*100*/
('admin', '$2y$12$ZBhIqEQSGywPhWaeuAXW5OwgdSsgQqVPmeBcf1F/RWhs6eLjWFSda', 'admin@gmail.com');/*200*/


insert into users_permissions (user_id, permissions_id)
values
(1, 4),
(2, 1),
(2, 2),
(2, 3);


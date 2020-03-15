/*create table product(
    id bigint primary key auto_increment,
    name varchar(100)
);

create table user(
    id bigint primary key auto_increment,
    username varchar(100),
    password varchar(100)
);

create table user_role(
    id bigint primary key auto_increment,
    role varchar(100)
);

create table user_user_role(
    id bigint primary key auto_increment,
    user_id bigint,
    role_id bigint
);
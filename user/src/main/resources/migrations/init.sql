create table if not exists users(
    user_id bigint primary key unique not null,
    username nvarchar(56) unique not null,
    email nvarchar(255) unique,
    password nvarchar(56)
);

alter table users
add column status ENUM('ACTIVE', 'NOT_VERIFIED', 'DEACTIVATED');


# 2023.04.04
alter table users
    add column avatar_url nvarchar(255),
    add column dob datetime,
    add column gender enum('MALE', 'FEMALE'),
    add column date_joined datetime;
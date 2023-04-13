create table if not exists posts(
    post_id bigint unique primary key not null,
    content longtext not null,
    user_id bigint,
    created_at datetime,
    updated_at datetime,
    foreign key (user_id) references users(user_id)
);
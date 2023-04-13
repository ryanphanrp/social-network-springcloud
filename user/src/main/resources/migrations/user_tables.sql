CREATE TABLE IF NOT EXISTS user_infos
(
    user_info_id bigint PRIMARY KEY AUTO_INCREMENT,
    user_id      bigint,
    name         nvarchar(256),
    bio          text(999),
    followers    int,
    following    int,
    num_posts    int
);

CREATE TABLE IF NOT EXISTS user_follows
(
    user_follow_id bigint PRIMARY KEY AUTO_INCREMENT,
    from_user_id   bigint,
    to_user_id     bigint
);

ALTER TABLE user_follows
    ADD FOREIGN KEY (from_user_id) REFERENCES users (user_id);

ALTER TABLE user_follows
    ADD FOREIGN KEY (to_user_id) REFERENCES users (user_id);
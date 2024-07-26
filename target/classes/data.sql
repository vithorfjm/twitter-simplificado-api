INSERT INTO tb_tweets (content, creation_timestamp, likes_count, active) VALUES ('Teste content', '2024-07-23', 3, 1);
INSERT INTO tb_tweets (content, creation_timestamp, likes_count, active) VALUES ('NENSE', '2024-07-25', 5, 1);

INSERT INTO tb_roles (name) VALUES ('ADMIN'),('USER');

INSERT INTO tb_users (login, password) VALUES ('vithor@gmail.com', '$2a$12$pJABp.RVuyEeMJa3LM7FJuxBzGvvc/gCLHYlyTlo4NNHRoHS9VNCC');

INSERT INTO tb_users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_users_roles (user_id, role_id) VALUES (1, 2);
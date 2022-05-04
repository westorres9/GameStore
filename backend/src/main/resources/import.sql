INSERT INTO tb_platform (name) VALUES ('PC');
INSERT INTO tb_platform (name) VALUES ('Xbox');
INSERT INTO tb_platform (name) VALUES ('Playstation');
INSERT INTO tb_platform (name) VALUES ('Nintendo');

INSERT INTO tb_publisher (name) VALUES ('Microsoft Studios');
INSERT INTO tb_publisher (name) VALUES ('Playstation Studios');
INSERT INTO tb_publisher (name) VALUES ('Bandai Namco');
INSERT INTO tb_publisher (name) VALUES ('Ubisoft');
INSERT INTO tb_publisher (name) VALUES ('Capcom');
INSERT INTO tb_publisher (name) VALUES ('Square Enix');
INSERT INTO tb_publisher (name) VALUES ('Konami');

INSERT INTO tb_game (name,release_date, publisher_id) VALUES ('God of War','2018-04-18', 2);

INSERT INTO tb_game_platform (game_id, platform_id) VALUES (1,3);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (1,1);
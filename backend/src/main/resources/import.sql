INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_platform (name) VALUES ('PC');
INSERT INTO tb_platform (name) VALUES ('Xbox');
INSERT INTO tb_platform (name) VALUES ('Playstation');
INSERT INTO tb_platform (name) VALUES ('Nintendo Switch');

INSERT INTO tb_publisher (name) VALUES ('Microsoft Studios');
INSERT INTO tb_publisher (name) VALUES ('Playstation Studios');
INSERT INTO tb_publisher (name) VALUES ('Bandai Namco');
INSERT INTO tb_publisher (name) VALUES ('Ubisoft');
INSERT INTO tb_publisher (name) VALUES ('Capcom');
INSERT INTO tb_publisher (name) VALUES ('Square Enix');
INSERT INTO tb_publisher (name) VALUES ('Konami');
INSERT INTO tb_publisher (name) VALUES ('Nintendo');


INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('God of War','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/godofwar.jpg',199.0);
INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('Killzone','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/kilzone.jpg',99.0);
INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('Horizon Zero Dawn','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/horizonzerodwan.jpg',299.0);
INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('Halo','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/halo.jpg',199.0);
INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('Gears of War','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/gears.jpg',99.0);
INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('Ace Combat 7','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/acecombat.jpg',179.0);
INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('FinalFantasy XV','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/finalfantasy.jpg',299.0);
INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('Tom clancy Ghost Recon','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/ghostrecon.jpg',89.0);
INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('Resident Evil Village','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/resident.jpg',299.0);
INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('Metal Solid Phantom Pain','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/metalgear.jpg',99.0);
INSERT INTO tb_game (name,release_date, img_Url, price) VALUES ('Mario Odissey','2018-04-18','https://raw.githubusercontent.com/westorres9/GameStore/blob/main/backend/img/mario.jpg',329.0);

INSERT INTO tb_game_platform (game_id, platform_id) VALUES (1,3);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (1,1);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (2,2);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (3,1);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (3,3);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (4,1);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (4,2);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (5,1);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (5,2);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (6,1);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (6,2);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (6,3);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (7,1);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (7,2);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (7,3);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (8,1);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (8,2);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (8,3);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (9,1);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (9,2);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (9,3);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (10,1);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (10,2);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (10,3);
INSERT INTO tb_game_platform (game_id, platform_id) VALUES (11,4);

INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (1,2);
INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (2,2);
INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (3,2);
INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (4,1);
INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (5,1);
INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (6,3);
INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (7,6);
INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (8,4);
INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (9,5);
INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (10,7);
INSERT INTO tb_game_publisher (game_id, publisher_id) VALUES (11,8);
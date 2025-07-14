-- Addresses:
INSERT INTO Addresses(id, latitude, longitude, street_and_number, postal_code, populated_place, 
	country) VALUES (1, 45.0466787283361, 20.077418481275856, 'Vatroslava Jagića 9', 
	'21000', 'Novi Sad', 'Srbija');
INSERT INTO Addresses(id, latitude, longitude, street_and_number, postal_code, populated_place, 
	country) VALUES (2, 45.25076069584408, 19.824365676452167, 'Fruškogorska 37', 
	'21000', 'Novi Sad', 'Srbija');
INSERT INTO Addresses(id, latitude, longitude, street_and_number, postal_code, populated_place, 
	country) VALUES (3, 45.24401166066522, 19.8475980669369572, 'Laze Nančića 22', 
	'21000', 'Novi Sad', 'Srbija');
INSERT INTO Addresses(id, latitude, longitude, street_and_number, postal_code, populated_place, 
	country) VALUES (4, 44.85856108034915, 20.363139670000777, 'Almaška 14', 
	'21000', 'Novi Sad', 'Srbija');
INSERT INTO Addresses(id, latitude, longitude, street_and_number, postal_code, populated_place, 
	country) VALUES (5, 45.25076069584408, 19.824365676452167, 'Šumadijska 5', 
	'21000', 'Novi Sad', 'Srbija');

-- Basic users:
-- Password for this user is 'dMilosevic2000'.
INSERT INTO Users(id, is_enabled, username, password, email_address, first_name, last_name, 
	residence_address_id, number_of_followed_users, number_of_following_users) VALUES (1, true, 
	'DarkoMilosevic2000', '$2a$10$sBvg6L9Xk9iRHY7tnTd42OsCW25IctZGgD6YiNnMxXp/Dtzm/hLWW', 
	'darko.milosevic@gmail.com', 'Darko', 'Milošević', 1, 3, 3);
-- '1e8a7e71cd25d51fd5d4c3a0b8d931db9db113dc9ad235129618c0085987615d', 
-- 'Vatroslava Jagića 9', 'Novi Sad', 'Srbija', '+381 649398427', '3105000710391', 'MALE', 
-- 45.0466787283361, 20.077418481275856);
-- Password for this user is 'pBorisavljevic1999'.
INSERT INTO Users(id, is_enabled, username, password, email_address, first_name, last_name, 
	residence_address_id, number_of_followed_users, number_of_following_users) VALUES (2, true, 
	'PavleBorisavljevic1999', '$2a$10$4MBoCfFOa8U0OrT8ZC34ZOhFAwh8MHpF7fMnXFurJX1VpbVvUsktq', 
	'pavle.borisavljevic@gmail.com', 'Pavle', 'Borisavljević', 2, 0, 2);
-- '2210b5da85e7867d0b4186f510ca4f6d0629012bc23f477cc405076b32028b3e', 
-- 'Fruškogorska 37', 'Novi Sad', 'Srbija', '+381 63569456', '0601999710135', 'MALE', 
-- 45.25076069584408, 19.824365676452167);
-- Password for this user is 'mUrosevic1991'.
INSERT INTO Users(id, is_enabled, username, password, email_address, first_name, last_name, 
	residence_address_id, number_of_followed_users, number_of_following_users) VALUES (3, true, 
	'MilanaUrosevic1991', '$2a$10$ioMKVjvTZ2qqh4fKKOZnIu8IbqdeGjyEWRKynikFNWVOldEzBPE3u', 
	'milana.urosevic@gmail.com', 'Milana', 'Urošević', 3, 3, 3);
-- '8c54b356f293664914dd32b26df9e17649c127400d8bbf691d5ee9557d4730d9', 
-- 'Laze Nančića 22', 'Novi Sad', 'Srbija', '+381 63682738', '1708991620486', 'FEMALE', 
-- 45.24401166066522, 19.8475980669369572);

-- System administrators:
-- Password for this user is 'eRajkovic1986'.
INSERT INTO Users(id, is_enabled, username, password, email_address, first_name, last_name, 
	residence_address_id, number_of_followed_users, number_of_following_users) VALUES (4, true, 
	'EmilRajkovic1986', '$2a$10$jMY/yxEvMO239YWOSJL6f.7oRR7DQIbNEX89NmPOn1ee3dln9ELty', 
	'emil.rajkovic@gmail.com', 'Emil', 'Rajković', 4, 4, 3);
-- '9ebde0d60831490561dc3d0e33896d46e2945374385d518f191a1d44aee586d1', 
-- 'Almaška 14', 'Novi Sad', 'Srbija', '+381 623859070', '2702986710117', 'MALE', 
-- 44.85856108034915, 20.363139670000777);
-- Password for this user is 'oLukic1990'.
INSERT INTO Users(id, is_enabled, username, password, email_address, first_name, last_name, 
	residence_address_id, number_of_followed_users, number_of_following_users) VALUES (5, true, 
	'OliveraLukic1990', '$2a$10$LaO2qmww6/xwEVh1/rgL9Ol/7e6XZ5JosLddngJo8khkYC8QYGe36', 
	'olivera.lukic@gmail.com', 'Olivera', 'Lukić', 5, 4, 3);
-- '2615b98b4a5b7ed324639b59ad01730f3faf188942ea7cfa132d3addf1f43df4', 
-- 'Šumadijska 5', 'Novi Sad', 'Srbija', '+381 63770422', '2410990620808', 'FEMALE', 
-- 45.25076069584408, 19.824365676452167, '2023-11-10 07:00:00.000+01');

-- User roles:
INSERT INTO User_roles(id, name) VALUES (1, 'ROLE_BASIC_USER');
INSERT INTO User_roles(id, name) VALUES (2, 'ROLE_SYSTEM_ADMINISTRATOR');

-- Posts:
INSERT INTO Posts(id, description, photo_path, address_id, user_id, number_of_likes, 
	creation_time) VALUES (1, 'Слаткиша :)', 
	'src/assets/Slatkisa.jpg', 1, 1, 3, '2025-06-28 10:00:00.000+01');
INSERT INTO Posts(id, description, photo_path, address_id, user_id, number_of_likes, 
	creation_time) VALUES (2, 'Зекоја вас поздравља!', 
	'src/assets/Zekoja.jpg', 1, 1, 1, '2025-06-28 12:00:00.000+01');
INSERT INTO Posts(id, description, photo_path, address_id, user_id, number_of_likes, 
	creation_time) VALUES (3, 'Мој малени зека :) <3', 
	'src/assets/Moj_maleni_zeka.jpg', 3, 3, 3, '2025-06-28 13:45:00.000+01');

-- Comments:
-- REFERENCE: https://stackoverflow.com/questions/26638615/insert-line-break-in-postgresql-when-updating-text-field
INSERT INTO Comments(id, content, post_id, user_id, creation_time) VALUES (1, 
	'Малишан медени! <3', 2, 3, '2025-06-28 19:34:57.000+01');
INSERT INTO Comments(id, content, post_id, user_id, creation_time) VALUES (2, 
	'Поздрављам и ја зекоју! :)', 2, 5, '2025-06-29 07:12:30.000+01');
INSERT INTO Comments(id, content, post_id, user_id, creation_time) VALUES (3, 
	CONCAT('Баш је сладак.', CHR(10), 'Уживајте! :)'), 3, 1, '2025-06-29 08:55:29.000+01');
INSERT INTO Comments(id, content, post_id, user_id, creation_time) VALUES (4, 
	'Нек нам је дуго жив и здрав! :)', 3, 4, '2025-06-29 11:02:43.000+01');
INSERT INTO Comments(id, content, post_id, user_id, creation_time) VALUES (5, 
	'Зекицааа :)', 3, 5, '2025-06-29 11:46:08.000+01');

-- Chats:
INSERT INTO Chats(id, title, is_group_chat, group_chat_creator, number_of_users, creation_time) 
	VALUES (1, 'Администратори система - редован разговор', false, 4, 
	2, '2025-01-03 08:36:24.000+01');
INSERT INTO Chats(id, title, is_group_chat, group_chat_creator, number_of_users, creation_time) 
	VALUES (2, 'Како да стекнем зекино поверење?', true, 1, 
	4, '2025-02-07 18:01:29.000+01');

-- Chat messages:
-- REFERENCE: https://stackoverflow.com/questions/26638615/insert-line-break-in-postgresql-when-updating-text-field
INSERT INTO (id, content, chat_id, user_id, creation_time) VALUES (1, CONCAT('Здраво! Овај ', 
	'разговор служи за редовну размену мишљења између администратора система.'), 
	1, 4, '2025-01-03 08:38:42.000+01');
INSERT INTO (id, content, chat_id, user_id, creation_time) VALUES (2, CONCAT('Здраво! Драго ми је ', 
	'да сам се придружила сајту. Анализирам сајт.'), 
	1, 5, '2025-01-03 08:45:31.000+01');
INSERT INTO (id, content, chat_id, user_id, creation_time) VALUES (3, CONCAT('Здраво! Желим да ', 
	'стекнем поверење мог зеке. Имате ли савета како то да урадим?'), 
	2, 1, '2025-02-07 18:03:05.000+01');
INSERT INTO (id, content, chat_id, user_id, creation_time) VALUES (4, CONCAT('Здраво! Поверење ', 
	'и неповерење љубимца према власнику је баланс који стално мора да се налази. Зеки се треба ', 
	'обраћати нежним тоном који ће он знати препознати као љубав. Када уради нешто што не сме да ', 
	'уради, треба му се обратити оштрим "Не!". Тиме се гради однос награге и казне.'), 
	2, 4, '2025-02-07 18:05:56.000+01');
INSERT INTO (id, content, chat_id, user_id, creation_time) VALUES (5, CONCAT('Према зеки се треба ', 
	'односити с поштовањем и љубављу коју ће он увек вратити! :)', CHR(10), 'Пробајте да му ', 
	'свакодневно приближавате руку лаганим, спорим покретом.'), 
	2, 3, '2025-02-07 18:07:43.000+01');
INSERT INTO (id, content, chat_id, user_id, creation_time) VALUES (6, CONCAT('Здраво! Зецу је ', 
	'након доласка у нов дом потребно време да се на њега привикне. Првих недељу до две дана, ', 
	'немојте му поклањати пажњу (било какву, осим наравно храњења и чишћења). Он/она треба да се ', 
	'увери да му не желите учинити ништа зло и тада ће се опустити и дозволити Вам да започнете ', 
	'пријатељски однос.'), 
	2, 5, '2025-02-07 18:08:32.000+01');
INSERT INTO (id, content, chat_id, user_id, creation_time) VALUES (7, CONCAT('У реду, хвала Вам! ', 
	'Применићу Ваше савете сутра.'), 
	2, 1, '2025-02-07 20:04:59.000+01');
INSERT INTO (id, content, chat_id, user_id, creation_time) VALUES (8, CONCAT('Јавите нам ', 
	'напредак! :)'), 
	2, 3, '2025-02-07 20:15:46.000+01');

-- Join table for users and user roles:
INSERT INTO User_roles_join_table(user_id, role_id) VALUES (1, 1);
INSERT INTO User_roles_join_table(user_id, role_id) VALUES (2, 1);
INSERT INTO User_roles_join_table(user_id, role_id) VALUES (3, 1);
INSERT INTO User_roles_join_table(user_id, role_id) VALUES (4, 2);
INSERT INTO User_roles_join_table(user_id, role_id) VALUES (5, 2);
-- Join table for user following:
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (1, 3);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (1, 4);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (1, 5);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (2, 4);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (2, 5);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (3, 1);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (3, 4);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (3, 5);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (4, 1);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (4, 3);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (4, 5);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (5, 1);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (5, 3);
INSERT INTO User_following_join_table(followed_id, follower_id) VALUES (5, 4);
-- Join table for users and liked posts:
INSERT INTO Post_likes_join_table(post_id, user_id) VALUES (1, 3);
INSERT INTO Post_likes_join_table(post_id, user_id) VALUES (1, 4);
INSERT INTO Post_likes_join_table(post_id, user_id) VALUES (1, 5);
INSERT INTO Post_likes_join_table(post_id, user_id) VALUES (2, 3);
INSERT INTO Post_likes_join_table(post_id, user_id) VALUES (3, 1);
INSERT INTO Post_likes_join_table(post_id, user_id) VALUES (3, 4);
INSERT INTO Post_likes_join_table(post_id, user_id) VALUES (3, 5);
-- Join table for users and chats:
INSERT INTO User_chats_join_table(chat_id, user_id) VALUES (1, 4);
INSERT INTO User_chats_join_table(chat_id, user_id) VALUES (1, 5);
INSERT INTO User_chats_join_table(chat_id, user_id) VALUES (2, 1);
INSERT INTO User_chats_join_table(chat_id, user_id) VALUES (2, 3);
INSERT INTO User_chats_join_table(chat_id, user_id) VALUES (2, 4);
INSERT INTO User_chats_join_table(chat_id, user_id) VALUES (2, 5);

-- REFERENCE: https://dba.stackexchange.com/questions/46125/why-does-postgres-generate-an-already-used-pk-value
-- REFERENCE: https://dba.stackexchange.com/a/90522
-- REFERENCE: https://commandprompt.com/education/is-nvl-function-same-as-coalesce-in-postgresql/
SELECT SETVAL('address_ids_sequence', (SELECT MAX(id) FROM Addresses));
SELECT SETVAL('user_ids_sequence', (SELECT MAX(id) FROM Users));
SELECT SETVAL('user_role_ids_sequence', (SELECT MAX(id) FROM User_roles));
SELECT SETVAL('post_ids_sequence', (SELECT MAX(id) FROM Posts));
SELECT SETVAL('comment_ids_sequence', (SELECT MAX(id) FROM Comments));
SELECT SETVAL('chat_ids_sequence', (SELECT MAX(id) FROM Chats));
SELECT SETVAL('chat_message_ids_sequence', (SELECT MAX(id) FROM Chat_messages));

INSERT INTO `roles` (`id`, `name`) VALUES (NULL, 'ADMIN'), (NULL, 'MODERATOR'), (NULL, 'USER');
INSERT INTO `users` (`id`, `code`, `email`, `is_verified`, `last_edited_at`, `nick_name`, `password`, `registered_at`, `role_id`, `reset_link_is_used`, `avatar`) VALUES (NULL, 'f839a9c4-d6c7-4e32-b19f-7743f15155bb', 'admin@voteme.ua', b'0', CURRENT_TIMESTAMP, 'admin', '$2a$10$SfJvrW20nzJvbhfxMKvnzOkbH00eS7q1/JPv8p1wee/ZjDOVG0gr6', CURRENT_TIMESTAMP, 1, b'0', 0), (NULL, '409fb67e-1b05-4a35-aeee-296c442d4ee4', 'moderator@voteme.ua', b'1', CURRENT_TIMESTAMP, 'moderator', '$2a$10$xUsgq02q4y5RFAITMVbCeeAJvBo14CzynQc4voiOBhY54XEl5WeNS', CURRENT_TIMESTAMP, 2, b'0', 0), (NULL, 'b2eea81d-3c72-4c4f-8868-310f4cb3167a', 'user@voteme.ua', b'1', CURRENT_TIMESTAMP, 'user', '$2a$10$mJIUX5YXyuTYd3VW/V0R.OTgHy8Q6ZMg3Jngc3KgvK.CWrRy98vou', CURRENT_TIMESTAMP, 3, b'0', 0);
INSERT INTO `versus` (`id`, `created_at`, `description`, `title`, `author_id`) VALUES (NULL, CURRENT_TIMESTAMP, 'Do you like pink or red, please vote!', 'Do u prefer red or pink?', '3'), (NULL, CURRENT_TIMESTAMP, 'Simple question.', 'To be or not to be?', '3');
INSERT INTO `opinion` (`id`, `text`, `versus_id`) VALUES (NULL, 'Pink the best!', '1'), (NULL, 'Red is better!', '1'), (NULL, 'To be.', '2'), (NULL, 'Not to be!', '2');
INSERT INTO `mark` (`mark_type`, `id`, `mark`, `user_id`, `opinion_id`, `versus_id`) VALUES ('1', NULL, b'1', '1', NULL, '2'), ('1', NULL, b'1', '2', NULL, '2'), ('1', NULL, b'0', '3', NULL, '2'), ('1', NULL, b'0', '1', NULL, '1'), ('1', NULL, b'0', '2', NULL, '1'), ('1', NULL, b'1', '3', NULL, '1'), ('2', NULL, b'1', '1', '4', NULL), ('2', NULL, b'1', '2', '3', NULL), ('2', NULL, b'1', '3', '3', NULL);
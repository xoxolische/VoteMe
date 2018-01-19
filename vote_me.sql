-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Янв 19 2018 г., 20:49
-- Версия сервера: 5.7.19
-- Версия PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `vote_me`
--

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(6),
(6),
(6),
(6),
(6);

-- --------------------------------------------------------

--
-- Структура таблицы `mark`
--

DROP TABLE IF EXISTS `mark`;
CREATE TABLE IF NOT EXISTS `mark` (
  `mark_type` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  `mark` bit(1) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `opinion_id` bigint(20) DEFAULT NULL,
  `versus_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtkioe39v18a3xggp01op1r9iu` (`user_id`),
  KEY `FKdernbist4y0hsjfmqtk20ar4c` (`opinion_id`),
  KEY `FK1ia6ht2edt1aexu5mxdimhqt9` (`versus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `mark`
--

INSERT INTO `mark` (`mark_type`, `id`, `mark`, `user_id`, `opinion_id`, `versus_id`) VALUES
(1, 1, b'1', 1, NULL, NULL),
(1, 2, b'0', 1, NULL, NULL),
(1, 3, b'0', 1, NULL, NULL),
(1, 4, b'0', 1, NULL, 1),
(1, 5, b'1', 1, NULL, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `opinion`
--

DROP TABLE IF EXISTS `opinion`;
CREATE TABLE IF NOT EXISTS `opinion` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `text` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author_id` bigint(20) NOT NULL,
  `versus_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_n1iav7uyptdjqwn2nv3vik6o3` (`versus_id`),
  KEY `FKm2rv2wgg4db47acjfk657a7va` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `last_edited_at` datetime DEFAULT NULL,
  `nick_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `registered_at` datetime DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `email`, `last_edited_at`, `nick_name`, `password`, `registered_at`, `role_id`) VALUES
(1, '1', '2018-01-11 00:00:00', '1', '1', '2018-01-31 00:00:00', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `versus`
--

DROP TABLE IF EXISTS `versus`;
CREATE TABLE IF NOT EXISTS `versus` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `description` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `versus`
--

INSERT INTO `versus` (`id`, `created_at`, `description`, `title`) VALUES
(1, '2018-01-05 00:00:00', '1', '1');

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `mark`
--
ALTER TABLE `mark`
  ADD CONSTRAINT `FK1ia6ht2edt1aexu5mxdimhqt9` FOREIGN KEY (`versus_id`) REFERENCES `versus` (`id`),
  ADD CONSTRAINT `FKdernbist4y0hsjfmqtk20ar4c` FOREIGN KEY (`opinion_id`) REFERENCES `opinion` (`id`),
  ADD CONSTRAINT `FKtkioe39v18a3xggp01op1r9iu` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Ограничения внешнего ключа таблицы `opinion`
--
ALTER TABLE `opinion`
  ADD CONSTRAINT `FKlxu1g6dbck0sbr1x4c8cwoho5` FOREIGN KEY (`versus_id`) REFERENCES `versus` (`id`),
  ADD CONSTRAINT `FKm2rv2wgg4db47acjfk657a7va` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`);

--
-- Ограничения внешнего ключа таблицы `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

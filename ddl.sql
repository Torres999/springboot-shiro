# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.1.22-MariaDB)
# Database: shiro
# Generation Time: 2018-09-17 16:03:13 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table t9_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t9_permission`;

CREATE TABLE `t9_permission` (
  `permission_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOCK TABLES `t9_permission` WRITE;
/*!40000 ALTER TABLE `t9_permission` DISABLE KEYS */;

INSERT INTO `t9_permission` (`permission_id`, `permission_name`, `created_time`, `update_time`)
VALUES
	(3,'/testPerms1',NULL,'2018-09-17 13:26:12'),
	(4,'/hi',NULL,'2018-09-17 13:26:41');

/*!40000 ALTER TABLE `t9_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t9_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t9_role`;

CREATE TABLE `t9_role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOCK TABLES `t9_role` WRITE;
/*!40000 ALTER TABLE `t9_role` DISABLE KEYS */;

INSERT INTO `t9_role` (`role_id`, `role_name`, `created_time`, `update_time`)
VALUES
	(3,'admin',NULL,'2018-09-17 13:25:44'),
	(4,'test',NULL,'2018-09-17 13:28:06'),
	(5,'manager',NULL,'2018-09-17 13:28:12');

/*!40000 ALTER TABLE `t9_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t9_role_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t9_role_permission`;

CREATE TABLE `t9_role_permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `permission_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_permission_id` (`permission_id`),
  KEY `idx_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOCK TABLES `t9_role_permission` WRITE;
/*!40000 ALTER TABLE `t9_role_permission` DISABLE KEYS */;

INSERT INTO `t9_role_permission` (`id`, `permission_id`, `role_id`)
VALUES
	(2,3,5);

/*!40000 ALTER TABLE `t9_role_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t9_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t9_user`;

CREATE TABLE `t9_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOCK TABLES `t9_user` WRITE;
/*!40000 ALTER TABLE `t9_user` DISABLE KEYS */;

INSERT INTO `t9_user` (`user_id`, `username`, `nickname`, `password`, `status`, `last_login_time`, `created_time`, `update_time`)
VALUES
	(3,'Mark','Mark','1234567',NULL,'2018-09-17 23:55:01',NULL,'2018-09-16 17:18:53');

/*!40000 ALTER TABLE `t9_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t9_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t9_user_role`;

CREATE TABLE `t9_user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT NULL,
  `role_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOCK TABLES `t9_user_role` WRITE;
/*!40000 ALTER TABLE `t9_user_role` DISABLE KEYS */;

INSERT INTO `t9_user_role` (`id`, `user_id`, `role_id`)
VALUES
	(3,3,3);

/*!40000 ALTER TABLE `t9_user_role` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

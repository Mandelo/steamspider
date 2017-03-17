/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.6.26-log : Database - steam_spider
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`steam_spider` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `steam_spider`;

/*Table structure for table `steam_spider` */

DROP TABLE IF EXISTS `steam_spider`;

CREATE TABLE `steam_spider` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `accountLv` varchar(20) DEFAULT NULL,
  `ownedGames` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `steam_spider` */

insert  into `steam_spider`(`id`,`username`,`accountLv`,`ownedGames`) values (1,'Krosis  ','23','190'),(2,'Leon  ','26','204'),(3,'Batchisu  ','17','95'),(4,'ChaoticKibble  ','25','116'),(5,'Corey  ','51','677'),(6,'Skali  ','13','296'),(7,'alkarioma  ','9','114'),(8,'ddosing roblox  ','16','70'),(9,'Matzuek  ','12','338'),(10,'[WB] MagicCleric07  ','28','154'),(11,'Krosis  ','23','190'),(12,'Batchisu  ','17','95'),(13,'Leon  ','26','204'),(14,'ChaoticKibble  ','25','116'),(15,'Corey  ','51','677'),(16,'Skali  ','13','296'),(17,'alkarioma  ','9','114'),(18,'ddosing roblox  ','16','70'),(19,'Matzuek  ','12','338'),(20,'[WB] MagicCleric07  ','28','154');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

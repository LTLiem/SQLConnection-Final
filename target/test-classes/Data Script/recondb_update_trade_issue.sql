-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: recondb_update
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `trade_issue`
--

DROP TABLE IF EXISTS `trade_issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_issue` (
  `trade_nb` varchar(20) NOT NULL,
  `issue_id` int(11) NOT NULL,
  `input_date` datetime DEFAULT NULL,
  PRIMARY KEY (`trade_nb`,`issue_id`),
  KEY `FK992pupt35ekst7ri2wha7yb2c` (`issue_id`),
  CONSTRAINT `FK992pupt35ekst7ri2wha7yb2c` FOREIGN KEY (`issue_id`) REFERENCES `issue` (`issue_id`),
  CONSTRAINT `FKk0wy3gcwrqmqajo3xe3xhp2wa` FOREIGN KEY (`trade_nb`) REFERENCES `trade` (`trade_nb`),
  CONSTRAINT `fk_issue` FOREIGN KEY (`issue_id`) REFERENCES `issue` (`issue_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_trade` FOREIGN KEY (`trade_nb`) REFERENCES `trade` (`trade_nb`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_issue`
--

LOCK TABLES `trade_issue` WRITE;
/*!40000 ALTER TABLE `trade_issue` DISABLE KEYS */;
INSERT INTO `trade_issue` VALUES ('12312',1,'2017-12-05 15:05:55'),('12345',1,'2017-11-29 00:00:00'),('12347',1,'2017-11-30 00:00:00'),('12348',1,'2017-12-01 00:00:00'),('12350',1,'2017-12-02 00:00:00'),('12351',1,'2017-12-03 00:00:00'),('12351',2,'2017-12-04 00:00:00'),('12352',2,'2017-12-05 00:00:00'),('12353',1,'2017-12-06 00:00:00'),('12353',2,'2017-12-07 00:00:00'),('12354',2,'2017-12-08 00:00:00'),('12356',2,'2017-12-09 00:00:00'),('12357',2,'2017-12-10 00:00:00');
/*!40000 ALTER TABLE `trade_issue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-05 15:15:23

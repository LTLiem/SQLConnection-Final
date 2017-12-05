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
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issue` (
  `issue_id` int(11) NOT NULL AUTO_INCREMENT,
  `field` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `report` varchar(45) CHARACTER SET utf8 NOT NULL,
  `sql_filter` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `correct_source` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT 'MX3',
  `different_type` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `explanation` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `field_value` varchar(45) CHARACTER SET utf8 NOT NULL,
  `input_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL,
  `user_created` int(11) NOT NULL,
  `last_action` int(11) DEFAULT NULL,
  `last_date` datetime DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `fk_issue_user_idx` (`user_created`),
  KEY `fk_status_status_idx` (`status`),
  KEY `fk_lastuser_user_idx` (`last_user`),
  KEY `fk_lastaction_action_idx` (`last_action`),
  CONSTRAINT `fk_issue_user` FOREIGN KEY (`user_created`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lastaction_action` FOREIGN KEY (`last_action`) REFERENCES `action` (`action_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lastuser_user` FOREIGN KEY (`last_user`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_status_status` FOREIGN KEY (`status`) REFERENCES `status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` VALUES (1,'PC','Core recon','','MX3','Behavior difference','Past cash issue xxx','PC','2017-11-28 16:50:25',1,1,2,'2017-11-28 16:50:25',2),(2,'MV','Core recon','','MX2','Behavior difference','MV issue zzzz','MV','2017-11-28 16:50:25',1,1,2,'2017-11-28 16:50:25',2),(3,'FC','Core recon','','MX2','Behavior difference','FC issue zzzz','FC','2017-11-28 16:50:25',1,1,2,'2017-11-28 16:50:25',2),(4,'FC','Core recon',NULL,'MX3','Behavior difference','FC issue zzzz','FC','2017-11-28 16:50:25',1,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
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

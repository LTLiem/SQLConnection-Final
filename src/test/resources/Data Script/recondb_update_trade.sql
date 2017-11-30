CREATE DATABASE  IF NOT EXISTS `recondb_update` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `recondb_update`;
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
-- Table structure for table `trade`
--

DROP TABLE IF EXISTS `trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade` (
  `trade_nb` varchar(20) CHARACTER SET utf8 NOT NULL,
  `instrument` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `currency` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `portfolio` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `trn_fmly` varchar(5) CHARACTER SET utf8 NOT NULL,
  `trn_grp` varchar(5) CHARACTER SET utf8 NOT NULL,
  `trn_type` varchar(5) CHARACTER SET utf8 NOT NULL,
  `trn_status` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `input_date` datetime NOT NULL,
  `user_created` int(11) NOT NULL,
  `last_action` int(11) DEFAULT NULL,
  `last_date` datetime DEFAULT NULL,
  `last_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`trade_nb`),
  KEY `fk_fmly_idx` (`trn_fmly`),
  KEY `fk_grp_idx` (`trn_grp`),
  KEY `fk_type_idx` (`trn_type`),
  KEY `fk_trade_user_idx` (`user_created`),
  KEY `FK8gdio75dncdfnr27o43uno0n6` (`trn_fmly`,`trn_grp`,`trn_type`),
  KEY `fk_action_action_idx` (`last_action`),
  KEY `fk_lastuser_user_idx` (`last_user`),
  CONSTRAINT `fk_trade_header` FOREIGN KEY (`trn_fmly`, `trn_grp`, `trn_type`) REFERENCES `trn_hdr` (`trn_fmly`, `trn_grp`, `trn_type`),
  CONSTRAINT `fk_trade_lastaction` FOREIGN KEY (`last_action`) REFERENCES `action` (`action_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_trade_lastuser_user` FOREIGN KEY (`last_user`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user` FOREIGN KEY (`user_created`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
INSERT INTO `trade` VALUES ('12312','FUT3','USD','FUT PTF','EQD','FUT','     ','LIVE','2017-11-29 09:33:14',1,NULL,NULL,NULL),('12345','SEC1','EUR','EQD PTF','EQD','OPT','OTC','LIVE','2017-11-29 09:33:13',1,2,'2017-11-29 09:33:13',2),('12347','SEC1','EUR','EQD PTF','EQD','OPT','OTC','LIVE','2017-11-29 09:33:13',1,2,'2017-11-29 09:33:13',2),('12348','SEC2','EUR','EQD PTF','EQD','OPT','OTC','LIVE','2017-11-29 09:33:13',1,2,'2017-11-29 09:33:13',2),('12350','SEC2','EUR','EQD PTF','EQD','OPT','OTC','LIVE','2017-11-29 09:33:13',1,2,'2017-11-29 09:33:13',2),('12351','FUT1','EUR','FUT PTF','EQD','FUT','     ','LIVE','2017-11-29 09:33:13',1,2,'2017-11-29 09:33:13',2),('12352','FUT2','USD','FUT PTF','EQD','FUT','     ','LIVE','2017-11-29 09:33:13',1,2,'2017-11-29 09:33:13',2),('12353','FUT1','EUR','FUT PTF','EQD','FUT','     ','LIVE','2017-11-29 09:33:14',1,2,'2017-11-29 09:33:13',2),('12354','FUT2','USD','FUT PTF','EQD','FUT','     ','LIVE','2017-11-29 09:33:14',1,2,'2017-11-29 09:33:13',2),('12356','FUT3','USD','FUT PTF','EQD','FUT','     ','LIVE','2017-11-29 09:33:14',1,2,'2017-11-29 09:33:13',2),('12357','FUT1','USD','FUT PTF','EQD','FUT','     ','LIVE','2017-11-29 09:33:14',1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `trade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-30 16:57:00

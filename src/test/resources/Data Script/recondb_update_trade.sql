-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: recondb_update
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
  `user` int(11) NOT NULL,
  PRIMARY KEY (`trade_nb`),
  UNIQUE KEY `trn_fmly_UNIQUE` (`trn_fmly`),
  UNIQUE KEY `trn_grp_UNIQUE` (`trn_grp`),
  UNIQUE KEY `trn_type_UNIQUE` (`trn_type`),
  KEY `fk_fmly_idx` (`trn_fmly`),
  KEY `fk_grp_idx` (`trn_grp`),
  KEY `fk_type_idx` (`trn_type`),
  KEY `fk_trade_user_idx` (`user`),
  KEY `FK8gdio75dncdfnr27o43uno0n6` (`trn_fmly`,`trn_grp`,`trn_type`),
  CONSTRAINT `FK5hrkd1f0i3gu38s27pvqlu0ax` FOREIGN KEY (`user`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK8gdio75dncdfnr27o43uno0n6` FOREIGN KEY (`trn_fmly`, `trn_grp`, `trn_type`) REFERENCES `trn_hdr` (`trn_fmly`, `trn_grp`, `trn_type`),
  CONSTRAINT `fk_trade_header` FOREIGN KEY (`trn_fmly`, `trn_grp`, `trn_type`) REFERENCES `trn_hdr` (`trn_fmly`, `trn_grp`, `trn_type`),
  CONSTRAINT `fk_trade_user` FOREIGN KEY (`user`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
INSERT INTO `trade` VALUES ('12345','I1','C1','P1','CURR','FXD','FXD','T1','2011-12-18 13:17:17',1);
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

-- Dump completed on 2017-11-23 14:33:17

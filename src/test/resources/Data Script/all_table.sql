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
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action` (
  `action_id` int(11) NOT NULL AUTO_INCREMENT,
  `action` varchar(45) NOT NULL,
  `comment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (1,'INSERT',NULL),(2,'DELETE',NULL),(3,'UPDATE',NULL);
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Recon Stream',NULL),(2,'BA Stream',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  `comment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'LIVE',NULL),(2,'PENDING',NULL),(3,'UNDER INVESTIGATION',NULL);
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `trn_hdr`
--

DROP TABLE IF EXISTS `trn_hdr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trn_hdr` (
  `trn_fmly` varchar(5) CHARACTER SET utf8 NOT NULL,
  `trn_grp` varchar(5) CHARACTER SET utf8 NOT NULL,
  `trn_type` varchar(5) CHARACTER SET utf8 NOT NULL,
  `description` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`trn_fmly`,`trn_grp`,`trn_type`),
  KEY `trade_header_index` (`trn_fmly`,`trn_grp`,`trn_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_hdr`
--

LOCK TABLES `trn_hdr` WRITE;
/*!40000 ALTER TABLE `trn_hdr` DISABLE KEYS */;
INSERT INTO `trn_hdr` VALUES ('COM','ASIAN','','COM Asian'),('COM','ASIAN','CLR','COM Cleared asian'),('COM','EFS','','COM Exchange Future for Swap'),('COM','FUT','','COM Future'),('COM','FWD','','COM Forward'),('COM','OFUT','LST','COM Option on Future - Listed'),('COM','OFUT','OTC','COM Option on Future - OTC'),('COM','OPT','CMP','COM Compound Option'),('COM','OPT','SMP','COM Simple option'),('COM','OPT','SWAP','COM Swaption'),('COM','SPOT','','COM Spot/Forward'),('COM','SWAP','','COM Swap'),('COM','SWAP','CAPA','COM Capacity'),('COM','SWAP','CLR','COM Cleared swap'),('COM','SWAP','PHYS','COM Physical Forward'),('COM','SWAP','TRS','COM transport'),('CURR','FUT','FUT','Futures'),('CURR','FXD','FXD','Spot-Forward'),('CURR','FXD','SWLEG','Forex-Swap Leg'),('CURR','FXD','XSW','Forex-Swap'),('CURR','OPT','ASN','Asian Option'),('CURR','OPT','BAR','Simple Barrier'),('CURR','OPT','BAR2','Double Barrier'),('CURR','OPT','FLEX','Flexible Deal'),('CURR','OPT','KIKO','Kiko Barrier'),('CURR','OPT','LST','Listed Option'),('CURR','OPT','RBT','Touch rebate'),('CURR','OPT','RBTS','Strip of Touch rebate'),('CURR','OPT','SMP','Simple Option'),('CURR','OPT','SMPS','Strip of Simple Options'),('EQD','FUT','     ','Future'),('EQD','OPT','OTC','otc'),('IRD','ASWP','','Asset swaps'),('IRD','BOND','','Bonds'),('IRD','BOND','CALL','Callable Bonds'),('IRD','BOND','CPCD','CP/CD'),('IRD','BOND','FWD','Bond Forwards'),('IRD','CD','','Call deposits'),('IRD','CF','','Caps/floors'),('IRD','CS','','Currency swaps'),('IRD','FRA','','FRA\'s'),('IRD','IRS','','Interest rate swaps'),('IRD','LFUT','','Long futures'),('IRD','LN_BR','','Loans/Deposits'),('IRD','OPT','ORG','Interest rate future options'),('IRD','OPT','OTC','Bond options'),('IRD','OSWP','','Swaptions'),('IRD','REPO','','Old Bond Buy/Sell Back'),('IRD','REPO','BSK','Basket Repos'),('IRD','REPO','REPO','Bond Repos'),('IRD','SFUT','','Short futures'),('SCF','SCF','SCF','Simple cash flow');
/*!40000 ALTER TABLE `trn_hdr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `actived_date` datetime NOT NULL,
  `status` varchar(45) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_user_role_idx` (`role`),
  CONSTRAINT `FKl5alypubd40lwejc45vl35wjb` FOREIGN KEY (`role`) REFERENCES `role` (`role_id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role`) REFERENCES `role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'LLE','1234','2011-12-18 13:17:17','ACTIVE',1),(2,'BA1','1234','2011-12-18 13:17:17','ACTIVE',2),(3,'LLE','$2a$10$BsSbBYwQNMUDkoIhIJR7v.MrKJbF8jhFYIWew9FFuzBFVFgV8XATK','2017-12-05 14:50:36','ACTIVE',1),(4,'PIKACHU','$2a$10$OIEN8PrBtxghefEZhJli2.wqEa.M4ekqtWK9.hJT.EbEwWDQSdJ6.','2017-12-05 14:56:05','ACTIVE',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-05 15:39:28

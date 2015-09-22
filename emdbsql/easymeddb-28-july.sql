-- MySQL dump 10.13  Distrib 5.6.25, for Win64 (x86_64)
--
-- Host: localhost    Database: easymeddb
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `city`
--
create database easymeddb;
use easymeddb;

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cityname` char(30) NOT NULL,
  `country` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_state_idx` (`state`),
  KEY `fk_country_idx` (`country`),
  CONSTRAINT `fk_city_country` FOREIGN KEY (`country`) REFERENCES `country` (`id`),
  CONSTRAINT `fk_city_state` FOREIGN KEY (`state`) REFERENCES `state` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (3,'London',2,2),(4,'Munich',3,3),(5,'Bangalore',3,3),(6,'Mysore',3,3);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryname` char(30) NOT NULL,
  `currency` char(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (2,'United Kingdom','Pound sterling'),(3,'Germany','Euro'),(4,'India','INR');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerdetails`
--

DROP TABLE IF EXISTS `customerdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerdetails` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(40) NOT NULL,
  `middlename` int(20) DEFAULT NULL,
  `lastname` varchar(20) NOT NULL,
  `Gender` tinyint(1) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(500) NOT NULL,
  `city` int(5) NOT NULL,
  `state` int(5) NOT NULL,
  `country` int(3) NOT NULL,
  `pin` smallint(6) NOT NULL,
  `usertype` int(3) NOT NULL,
  `createdat` datetime NOT NULL,
  `updatedat` datetime NOT NULL,
  `updatedby` int(4) NOT NULL,
  `password` varchar(15) CHARACTER SET utf8 NOT NULL,
  `primarycontactno` int(10) NOT NULL,
  `secondarycontactno` int(10) DEFAULT NULL,
  `emailid` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `primarycontactno_UNIQUE` (`primarycontactno`),
  UNIQUE KEY `emailid_UNIQUE` (`emailid`),
  KEY `fk_city_idx` (`city`),
  KEY `fk_country_idx` (`country`),
  KEY `fk_state_idx` (`state`),
  KEY `fk_gender_idx` (`Gender`),
  KEY `fk_usertype_idx` (`usertype`),
  CONSTRAINT `fk_city` FOREIGN KEY (`city`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_country` FOREIGN KEY (`country`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_state` FOREIGN KEY (`state`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usertype` FOREIGN KEY (`usertype`) REFERENCES `usertype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerdetails`
--

LOCK TABLES `customerdetails` WRITE;
/*!40000 ALTER TABLE `customerdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `customerdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drugtype`
--

DROP TABLE IF EXISTS `drugtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drugtype` (
  `iddrugtype` int(2) NOT NULL,
  `typename` varchar(45) NOT NULL,
  PRIMARY KEY (`iddrugtype`),
  UNIQUE KEY `idorders_UNIQUE` (`iddrugtype`),
  UNIQUE KEY `typename_UNIQUE` (`typename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drugtype`
--

LOCK TABLES `drugtype` WRITE;
/*!40000 ALTER TABLE `drugtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `drugtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mastermedicinelist`
--

DROP TABLE IF EXISTS `mastermedicinelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mastermedicinelist` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `drugname` varchar(255) NOT NULL,
  `verified` tinyint(1) NOT NULL,
  `verificationdate` datetime DEFAULT NULL,
  `lastupdatedon` datetime NOT NULL,
  `banned` tinyint(1) NOT NULL,
  `companyname` varchar(255) NOT NULL,
  `createdat` datetime NOT NULL,
  `drugtypeid` varchar(45) NOT NULL,
  `perunitprice` int(5) NOT NULL,
  `isbanned` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastermedicinelist`
--

LOCK TABLES `mastermedicinelist` WRITE;
/*!40000 ALTER TABLE `mastermedicinelist` DISABLE KEYS */;
/*!40000 ALTER TABLE `mastermedicinelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mastermedicinestore`
--

DROP TABLE IF EXISTS `mastermedicinestore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mastermedicinestore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storename` varchar(255) NOT NULL,
  `ownername` varchar(255) NOT NULL,
  `isactive` tinyint(1) NOT NULL,
  `licennceno` varchar(200) NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `verifiedby` int(11) DEFAULT NULL,
  `verifyDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updatedbyid` int(11) NOT NULL,
  `documentssubmited` tinyint(1) NOT NULL,
  `address` varchar(500) NOT NULL,
  `state` int(11) NOT NULL,
  `city` int(11) NOT NULL,
  `country` int(11) NOT NULL,
  `pin` int(11) NOT NULL,
  `primarycontactno` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_store_city` (`city`),
  KEY `fk_store_state` (`state`),
  KEY `fk_store_country` (`country`),
  CONSTRAINT `fk_store_city` FOREIGN KEY (`city`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_store_country` FOREIGN KEY (`country`) REFERENCES `country` (`id`),
  CONSTRAINT `fk_store_state` FOREIGN KEY (`state`) REFERENCES `state` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mastermedicinestore`
--

LOCK TABLES `mastermedicinestore` WRITE;
/*!40000 ALTER TABLE `mastermedicinestore` DISABLE KEYS */;
/*!40000 ALTER TABLE `mastermedicinestore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otp_request_details`
--

DROP TABLE IF EXISTS `otp_request_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `otp_request_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `requestedby` int(11) NOT NULL,
  `otp` int(11) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT '0',
  `isValidated` tinyint(1) DEFAULT '0',
  `createdDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otp_request_details`
--

LOCK TABLES `otp_request_details` WRITE;
/*!40000 ALTER TABLE `otp_request_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `otp_request_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `middlename` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) NOT NULL,
  `gender` enum('male','female') NOT NULL,
  `mobileno` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` varchar(300) NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifiedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `city` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `country` int(11) NOT NULL,
  `pin` int(6) NOT NULL,
  `usertype` int(11) DEFAULT NULL,
  `appinfo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `mobilenno_UNIQUE` (`mobileno`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_patient_city` (`city`),
  KEY `fk_patient_country` (`country`),
  KEY `fk_patient_state` (`state`),
  KEY `fk_patient_usertype` (`usertype`),
  CONSTRAINT `fk_patient_city` FOREIGN KEY (`city`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_patient_country` FOREIGN KEY (`country`) REFERENCES `country` (`id`),
  CONSTRAINT `fk_patient_state` FOREIGN KEY (`state`) REFERENCES `state` (`id`),
  CONSTRAINT `fk_patient_usertype` FOREIGN KEY (`usertype`) REFERENCES `usertype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (2,'Gabbar',NULL,'Sing','male','9876543210','gabbar@zmed.com','reset@123','ramgar','2015-07-12 18:30:00','2015-07-12 18:30:00',3,2,2,560032,2,NULL),(4,'Mugambo','Khush','Hua','male','9876543211','mugambo@zmed.com','reset123','kolapur','2015-07-14 14:58:27','2015-07-14 14:58:27',3,2,2,799001,2,NULL),(5,'Adolf',NULL,'Hitler','male','9876543212','ahitler@zmed.com','reset123','Reich Chancellery','2015-07-14 15:30:57','2015-07-14 15:30:57',4,3,3,799002,1,NULL),(6,'Mussolini',NULL,'Benito','male','9876543215','mussolini@zmed.com','reset_123','italy','2015-07-18 18:36:47','2015-07-18 18:36:47',3,2,2,799001,2,NULL);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `statename` char(30) NOT NULL,
  `country` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_state_country` (`country`),
  CONSTRAINT `fk_state_country` FOREIGN KEY (`country`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (2,'London',2),(3,'Munich',3),(4,'Karnataka',3);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `updatehistory`
--

DROP TABLE IF EXISTS `updatehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `updatehistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `updatedtype` varchar(45) NOT NULL,
  `typeid` varchar(45) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `updatedtype_UNIQUE` (`updatedtype`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `typeid_UNIQUE` (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `updatehistory`
--

LOCK TABLES `updatehistory` WRITE;
/*!40000 ALTER TABLE `updatehistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `updatehistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermedmapping`
--

DROP TABLE IF EXISTS `usermedmapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermedmapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drugid` int(5) NOT NULL,
  `userid` int(11) NOT NULL,
  `quantity` int(5) NOT NULL,
  `username` varchar(45) NOT NULL,
  `drugname` varchar(45) NOT NULL,
  `storeid` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idusermedmapping_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermedmapping`
--

LOCK TABLES `usermedmapping` WRITE;
/*!40000 ALTER TABLE `usermedmapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `usermedmapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertype` (
  `id` int(3) NOT NULL,
  `usertype` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idusertype_UNIQUE` (`id`),
  UNIQUE KEY `Admin_UNIQUE` (`usertype`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'admin'),(2,'patient');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-28 10:16:30

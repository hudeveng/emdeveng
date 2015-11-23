-- MySQL dump 10.13  Distrib 5.6.25, for Win64 (x86_64)
--
-- Host: localhost    Database: grepreqdb
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
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `dob` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `phone` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` enum('male','female') DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultationhistory`
--

DROP TABLE IF EXISTS `consultationhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consultationhistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `professionaldetailsid` int(11) DEFAULT NULL,
  `clientid` int(11) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modeid` int(11) DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `consultationhistory_professionaldetails_fk` (`professionaldetailsid`),
  KEY `consultationhistory_client_fk` (`clientid`),
  KEY `consultationhistory_mode_fk` (`modeid`),
  CONSTRAINT `consultationhistory_client_fk` FOREIGN KEY (`clientid`) REFERENCES `client` (`id`),
  CONSTRAINT `consultationhistory_mode_fk` FOREIGN KEY (`modeid`) REFERENCES `mode` (`id`),
  CONSTRAINT `consultationhistory_professionaldetails_fk` FOREIGN KEY (`professionaldetailsid`) REFERENCES `professionaldetails` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultationhistory`
--

LOCK TABLES `consultationhistory` WRITE;
/*!40000 ALTER TABLE `consultationhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `consultationhistory` ENABLE KEYS */;
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
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locality`
--

DROP TABLE IF EXISTS `locality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locality` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `city` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `locality_city_fk` (`city`),
  CONSTRAINT `locality_city_fk` FOREIGN KEY (`city`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locality`
--

LOCK TABLES `locality` WRITE;
/*!40000 ALTER TABLE `locality` DISABLE KEYS */;
/*!40000 ALTER TABLE `locality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logincredentials`
--

DROP TABLE IF EXISTS `logincredentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logincredentials` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `professionaldetails` int(11) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `otp` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `logincredentials_professionaldetails_fk` (`professionaldetails`),
  CONSTRAINT `logincredentials_professionaldetails_fk` FOREIGN KEY (`professionaldetails`) REFERENCES `professionaldetails` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logincredentials`
--

LOCK TABLES `logincredentials` WRITE;
/*!40000 ALTER TABLE `logincredentials` DISABLE KEYS */;
/*!40000 ALTER TABLE `logincredentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mode`
--

DROP TABLE IF EXISTS `mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modeofconsultation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mode`
--

LOCK TABLES `mode` WRITE;
/*!40000 ALTER TABLE `mode` DISABLE KEYS */;
/*!40000 ALTER TABLE `mode` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otp_request_details`
--

LOCK TABLES `otp_request_details` WRITE;
/*!40000 ALTER TABLE `otp_request_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `otp_request_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `practiceareas`
--

DROP TABLE IF EXISTS `practiceareas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `practiceareas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `practiceareas` varchar(100) DEFAULT NULL,
  `professionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `practiceareas_professionid_fk` (`professionid`),
  CONSTRAINT `practiceareas_professionid_fk` FOREIGN KEY (`professionid`) REFERENCES `professions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `practiceareas`
--

LOCK TABLES `practiceareas` WRITE;
/*!40000 ALTER TABLE `practiceareas` DISABLE KEYS */;
/*!40000 ALTER TABLE `practiceareas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professionaldetails`
--

DROP TABLE IF EXISTS `professionaldetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professionaldetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `dob` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `phone` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` enum('male','female') DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `professions` int(11) DEFAULT NULL,
  `locality` int(11) DEFAULT NULL,
  `languagesopken` varchar(100) DEFAULT NULL,
  `pan` varchar(20) DEFAULT NULL,
  `isactive` tinyint(4) DEFAULT NULL,
  `others` blob,
  `professionalpracticemapping` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `professionaldetails_locality_fk` (`locality`),
  KEY `professionaldetails_profession_fk` (`professions`),
  KEY `professioanldetails_professioanlpracticemapping_fk` (`professionalpracticemapping`),
  CONSTRAINT `professioanldetails_professioanlpracticemapping_fk` FOREIGN KEY (`professionalpracticemapping`) REFERENCES `professionalpracticemapping` (`id`),
  CONSTRAINT `professionaldetails_locality_fk` FOREIGN KEY (`locality`) REFERENCES `locality` (`id`),
  CONSTRAINT `professionaldetails_profession_fk` FOREIGN KEY (`professions`) REFERENCES `professions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professionaldetails`
--

LOCK TABLES `professionaldetails` WRITE;
/*!40000 ALTER TABLE `professionaldetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `professionaldetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professionalpracticemapping`
--

DROP TABLE IF EXISTS `professionalpracticemapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professionalpracticemapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `professionsid` int(11) DEFAULT NULL,
  `practiceareas` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `professionalpracticemapping_professionsid_fk` (`professionsid`),
  KEY `professionalpracticemapping_practiceareas_fk` (`practiceareas`),
  CONSTRAINT `professionalpracticemapping_practiceareas_fk` FOREIGN KEY (`practiceareas`) REFERENCES `practiceareas` (`id`),
  CONSTRAINT `professionalpracticemapping_professionsid_fk` FOREIGN KEY (`professionsid`) REFERENCES `professions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professionalpracticemapping`
--

LOCK TABLES `professionalpracticemapping` WRITE;
/*!40000 ALTER TABLE `professionalpracticemapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `professionalpracticemapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professionattributes`
--

DROP TABLE IF EXISTS `professionattributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professionattributes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attributes` blob,
  `professionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `professionattributes_professions_fk` (`professionid`),
  CONSTRAINT `professionattributes_professions_fk` FOREIGN KEY (`professionid`) REFERENCES `professions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professionattributes`
--

LOCK TABLES `professionattributes` WRITE;
/*!40000 ALTER TABLE `professionattributes` DISABLE KEYS */;
/*!40000 ALTER TABLE `professionattributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professions`
--

DROP TABLE IF EXISTS `professions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professions`
--

LOCK TABLES `professions` WRITE;
/*!40000 ALTER TABLE `professions` DISABLE KEYS */;
/*!40000 ALTER TABLE `professions` ENABLE KEYS */;
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
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-23  0:11:55

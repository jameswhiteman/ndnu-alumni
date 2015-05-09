-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: ndnualumni
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `docs`
--

DROP TABLE IF EXISTS `docs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docs` (
  `DocID` int(5) NOT NULL,
  `ProjectID` int(11) NOT NULL,
  `DocName` varchar(40) DEFAULT NULL,
  `DocType` varchar(40) DEFAULT NULL,
  `DocLocation` text,
  PRIMARY KEY (`DocID`),
  UNIQUE KEY `DocID` (`DocID`),
  KEY `ProjectID` (`ProjectID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `EventID` int(6) NOT NULL AUTO_INCREMENT,
  `EventTitle` varchar(255) NOT NULL,
  `EventType` varchar(100) NOT NULL,
  `EventOrgName` varchar(70) DEFAULT NULL,
  `EventMajor` varchar(70) DEFAULT NULL,
  `EventTopic` varchar(255) DEFAULT NULL,
  `EventDesc` text,
  `EventTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`EventID`),
  UNIQUE KEY `EventID` (`EventID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `QuestionID` int(6) NOT NULL AUTO_INCREMENT,
  `UserID` int(5) NOT NULL,
  `QuestionOne` text,
  `QuestionTwo` text,
  `QuestionThree` text,
  `QuestionFour` text,
  `QuestionFive` text,
  PRIMARY KEY (`QuestionID`),
  UNIQUE KEY `QuestionId` (`QuestionID`),
  KEY `UserID` (`UserID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs` (
  `JobID` int(5) NOT NULL,
  `UserID` int(5) NOT NULL,
  `JobTitle` varchar(40) NOT NULL DEFAULT '',
  `CompanyName` varchar(40) DEFAULT NULL,
  `Salary` decimal(10,2) DEFAULT NULL,
  `Description` text,
  `JobType` varchar(40) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  PRIMARY KEY (`JobID`),
  UNIQUE KEY `JobID` (`JobID`),
  KEY `UserID` (`UserID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `ProjectID` int(5) NOT NULL AUTO_INCREMENT,
  `ProjectName` varchar(40) NOT NULL DEFAULT '',
  `ProjectYear` int(11) DEFAULT NULL,
  `ProjectAbstracts` text,
  PRIMARY KEY (`ProjectID`),
  UNIQUE KEY `ProjectID` (`ProjectID`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserID` int(5) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(30) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `UserType` varchar(30) DEFAULT NULL,
  `ProjectID` int(5) DEFAULT NULL,
  `JobTitle` varchar(255) DEFAULT NULL,
  `Company` varchar(255) DEFAULT NULL,
  `GradYear` int(4) DEFAULT NULL,
  `Major` varchar(40) DEFAULT NULL,
  `PhoneNumber` varchar(12) DEFAULT NULL,
  `Email` varchar(70) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
  `State` varchar(20) DEFAULT NULL,
  `Description` text,
  `Page` text,
  `Image` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `user_id` (`UserID`),
  KEY `ProjectID` (`ProjectID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-08 19:46:32

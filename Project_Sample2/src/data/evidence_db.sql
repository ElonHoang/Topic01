-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: evidence_db
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `criminal`
--
CREATE DATABASE IF NOT EXISTS evidence_db;
USE evidence_db;
DROP TABLE IF EXISTS `criminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criminal` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `version` varchar(45) NOT NULL,
  `number` varchar(255) NOT NULL,
  `type` varchar(55) NOT NULL,
  `shortDescription` varchar(255) NOT NULL,
  `detailedDescription` varchar(255) NOT NULL,
  `status` varchar(55) NOT NULL,
  `note` varchar(55) NOT NULL,
  `leadDetective` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `leadDetective` (`leadDetective`),
  CONSTRAINT `criminal_ibfk_1` FOREIGN KEY (`leadDetective`) REFERENCES `detective` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criminal`
--

LOCK TABLES `criminal` WRITE;
/*!40000 ALTER TABLE `criminal` DISABLE KEYS */;
INSERT INTO `criminal` VALUES (1,'0004','2AS2','INFRACTION','wegtwea','gtetgeatgaetaertfa','UNDER_INVESTIGATION','214214',1),(2,'2','043','FENOLY','short','detailed','IN_COURT','note',2);
/*!40000 ALTER TABLE `criminal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detective`
--

DROP TABLE IF EXISTS `detective`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detective` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `version` varchar(45) NOT NULL,
  `personId` bigint DEFAULT NULL,
  `badgeNumber` varchar(55) NOT NULL,
  `rank` varchar(55) NOT NULL,
  `armed` tinyint(1) NOT NULL,
  `status` varchar(55) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `personId` (`personId`),
  CONSTRAINT `detective_ibfk_1` FOREIGN KEY (`personId`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detective`
--

LOCK TABLES `detective` WRITE;
/*!40000 ALTER TABLE `detective` DISABLE KEYS */;
INSERT INTO `detective` VALUES (1,'003',1,'1','CHEF_INSPECTOR',1,'ACTIVE'),(2,'2',1,'2DA','JUNIOR',1,'UNDER_INVESGATION'),(3,'2',2,'tArtt','INSPECTOR',0,'SUPENDED');
/*!40000 ALTER TABLE `detective` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evidence`
--

DROP TABLE IF EXISTS `evidence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evidence` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `version` varchar(45) NOT NULL,
  `criminalId` bigint DEFAULT NULL,
  `storageId` bigint DEFAULT NULL,
  `number` varchar(55) NOT NULL,
  `itemName` varchar(55) NOT NULL,
  `note` varchar(55) NOT NULL,
  `archired` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `criminalId` (`criminalId`),
  KEY `storageId` (`storageId`),
  CONSTRAINT `evidence_ibfk_1` FOREIGN KEY (`criminalId`) REFERENCES `criminal` (`id`),
  CONSTRAINT `evidence_ibfk_2` FOREIGN KEY (`storageId`) REFERENCES `storage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evidence`
--

LOCK TABLES `evidence` WRITE;
/*!40000 ALTER TABLE `evidence` DISABLE KEYS */;
INSERT INTO `evidence` VALUES (1,'001',1,1,'21A','Kinhsam','efrtq',1),(2,'16',2,2,'222','item2','note2',0),(3,'16',2,2,'222L','item2','note2',0);
/*!40000 ALTER TABLE `evidence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `version` varchar(45) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `firstName` varchar(55) DEFAULT NULL,
  `lastName` varchar(55) DEFAULT NULL,
  `passWord` varchar(55) DEFAULT NULL,
  `hiringDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'002','ANOAN','Hoang','An','123456','1996-12-24 00:00:00'),(2,'004','SDAD','GAQHNONehgt','agwegata','216512561','2006-02-24 00:00:00'),(3,'2','Hoanf','Nguyef','Vief','AAA3970','2022-06-12 00:00:00');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storage` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `version` varchar(45) DEFAULT NULL,
  `name` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `location` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES (1,'003','ABC','Tanbap'),(2,'33','Am','VAVN'),(3,'4','Bm','FHN');
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trackentry`
--

DROP TABLE IF EXISTS `trackentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trackentry` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `version` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `evidenceId` bigint DEFAULT NULL,
  `detectiveId` bigint DEFAULT NULL,
  `action` varchar(55) NOT NULL,
  `reason` varchar(55) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `evidenceId` (`evidenceId`),
  KEY `detectiveId` (`detectiveId`),
  CONSTRAINT `trackentry_ibfk_1` FOREIGN KEY (`evidenceId`) REFERENCES `evidence` (`id`),
  CONSTRAINT `trackentry_ibfk_2` FOREIGN KEY (`detectiveId`) REFERENCES `detective` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trackentry`
--

LOCK TABLES `trackentry` WRITE;
/*!40000 ALTER TABLE `trackentry` DISABLE KEYS */;
INSERT INTO `trackentry` VALUES (1,'0021','2022-02-22 00:00:00',1,1,'SUBMITTED','2154512512ewsadasw'),(4,'4','2022-06-12 00:00:00',2,2,'RETRIEVED','ABCNAHNJOWO');
/*!40000 ALTER TABLE `trackentry` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-14 18:02:12

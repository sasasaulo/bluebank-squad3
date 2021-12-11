-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: s3t2-pandas-database.clyhnzfw5a4h.us-east-2.rds.amazonaws.com    Database: s3t2_PANdas_Database
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(120) NOT NULL,
  `telefone` bigint NOT NULL,
  `idconta` bigint NOT NULL,
  `id_endereco` bigint NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `UK_r1u8010d60num5vc8fp0q1j2a` (`cpf`),
  UNIQUE KEY `UKr1u8010d60num5vc8fp0q1j2a` (`cpf`),
  KEY `FKkyuf3h2dpbkl95tfqkk9t49po` (`idconta`),
  KEY `FKlwi9bnlu6fxg74femu1u3wvy3` (`id_endereco`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'80220853088','Saulo Scarpina',11988541247,1,1),(2,'25906630058','Alana Lima',11988547412,2,2),(3,'24352147079','Denise Mignoli',11988547417,3,3),(4,'24647042022','Marcelo Silva',58995584785,4,4),(5,'60585516090','Carlos Mihlbar',58995584784,5,5),(6,'89646322069','Tamires Pinheiro',11988547412,6,6);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conta` (
  `id_conta` bigint NOT NULL AUTO_INCREMENT,
  `agencia` int NOT NULL,
  `conta` bigint NOT NULL,
  `saldo` int DEFAULT '0',
  PRIMARY KEY (`id_conta`),
  UNIQUE KEY `UK_2axim6g9e1ru90qmdm40p5l5v` (`conta`),
  UNIQUE KEY `UK2axim6g9e1ru90qmdm40p5l5v` (`conta`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (1,1000,100000,1000),(2,2000,200000,2000),(3,3000,300000,3200),(4,3000,400000,4085),(5,9999,500000,10160),(6,9999,600000,9555);
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `id_endereco` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) NOT NULL,
  `cep` varchar(255) NOT NULL,
  `numero` int NOT NULL,
  `rua` varchar(255) NOT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'Santana','02332000',144,'Avenida Água Fria'),(2,'Tucuruvi','02241000',89,'Rua Carapocaia'),(3,'Carandiru','02332000',89,'Avenida Cruzeiro do Sul'),(4,'Vila Olímpia','48598000',25,'Casa Rio Grande'),(5,'Vila das Vilas','48598845',25,'Sorte Brasil'),(6,'Tietê','02541000',89,'Rua Padre Ildefonso');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id_login` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `id_cliente` bigint NOT NULL,
  PRIMARY KEY (`id_login`),
  UNIQUE KEY `UKckk423i9neikbujv3kix8a0pl` (`email`,`id_cliente`),
  UNIQUE KEY `UK_3cs7dxhnine2f6x5ic4741s6e` (`email`),
  UNIQUE KEY `UK_cr3iutmavr8o7psqg2nyrrqyh` (`id_cliente`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'sasasaulo@gmail.com','$2a$10$DVKrJAAtNPAV1MD8jUtlgumPqmjQbfEiG1bsI5Ng5.IAZ2biCMHfa',1),(2,'alanalv300@hotmail.com','$2a$10$rq39pyEx9fDbO6sE3RBnXeaQbGGEZrh.EEtUw/mIIm4JAkiK14XJq',2),(3,'denisemignoli@gmail.com','$2a$10$Kkb8rZe0qCl7AAOF3DcTq.p/Eg/zZndfx/GAISfBQ0u.mVTH1Tkpm',3),(4,'tamirespinheiro@live.com','$2a$10$yCrWu2bsdpF.EACGhSq90ev691JJQNTVhibIMf/i2PANyzNl.Lk2e',6);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacoes`
--

DROP TABLE IF EXISTS `transacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transacoes` (
  `id_transacoes` bigint NOT NULL AUTO_INCREMENT,
  `contarecebe` bigint DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `id_contaenvia` bigint DEFAULT NULL,
  `valor_transacao` double NOT NULL,
  PRIMARY KEY (`id_transacoes`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacoes`
--

LOCK TABLES `transacoes` WRITE;
/*!40000 ALTER TABLE `transacoes` DISABLE KEYS */;
INSERT INTO `transacoes` VALUES (12,300000,'2021-12-11 15:43:10',6,250),(13,400000,'2021-12-11 15:43:37',5,150),(14,500000,'2021-12-11 15:43:49',6,250),(15,600000,'2021-12-11 15:44:09',3,50),(16,600000,'2021-12-11 15:44:21',4,5),(17,500000,'2021-12-11 15:44:31',4,60);
/*!40000 ALTER TABLE `transacoes` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-11 14:52:29

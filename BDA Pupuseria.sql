CREATE DATABASE  IF NOT EXISTS `pupuseria` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pupuseria`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: pupuseria
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `bebidas`
--

DROP TABLE IF EXISTS `bebidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebidas` (
  `cod_bebida` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cod_bebida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebidas`
--

LOCK TABLES `bebidas` WRITE;
/*!40000 ALTER TABLE `bebidas` DISABLE KEYS */;
INSERT INTO `bebidas` VALUES (1,'coca cola'),(2,'fanta'),(3,'soda uva'),(4,'sprite'),(5,'horchata'),(6,'cebada'),(7,'cafe'),(8,'chocolate'),(9,'colachampan');
/*!40000 ALTER TABLE `bebidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contraseña`
--

DROP TABLE IF EXISTS `contraseña`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contraseña` (
  `cod_contrase` int NOT NULL AUTO_INCREMENT,
  `cod_usuario` int NOT NULL,
  `contrasena` varchar(15) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cod_contrase`),
  KEY `fk_cod_usuario_idx` (`cod_usuario`),
  CONSTRAINT `fk_cod_usuario1` FOREIGN KEY (`cod_usuario`) REFERENCES `usuarios` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contraseña`
--

LOCK TABLES `contraseña` WRITE;
/*!40000 ALTER TABLE `contraseña` DISABLE KEYS */;
INSERT INTO `contraseña` VALUES (1,1,'1234'),(2,2,'4321'),(3,3,'9875');
/*!40000 ALTER TABLE `contraseña` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ordenes`
--

DROP TABLE IF EXISTS `detalle_ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_ordenes` (
  `cod_det_orden` int NOT NULL AUTO_INCREMENT,
  `cod_orden` int NOT NULL,
  `cod_pre_esp` int DEFAULT NULL,
  `cod_pre_tra` int DEFAULT NULL,
  `cod_bebida` int DEFAULT NULL,
  `cod_p_esp` int DEFAULT NULL,
  `cod_p_trad` int DEFAULT NULL,
  `cod_pre_beb` int DEFAULT NULL,
  `cantidad_esp` int DEFAULT NULL,
  `cantidad_tra` int DEFAULT NULL,
  `cantidad_bebida` int DEFAULT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`cod_det_orden`),
  KEY `fk_cod_orden_idx` (`cod_orden`),
  KEY `fk_cod_pre_espe_idx` (`cod_pre_esp`),
  KEY `fk_cod_pre_tra_idx` (`cod_pre_tra`),
  KEY `fk_cod_bebida_idx` (`cod_bebida`),
  KEY `fk_cod_p_espe_idx` (`cod_p_esp`),
  KEY `fk_cod_p_tradi_idx` (`cod_p_trad`),
  KEY `fk_cod_pre_beb_idx` (`cod_pre_beb`),
  CONSTRAINT `fk_ccod_p_trad` FOREIGN KEY (`cod_p_trad`) REFERENCES `precios_pupusas_trad` (`cod_p_trad`),
  CONSTRAINT `fk_cod_bebida` FOREIGN KEY (`cod_bebida`) REFERENCES `bebidas` (`cod_bebida`),
  CONSTRAINT `fk_cod_orden` FOREIGN KEY (`cod_orden`) REFERENCES `ordenes` (`cod_orden`),
  CONSTRAINT `fk_cod_p_esp` FOREIGN KEY (`cod_p_esp`) REFERENCES `precios_pupusa_esp` (`cod_p_esp`),
  CONSTRAINT `fk_cod_pre_bed` FOREIGN KEY (`cod_pre_beb`) REFERENCES `precio_bebidas` (`cod_pre_bed`),
  CONSTRAINT `fk_cod_pre_esp` FOREIGN KEY (`cod_pre_esp`) REFERENCES `precios_pupusa_esp` (`cod_p_esp`),
  CONSTRAINT `fk_cod_pre_tra` FOREIGN KEY (`cod_pre_tra`) REFERENCES `precios_pupusas_trad` (`cod_p_trad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ordenes`
--

LOCK TABLES `detalle_ordenes` WRITE;
/*!40000 ALTER TABLE `detalle_ordenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciones` (
  `cod_direccion` int NOT NULL AUTO_INCREMENT,
  `cod_usuario` int NOT NULL,
  `direccion` varchar(100) COLLATE utf8_bin NOT NULL,
  `municipio` varchar(25) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cod_direccion`),
  KEY `fk_cod_usuario_idx` (`cod_usuario`),
  CONSTRAINT `fk_cod_usuario` FOREIGN KEY (`cod_usuario`) REFERENCES `usuarios` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especial_1`
--

DROP TABLE IF EXISTS `especial_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especial_1` (
  `cod_es_1` int NOT NULL AUTO_INCREMENT,
  `cod_ingre` int NOT NULL,
  PRIMARY KEY (`cod_es_1`),
  KEY `fk_cod_ingre_idx` (`cod_ingre`),
  CONSTRAINT `fk_cod_ingre` FOREIGN KEY (`cod_ingre`) REFERENCES `ingredientes` (`cod_ingre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especial_1`
--

LOCK TABLES `especial_1` WRITE;
/*!40000 ALTER TABLE `especial_1` DISABLE KEYS */;
/*!40000 ALTER TABLE `especial_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especial_2`
--

DROP TABLE IF EXISTS `especial_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especial_2` (
  `cod_es_2` int NOT NULL AUTO_INCREMENT,
  `cod_ingre` int NOT NULL,
  PRIMARY KEY (`cod_es_2`),
  KEY `fk_cod_ingre_idx` (`cod_ingre`),
  CONSTRAINT `fk_cod_ingre2` FOREIGN KEY (`cod_ingre`) REFERENCES `ingredientes` (`cod_ingre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especial_2`
--

LOCK TABLES `especial_2` WRITE;
/*!40000 ALTER TABLE `especial_2` DISABLE KEYS */;
/*!40000 ALTER TABLE `especial_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especial_3`
--

DROP TABLE IF EXISTS `especial_3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especial_3` (
  `cod_es_3` int NOT NULL AUTO_INCREMENT,
  `cod_ingre` int NOT NULL,
  PRIMARY KEY (`cod_es_3`),
  KEY `fk_cod_ingre_idx` (`cod_ingre`),
  CONSTRAINT `fk_cod_ingre3` FOREIGN KEY (`cod_ingre`) REFERENCES `ingredientes` (`cod_ingre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especial_3`
--

LOCK TABLES `especial_3` WRITE;
/*!40000 ALTER TABLE `especial_3` DISABLE KEYS */;
/*!40000 ALTER TABLE `especial_3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especial_4`
--

DROP TABLE IF EXISTS `especial_4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especial_4` (
  `cod_es_4` int NOT NULL AUTO_INCREMENT,
  `cod_ingre` int NOT NULL,
  PRIMARY KEY (`cod_es_4`),
  KEY `fk_cod_ingre_idx` (`cod_ingre`),
  CONSTRAINT `fk_cod_ingre4` FOREIGN KEY (`cod_ingre`) REFERENCES `ingredientes` (`cod_ingre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especial_4`
--

LOCK TABLES `especial_4` WRITE;
/*!40000 ALTER TABLE `especial_4` DISABLE KEYS */;
/*!40000 ALTER TABLE `especial_4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especial_5`
--

DROP TABLE IF EXISTS `especial_5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especial_5` (
  `cod_es_5` int NOT NULL AUTO_INCREMENT,
  `cod_ingre` int NOT NULL,
  PRIMARY KEY (`cod_es_5`),
  KEY `fk_cod_ingre_idx` (`cod_ingre`),
  CONSTRAINT `fk_cod_ingre5` FOREIGN KEY (`cod_ingre`) REFERENCES `ingredientes` (`cod_ingre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especial_5`
--

LOCK TABLES `especial_5` WRITE;
/*!40000 ALTER TABLE `especial_5` DISABLE KEYS */;
/*!40000 ALTER TABLE `especial_5` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientes`
--

DROP TABLE IF EXISTS `ingredientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredientes` (
  `cod_ingre` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cod_ingre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientes`
--

LOCK TABLES `ingredientes` WRITE;
/*!40000 ALTER TABLE `ingredientes` DISABLE KEYS */;
INSERT INTO `ingredientes` VALUES (1,'queso'),(2,'chicharron'),(3,'jalapeño'),(4,'frijoles'),(5,'loroco'),(6,'ayote'),(7,'ajo'),(8,'pollo'),(9,'camaron'),(10,'choriso');
/*!40000 ALTER TABLE `ingredientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenes` (
  `cod_orden` int NOT NULL AUTO_INCREMENT,
  `cod_usuario` int NOT NULL,
  `Fecha` date NOT NULL,
  `hora` time NOT NULL,
  PRIMARY KEY (`cod_orden`),
  KEY `fk_cod_usuario_idx` (`cod_usuario`),
  CONSTRAINT `fk_cod_usuario_orden` FOREIGN KEY (`cod_usuario`) REFERENCES `usuarios` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_especial`
--

DROP TABLE IF EXISTS `pedido_especial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_especial` (
  `cod_ped_especial` int NOT NULL AUTO_INCREMENT,
  `cod_es_1` int NOT NULL,
  `cod_es_2` int NOT NULL,
  `cod_es_3` int NOT NULL,
  `cod_es_4` int NOT NULL,
  `cod_es_5` int NOT NULL,
  PRIMARY KEY (`cod_ped_especial`),
  KEY `fk_cod_es_1_idx` (`cod_es_1`),
  KEY `fk_cod_es_2_idx` (`cod_es_2`),
  KEY `fk_cod_es_3_idx` (`cod_es_3`),
  KEY `fk_cod_es_4_idx` (`cod_es_4`),
  KEY `fk_cod_es_5_idx` (`cod_es_5`),
  CONSTRAINT `fk_cod_es_1` FOREIGN KEY (`cod_es_1`) REFERENCES `especial_1` (`cod_es_1`),
  CONSTRAINT `fk_cod_es_2` FOREIGN KEY (`cod_es_2`) REFERENCES `especial_2` (`cod_es_2`),
  CONSTRAINT `fk_cod_es_3` FOREIGN KEY (`cod_es_3`) REFERENCES `especial_3` (`cod_es_3`),
  CONSTRAINT `fk_cod_es_4` FOREIGN KEY (`cod_es_4`) REFERENCES `especial_4` (`cod_es_4`),
  CONSTRAINT `fk_cod_es_5` FOREIGN KEY (`cod_es_5`) REFERENCES `especial_5` (`cod_es_5`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_especial`
--

LOCK TABLES `pedido_especial` WRITE;
/*!40000 ALTER TABLE `pedido_especial` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido_especial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_orden_especial`
--

DROP TABLE IF EXISTS `pre_orden_especial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pre_orden_especial` (
  `cod_pre_espe` int NOT NULL AUTO_INCREMENT,
  `cod_tip_pupusa` int NOT NULL,
  `cod_ped_especial` int NOT NULL,
  PRIMARY KEY (`cod_pre_espe`),
  KEY `fk_cod_tip_pupusa_idx` (`cod_tip_pupusa`),
  KEY `fk_cod_ped_espe_idx` (`cod_ped_especial`),
  CONSTRAINT `fk_cod_ped_especial` FOREIGN KEY (`cod_ped_especial`) REFERENCES `pedido_especial` (`cod_ped_especial`),
  CONSTRAINT `fk_cod_tip_pupusa2` FOREIGN KEY (`cod_tip_pupusa`) REFERENCES `tipos_pupusas` (`cod_tip_pupusa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_orden_especial`
--

LOCK TABLES `pre_orden_especial` WRITE;
/*!40000 ALTER TABLE `pre_orden_especial` DISABLE KEYS */;
/*!40000 ALTER TABLE `pre_orden_especial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_orden_tradicional`
--

DROP TABLE IF EXISTS `pre_orden_tradicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pre_orden_tradicional` (
  `cod_pre_tradi` int NOT NULL AUTO_INCREMENT,
  `cod_tip_pupusa` int NOT NULL,
  `cod_tra_pupusa` int NOT NULL,
  PRIMARY KEY (`cod_pre_tradi`),
  KEY `fk_cod_tip_pupusa_idx` (`cod_tip_pupusa`),
  KEY `fk_cod_tra_pupusa_idx` (`cod_tra_pupusa`),
  CONSTRAINT `fk_cod_tip_pupusa` FOREIGN KEY (`cod_tip_pupusa`) REFERENCES `tipos_pupusas` (`cod_tip_pupusa`),
  CONSTRAINT `fk_cod_tra_pupusa` FOREIGN KEY (`cod_tra_pupusa`) REFERENCES `pupusas_tradicional` (`cod_tra_pupusa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_orden_tradicional`
--

LOCK TABLES `pre_orden_tradicional` WRITE;
/*!40000 ALTER TABLE `pre_orden_tradicional` DISABLE KEYS */;
/*!40000 ALTER TABLE `pre_orden_tradicional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precio_bebidas`
--

DROP TABLE IF EXISTS `precio_bebidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `precio_bebidas` (
  `cod_pre_bed` int NOT NULL AUTO_INCREMENT,
  `precio` double NOT NULL,
  `cod_bebida` int NOT NULL,
  PRIMARY KEY (`cod_pre_bed`),
  KEY `fk_cod_beb_pre_idx` (`cod_bebida`),
  CONSTRAINT `fk_cod_beb_pre` FOREIGN KEY (`cod_bebida`) REFERENCES `bebidas` (`cod_bebida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precio_bebidas`
--

LOCK TABLES `precio_bebidas` WRITE;
/*!40000 ALTER TABLE `precio_bebidas` DISABLE KEYS */;
INSERT INTO `precio_bebidas` VALUES (1,0.6,1),(2,0.6,2),(3,0.6,3),(4,0.6,4),(5,1,5),(6,1,6),(7,0.6,7),(8,0.6,8),(9,0.6,9);
/*!40000 ALTER TABLE `precio_bebidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precios_pupusa_esp`
--

DROP TABLE IF EXISTS `precios_pupusa_esp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `precios_pupusa_esp` (
  `cod_p_esp` int NOT NULL AUTO_INCREMENT,
  `precio` double NOT NULL,
  PRIMARY KEY (`cod_p_esp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precios_pupusa_esp`
--

LOCK TABLES `precios_pupusa_esp` WRITE;
/*!40000 ALTER TABLE `precios_pupusa_esp` DISABLE KEYS */;
INSERT INTO `precios_pupusa_esp` VALUES (1,1.5);
/*!40000 ALTER TABLE `precios_pupusa_esp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precios_pupusas_trad`
--

DROP TABLE IF EXISTS `precios_pupusas_trad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `precios_pupusas_trad` (
  `cod_p_trad` int NOT NULL AUTO_INCREMENT,
  `cod_tra_pupusa` int NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`cod_p_trad`),
  KEY `fk_cod_tra_pu_idx` (`cod_tra_pupusa`),
  CONSTRAINT `fk_cod_tra_pupusa_prec` FOREIGN KEY (`cod_tra_pupusa`) REFERENCES `pupusas_tradicional` (`cod_tra_pupusa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precios_pupusas_trad`
--

LOCK TABLES `precios_pupusas_trad` WRITE;
/*!40000 ALTER TABLE `precios_pupusas_trad` DISABLE KEYS */;
INSERT INTO `precios_pupusas_trad` VALUES (1,1,0.5),(2,2,0.8),(3,3,0.8),(4,4,0.8),(5,5,0.8),(6,6,0.6),(7,7,0.8),(8,8,0.8),(9,9,0.8),(10,10,0.5);
/*!40000 ALTER TABLE `precios_pupusas_trad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pupusas_tradicional`
--

DROP TABLE IF EXISTS `pupusas_tradicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pupusas_tradicional` (
  `cod_tra_pupusa` int NOT NULL AUTO_INCREMENT,
  `pupusa` varchar(35) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cod_tra_pupusa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pupusas_tradicional`
--

LOCK TABLES `pupusas_tradicional` WRITE;
/*!40000 ALTER TABLE `pupusas_tradicional` DISABLE KEYS */;
INSERT INTO `pupusas_tradicional` VALUES (1,'revuelta'),(2,'queso'),(3,'queso loroco'),(4,'chicharron'),(5,'jalapeño queso'),(6,'frijol con queso'),(7,'chicharron con queso'),(8,'camaron'),(9,'pollo'),(10,'ayote con queso');
/*!40000 ALTER TABLE `pupusas_tradicional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `cod_rol` int NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cod_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Aministrador'),(2,'Empleaedo'),(3,'Cliente');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_pupusas`
--

DROP TABLE IF EXISTS `tipos_pupusas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_pupusas` (
  `cod_tip_pupusa` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(25) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cod_tip_pupusa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_pupusas`
--

LOCK TABLES `tipos_pupusas` WRITE;
/*!40000 ALTER TABLE `tipos_pupusas` DISABLE KEYS */;
INSERT INTO `tipos_pupusas` VALUES (1,'maiz'),(2,'arroz');
/*!40000 ALTER TABLE `tipos_pupusas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `cod_usuario` int NOT NULL AUTO_INCREMENT,
  `prim_nom` varchar(25) COLLATE utf8_bin NOT NULL,
  `seg_nom` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `prim_ape` varchar(25) COLLATE utf8_bin NOT NULL,
  `seg_ape` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `telefono` int NOT NULL,
  `correo` varchar(25) COLLATE utf8_bin NOT NULL,
  `cod_rol` int NOT NULL,
  PRIMARY KEY (`cod_usuario`),
  KEY `fk_cod_rol_idx` (`cod_rol`),
  CONSTRAINT `fk_cod_rol` FOREIGN KEY (`cod_rol`) REFERENCES `roles` (`cod_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Josue','Daniel','Quinteros','Rodriguez',24406102,'jdd@gmail.com',1),(2,'Pablo','Francisco','Landos','Pineda',23569452,'jqtw@gmail.com',2),(3,'Osvaldo','Andres','Dominguez','Mejia',21459875,'osva@gmail.com',3);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-15 23:20:25

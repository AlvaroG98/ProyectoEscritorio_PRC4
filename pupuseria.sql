CREATE DATABASE  IF NOT EXISTS `pupuseria_final` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pupuseria_final`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pupuseria_final
-- ------------------------------------------------------
-- Server version	5.7.27-log

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
-- Table structure for table `acompanamiento`
--

DROP TABLE IF EXISTS `acompanamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acompanamiento` (
  `idacompanamiento` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  `idtipoacompanamiento` int(11) NOT NULL,
  PRIMARY KEY (`idacompanamiento`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `FK_Tipo_acompanamiento_idx` (`idtipoacompanamiento`),
  CONSTRAINT `FK_Tipo_acompanamiento` FOREIGN KEY (`idtipoacompanamiento`) REFERENCES `tipoacompanamiento` (`idtipoacompanamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acompanamiento`
--

LOCK TABLES `acompanamiento` WRITE;
/*!40000 ALTER TABLE `acompanamiento` DISABLE KEYS */;
INSERT INTO `acompanamiento` VALUES (1,'Cocacola',0.65,1),(2,'Pepsi',0.6,1),(3,'Horchata',0.35,1),(4,'Tres leches',1.75,2),(5,'Budin',1,2);
/*!40000 ALTER TABLE `acompanamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ordenes_acom`
--

DROP TABLE IF EXISTS `detalle_ordenes_acom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_ordenes_acom` (
  `Cod_Detalle_Acomp` int(11) NOT NULL,
  `Cod_Acompanamiento` int(11) NOT NULL,
  `Cod_Ordenes` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Detalle_Acomp`),
  KEY `fk_detacom_cod_acompa_idx` (`Cod_Acompanamiento`),
  KEY `fk_detacom_cod_ordenes_idx` (`Cod_Ordenes`),
  CONSTRAINT `fk_detacom_cod_acompa` FOREIGN KEY (`Cod_Acompanamiento`) REFERENCES `acompanamiento` (`idacompanamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detacom_cod_ordenes` FOREIGN KEY (`Cod_Ordenes`) REFERENCES `ordenes` (`Cod_Orden`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ordenes_acom`
--

LOCK TABLES `detalle_ordenes_acom` WRITE;
/*!40000 ALTER TABLE `detalle_ordenes_acom` DISABLE KEYS */;
INSERT INTO `detalle_ordenes_acom` VALUES (1,1,1,2),(2,4,1,1);
/*!40000 ALTER TABLE `detalle_ordenes_acom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ordenes_especiales`
--

DROP TABLE IF EXISTS `detalle_ordenes_especiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_ordenes_especiales` (
  `Cod_Detalle_Especial` int(11) NOT NULL,
  `Cod_Especial` int(11) NOT NULL,
  `Cod_Ordenes` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Detalle_Especial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ordenes_especiales`
--

LOCK TABLES `detalle_ordenes_especiales` WRITE;
/*!40000 ALTER TABLE `detalle_ordenes_especiales` DISABLE KEYS */;
INSERT INTO `detalle_ordenes_especiales` VALUES (1,1,1,2),(2,2,1,1);
/*!40000 ALTER TABLE `detalle_ordenes_especiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ordenes_pupusas`
--

DROP TABLE IF EXISTS `detalle_ordenes_pupusas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_ordenes_pupusas` (
  `Cod_Detalle_Pupusas` int(11) NOT NULL,
  `Cod_Pupusa` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Descuento` float NOT NULL,
  `Cod_Ordenes` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Detalle_Pupusas`),
  KEY `fk_cod_pupusa_idx` (`Cod_Pupusa`),
  KEY `fk_cod_orden_idx` (`Cod_Ordenes`),
  CONSTRAINT `fk_cod_orden` FOREIGN KEY (`Cod_Ordenes`) REFERENCES `ordenes` (`Cod_Orden`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_pupusa` FOREIGN KEY (`Cod_Pupusa`) REFERENCES `pupusas` (`Cod_Pupusa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ordenes_pupusas`
--

LOCK TABLES `detalle_ordenes_pupusas` WRITE;
/*!40000 ALTER TABLE `detalle_ordenes_pupusas` DISABLE KEYS */;
INSERT INTO `detalle_ordenes_pupusas` VALUES (1,2,1,0,1),(2,1,2,0,1);
/*!40000 ALTER TABLE `detalle_ordenes_pupusas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_pupusa_especial`
--

DROP TABLE IF EXISTS `detalle_pupusa_especial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_pupusa_especial` (
  `Cod_Detalle_PupaEsp` int(11) NOT NULL,
  `Cod_Especial` int(11) NOT NULL,
  `Cod_Ingre` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Detalle_PupaEsp`),
  KEY `fk_detesp_cod_ingre_idx` (`Cod_Ingre`),
  KEY `fk_detesp_cod_esp_idx` (`Cod_Especial`),
  CONSTRAINT `fk_detesp_cod_esp` FOREIGN KEY (`Cod_Especial`) REFERENCES `pupusa_especial` (`Cod_Especial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detesp_cod_ingre` FOREIGN KEY (`Cod_Ingre`) REFERENCES `ingredientes` (`Cod_Ingre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pupusa_especial`
--

LOCK TABLES `detalle_pupusa_especial` WRITE;
/*!40000 ALTER TABLE `detalle_pupusa_especial` DISABLE KEYS */;
INSERT INTO `detalle_pupusa_especial` VALUES (1,1,1),(2,1,2),(3,1,4),(4,2,2),(5,2,5);
/*!40000 ALTER TABLE `detalle_pupusa_especial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `detalleordenes`
--

DROP TABLE IF EXISTS `detalleordenes`;
/*!50001 DROP VIEW IF EXISTS `detalleordenes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `detalleordenes` AS SELECT 
 1 AS `Cod_Orden`,
 1 AS `Nombre`,
 1 AS `Cantidad`,
 1 AS `Precio`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direcciones` (
  `Cod_direc` int(11) NOT NULL AUTO_INCREMENT,
  `Municipio` varchar(30) NOT NULL,
  `Direccion` varchar(40) NOT NULL,
  `Punto_referen` varchar(25) NOT NULL,
  `Telefono` int(8) NOT NULL,
  `Cod_Usuario` int(11) NOT NULL,
  PRIMARY KEY (`Cod_direc`),
  KEY `FK_COD_USUARIO_idx` (`Cod_Usuario`),
  CONSTRAINT `FK_COD_USUARIO` FOREIGN KEY (`Cod_Usuario`) REFERENCES `usuarios` (`Cod_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (2,'San salvador','5a AV note calle #3','Tienda azul',78787654,1),(3,'Santa tecla','8a AV note calle #4','Tienda roja',76543432,2),(4,'San Ignacio','Calle principal','Colegio Amigos',77777777,6),(5,'La Palma','Barrio El Centro','Iglesia',55555555,6),(6,'pruebamun','pruebadirec','pruebapunto',0,1),(7,'Citala','Calle principal','Frente al parque',11111111,6);
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `Cod_Empleado` int(11) NOT NULL AUTO_INCREMENT,
  `Prim_nom` varchar(25) NOT NULL,
  `Seg_nom` varchar(25) DEFAULT NULL,
  `Prim_ape` varchar(25) NOT NULL,
  `Seg_ape` varchar(25) DEFAULT NULL,
  `Email` varchar(20) NOT NULL,
  `Contraseña` varchar(10) NOT NULL,
  `Foto` blob NOT NULL,
  PRIMARY KEY (`Cod_Empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'Juan','Antonio','Perez','Hernandez','juanperez@gmail.com','1234','C:UserslandoDownloadscommunication.png'),(2,'Jorge','Mauricio','Serrano','Hernandez','mauricio@gmail.com','1234','C:UserslandoDownloadscommunication.png');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `encabezadoordenes`
--

DROP TABLE IF EXISTS `encabezadoordenes`;
/*!50001 DROP VIEW IF EXISTS `encabezadoordenes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `encabezadoordenes` AS SELECT 
 1 AS `Cod_Orden`,
 1 AS `Status`,
 1 AS `Nombre`,
 1 AS `Email`,
 1 AS `Fecha`,
 1 AS `ProcesoOrden`,
 1 AS `Direccion`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `harinas`
--

DROP TABLE IF EXISTS `harinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `harinas` (
  `Cod_Harina` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`Cod_Harina`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `harinas`
--

LOCK TABLES `harinas` WRITE;
/*!40000 ALTER TABLE `harinas` DISABLE KEYS */;
INSERT INTO `harinas` VALUES (2,'Arroz'),(1,'Maiz');
/*!40000 ALTER TABLE `harinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientes`
--

DROP TABLE IF EXISTS `ingredientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredientes` (
  `Cod_Ingre` int(11) NOT NULL AUTO_INCREMENT,
  `Ingredientes` varchar(35) NOT NULL,
  `Costo_Indiv` float NOT NULL,
  PRIMARY KEY (`Cod_Ingre`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientes`
--

LOCK TABLES `ingredientes` WRITE;
/*!40000 ALTER TABLE `ingredientes` DISABLE KEYS */;
INSERT INTO `ingredientes` VALUES (1,'Queso',0.5),(2,'Frijol',0.5),(3,'Chicharron',0.75),(4,'Loroco',0.75),(5,'Ayote',0.75),(6,'Ajo',0.75),(7,'Pollo',1.5),(8,'Camaron',2),(9,'Jalapeño',0.8);
/*!40000 ALTER TABLE `ingredientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordenes` (
  `Cod_Orden` int(11) NOT NULL AUTO_INCREMENT,
  `Status` varchar(35) NOT NULL,
  `Cod_Usuario` int(11) NOT NULL,
  `CreadaEl` date NOT NULL,
  `ProcesoOrden` int(1) NOT NULL,
  `Cod_Direccion` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Orden`),
  KEY `fk_cod_usuario2` (`Cod_Usuario`),
  KEY `fk_cod_direccion_idx` (`Cod_Direccion`),
  CONSTRAINT `fk_cod_direccion` FOREIGN KEY (`Cod_Direccion`) REFERENCES `direcciones` (`Cod_direc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_usuario2` FOREIGN KEY (`Cod_Usuario`) REFERENCES `usuarios` (`Cod_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
INSERT INTO `ordenes` VALUES (1,'Activa',6,'2020-11-03',1,4);
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pupusa_especial`
--

DROP TABLE IF EXISTS `pupusa_especial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pupusa_especial` (
  `Cod_Especial` int(11) NOT NULL,
  `Cod_Harina` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Especial`),
  KEY `fk_esp_cod_harina_idx` (`Cod_Harina`),
  CONSTRAINT `fk_esp_cod_harina` FOREIGN KEY (`Cod_Harina`) REFERENCES `harinas` (`Cod_Harina`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pupusa_especial`
--

LOCK TABLES `pupusa_especial` WRITE;
/*!40000 ALTER TABLE `pupusa_especial` DISABLE KEYS */;
INSERT INTO `pupusa_especial` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `pupusa_especial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pupusas`
--

DROP TABLE IF EXISTS `pupusas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pupusas` (
  `Cod_Pupusa` int(11) NOT NULL AUTO_INCREMENT,
  `Cod_Harina` int(11) NOT NULL,
  `Cod_Ingre` int(11) NOT NULL,
  PRIMARY KEY (`Cod_Pupusa`),
  KEY `fk_cod_ingre` (`Cod_Ingre`),
  KEY `fk_cod_harina_idx` (`Cod_Harina`),
  CONSTRAINT `fk_cod_harina` FOREIGN KEY (`Cod_Harina`) REFERENCES `harinas` (`Cod_Harina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_ingre` FOREIGN KEY (`Cod_Ingre`) REFERENCES `ingredientes` (`Cod_Ingre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pupusas`
--

LOCK TABLES `pupusas` WRITE;
/*!40000 ALTER TABLE `pupusas` DISABLE KEYS */;
INSERT INTO `pupusas` VALUES (1,1,1),(2,2,1),(3,1,2),(4,2,2),(5,1,3),(6,2,3);
/*!40000 ALTER TABLE `pupusas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `seleccionardatosusuario`
--

DROP TABLE IF EXISTS `seleccionardatosusuario`;
/*!50001 DROP VIEW IF EXISTS `seleccionardatosusuario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `seleccionardatosusuario` AS SELECT 
 1 AS `Email`,
 1 AS `Prim_nom`,
 1 AS `Seg_nom`,
 1 AS `Prim_ape`,
 1 AS `Seg_ape`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tipoacompanamiento`
--

DROP TABLE IF EXISTS `tipoacompanamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoacompanamiento` (
  `idtipoacompanamiento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipoacompanamiento`),
  UNIQUE KEY `Nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoacompanamiento`
--

LOCK TABLES `tipoacompanamiento` WRITE;
/*!40000 ALTER TABLE `tipoacompanamiento` DISABLE KEYS */;
INSERT INTO `tipoacompanamiento` VALUES (1,'Bebida','Refrescos, sodas, etc.'),(2,'Postre','Pasteles de la casa');
/*!40000 ALTER TABLE `tipoacompanamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `Cod_Usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Prim_nom` varchar(25) NOT NULL,
  `Seg_nom` varchar(25) DEFAULT NULL,
  `Prim_ape` varchar(25) NOT NULL,
  `Seg_ape` varchar(25) DEFAULT NULL,
  `Email` varchar(45) NOT NULL,
  `Contraseña` varchar(10) NOT NULL,
  PRIMARY KEY (`Cod_Usuario`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'0','0','0','0','0','0'),(2,'asasv','vdvfsd','vsdvs','dqw','qwfew','1234'),(3,'Orlando','Josue','Cortez','Santos','sfweiufnwe','1234'),(4,'Gerson','Daniel','Morales','Landaverde','hola@gmail.com','1234'),(5,'Alvaro','Calderon','Guillermo','Bonilla','safsfas','1234'),(6,'Gerson','Daniel','Morales','Landaverde','gmorales','1234'),(7,'El','John','Bon','Jovi','jonbonjovi','1234'),(8,'Chris','Tofer','En','Gel','cteg','1234');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vista_ingrediente`
--

DROP TABLE IF EXISTS `vista_ingrediente`;
/*!50001 DROP VIEW IF EXISTS `vista_ingrediente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vista_ingrediente` AS SELECT 
 1 AS `Cod_Ingre`,
 1 AS `Ingredientes`,
 1 AS `Costo_Indiv`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'pupuseria_final'
--
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarContrasena` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarContrasena`(IN In_Contrasena VARCHAR(10), IN IN_Email varchar(45))
    READS SQL DATA
BEGIN declare error int;
start transaction;
UPDATE usuarios set contraseña = In_Contrasena where Email = IN_Email;
SET error=(SELECT @error);
IF(error=0) THEN ROLLBACK;
ELSE COMMIT;
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ActualizarNombreUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarNombreUsuario`(IN_Email varchar(45), IN In_Nombre VARCHAR(25), IN In_Nombre2 VARCHAR(25), IN In_Apellido VARCHAR(25), IN In_Apellido2 VARCHAR(25))
    READS SQL DATA
BEGIN declare error int;
start transaction;
UPDATE usuarios set Prim_nom = In_Nombre, Seg_nom = In_Nombre2, Prim_ape = In_Apellido, Seg_ape = In_Apellido2 where Email = IN_Email;
SET error=(SELECT @error);
IF(error=0) THEN ROLLBACK;
ELSE COMMIT;
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertarDireccion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarDireccion`(IN IN_Municipio VARCHAR (30), IN IN_Direccion VARCHAR(40), IN IN_Punto_Referencia VARCHAR(25), IN IN_Telefono INT(8), IN IN_Email varchar(45))
    READS SQL DATA
BEGIN DECLARE error INT;
START TRANSACTION;
INSERT INTO direcciones (Municipio, Direccion, Punto_referen, Telefono, Cod_Usuario) VALUES(IN_Municipio, IN_Direccion, IN_Punto_Referencia, IN_Telefono, (select Cod_Usuario from usuarios where Email = IN_Email)); 
SET error=(SELECT @error); 
IF(error=0) THEN ROLLBACK;
ELSE COMMIT;
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarUsuario`(IN In_Prim_nom VARCHAR(25), IN In_Seg_nom VARCHAR(25), IN In_Prim_ape VARCHAR(25), IN In_Seg_ape VARCHAR(25), IN In_Email VARCHAR(25), IN In_Contrasena VARCHAR(10))
    READS SQL DATA
BEGIN DECLARE error INT;
START TRANSACTION;
INSERT INTO usuarios (Prim_nom, Seg_nom, Prim_ape, Seg_ape, Email, Contraseña) 
VALUES(IN_Prim_nom, IN_Seg_nom, IN_Prim_ape, IN_Seg_ape, IN_Email, IN_Contrasena); 
SET error=(SELECT @error);
IF(error=0) THEN ROLLBACK;
ELSE COMMIT;
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `detalleordenes`
--

/*!50001 DROP VIEW IF EXISTS `detalleordenes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `detalleordenes` AS select `o`.`Cod_Orden` AS `Cod_Orden`,`a`.`nombre` AS `Nombre`,`doa`.`Cantidad` AS `Cantidad`,round(`a`.`precio`,2) AS `Precio` from ((`ordenes` `o` join `detalle_ordenes_acom` `doa` on((`o`.`Cod_Orden` = `doa`.`Cod_Ordenes`))) join `acompanamiento` `a` on((`a`.`idacompanamiento` = `doa`.`Cod_Acompanamiento`))) union select `o`.`Cod_Orden` AS `Cod_Orden`,concat(`i`.`Ingredientes`,' (',`h`.`Nombre`,')') AS `concat(i.Ingredientes, ' (', h.Nombre, ')')`,`dop`.`Cantidad` AS `Cantidad`,round(`i`.`Costo_Indiv`,2) AS `round(i.Costo_Indiv, 2)` from ((((`ordenes` `o` join `detalle_ordenes_pupusas` `dop` on((`o`.`Cod_Orden` = `dop`.`Cod_Ordenes`))) join `pupusas` `p` on((`p`.`Cod_Pupusa` = `dop`.`Cod_Pupusa`))) join `ingredientes` `i` on((`i`.`Cod_Ingre` = `p`.`Cod_Ingre`))) join `harinas` `h` on((`h`.`Cod_Harina` = `p`.`Cod_Harina`))) union select `o`.`Cod_Orden` AS `Cod_Orden`,concat((select group_concat(' ',`i`.`Ingredientes` separator ',') AS `ingredientes` from (`detalle_pupusa_especial` `dpe` join `ingredientes` `i` on((`i`.`Cod_Ingre` = `dpe`.`Cod_Ingre`))) where (`dpe`.`Cod_Especial` = `doe`.`Cod_Especial`) group by `dpe`.`Cod_Especial`),' (',`h`.`Nombre`,')') AS `Name_exp_10`,`doe`.`Cantidad` AS `Cantidad`,round((select sum(`i`.`Costo_Indiv`) from (`detalle_pupusa_especial` `dps` join `ingredientes` `i` on((`i`.`Cod_Ingre` = `dps`.`Cod_Ingre`))) where (`doe`.`Cod_Especial` = `dps`.`Cod_Especial`) group by `dps`.`Cod_Especial`),2) AS `Precio` from (((`ordenes` `o` join `detalle_ordenes_especiales` `doe` on((`o`.`Cod_Orden` = `doe`.`Cod_Ordenes`))) join `pupusa_especial` `ps` on((`ps`.`Cod_Especial` = `doe`.`Cod_Especial`))) join `harinas` `h` on((`h`.`Cod_Harina` = `ps`.`Cod_Harina`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `encabezadoordenes`
--

/*!50001 DROP VIEW IF EXISTS `encabezadoordenes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `encabezadoordenes` AS select `o`.`Cod_Orden` AS `Cod_Orden`,`o`.`Status` AS `Status`,concat(`u`.`Prim_nom`,' ',`u`.`Seg_nom`,' ',`u`.`Prim_ape`,' ',`u`.`Seg_ape`) AS `Nombre`,`u`.`Email` AS `Email`,`o`.`CreadaEl` AS `Fecha`,`o`.`ProcesoOrden` AS `ProcesoOrden`,concat(`d`.`Direccion`,', ',`d`.`Municipio`,', ',`d`.`Punto_referen`) AS `Direccion` from ((`ordenes` `o` join `usuarios` `u` on((`u`.`Cod_Usuario` = `o`.`Cod_Usuario`))) join `direcciones` `d` on((`d`.`Cod_direc` = `o`.`Cod_Direccion`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `seleccionardatosusuario`
--

/*!50001 DROP VIEW IF EXISTS `seleccionardatosusuario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `seleccionardatosusuario` AS select `usuarios`.`Email` AS `Email`,`usuarios`.`Prim_nom` AS `Prim_nom`,`usuarios`.`Seg_nom` AS `Seg_nom`,`usuarios`.`Prim_ape` AS `Prim_ape`,`usuarios`.`Seg_ape` AS `Seg_ape` from `usuarios` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_ingrediente`
--

/*!50001 DROP VIEW IF EXISTS `vista_ingrediente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_ingrediente` AS select `ingredientes`.`Cod_Ingre` AS `Cod_Ingre`,`ingredientes`.`Ingredientes` AS `Ingredientes`,`ingredientes`.`Costo_Indiv` AS `Costo_Indiv` from `ingredientes` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-04 12:50:25

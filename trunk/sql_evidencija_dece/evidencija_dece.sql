-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.32-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema evidencija_dece
--

CREATE DATABASE IF NOT EXISTS evidencija_dece;
USE evidencija_dece;



--
-- Definition of table `dete`
--

DROP TABLE IF EXISTS `dete`;
CREATE TABLE `dete` (
  `idde` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `jmbde` char(13) NOT NULL,
  `imede` varchar(20) NOT NULL,
  `przde` varchar(20) NOT NULL,
  `idk` int(10) unsigned NOT NULL,
  `brlkh` int(13) DEFAULT NULL,
  `idt` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idde`),
  UNIQUE KEY `Unique_jmbde` (`jmbde`),
  KEY `FK_dete_idk` (`idk`),
  KEY `FK_dete_brlkh` (`brlkh`),
  KEY `FK_dete_idt` (`idt`),
  CONSTRAINT `FK_dete_idk` FOREIGN KEY (`idk`) REFERENCES `kategorija` (`idk`) ON UPDATE CASCADE,
  CONSTRAINT `FK_dete_brlkh` FOREIGN KEY (`brlkh`) REFERENCES `hraniteljska_porodica` (`brlkh`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_dete_idt` FOREIGN KEY (`idt`) REFERENCES `tim` (`idt`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dete`
--

/*!40000 ALTER TABLE `dete` DISABLE KEYS */;
/*!40000 ALTER TABLE `dete` ENABLE KEYS */;



--
-- Definition of table `hraniteljska_porodica`
--

DROP TABLE IF EXISTS `hraniteljska_porodica`;
CREATE TABLE `hraniteljska_porodica` (
  `brlkh` int(6) NOT NULL,
  `jmbh` char(13) NOT NULL,
  `imeh` varchar(20) NOT NULL,
  `przh` varchar(20) NOT NULL,
  `adrh` varchar(50) NOT NULL,
  `gradh` varchar(20) NOT NULL,
  `ziph` varchar(10) NOT NULL,
  `telh` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`brlkh`),
  UNIQUE KEY `Unique_jmbh` (`jmbh`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hraniteljska_porodica`
--

/*!40000 ALTER TABLE `hraniteljska_porodica` DISABLE KEYS */;
/*!40000 ALTER TABLE `hraniteljska_porodica` ENABLE KEYS */;



--
-- Definition of table `kategorija`
--

DROP TABLE IF EXISTS `kategorija`;
CREATE TABLE `kategorija` (
  `idk` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazk` enum('hraniteljska porodica','dnevni boravak','sigurna kuca','materijalno ugrozena') NOT NULL DEFAULT 'sigurna kuca',
  PRIMARY KEY (`idk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategorija`
--

/*!40000 ALTER TABLE `kategorija` DISABLE KEYS */;
/*!40000 ALTER TABLE `kategorija` ENABLE KEYS */;



--
-- Definition of table `tim`
--

DROP TABLE IF EXISTS `tim`;
CREATE TABLE `tim` (
  `idt` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazt` varchar(30) NOT NULL,
  `opist` varchar(50) DEFAULT NULL,
  `napomenat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tim`
--

/*!40000 ALTER TABLE `tim` DISABLE KEYS */;
/*!40000 ALTER TABLE `tim` ENABLE KEYS */;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

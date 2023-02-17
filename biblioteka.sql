/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.21-MariaDB : Database - projekatoptika
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`projekatoptika` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `projekatoptika`;

/*Table structure for table `administratori` */

DROP TABLE IF EXISTS `administratori`;

CREATE TABLE `administratori` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `administratori` */

insert  into `administratori`(`id`,`username`,`password`,`ime`,`prezime`) values 
(1,'admin','admin','Admin','Admin'),
(2,'marko','1234','Marko','Markovic');

/*Table structure for table `naocare` */

DROP TABLE IF EXISTS `naocare`;

CREATE TABLE `naocare` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `marka` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `kolicina` int(11) NOT NULL,
  `cena` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `naocare` */

insert  into `naocare`(`id`,`marka`,`model`,`kolicina`,`cena`) values 
(6,'ARMANI','M-85',25,25000);

/*Table structure for table `opticari` */

DROP TABLE IF EXISTS `opticari`;

CREATE TABLE `opticari` (
  `opticarId` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `telefon` int(11) NOT NULL,
  PRIMARY KEY (`opticarId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `opticari` */

insert  into `opticari`(`opticarId`,`ime`,`prezime`,`telefon`) values 
(1,'Aleksandra','Grebovic',2147483647),
(2,'Mirjana','Stevanoski',2147483647);

/*Table structure for table `pacijenti` */

DROP TABLE IF EXISTS `pacijenti`;

CREATE TABLE `pacijenti` (
  `pacijentId` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `telefon` int(11) NOT NULL,
  `dioptrijaLevogOka` double NOT NULL,
  `dioptrijaDesnogOka` double NOT NULL,
  `PD` double NOT NULL,
  PRIMARY KEY (`pacijentId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pacijenti` */

insert  into `pacijenti`(`pacijentId`,`ime`,`prezime`,`telefon`,`dioptrijaLevogOka`,`dioptrijaDesnogOka`,`PD`) values 
(2,'Petar','Petrovic',631254879,-2.5,-2.5,55),
(3,'Milos','Milosevic',697894564,3.25,2,53),
(4,'Lazar','Markovic',65355885,0.75,0,52),
(5,'Marko','Perovicc',653565955,3.75,3.75,51),
(7,'Marko','Todorovic',653565885,3.75,3.75,62),
(9,'Janko','Petrovic',652565885,-1.25,-0.25,52),
(14,'Marko','Peric',612565335,1,1,62),
(15,'Milutina','Markovicc',621594885,-1.75,-1.25,62);

/*Table structure for table `stakla` */

DROP TABLE IF EXISTS `stakla`;

CREATE TABLE `stakla` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  `vrsta` varchar(255) NOT NULL,
  `dioptrija` double NOT NULL,
  `kolicina` int(11) NOT NULL,
  `cena` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `stakla` */

insert  into `stakla`(`id`,`naziv`,`vrsta`,`dioptrija`,`kolicina`,`cena`) values 
(1,'CR-39','ORGANIC',2.25,0,0),
(2,'CR-39','BLUECUT',2.25,0,0);

/*Table structure for table `statistikaodusluga` */

DROP TABLE IF EXISTS `statistikaodusluga`;

CREATE TABLE `statistikaodusluga` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opticarId` int(11) NOT NULL,
  `uslugaId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pacijentId` (`opticarId`),
  KEY `uslugaId` (`uslugaId`),
  CONSTRAINT `opticarId` FOREIGN KEY (`opticarId`) REFERENCES `opticari` (`opticarId`),
  CONSTRAINT `uslugaId` FOREIGN KEY (`uslugaId`) REFERENCES `usluge` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `statistikaodusluga` */

/*Table structure for table `stavkepregleda` */

DROP TABLE IF EXISTS `stavkepregleda`;

CREATE TABLE `stavkepregleda` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `terminPregledaId` int(11) NOT NULL,
  `uslugaId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usluga` (`terminPregledaId`),
  KEY `usluga1` (`uslugaId`),
  CONSTRAINT `termin` FOREIGN KEY (`terminPregledaId`) REFERENCES `terminpregleda` (`terminId`),
  CONSTRAINT `usluga1` FOREIGN KEY (`uslugaId`) REFERENCES `usluge` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `stavkepregleda` */

/*Table structure for table `terminpregleda` */

DROP TABLE IF EXISTS `terminpregleda`;

CREATE TABLE `terminpregleda` (
  `terminId` int(11) NOT NULL AUTO_INCREMENT,
  `datumVreme` date NOT NULL,
  `pacijentId` int(11) NOT NULL,
  `opticarId` int(11) NOT NULL,
  PRIMARY KEY (`terminId`),
  KEY `opticar` (`opticarId`),
  KEY `pacijent` (`pacijentId`),
  CONSTRAINT `opticar` FOREIGN KEY (`opticarId`) REFERENCES `opticari` (`opticarId`),
  CONSTRAINT `pacijent` FOREIGN KEY (`pacijentId`) REFERENCES `pacijenti` (`pacijentId`)
) ENGINE=InnoDB AUTO_INCREMENT=875 DEFAULT CHARSET=utf8mb4;

/*Data for the table `terminpregleda` */

insert  into `terminpregleda`(`terminId`,`datumVreme`,`pacijentId`,`opticarId`) values 
(1,'2022-12-13',3,1),
(2,'2022-12-12',2,1),
(4,'2021-12-14',4,2),
(5,'2021-12-08',5,1),
(865,'2015-11-01',4,1),
(869,'2023-01-23',5,1),
(873,'2023-01-03',14,1),
(874,'2023-01-03',15,1);

/*Table structure for table `usluge` */

DROP TABLE IF EXISTS `usluge`;

CREATE TABLE `usluge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naocareId` int(11) NOT NULL,
  `staklaId` int(11) NOT NULL,
  `vrsteUslugeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `naocareId` (`naocareId`),
  KEY `staklaId` (`staklaId`),
  KEY `crstaUslugeId` (`vrsteUslugeId`),
  CONSTRAINT `crstaUslugeId` FOREIGN KEY (`vrsteUslugeId`) REFERENCES `vrstausluge` (`id`),
  CONSTRAINT `naocareId` FOREIGN KEY (`naocareId`) REFERENCES `naocare` (`id`),
  CONSTRAINT `staklaId` FOREIGN KEY (`staklaId`) REFERENCES `stakla` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

/*Data for the table `usluge` */

insert  into `usluge`(`id`,`naocareId`,`staklaId`,`vrsteUslugeId`) values 
(24,6,1,1),
(25,6,2,1);

/*Table structure for table `vrstausluge` */

DROP TABLE IF EXISTS `vrstausluge`;

CREATE TABLE `vrstausluge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vrsta` varchar(255) NOT NULL,
  `cena` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `vrstausluge` */

insert  into `vrstausluge`(`id`,`vrsta`,`cena`) values 
(1,'merenje dioptrije',550);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

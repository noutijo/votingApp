-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 23, 2022 at 12:01 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ens`
--

-- --------------------------------------------------------

--
-- Table structure for table `candidat`
--

DROP TABLE IF EXISTS `candidat`;
CREATE TABLE IF NOT EXISTS `candidat` (
  `id_candidat` varchar(20) NOT NULL,
  `nom_candidat` varchar(50) NOT NULL,
  `prenom_candidat` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `nom_parti` varchar(30) NOT NULL,
  PRIMARY KEY (`id_candidat`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `candidat`
--

INSERT INTO `candidat` (`id_candidat`, `nom_candidat`, `prenom_candidat`, `age`, `nom_parti`) VALUES
('CAN01', 'NOUMODONG TINDJONG Junior-Oréol', 'Junior-Oréol', 21, 'BARCELONE'),
('CAN02', 'BETSEM', 'Edouard', 22, 'JUVENTUS'),
('CAN03', 'TAMKO', 'Clarence', 17, 'LIVERPOOL'),
('CAN04', 'HADANAMA', 'Ismael', 19, 'NTJO');

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `code_categorie` char(5) NOT NULL,
  `taux_tp` int(11) NOT NULL,
  `taux_td` int(11) NOT NULL,
  `taux_cm` int(11) NOT NULL,
  PRIMARY KEY (`code_categorie`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `code_classe` char(5) NOT NULL,
  `nom_classe` char(15) NOT NULL,
  PRIMARY KEY (`code_classe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `tarif` int(11) NOT NULL,
  `pourcent` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `nom`, `tarif`, `pourcent`) VALUES
(1, 'Noumodong', 45, ''),
(2, 'Noumodong', 45, ''),
(3, 'Tamko', 41, ''),
(4, 'Kameni', 21, ''),
(5, 'Noumodong', 11, ''),
(6, 'Kameni', 30, '');

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `utilisateurs_id` int(11) NOT NULL,
  `date_achat` date NOT NULL,
  `num_facture` varchar(50) NOT NULL,
  `prix_total` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`utilisateurs_id`, `date_achat`, `num_facture`, `prix_total`) VALUES
(1, '2013-01-23', 'A00103', 203.14),
(1, '2013-02-14', 'A00104', 124),
(2, '2013-02-17', 'A00105', 149.45),
(2, '2013-03-21', 'A00106', 235.35),
(5, '2013-03-02', 'A00107', 47.58);

-- --------------------------------------------------------

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `code_cours` char(5) NOT NULL,
  `nom_cours` char(30) NOT NULL,
  `nature_cours` char(30) NOT NULL,
  `code_salle` char(5) DEFAULT NULL,
  PRIMARY KEY (`code_cours`),
  KEY `code_salle` (`code_salle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dates`
--

DROP TABLE IF EXISTS `dates`;
CREATE TABLE IF NOT EXISTS `dates` (
  `periodes` date NOT NULL,
  PRIMARY KEY (`periodes`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dipenser`
--

DROP TABLE IF EXISTS `dipenser`;
CREATE TABLE IF NOT EXISTS `dipenser` (
  `code_cours` char(20) NOT NULL,
  `periodes` date NOT NULL,
  `code_plage` char(5) NOT NULL,
  `id_enseignant` char(5) NOT NULL,
  `code_salle` char(10) NOT NULL,
  PRIMARY KEY (`code_cours`,`periodes`,`code_plage`,`id_enseignant`,`code_salle`),
  KEY `code_salle` (`code_salle`),
  KEY `periodes` (`periodes`),
  KEY `code_plage` (`code_plage`),
  KEY `id_enseignant` (`id_enseignant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `effectuer`
--

DROP TABLE IF EXISTS `effectuer`;
CREATE TABLE IF NOT EXISTS `effectuer` (
  `id_tp` char(5) NOT NULL,
  `code_laboratoire` char(5) NOT NULL,
  `id_enseignant` char(30) NOT NULL,
  `periodes` date NOT NULL,
  `id_groupe` char(5) NOT NULL,
  PRIMARY KEY (`id_tp`,`code_laboratoire`,`id_enseignant`,`periodes`,`id_groupe`),
  KEY `code_laboratoire` (`code_laboratoire`),
  KEY `id_enseignant` (`id_enseignant`),
  KEY `periodes` (`periodes`),
  KEY `id_groupe` (`id_groupe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `id_enseignant` char(5) NOT NULL,
  `nom_enseignant` char(30) NOT NULL,
  `prenom_enseignant` char(30) NOT NULL,
  `add_enseignant` char(30) NOT NULL,
  `email_enseignant` char(30) NOT NULL,
  `telephone_enseignant` int(11) NOT NULL,
  `statut_enseignant` char(30) NOT NULL,
  `code_categorie` char(5) DEFAULT NULL,
  PRIMARY KEY (`id_enseignant`),
  KEY `code_categorie` (`code_categorie`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enseignant`
--

INSERT INTO `enseignant` (`id_enseignant`, `nom_enseignant`, `prenom_enseignant`, `add_enseignant`, `email_enseignant`, `telephone_enseignant`, `statut_enseignant`, `code_categorie`) VALUES
('JUU', 'Ngoufack', 'Ursem', 'EmanaII', 'ursemngoufack@gmail.com', 695825524, 'Cuba', 'Chili'),
('EN011', 'Noumo', 'oreo', 'Canada', 'j@hhd', 6522155, 'Cuba', 'Inde'),
('EN004', 'Noumodong Tindjong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 690079333, 'Chili', 'Chili'),
('EN5', 'Noumo', 'oreo', 'Canada', 'j@hhd', 6522155, 'Cuba', 'Inde'),
('JUT', 'Ngoufack', 'Ursem', 'EmanaII', 'ursemngoufack@gmail.com', 695825524, 'Cuba', 'Chili'),
('LEN7', 'Noumodong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 690079333, 'Cuba', 'Togo'),
('LEN6', 'Noumodong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 690079333, 'Cuba', 'Togo'),
('LEN5', 'Noumodong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 690079333, 'Cuba', 'Togo'),
('LEN4', 'Noumodong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 690079333, 'Cuba', 'Togo'),
('JAJ', 'BETSEM A ABEDIANG JU§', 'Edouard Junior', 'Terminux', 'betsemedouard@gmail.com', 689854711, 'Cuba', 'Chili'),
('JILY', 'Betsem', 'Edouard', 'Terminux', 'betsemedouard@gmail.com', 689854711, 'Cuba', 'Chili'),
('JUL', 'Betsem', 'Edouard', 'Terminux', 'betsemedouard@gmail.com', 689854711, 'Cuba', 'Chili'),
('JUH', 'Betsem', 'Edouard', 'Terminux', 'betsemedouard@gmail.com', 689854711, 'Cuba', 'Chili'),
('JUNI', 'Ngoufack', 'Ursem', 'Emana', 'ursemngoufack@gmail.com', 695825524, 'Cuba', 'Chili'),
('JUN', 'Ngoufack', 'Ursem', 'Emana', 'ursemngoufack@gmail.com', 695825524, 'Cuba', 'Chili'),
('LEN', 'Noumodong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 651922571, 'Cuba', 'Togo'),
('JILE', 'BETSEM A ABEDIANG', 'Edouard', 'Terminux', 'betsemedouard@gmail.com', 689854711, 'Cuba', 'Chili'),
('LEN3', 'Noumodong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 651922571, 'Cuba', 'Togo'),
('LEN8', 'Noumodong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 690079333, 'Cuba', 'Togo'),
('LEN9', 'Noumodong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 690079333, 'Cuba', 'Togo'),
('LE10', 'Noumodong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 690079333, 'Cuba', 'Togo'),
('LE11', 'Noumodong', 'Junior-Oréol', 'Canada', 'oreolnoumodong@gmail.com', 690079333, 'Cuba', 'Togo'),
('riz', 'zambou Zambou', 'Ditriech', 'Yaoundé', 'zam@gmail.com', 655527847, 'Inde', 'Mali'),
('ri1', 'zambou Zambou', 'Ditriech', 'Yaoundé', 'zam@gmail.com', 655527847, 'Inde', 'Mali'),
('ri2', 'zambou Zambou', 'Ditriech', 'Yaoundé', 'zam@gmail.com', 655527847, 'Inde', 'Mali'),
('yon', 'd', 'd', 'l', 'l', 444, 'Irak', 'Togo'),
('yoo', 'd', 'd', 'l', 'l', 444, 'Irak', 'Togo'),
('BRIN', 'Bill', 'Gates', 'Califonia', 'cali@gmail.com', 690079333, 'Laos', 'Chili'),
('BRID', 'Bill', 'Gates', 'Califonia', 'cali@gmail.com', 690079333, 'Laos', 'Chili'),
('BRIT', 'Bill', 'Gates', 'Califonia', 'cali@gmail.com', 690079333, 'Laos', 'Chili'),
('XOn', 'Xoximan', 'poo', 'oo', 'ooo', 14, 'Cuba', 'Chili'),
('XOit', 'Xoximan', 'poo', 'oo', 'ooo', 14, 'Cuba', 'Chili'),
('XOip', 'Xoximan', 'poo', 'oo', 'ooo@lklkll', 14, 'Cuba', 'Chili'),
('Love', 'Noumdong', 'Junior', 'Yaoundé', 'oerolnoumodong@gmail.com', 690079333, 'Cuba', 'Inde'),
('LION', 'Noumdong', 'Junior', 'Yaoundé', 'oerolnoumodong@gmail.com', 690079333, 'Cuba', 'Inde'),
('LOU', 'Noumdong', 'Junior', 'Yaoundé', 'oerolnoumodong@gmail.com', 690079333, 'Cuba', 'Inde');

-- --------------------------------------------------------

--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `id_groupe` char(5) NOT NULL,
  `nom_groupe` char(20) NOT NULL,
  `code_classe` char(20) DEFAULT NULL,
  PRIMARY KEY (`id_groupe`),
  KEY `code_classe` (`code_classe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `labo_tp`
--

DROP TABLE IF EXISTS `labo_tp`;
CREATE TABLE IF NOT EXISTS `labo_tp` (
  `code_laboratoire` char(5) NOT NULL,
  `libelle_laboratoire` char(30) NOT NULL,
  PRIMARY KEY (`code_laboratoire`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mama`
--

DROP TABLE IF EXISTS `mama`;
CREATE TABLE IF NOT EXISTS `mama` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `parti`
--

DROP TABLE IF EXISTS `parti`;
CREATE TABLE IF NOT EXISTS `parti` (
  `nom_parti` varchar(30) NOT NULL,
  `nombre_millitants` int(11) NOT NULL,
  `nombres_votes` int(11) DEFAULT NULL,
  PRIMARY KEY (`nom_parti`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parti`
--

INSERT INTO `parti` (`nom_parti`, `nombre_millitants`, `nombres_votes`) VALUES
('BARCELONE', 25, 1),
('JUVENTUS', 450, 5),
('LIVERPOOL', 150, 2),
('NTJO', 601, 2);

-- --------------------------------------------------------

--
-- Table structure for table `plage`
--

DROP TABLE IF EXISTS `plage`;
CREATE TABLE IF NOT EXISTS `plage` (
  `code_plage` char(5) NOT NULL,
  `libelle_plage` char(10) NOT NULL,
  `heure_debut` date NOT NULL,
  `heure_fin` date NOT NULL,
  PRIMARY KEY (`code_plage`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `code_salle` char(5) NOT NULL,
  `nom_salle` char(15) NOT NULL,
  `code_classe` char(5) DEFAULT NULL,
  PRIMARY KEY (`code_salle`),
  KEY `code_classe` (`code_classe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tp`
--

DROP TABLE IF EXISTS `tp`;
CREATE TABLE IF NOT EXISTS `tp` (
  `id_tp` char(5) NOT NULL,
  `nom_tp` char(30) NOT NULL,
  PRIMARY KEY (`id_tp`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `date_inscription` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `date_inscription`) VALUES
(1, 'Noumodong', '2018-12-05'),
(2, 'Tindjong', '2017-05-04'),
(3, 'Kameni', '2017-07-01'),
(4, 'Tamko', '2016-05-23'),
(5, 'Hadanama', '2015-06-25'),
(6, 'Pacome', '2014-03-09');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `prenom`, `nom`, `email`, `ville`) VALUES
(1, 'Aimée', 'Marechal', 'aime.marechal@gmail.com', 'Paris'),
(2, 'Esmée', 'Lefort', 'esme.lefort@gmail.com', 'Lyon'),
(3, 'Marine', 'Prevost', 'marine.prevost@gmail.com', 'Lille'),
(4, 'Luc', 'Rolland', 'luc.rolland@gmail.com', 'Marseille');

-- --------------------------------------------------------

--
-- Table structure for table `votant`
--

DROP TABLE IF EXISTS `votant`;
CREATE TABLE IF NOT EXISTS `votant` (
  `id_votant` varchar(30) NOT NULL,
  `nom_votant` varchar(50) NOT NULL,
  `prenom_votant` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id_votant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `votant`
--

INSERT INTO `votant` (`id_votant`, `nom_votant`, `prenom_votant`, `age`) VALUES
('VOT01', 'Noumodong Tindjong ', 'Junior-Oréol', 21),
('VOT02', 'Noumodong Owono', 'Junior-Oréol', 21),
('VOT03', 'Adanama', 'Ismael', 19),
('VOT004', 'Adanama Oumar', 'Ismael', 19),
('VOT05', 'Kamgang', 'Armel', 45),
('VOT06', 'Watcheu', 'Franc', 46);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

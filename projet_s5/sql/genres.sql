-- phpMyAdmin SQL Dump
-- version 4.1.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 18, 2015 at 10:08 AM
-- Server version: 5.6.15
-- PHP Version: 5.5.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `s5`
--

-- --------------------------------------------------------

--
-- Table structure for table `genres`
--

CREATE TABLE IF NOT EXISTS `genres` (
  `IdGenre` varchar(10) NOT NULL,
  `genre` varchar(100) NOT NULL,
  PRIMARY KEY (`IdGenre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genres`
--

INSERT INTO `genres` (`IdGenre`, `genre`) VALUES
('0', 'Généralités'),
('070', 'Médias documentaires et éducatifs, journalism, édition'),
('100', 'Philosophie,Psychologie'),
('130', 'Phénomènes paranormaux. Pseudosciences'),
('140', 'Les divers systèmes et écoles philosophiques'),
('150', 'Psychologie'),
('152', 'Perception sensorielle, mouvements, émotions, pulsions'),
('153', 'Processus mentaux conscients et intelligence'),
('155', 'Psychologie différentielle et génétique'),
('155.2', 'Psychologie individuelle'),
('155.6', 'Psychologie des adultes'),
('155.9', 'Psychologie et environnement'),
('158', 'Psychologie appliquée'),
('169', 'Analogie'),
('200', 'Religion'),
('230', 'Théologie chrétienne'),
('292', 'Religions de l''Antiquité grecque et romaine (mythologie)'),
('297', 'Islam, babisme, foi bahaïe'),
('299', 'Autre religions'),
('300', 'Science Sociales'),
('301', 'Sociologie et anthropologie'),
('302', 'Interaction sociale'),
('303', 'Processus sociaux'),
('305', 'Groupes sociaux'),
('305.8', 'Groupes ethniques et nationaux'),
('306', 'Culture. Institutions sociales. Comportements culturels'),
('306.8', 'Mariage et famille'),
('320', 'Science politique (politique et gouvernement)'),
('322', 'Relations entre l''État et les groupes sociaux'),
('323', 'Droits civils et politiques'),
('325', 'Migrations internationales et colonisation'),
('327', 'Relations internationales'),
('330', 'Économie'),
('331', 'Économie du travail'),
('332', 'Économie financière'),
('333', 'Économie de la terre, des ressources naturelles et de l''énergie'),
('337', 'Économie internationale'),
('360', 'Problémes et service sociaux. Associations'),
('361', 'Problèmes sociaux. Aide sociale'),
('362', 'Problèmes et services d''aide sociale'),
('363', 'Autre problèmes et service sociaux'),
('364', 'Criminologie'),
('366', 'Associations. Sociétés secrèts'),
('372', 'L''enseignement élémentaire'),
('373', 'L''enseignement secondaire'),
('378', 'Enseignement supérieur'),
('382', 'Commerce international'),
('390', 'Coutumes, savoir-vivre, folklore'),
('400', 'Langage, Linguistique'),
('490', 'Autre langues'),
('500', 'Science Exacte'),
('501', 'Philosophie et théorie'),
('551.4', 'Géomorphologie et hydrosphère'),
('570', 'Sciences de la vie. Biologie'),
('576', 'Génetique et évolution'),
('600', 'Science Appliquées'),
('610', 'Médecine'),
('612', 'Physiologie humaine'),
('613', 'Santé et hygiène personnelles'),
('616', 'Maladies'),
('621', 'Génie mécanique. Physique apppliquée'),
('635', 'Jardinage'),
('641', 'Cuisine'),
('643', 'Bricolage'),
('650', 'Gestion et services annexes'),
('652.8', 'Cryptographie'),
('658', 'Gestion générale'),
('658.31', 'Éléments'),
('690', 'Bâtiments'),
('700', 'Arts, Loisirs, Sport'),
('720', 'Architecture'),
('730', 'Arts plastiques. Sculpture'),
('741', 'Dessin'),
('750', 'La peinture et les peintures'),
('770', 'La photographie et les photographies, art numérique'),
('780', 'Musique'),
('792', 'Thêatre. Représentations sur scène'),
('793', 'Jeux d''intérieur'),
('796', 'Sports et jeux athlétiques de plein air'),
('796.3', 'Jeux de ballon, balle et boule'),
('796.4', 'Haltérophilie, athlétisme et gymnastique'),
('796.6', 'Cyclisme'),
('796.9', 'Sports sur glace et sur neige'),
('798', 'Sports équestres, courses d''animaux'),
('800', 'Litterature'),
('823', 'Romans traduits de l''anglais et de l''americain'),
('828', 'Textes divers'),
('830', 'Littérature des langues germaniques. Littérature allemande'),
('833', 'Subdivisions de la littérature allemande'),
('839', 'Autres littératures germaniques'),
('840', 'Littérature des langues romanes. Littérature française'),
('841', 'Poèsie'),
('842', 'Théâtre'),
('843', 'Romain francais'),
('844', 'Essais'),
('846', 'Lettres, correspondance littéraire'),
('847', 'Satire, humour'),
('848', 'Écrits divers'),
('849', 'Littérature occitane, provençale et catalane'),
('853', 'Subdivisions de la littérature italienne'),
('863', 'Subdivisions de la littérature espagnole'),
('869', 'Portugais (et brésilien)'),
('891.6', 'Celtiques'),
('891.7', 'Slaves du groupe oriental. Russe'),
('892', 'Littérature chamito-sémitiques (afro-asiatiques)'),
('894', 'Littérature ouralo-altaïque'),
('895', 'Littératures des pays d''Asie de l''Est et du Sud-Est'),
('896', 'Littératures africaines'),
('900', 'Géographie, Histoire'),
('910', 'Géographique et voyages'),
('914', 'Géographie et voyages en Europe. Europe de l''Ouest'),
('914.1', 'Iles britanniques'),
('914.3', 'Europe Centrales'),
('914.4', 'France'),
('914.41', 'Bretagne'),
('914.434', 'Région de Paris'),
('914.5', 'Italie'),
('914.6', 'Espagne'),
('914.7', 'Europe de l''Est'),
('914.94', 'Suisse'),
('914.95', 'Grece'),
('915', 'Géographie et voyages en Asie, Orient, Extrême Orient'),
('915.1', 'Chine'),
('915.2', 'Japon'),
('915.4', 'Asie du Sud, Inde'),
('915.6', 'Moyen Orient et Proche Orient'),
('915.8', 'Asie centrale'),
('916', 'Géographie et voyages en Afrique'),
('916.1', 'Tunisie et Lybie, Afrique du Nord'),
('916.2', 'Egypte et Soudan et Lybie, Afrique du Nord'),
('916.5', 'Algérie'),
('917', 'Géographie et voyages en Amérique du Nord'),
('917.1', 'Canada'),
('917.2', 'Amérique Centrale'),
('917.3', 'Etats-Unis'),
('918', 'Géographie et voyages en Amérique du Sud'),
('918.1', 'Brésil'),
('918.2', 'Argentine'),
('918.3', 'Chili'),
('918.4', 'Bolivie'),
('919', 'Géographie et voyages dans les autres parties du monde'),
('919.3', 'Nouvelle Zélande'),
('919.4', 'Australie'),
('919.5', 'Mélanésie, Nouvell Guinée, Océanie'),
('919.6', 'Autres parties de l''océan Pacifique, Polynésie'),
('920', 'Biographies générales, généalogie, emblèmes'),
('923', 'Politiciens, économistes, juristes, ensiegnants'),
('927', 'Artistes. Sportifs'),
('928', 'Écrivains, historiens'),
('930', 'Histoire générale du monde ancien'),
('944', 'Histoire de France'),
('950', 'Histoire de l''Asie, l''Orient, l''Extrême-Orient'),
('960', 'Histoire de l''Afrique'),
('970', 'Histoire de l''Amerique de Nord'),
('980', 'Histoire de l''Amerique de Sud'),
('RP', 'Romans policiers'),
('SF', 'Science Fiction');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

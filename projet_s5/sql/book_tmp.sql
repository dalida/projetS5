-- phpMyAdmin SQL Dump
-- version 4.1.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 17, 2015 at 04:01 PM
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
-- Table structure for table `book_tmp`
--

CREATE TABLE IF NOT EXISTS `book_tmp` (
  `IdBook` int(11) NOT NULL,
  `title` varchar(500) DEFAULT NULL,
  `language` varchar(100) DEFAULT NULL,
  `year` varchar(100) DEFAULT NULL,
  `editor` varchar(100) DEFAULT NULL,
  `pageNumber` varchar(500) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `genre` varchar(100) DEFAULT NULL,
  `genreNumeric` int(11) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdBook`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

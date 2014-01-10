-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2014 at 09:15 PM
-- Server version: 5.6.14
-- PHP Version: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `adminbldr`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_tbl`
--

CREATE TABLE IF NOT EXISTS `admin_tbl` (
  `tbl_nm` varchar(50) NOT NULL,
  `dspl_nm` varchar(100) NOT NULL,
  `short_desc` varchar(500) NOT NULL,
  `view_ind` varchar(1) NOT NULL,
  `view_nm` varchar(50) DEFAULT NULL,
  `lang_ind` varchar(1) DEFAULT NULL,
  `sort_ind` varchar(1) DEFAULT NULL,
  `lang_col_nm` varchar(30) NOT NULL,
  `url_nm` varchar(30) NOT NULL,
  `surrogate_key_nm` varchar(30) NOT NULL,
  `instr_add` varchar(1000) DEFAULT NULL,
  `instr_edit` varchar(1000) DEFAULT NULL,
  `instr_del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tbl_nm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_tbl`
--

INSERT INTO `admin_tbl` (`tbl_nm`, `dspl_nm`, `short_desc`, `view_ind`, `view_nm`, `lang_ind`, `sort_ind`, `lang_col_nm`, `url_nm`, `surrogate_key_nm`, `instr_add`, `instr_edit`, `instr_del`) VALUES
('fabric', 'Fabric', 'Fabric short description', 'N', '', 'Y', 'Y', 'lang_cd', 'fabric', 'fabric_cd', 'Example instructions for adding a new row.', 'Example instructions for editing an existing row.', 'Example instructions for deleting a row.');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

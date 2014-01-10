-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2014 at 09:17 PM
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
-- Table structure for table `admin_col`
--

CREATE TABLE IF NOT EXISTS `admin_col` (
  `tbl_nm` varchar(50) NOT NULL,
  `col_nm` varchar(50) NOT NULL,
  `dspl_nm` varchar(100) NOT NULL,
  `dspl_ord` int(11) NOT NULL,
  `data_type` varchar(25) NOT NULL,
  `sort_ind` varchar(1) DEFAULT NULL,
  `sort_ord` int(11) DEFAULT NULL,
  `sort_dir` varchar(5) DEFAULT NULL,
  `srch_ind` varchar(1) DEFAULT NULL,
  `key_ind` varchar(1) DEFAULT NULL,
  `meta_ind` varchar(1) DEFAULT NULL,
  `meta_type` varchar(25) DEFAULT NULL,
  `render_type` varchar(25) DEFAULT NULL,
  `render_params` varchar(255) DEFAULT NULL,
  `col_desc` varchar(255) NOT NULL,
  `max_len` int(11) NOT NULL,
  PRIMARY KEY (`tbl_nm`,`col_nm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_col`
--

INSERT INTO `admin_col` (`tbl_nm`, `col_nm`, `dspl_nm`, `dspl_ord`, `data_type`, `sort_ind`, `sort_ord`, `sort_dir`, `srch_ind`, `key_ind`, `meta_ind`, `meta_type`, `render_type`, `render_params`, `col_desc`, `max_len`) VALUES
('fabric', 'fabric_cd', 'Fabric Code', 1, 'char', 'N', 0, '', 'Y', 'Y', 'N', '', 'text', 'css=small', '', 5),
('fabric', 'fabric_desc', 'Fabric Description', 3, 'char', 'N', 0, '', 'N', 'N', 'N', '', 'textarea', 'html=true', '', 255),
('fabric', 'fabric_family_cd', 'Fabric Family', 4, 'char', 'N', NULL, NULL, 'Y', 'N', 'N', NULL, 'list', 'list=lst_fabric_family,css=large', '', 5),
('fabric', 'fabric_nm', 'Fabric Name', 2, 'char', 'Y', 1, 'asc', 'Y', 'N', 'N', '', 'text', 'css=large', '', 100),
('fabric', 'lang_cd', 'Lang Cd', 99, 'char', 'N', NULL, NULL, 'N', 'N', 'Y', 'lang', 'none', NULL, '', 5);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin_col`
--
ALTER TABLE `admin_col`
  ADD CONSTRAINT `fg_admin_tbl` FOREIGN KEY (`tbl_nm`) REFERENCES `admin_tbl` (`tbl_nm`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2021-06-09 15:52:20
-- 服务器版本： 10.1.37-MariaDB
-- PHP 版本： 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `road`
--

-- --------------------------------------------------------

--
-- 表的结构 `websites`
--

CREATE TABLE `websites` (
  `id` int(8) NOT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `Road_No` varchar(255) DEFAULT NULL,
  `Road_Category` varchar(255) DEFAULT NULL,
  `Province_Name` varchar(255) DEFAULT NULL,
  `Start_Point_City` varchar(255) DEFAULT NULL,
  `End_Point_City` varchar(255) DEFAULT NULL,
  `Section_Length` varchar(255) DEFAULT NULL,
  `Year_of_Construction` varchar(255) DEFAULT NULL,
  `Year_of_Recent_Improvement` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

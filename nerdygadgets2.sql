-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2024 at 12:50 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nerdygadgets2`
--
CREATE DATABASE IF NOT EXISTS `nerdygadgets2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `nerdygadgets2`;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerid` int(10) NOT NULL,
  `location` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `middlename` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `location`, `name`, `surname`, `middlename`) VALUES
(1, 1, 'John', 'Doe', NULL),
(2, 2, 'Jane', 'Smith', 'A'),
(3, 3, 'Alice', 'Johnson', 'B'),
(4, 4, 'Bob', 'Brown', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `locationid` int(11) NOT NULL,
  `longitude` float DEFAULT NULL,
  `latitiude` float DEFAULT NULL,
  `place` varchar(30) DEFAULT NULL,
  `adress` varchar(30) DEFAULT NULL,
  `postalcode` varchar(6) DEFAULT NULL,
  `housenumber` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`locationid`, `longitude`, `latitiude`, `place`, `adress`, `postalcode`, `housenumber`) VALUES
(1, -0.1257, 51.5085, 'London', '10 Downing St', 'SW1A 2', '10'),
(2, -74.006, 40.7128, 'New York', 'Wall Street', '10005', '11'),
(3, 2.3522, 48.8566, 'Paris', 'Champs-Elysees', '75008', '20'),
(4, 139.692, 35.6895, 'Tokyo', 'Shibuya', '150-00', '30');

-- --------------------------------------------------------

--
-- Table structure for table `packages`
--

DROP TABLE IF EXISTS `packages`;
CREATE TABLE `packages` (
  `packageid` int(11) NOT NULL,
  `destination` varchar(128) NOT NULL,
  `status` varchar(128) NOT NULL,
  `location` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `packages`
--

INSERT INTO `packages` (`packageid`, `destination`, `status`, `location`) VALUES
(1, 'ABC', 'Pending', 'Warehouse A'),
(2, 'DEF', 'In Transit', 'Warehouse B'),
(3, 'XYZ', 'Delevered', 'Customer'),
(4, 'GHI', 'Testing', 'Warehouse c');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productid` int(127) NOT NULL,
  `name` varchar(127) NOT NULL,
  `description` varchar(127) DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productid`, `name`, `description`, `price`) VALUES
(11, 'Macbook air', NULL, NULL),
(12, 'Samsung S23', NULL, NULL),
(13, 'SDXC 16 gb', NULL, NULL),
(14, 'Raspberry pi 4 (4gb)', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `returns`
--

DROP TABLE IF EXISTS `returns`;
CREATE TABLE `returns` (
  `returnid` int(11) NOT NULL,
  `returnstatus` varchar(20) NOT NULL,
  `ordernumber` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `returnlocation` varchar(127) NOT NULL,
  `notes` varchar(1024) NOT NULL,
  `returntype` int(11) NOT NULL,
  `reason` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `returns`
--

INSERT INTO `returns` (`returnid`, `returnstatus`, `ordernumber`, `productid`, `amount`, `returnlocation`, `notes`, `returntype`, `reason`) VALUES
(1, 'Processing', 101, 11, 1, 'Main Warehouse', 'Defective item', 1, 'Damaged'),
(2, 'Completed', 102, 12, 1, 'Main Warehouse', 'Wrong item delivered', 2, 'Incorrect Item'),
(3, 'Pending', 103, 13, 2, 'Secondary Warehouse', 'Customer changed mind', 1, 'Customer Decision'),
(4, 'Approved', 104, 14, 1, 'Main Warehouse', 'Not as described', 2, 'Description Mismatch');

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `location` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `warehouse`
--

INSERT INTO `warehouse` (`location`, `productid`, `amount`) VALUES
(1, 13, 420),
(2, 11, 45),
(3, 12, 99),
(4, 14, 14),
(6, 13, 420),
(8, 11, 45),
(13, 12, 99),
(14, 14, 14);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerid`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`locationid`);

--
-- Indexes for table `packages`
--
ALTER TABLE `packages`
  ADD PRIMARY KEY (`packageid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productid`);

--
-- Indexes for table `returns`
--
ALTER TABLE `returns`
  ADD PRIMARY KEY (`returnid`);

--
-- Indexes for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`location`,`productid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productid` int(127) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `returns`
--
ALTER TABLE `returns`
  MODIFY `returnid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `location` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

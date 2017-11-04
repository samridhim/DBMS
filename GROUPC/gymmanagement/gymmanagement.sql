-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 02, 2017 at 09:40 AM
-- Server version: 5.7.19-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gymmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `classid` varchar(2) NOT NULL,
  `classname` varchar(10) DEFAULT NULL,
  `classtime` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`classid`, `classname`, `classtime`) VALUES
('A', 'Aerobics', '11-12 AM'),
('W', 'WeightLift', '10-11 AM'),
('Z', 'Zumba', '9-10 AM');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cid` int(5) NOT NULL,
  `cfname` varchar(10) DEFAULT NULL,
  `clname` varchar(10) DEFAULT NULL,
  `age` varchar(2) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `classid` varchar(2) DEFAULT NULL,
  `user` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cid`, `cfname`, `clname`, `age`, `gender`, `email`, `classid`, `user`) VALUES
(8, 'Madhura', 'Nirale', '19', 'F', 'maddy@gmail.com', 'Z', 'madhura'),
(11, 'Samridhi', 'Maheshwari', '19', 'F', 'samridhimaheshwari@gmail.com', 'W', 'samridhim'),
(12, 'Nachiket', 'Lele', '19', 'M', 'nlele@gmail.com', 'W', 'nachiket');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `instructorid` varchar(50) NOT NULL,
  `instructorname` varchar(10) DEFAULT NULL,
  `specialization` varchar(10) DEFAULT NULL,
  `salary` int(5) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `pwd` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`instructorid`, `instructorname`, `specialization`, `salary`, `email`, `pwd`) VALUES
('samridhim', 'samridhi', 'zumba', NULL, 'samridhi@gmail.com', 'samridhi'),
('samridhimaheshwari', 'Samridhi', 'Zumba', NULL, 'samridhimaheshwari@gmail.com', 'samridhi');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `uid` varchar(50) NOT NULL,
  `pwd` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`uid`, `pwd`) VALUES
('madhura', 'madhura'),
('nachiket', 'nachiket'),
('samridhim', 'samridhi');

-- --------------------------------------------------------

--
-- Table structure for table `shift`
--

CREATE TABLE `shift` (
  `instructorid` varchar(10) NOT NULL,
  `classid` varchar(2) NOT NULL,
  `cid` int(5) NOT NULL,
  `shiftstarttime` time DEFAULT NULL,
  `shiftendtime` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`classid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cid`),
  ADD KEY `customer_ibfk_1` (`classid`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`instructorid`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `shift`
--
ALTER TABLE `shift`
  ADD PRIMARY KEY (`instructorid`,`classid`,`cid`),
  ADD KEY `classid` (`classid`),
  ADD KEY `cid` (`cid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`);

--
-- Constraints for table `shift`
--
ALTER TABLE `shift`
  ADD CONSTRAINT `shift_ibfk_1` FOREIGN KEY (`instructorid`) REFERENCES `instructor` (`instructorid`) ON UPDATE CASCADE,
  ADD CONSTRAINT `shift_ibfk_2` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`) ON UPDATE CASCADE,
  ADD CONSTRAINT `shift_ibfk_3` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

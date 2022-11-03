-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2022 at 12:30 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cup_gifts`
--

-- --------------------------------------------------------

--
-- Table structure for table `gift`
--

CREATE TABLE `gift` (
  `gift_id` int(11) NOT NULL,
  `gift_details` varchar(255) DEFAULT NULL,
  `gift_image_url` varchar(255) DEFAULT NULL,
  `gift_name` varchar(255) DEFAULT NULL,
  `gift_price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_address` varchar(255) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `order_description` varchar(255) DEFAULT NULL,
  `order_email` varchar(255) DEFAULT NULL,
  `order_name` varchar(255) DEFAULT NULL,
  `order_phone` varchar(255) DEFAULT NULL,
  `order_price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `gift_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order_theme`
--

CREATE TABLE `order_theme` (
  `order_id` int(11) NOT NULL,
  `theme_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `theme`
--

CREATE TABLE `theme` (
  `theme_id` int(11) NOT NULL,
  `theme_details` varchar(255) DEFAULT NULL,
  `theme_name` varchar(255) DEFAULT NULL,
  `theme_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `mobile_number`, `password`, `user_role`, `username`) VALUES
(1, 'superadmin@test.com', '9966134255', '$2a$10$Ik6p4ev1KDjTq.GQu.61t.4cQ45rvXhvvhh9IeGeamw01Sad784Bq', 'SuperAdmin', 'superadmin'),
(2, 'user1@test.com', '8866564344', '$2a$10$qz1xFM5xKkvxnjRJf8kpSeeLF/A8u4jENOAlfu/0Acboi3Dsyu9Am', 'User', 'user1'),
(3, 'admin1@test.com', '7755653422', '$2a$10$G/3R.MrjYigcYntw6eQos.wvnUIitcGbDj9K7V1KoLQOiWGplFV1K', 'Admin', 'admin1'),
(4, 'admin2@test.com', '9977564233', '$2a$10$ELmkRxNQlQ3kM55G8d.kNuPQ9YYtV4EwqSX3nRc.FbRathBj7XL.u', 'Admin', 'admin2'),
(7, 'user3@test.com', '9966574366', '$2a$10$0Vm5d3qc876qtAebvdzFBerDmo35IdI7Sg7ivwFVREgrxy6GIEcYK', 'User', 'user3'),
(8, 'user4@test.com', '9955406511', '$2a$10$CThNF1bpOzrQFEIIowEH8uPBEv3QnMBGDCcwKoH95PwyYgaL2TVQ2', 'User', 'user4'),
(9, 'user5@test.com', '9955160945', '$2a$10$Yqc9mPctkoz5HUvaUJfMNOyqSieUlGw8q0TCPyPALUCG6L4HmF7cS', 'User', 'user5'),
(10, 'admin4@test.com', '9006743556', '$2a$10$pNcAClJttWtuMbFT6FNYRuO32mlCfm7pxkQh.InPMyQH9ZYHRFHuq', 'Admin', 'admin4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gift`
--
ALTER TABLE `gift`
  ADD PRIMARY KEY (`gift_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `FKex2h5le8t3hdr76e2e7067mak` (`gift_id`),
  ADD KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`);

--
-- Indexes for table `order_theme`
--
ALTER TABLE `order_theme`
  ADD KEY `FK3c65vyqbir7rs8ua81xe4nbhg` (`theme_id`),
  ADD KEY `FKhkbbhw8fdnns2bocf5ce6rihi` (`order_id`);

--
-- Indexes for table `theme`
--
ALTER TABLE `theme`
  ADD PRIMARY KEY (`theme_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKex2h5le8t3hdr76e2e7067mak` FOREIGN KEY (`gift_id`) REFERENCES `gift` (`gift_id`);

--
-- Constraints for table `order_theme`
--
ALTER TABLE `order_theme`
  ADD CONSTRAINT `FK3c65vyqbir7rs8ua81xe4nbhg` FOREIGN KEY (`theme_id`) REFERENCES `theme` (`theme_id`),
  ADD CONSTRAINT `FKhkbbhw8fdnns2bocf5ce6rihi` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

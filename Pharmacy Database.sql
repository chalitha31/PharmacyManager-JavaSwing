-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.26 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for pshop
CREATE DATABASE IF NOT EXISTS `pshop` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pshop`;

-- Dumping structure for table pshop.brand
CREATE TABLE IF NOT EXISTS `brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.brand: ~7 rows (approximately)
INSERT INTO `brand` (`id`, `name`) VALUES
	(1, 'None'),
	(2, 'Fluticasone '),
	(3, 'Budesonide '),
	(4, 'Mometasone '),
	(5, 'Beclomethasone '),
	(6, 'Ciclesonide '),
	(7, 'abc');

-- Dumping structure for table pshop.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.category: ~10 rows (approximately)
INSERT INTO `category` (`id`, `name`) VALUES
	(0, 'None'),
	(1, 'Tablet'),
	(2, 'Injections'),
	(3, 'Inhalers'),
	(4, 'Drops'),
	(5, 'Liquid'),
	(6, 'Preparations'),
	(7, 'CREAM'),
	(8, 'aaa');

-- Dumping structure for table pshop.city
CREATE TABLE IF NOT EXISTS `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.city: ~9 rows (approximately)
INSERT INTO `city` (`id`, `name`) VALUES
	(0, 'None'),
	(1, 'Alawwa'),
	(2, 'Kurunegala'),
	(3, 'colombo'),
	(4, 'kandy'),
	(5, 'Negombo'),
	(6, 'Galle'),
	(7, 'Dambulla'),
	(8, 'Anuradhapura');

-- Dumping structure for table pshop.company
CREATE TABLE IF NOT EXISTS `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `contact_num` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.company: ~1 rows (approximately)
INSERT INTO `company` (`id`, `name`, `contact_num`) VALUES
	(1, 'ABC', '0113565464');

-- Dumping structure for table pshop.company_branch
CREATE TABLE IF NOT EXISTS `company_branch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NOT NULL,
  `branch_contact_number` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `company_branch_address_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_baranch_company1_idx` (`company_id`),
  KEY `fk_company_baranch_company_branch_address1_idx` (`company_branch_address_id`),
  CONSTRAINT `fk_company_baranch_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `fk_company_baranch_company_branch_address1` FOREIGN KEY (`company_branch_address_id`) REFERENCES `company_branch_address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.company_branch: ~1 rows (approximately)
INSERT INTO `company_branch` (`id`, `company_id`, `branch_contact_number`, `name`, `company_branch_address_id`) VALUES
	(1, 1, '0375426585', 'Chali Product', 1);

-- Dumping structure for table pshop.company_branch_address
CREATE TABLE IF NOT EXISTS `company_branch_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` text NOT NULL,
  `city_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_branch_address_city1_idx` (`city_id`),
  CONSTRAINT `fk_company_branch_address_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.company_branch_address: ~1 rows (approximately)
INSERT INTO `company_branch_address` (`id`, `address`, `city_id`) VALUES
	(1, 'Colombo Road Kurunegala', 2);

-- Dumping structure for table pshop.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `city_id` int NOT NULL,
  `address` text,
  `nic` varchar(45) DEFAULT NULL,
  `gender_id` int DEFAULT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_city1_idx` (`city_id`),
  KEY `FK_customer_gender` (`gender_id`),
  CONSTRAINT `fk_customer_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FK_customer_gender` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.customer: ~2 rows (approximately)
INSERT INTO `customer` (`id`, `name`, `contact_number`, `city_id`, `address`, `nic`, `gender_id`, `dob`) VALUES
	(1, 'None', 'None', 0, 'None', 'None', 0, NULL),
	(2, 'raveen shanuka', '0785462569', 1, 'alawwa', '200001563546', 1, '2000-08-05'),
	(3, 'cgcgd', '0716465484', 1, 'gvtyuhy', '5404545', 2, '1998-08-10');

-- Dumping structure for table pshop.gender
CREATE TABLE IF NOT EXISTS `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.gender: ~4 rows (approximately)
INSERT INTO `gender` (`id`, `name`) VALUES
	(0, 'None'),
	(1, 'Male'),
	(2, 'Frmale'),
	(3, 'Other');

-- Dumping structure for table pshop.grn
CREATE TABLE IF NOT EXISTS `grn` (
  `id` int NOT NULL AUTO_INCREMENT,
  `supplier_id` int DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `unique_id` text,
  PRIMARY KEY (`id`),
  KEY `fk_grn_supplier1_idx` (`supplier_id`),
  KEY `fk_grn_user1_idx` (`user_id`),
  CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `fk_grn_user1` FOREIGN KEY (`user_id`) REFERENCES `user_registration` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.grn: ~11 rows (approximately)
INSERT INTO `grn` (`id`, `supplier_id`, `date_time`, `user_id`, `unique_id`) VALUES
	(27, 1, '2022-08-08 23:37:31', 10, '1659982051777-10'),
	(28, 2, '2022-08-08 23:50:37', 10, '1659982837424-10'),
	(29, 1, '2022-08-08 23:52:43', 10, '1659982963225-10'),
	(30, 1, '2022-08-08 23:57:54', 10, '1659983274305-10'),
	(31, 1, '2022-08-08 23:59:21', 10, '1659983361424-10'),
	(32, 2, '2022-08-09 00:06:30', 10, '1659983790824-10'),
	(33, 1, '2022-08-09 00:20:05', 10, '1659984605929-10'),
	(34, 2, '2022-08-09 08:49:34', 10, '1660015174660-10'),
	(35, 1, '2022-08-09 09:28:05', 10, '1660017485252-10'),
	(36, 1, '2022-08-09 09:29:39', 10, '1660017579036-10'),
	(37, 1, '2022-08-09 09:42:47', 10, '1660018367732-10'),
	(38, 1, '2022-08-09 09:44:51', 10, '1660018491829-10'),
	(39, 1, '2022-08-09 09:48:07', 10, '1660018687524-10'),
	(40, 1, '2022-08-11 13:55:26', 10, '1660206326509-10');

-- Dumping structure for table pshop.grn_item
CREATE TABLE IF NOT EXISTS `grn_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `buying_price` double DEFAULT NULL,
  `grn_id` int NOT NULL,
  `stock_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_item_grn1_idx` (`grn_id`),
  KEY `fk_grn_item_stock1_idx` (`stock_id`),
  CONSTRAINT `fk_grn_item_grn1` FOREIGN KEY (`grn_id`) REFERENCES `grn` (`id`),
  CONSTRAINT `fk_grn_item_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.grn_item: ~14 rows (approximately)
INSERT INTO `grn_item` (`id`, `quantity`, `buying_price`, `grn_id`, `stock_id`) VALUES
	(27, 456, 100, 27, 31),
	(28, 65, 90, 27, 32),
	(29, 456, 180, 28, 33),
	(30, 32, 50, 29, 34),
	(31, 65, 80, 30, 35),
	(32, 656, 534, 31, 36),
	(33, 600, 120, 32, 37),
	(34, 10, 100, 33, 38),
	(35, 10, 50, 34, 39),
	(36, 50, 80, 35, 40),
	(37, 1000, 100, 36, 41),
	(38, 12, 120, 37, 42),
	(39, 12, 50, 38, 43),
	(40, 10, 100, 39, 44),
	(41, 10, 120, 40, 45),
	(42, 100, 110, 40, 46);

-- Dumping structure for table pshop.grn_payment
CREATE TABLE IF NOT EXISTS `grn_payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `grn_id` int NOT NULL,
  `payment_type_id` int NOT NULL,
  `payment` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_payment_grn1_idx` (`grn_id`),
  KEY `fk_grn_payment_payment_type1_idx` (`payment_type_id`),
  CONSTRAINT `fk_grn_payment_grn1` FOREIGN KEY (`grn_id`) REFERENCES `grn` (`id`),
  CONSTRAINT `fk_grn_payment_payment_type1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.grn_payment: ~11 rows (approximately)
INSERT INTO `grn_payment` (`id`, `grn_id`, `payment_type_id`, `payment`, `balance`) VALUES
	(20, 27, 3, 50000, -1450),
	(21, 28, 4, 80000, -2080),
	(22, 29, 2, 1600, 0),
	(23, 30, 3, 6000, 800),
	(24, 31, 3, 360000, 9696),
	(25, 32, 2, 70000, -2000),
	(26, 33, 2, 2000, 1000),
	(27, 34, 3, 500, 0),
	(28, 35, 1, 5000, 1000),
	(29, 36, 2, 80000, -20000),
	(30, 37, 3, 145, -1295),
	(31, 38, 3, 10000, 9400),
	(32, 39, 3, 1000, 0),
	(33, 40, 4, 15000, 2800);

-- Dumping structure for table pshop.image
CREATE TABLE IF NOT EXISTS `image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(80) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_image_product` (`product_id`),
  CONSTRAINT `FK_image_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.image: ~0 rows (approximately)

-- Dumping structure for table pshop.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `user_id` int NOT NULL,
  `unique_id` text,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_customer1_idx` (`customer_id`),
  KEY `fk_invoice_user1_idx` (`user_id`),
  CONSTRAINT `fk_invoice_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_invoice_user1` FOREIGN KEY (`user_id`) REFERENCES `user_registration` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.invoice: ~4 rows (approximately)
INSERT INTO `invoice` (`id`, `customer_id`, `date_time`, `user_id`, `unique_id`) VALUES
	(15, 2, '2022-08-08 23:38:39', 10, '1659982119738-10'),
	(16, 3, '2022-08-08 23:40:09', 10, '1659982209472-10'),
	(17, 2, '2022-08-09 00:08:06', 10, '1659983886656-10'),
	(18, 2, '2022-08-09 09:32:58', 10, '1660017778061-10'),
	(19, 2, '2022-08-11 13:58:47', 10, '1660206527525-10');

-- Dumping structure for table pshop.invoice_item
CREATE TABLE IF NOT EXISTS `invoice_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stock_id` int NOT NULL,
  `qty` int DEFAULT NULL,
  `invoice_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_item_stock1_idx` (`stock_id`),
  KEY `fk_invoice_item_invoice1_idx` (`invoice_id`),
  CONSTRAINT `fk_invoice_item_invoice1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  CONSTRAINT `fk_invoice_item_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.invoice_item: ~4 rows (approximately)
INSERT INTO `invoice_item` (`id`, `stock_id`, `qty`, `invoice_id`) VALUES
	(22, 31, 1, 15),
	(23, 32, 1, 16),
	(24, 33, 2, 17),
	(25, 35, 1, 18),
	(26, 33, 2, 19),
	(27, 46, 1, 19),
	(28, 31, 3, 19);

-- Dumping structure for table pshop.invoice_payment
CREATE TABLE IF NOT EXISTS `invoice_payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `invoice_id` int NOT NULL,
  `payment_type_id` int NOT NULL,
  `payment` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_payment_invoice1_idx` (`invoice_id`),
  KEY `fk_invoice_payment_payment_type1_idx` (`payment_type_id`),
  CONSTRAINT `fk_invoice_payment_invoice1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  CONSTRAINT `fk_invoice_payment_payment_type1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.invoice_payment: ~4 rows (approximately)
INSERT INTO `invoice_payment` (`id`, `invoice_id`, `payment_type_id`, `payment`, `balance`) VALUES
	(14, 15, 4, 120, 0),
	(15, 16, 1, 110, 10),
	(16, 17, 3, 400, 0),
	(17, 18, 2, 100, 0),
	(18, 19, 1, 1000, 60);

-- Dumping structure for table pshop.payment_type
CREATE TABLE IF NOT EXISTS `payment_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.payment_type: ~4 rows (approximately)
INSERT INTO `payment_type` (`id`, `name`) VALUES
	(1, 'Cash'),
	(2, 'Check'),
	(3, 'Card'),
	(4, 'Credit');

-- Dumping structure for table pshop.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` int NOT NULL,
  `brand_id` int NOT NULL,
  `name` text,
  `image_id` int DEFAULT NULL,
  `discription` text,
  `SideEffect` text,
  PRIMARY KEY (`id`),
  KEY `fk_product_category1_idx` (`category_id`),
  KEY `fk_product_brand1_idx` (`brand_id`),
  KEY `FK_product_product_img` (`image_id`),
  CONSTRAINT `fk_product_brand1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  CONSTRAINT `fk_product_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_product_product_img` FOREIGN KEY (`image_id`) REFERENCES `product_img` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.product: ~6 rows (approximately)
INSERT INTO `product` (`id`, `category_id`, `brand_id`, `name`, `image_id`, `discription`, `SideEffect`) VALUES
	(14, 2, 2, 'ALERID 10MG', 7, 'Take Alerid 10 MG Tablet with or without food. \nDrink an adequate amount of water. Avoid taking more or \nless than the prescribed dose. Avoid the discontinuation of this medicine without consulting your doctor', 'Sleepiness\r\nTiredness\r\nDizziness\r\nHeadache\r\nDry mouth'),
	(15, 2, 5, 'Esomac 40mg', 1, 'Esomac 40 Tablet is a medicine that reduces the amount of acid produced in your stomach. It is used to treat acid reflux, peptic ulcer disease, and other problems in your food pipe. It is also used to prevent and treat stomach ulcers.', 'Headache.\r\nNausea or vomiting\r\nExcessive gas in stomach\r\n Stomach pain\r\nSkin rash\r\nDifficulty in breathing\r\nSwelling of face, lips, eyelids, tongue, hands and feet \r\nIrregular heartbeat'),
	(16, 7, 5, 'Betamet-N-Anti-Fungal-Cream', 8, 'Betamethasone skin treatments are used to treat itching, swollen and irritated skin. They can help with conditions such as eczema, contact dermatitis and psoriasis', 'None'),
	(17, 1, 4, 'DILZEM 90 SR ', 9, 'Dilzem 90 MG Tablet SR is used to treat high blood pressure and other heart complications. The medicine should be taken in conjunction with a proper diet and regular exercise. It is also used in managing chest pain', 'Headache\r\nConstipation\r\nDizziness\r\nFatigue\r\nFlushing (sense of warmth in the face, ears, neck and trunk)\r\nNausea\r\nPalpitations\r\nRash'),
	(18, 3, 4, 'celekop 200', 10, 'Channel 90 MG Tablet SR is used to treat high blood pressure and other heart complications. The medicine should be taken in conjunction with a proper diet and regular exercise. It is also used in managing chest pain.', 'Celecoxib can increase your risk of fatal heart attack or stroke, even if you don\'t have any risk factors. Do not use this medicine just before or after heart bypass surgery'),
	(19, 1, 3, 'DEXAMETHASONE', 1, 'Take this medication by mouth as directed by your doctor. Take with food or milk to prevent stomach upset. Take the tablet form of this medication with a full glass of water (8 ounces/240 milliliters) unless your doctor directs you otherwise. If you are using the liquid form of this medication, carefully measure the dose using a special measuring device/spoon. Do not use a household spoon because you may not get the correct dose', 'upset stomach.\r\nstomach irritation.\r\nvomiting.\r\nheadache.\r\ndizziness.\r\ninsomnia.\r\nrestlessness.\r\ndepression.');

-- Dumping structure for table pshop.product_img
CREATE TABLE IF NOT EXISTS `product_img` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.product_img: ~5 rows (approximately)
INSERT INTO `product_img` (`id`, `image`) VALUES
	(1, 'C:\\Users\\sandu\\OneDrive\\Documents\\NetBeansProjects\\Pharmacy_System\\build\\classes\\img\\icons8_remove_image_64px.png'),
	(7, 'C:\\Users\\sandu\\OneDrive\\Documents\\NetBeansProjects\\Pharmacy_System\\dist\\upload\\product_Img\\ALERID 10MG.jpg'),
	(8, 'C:\\Users\\sandu\\OneDrive\\Documents\\NetBeansProjects\\Pharmacy_System\\dist\\upload\\product_Img\\Betamet-N-Cream.jpg'),
	(9, 'C:\\Users\\sandu\\OneDrive\\Documents\\NetBeansProjects\\Pharmacy_System\\dist\\upload\\product_Img\\DILZEM.jpg'),
	(10, 'C:\\Users\\sandu\\OneDrive\\Documents\\NetBeansProjects\\Pharmacy_System\\dist\\upload\\product_Img\\celekop 200.jpg');

-- Dumping structure for table pshop.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `mfd` date DEFAULT NULL,
  `exd` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stock_product1_idx` (`product_id`),
  CONSTRAINT `fk_stock_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.stock: ~14 rows (approximately)
INSERT INTO `stock` (`id`, `product_id`, `quantity`, `selling_price`, `mfd`, `exd`) VALUES
	(31, 14, 2, 130, '2022-08-02', '2022-08-17'),
	(32, 16, 0, 100, '2022-08-02', '2022-09-21'),
	(33, 16, 452, 200, '2022-08-03', '2022-08-31'),
	(34, 18, 15, 55, '2022-08-03', '2022-08-11'),
	(35, 14, 17, 100, '2022-08-03', '2022-10-26'),
	(36, 17, 656, 600, '2022-08-02', '2023-08-24'),
	(37, 15, 600, 125, '2022-08-04', '2022-08-24'),
	(38, 15, 10, 110, '2022-08-02', '2022-08-18'),
	(39, 15, 10, 60, '2022-08-03', '2022-10-27'),
	(40, 15, 50, 100, '2022-08-02', '2022-08-19'),
	(41, 14, 1000, 120, '2022-08-05', '2022-08-26'),
	(42, 15, 12, 150, '2022-08-04', '2023-08-19'),
	(43, 16, 12, 60, '2022-08-03', '2022-11-30'),
	(44, 14, 10, 210, '2022-08-04', '2023-08-12'),
	(45, 14, 10, 130, '2022-08-08', '2022-08-31'),
	(46, 18, 99, 150, '2022-08-01', '2022-09-22');

-- Dumping structure for table pshop.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `contact_no` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `company_branch_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier_company_baranch1_idx` (`company_branch_id`) USING BTREE,
  CONSTRAINT `FK_supplier_company_branch` FOREIGN KEY (`company_branch_id`) REFERENCES `company_branch` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.supplier: ~2 rows (approximately)
INSERT INTO `supplier` (`id`, `name`, `contact_no`, `email`, `company_branch_id`) VALUES
	(1, 'Sandun chandika', '0714535845', 'sandun@gmail.com', 1),
	(2, 'raveesha', '0784654556', 'raveesha@gmail.com', 1);

-- Dumping structure for table pshop.user_image
CREATE TABLE IF NOT EXISTS `user_image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_image_user_login` (`user_id`),
  CONSTRAINT `FK_user_image_user_login` FOREIGN KEY (`user_id`) REFERENCES `user_login` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.user_image: ~3 rows (approximately)
INSERT INTO `user_image` (`id`, `image`, `user_id`) VALUES
	(14, 'C:\\Users\\sandu\\OneDrive\\Documents\\NetBeansProjects\\Pharmacy_System\\dist\\upload\\profile\\Bota linkedin.png', 18),
	(15, 'C:\\Users\\sandu\\OneDrive\\Documents\\NetBeansProjects\\Pharmacy_System\\dist\\upload\\profile\\ravesha.jpeg', 19),
	(16, 'C:\\Users\\sandu\\OneDrive\\Documents\\NetBeansProjects\\Pharmacy_System\\dist\\upload\\profile\\deshan.jpeg', 20),
	(17, 'C:\\Users\\sandu\\OneDrive\\Documents\\NetBeansProjects\\Pharmacy_System\\dist\\upload\\profile\\gavurava.jpeg', 21);

-- Dumping structure for table pshop.user_login
CREATE TABLE IF NOT EXISTS `user_login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `contact_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.user_login: ~3 rows (approximately)
INSERT INTO `user_login` (`id`, `name`, `username`, `password`, `contact_no`) VALUES
	(18, 'Chalitha Chamod', 'chalitha', '123', '0713772006'),
	(19, 'Raveesha Madumal', 'raveesha', '456', '0726465956'),
	(20, 'Deshan Rathnayaka', 'deshan', '789', '0785685965'),
	(21, 'Gavrava', 'gavrava', '987', '0716558546');

-- Dumping structure for table pshop.user_registration
CREATE TABLE IF NOT EXISTS `user_registration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `user_type_id` int NOT NULL,
  `user_status_id` int NOT NULL DEFAULT '1',
  `city_id` int NOT NULL,
  `address` text,
  `nic` varchar(45) DEFAULT NULL,
  `gender_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_user_type_idx` (`user_type_id`),
  KEY `fk_user_user_status1_idx` (`user_status_id`),
  KEY `fk_user_city1_idx` (`city_id`),
  KEY `FK_user_gender` (`gender_id`),
  KEY `FK_user_registration_user_login_2` (`user_id`),
  CONSTRAINT `fk_user_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FK_user_gender` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `FK_user_registration_user_login` FOREIGN KEY (`user_id`) REFERENCES `user_login` (`id`),
  CONSTRAINT `fk_user_user_status1` FOREIGN KEY (`user_status_id`) REFERENCES `user_status` (`id`),
  CONSTRAINT `fk_user_user_type` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.user_registration: ~2 rows (approximately)
INSERT INTO `user_registration` (`id`, `user_id`, `user_type_id`, `user_status_id`, `city_id`, `address`, `nic`, `gender_id`) VALUES
	(10, 18, 1, 1, 3, 'No 45/2 Colombo', '200009103532', 1),
	(11, 20, 3, 1, 1, 'Alawwa  siyabalagaha kotuva', '200016584526', 1),
	(12, 21, 3, 1, 2, 'kurunegala', '200095416585', 1);

-- Dumping structure for table pshop.user_status
CREATE TABLE IF NOT EXISTS `user_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.user_status: ~2 rows (approximately)
INSERT INTO `user_status` (`id`, `name`) VALUES
	(1, 'Active'),
	(2, 'Deactive');

-- Dumping structure for table pshop.user_type
CREATE TABLE IF NOT EXISTS `user_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table pshop.user_type: ~3 rows (approximately)
INSERT INTO `user_type` (`id`, `name`) VALUES
	(1, 'Super Admin'),
	(2, 'Manager'),
	(3, 'Cashier');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

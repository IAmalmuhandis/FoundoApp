CREATE database dsblock;

USE dsblock;

CREATE TABLE `orders_table` (
  `Order_ID` int NOT NULL AUTO_INCREMENT,
  `Customer_ID` varchar(32) DEFAULT NULL,
  `Product_ID` varchar(45) DEFAULT NULL,
  `Quantity` bigint DEFAULT NULL,
  `Total_Amount` double DEFAULT NULL,
  `Desired_location` text,
  `Recievers_PhoneNumber` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Order_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `admin_details` (
  `entry_id` int NOT NULL AUTO_INCREMENT,
  `admin_Id` varchar(32) DEFAULT NULL,
  `admin_Password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`entry_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customers_table` (
  `Customer_ID` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email_address` text NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `password` char(50) NOT NULL,
  `profile_picture` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Customer_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `carts_table` (
  `Entry_ID` int NOT NULL AUTO_INCREMENT,
  `Customer_ID` varchar(45) DEFAULT NULL,
  `Block_Type` varchar(50) DEFAULT NULL,
  `Block_Inch` varchar(20) DEFAULT NULL,
  `Desired_Location` text,
  `Recievers_PhoneNumber` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Entry_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `products_table` (
  `Entry_id` int NOT NULL AUTO_INCREMENT,
  `Block_Type` varchar(32) DEFAULT NULL,
  `Block_Inch` int DEFAULT NULL,
  `Unit_Price` int DEFAULT NULL,
  `Available_Amount` bigint DEFAULT NULL,
  `Product_ID` varchar(45) DEFAULT 'DS/PRD/',
  PRIMARY KEY (`Entry_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

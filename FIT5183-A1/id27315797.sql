CREATE DATABASE IF NOT EXISTS 'id27315797';
USE 'id27315797';
/*
Navicat MySQL Data Transfer

Source Server         : health
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : id27315797

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-03-30 09:21:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` char(1) NOT NULL COMMENT '0 male,1female',
  `height` double(5,2) NOT NULL COMMENT 'centimetres',
  `weight` double(10,2) NOT NULL COMMENT 'kilograms',
  `activity_level` int(255) NOT NULL COMMENT '1-5',
  `steps_mile` int(255) NOT NULL,
  `BMR` double(10,2) NOT NULL COMMENT 'Men: (13.75 x weight) + (5 x height) - (6.76 x age) + 66\r\nWomen: (9.56 x weight) + (1.85 x height) - (4.68 x age) + 655',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0eb8f722-2548-4454-b006-e342347d5a89', '123', 'Jams', '26', '0', '182.00', '71.80', '5', '1205', '1787.49');
INSERT INTO `user` VALUES ('1', '123', 'Amy', '22', '1', '173.00', '53.50', '3', '1745', '1383.55');
INSERT INTO `user` VALUES ('2', '123', 'Tom', '23', '0', '183.00', '74.30', '4', '1549', '1847.15');
INSERT INTO `user` VALUES ('3', '123', 'Helen', '21', '1', '165.00', '55.10', '2', '1845', '1388.73');
INSERT INTO `user` VALUES ('7097b9c5-2f9f-438d-9d80-05cdba79005e', '123', 'Chris', '29', '0', '190.00', '80.30', '4', '1693', '1924.09');


-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `calorie` double(10,2) NOT NULL,
  `serving` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', 'Catsup', '16.00', '1 Tbsp');
INSERT INTO `food` VALUES ('10', 'Tabasco sauce, hot sauce', '2.00', '1 Tbsp');
INSERT INTO `food` VALUES ('11', 'Worcestershire sauce', '10.00', '1 Tbsp');
INSERT INTO `food` VALUES ('12', 'Yams, candied', '176.00', '1/2 cup');
INSERT INTO `food` VALUES ('13', 'Veal Parmesan', '471.00', '1 cup');
INSERT INTO `food` VALUES ('14', 'Zucchini,raw', '9.00', '1 cup');
INSERT INTO `food` VALUES ('15', '\r\nAloochat', '361.00', '1 each');
INSERT INTO `food` VALUES ('16', 'Boniatos', '131.00', '1/2 cup');
INSERT INTO `food` VALUES ('17', 'Calabacitas', '70.00', '1/2 cup');
INSERT INTO `food` VALUES ('18', 'Coconut water', '16.00', '1 cup');
INSERT INTO `food` VALUES ('19', 'Dosa, 8\" diam', '74.00', '1 each');
INSERT INTO `food` VALUES ('2', 'Light cream cheese', '64.00', '2 Tbsp');
INSERT INTO `food` VALUES ('20', 'Empanadas, dessert type, fruitfilled (apple)', '190.00', '1 each');
INSERT INTO `food` VALUES ('21', 'Hog maw', '221.00', '3 oz');
INSERT INTO `food` VALUES ('22', 'Jicama, raw', '25.00', '1 cup');
INSERT INTO `food` VALUES ('23', 'Fry bread (no milk), 5\" diam', '302.00', '1 each');
INSERT INTO `food` VALUES ('24', 'Kulifi (rich ice cream)', '254.00', '1/2 each');
INSERT INTO `food` VALUES ('25', 'Lychees', '62.00', '10 pcs');
INSERT INTO `food` VALUES ('26', 'Menudo', '384.00', '1 cup');
INSERT INTO `food` VALUES ('27', 'Navajo tea', '4.00', '1 oz');
INSERT INTO `food` VALUES ('28', 'Poke sallet', '94.00', '1 cup');
INSERT INTO `food` VALUES ('29', 'Samosa, fried', '114.00', '1 md');
INSERT INTO `food` VALUES ('3', 'Chicken, light meat only', '47.00', '1 oz');
INSERT INTO `food` VALUES ('30', 'Squirrel', '73.00', '3 oz');
INSERT INTO `food` VALUES ('4', 'Chipped or dried beef', '140.00', '3 oz');
INSERT INTO `food` VALUES ('5', 'Coconut milk:\r\nlight', '144.00', '1 cup');
INSERT INTO `food` VALUES ('6', 'Corn chips', '142.00', '1 cup ');
INSERT INTO `food` VALUES ('7', 'Kugel', '257.00', '1 cup');
INSERT INTO `food` VALUES ('8', 'pecans', '180.00', '1/4 cup');
INSERT INTO `food` VALUES ('9', 'Salsa, picante sauce', '4.00', '1 Tbsp');


-- ----------------------------
-- Table structure for consume
-- ----------------------------
DROP TABLE IF EXISTS `consume`;
CREATE TABLE `consume` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `steps` int(255) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_step_id` (`user_id`) USING BTREE,
  CONSTRAINT `user_consume_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of consume
-- ----------------------------
INSERT INTO `consume` VALUES ('0b279e5b-1c92-4595-bf44-8c5c0fe379a3', '1', '10231', '2016-03-27 22:21:43');
INSERT INTO `consume` VALUES ('1', '1', '5230', '2016-03-22 16:46:04');
INSERT INTO `consume` VALUES ('2', '1', '1253', '2016-03-22 08:33:46');
INSERT INTO `consume` VALUES ('585e8e49-b333-41c5-8dce-a3eb08bbbf40', '1', '2341', '2016-03-25 22:20:43');
INSERT INTO `consume` VALUES ('a66b6c3c-b6ff-4533-a407-23b7a31eb09f', '1', '8240', '2016-03-27 22:22:02');
INSERT INTO `consume` VALUES ('b86a50b9-5ca4-41ee-a709-8221e8a457f1', '1', '7809', '2016-03-23 19:13:14');
INSERT INTO `consume` VALUES ('cbf336cc-7d6d-434b-8d21-ad7ebad97d78', '2', '3420', '2016-03-27 22:22:11');
INSERT INTO `consume` VALUES ('f7e6152f-ebf7-45cb-9dd5-8af1e3c21354', '1', '9321', '2016-03-26 22:21:11');



-- ----------------------------
-- Table structure for intake
-- ----------------------------
DROP TABLE IF EXISTS `intake`;
CREATE TABLE `intake` (
  `id` varchar(255) NOT NULL,
  `food_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `quantiy` double(10,2) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `food_consumed_id` (`food_id`) USING BTREE,
  KEY `user_consumed_id` (`user_id`) USING BTREE,
  CONSTRAINT `food_intake_id` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`),
  CONSTRAINT `user_intake_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of intake
-- ----------------------------
INSERT INTO `intake` VALUES ('1', '4', '1', '5.00', '2016-03-22 16:44:25');
INSERT INTO `intake` VALUES ('10', '23', '1', '3.00', '2016-03-26 16:45:03');
INSERT INTO `intake` VALUES ('11', '24', '1', '9.00', '2016-03-27 16:45:03');
INSERT INTO `intake` VALUES ('2', '5', '1', '2.00', '2016-03-23 16:34:50');
INSERT INTO `intake` VALUES ('3', '6', '1', '1.00', '2016-03-22 12:45:14');
INSERT INTO `intake` VALUES ('3b873cde-9501-49c7-aa3e-269f5e33de94', '8', '1', '10.00', '2016-03-25 18:51:24');
INSERT INTO `intake` VALUES ('4', '2', '1', '7.00', '2016-03-23 16:45:03');
INSERT INTO `intake` VALUES ('5', '8', '1', '2.00', '2016-03-26 16:45:03');
INSERT INTO `intake` VALUES ('6', '9', '1', '7.00', '2016-03-27 16:45:03');
INSERT INTO `intake` VALUES ('7', '18', '2', '10.00', '2016-03-23 16:45:03');
INSERT INTO `intake` VALUES ('8', '15', '1', '12.00', '2016-03-24 16:45:03');
INSERT INTO `intake` VALUES ('9', '20', '1', '20.00', '2016-03-25 16:45:03');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  `consumed` double(10,2) NOT NULL,
  `intaked` double(10,2) NOT NULL,
  `total_steps` double(10,2) NOT NULL,
  `calorie_set_goal` double(10,2) NOT NULL,
  `remaining` double(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_report_id` (`user_id`),
  CONSTRAINT `user_report_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('2f539059-5579-4b89-afe7-797e3252f9ca', '1', '2016-03-25 12:00:00', '2222.04', '5600.00', '2341.00', '500.00', '3377.96');
INSERT INTO `report` VALUES ('6c29b392-2aaf-4055-8511-c12a6fd75254', '1', '2016-03-24 12:00:00', '2144.50', '4332.00', '0.00', '500.00', '2187.50');
INSERT INTO `report` VALUES ('8e19d60f-ba52-4757-940f-5e957015fceb', '1', '2016-03-23 12:00:00', '2403.14', '736.00', '7809.00', '500.00', '-1667.14');
INSERT INTO `report` VALUES ('b9002ec8-12c3-44aa-9711-e2ea8d2c540f', '1', '2016-03-27 12:00:00', '2756.26', '2314.00', '18471.00', '500.00', '-442.26');
INSERT INTO `report` VALUES ('b9f0207a-527b-4bb1-b7ba-5da123b2aca5', '1', '2016-03-22 12:00:00', '2359.22', '842.00', '6483.00', '500.00', '-1517.22');
INSERT INTO `report` VALUES ('e7e1f008-9f4a-4347-9bbe-fe281b8c3c68', '1', '2016-03-26 12:00:00', '2453.21', '1266.00', '9321.00', '500.00', '-1187.21');


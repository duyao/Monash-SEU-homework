/*
Navicat MySQL Data Transfer

Source Server         : health
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : id27315797

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-04-29 10:58:52
*/

CREATE DATABASE IF NOT EXISTS 'id27315797';
USE 'id27315797';

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `consume` VALUES ('111fcb48-33c3-4e24-8850-ad4f5873e67d', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2021', '2016-04-28 12:10:39');
INSERT INTO `consume` VALUES ('3d0e4948-0471-45ab-be92-ec959955ba3e', '23394d4e-b3cd-49cb-9251-ff38286333de', '0', '2016-04-28 15:33:03');
INSERT INTO `consume` VALUES ('64a468dc-85b5-44b9-b483-fd8976514b4a', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2232', '2016-04-27 11:43:06');
INSERT INTO `consume` VALUES ('9a749af1-b7e0-4599-ad16-78fd12a87179', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2427', '2016-04-26 14:44:56');
INSERT INTO `consume` VALUES ('a9dd7da2-a928-43f4-a64b-f82d7a0c143c', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1518', '2016-04-25 09:07:17');

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
INSERT INTO `food` VALUES ('06006', 'Soup, bean with frankfurters, canned, condensed', '594.00', 'Soups,&Sauces,&and&Gravies');
INSERT INTO `food` VALUES ('06007', '	Soup, bean with ham, canned, chunky, ready-to-serve', '397.00', 'Soups,&Sauces,&and&Gravies');
INSERT INTO `food` VALUES ('06009', 'Soup, beef noodle, canned, condensed', '280.00', 'Soups,&Sauces,&and&Gravies');
INSERT INTO `food` VALUES ('06010', 'Soup, cream of celery, canned, condensed', '301.00', 'Soups,&Sauces,&and&Gravies');
INSERT INTO `food` VALUES ('06050', 'Soup, pea, split with ham, canned, chunky, ready-to-serve', '322.00', 'Soups,&Sauces,&and&Gravies');
INSERT INTO `food` VALUES ('08129', 'Cereals, oats, instant, fortified, with cinnamon and spice, prepared with water', '402.00', 'Breakfast&Cereals');
INSERT INTO `food` VALUES ('09102', 'Fruit salad, (peach and pear and apricot and pineapple and cherry), canned, water pack, solids and liquids', '126.00', 'Fruits&and&Fruit&Juices');
INSERT INTO `food` VALUES ('09103', 'Fruit salad, (peach and pear and apricot and pineapple and cherry), canned, juice pack, solids and liquids', '209.00', 'Fruits&and&Fruit&Juices');
INSERT INTO `food` VALUES ('09104', 'Fruit salad, (peach and pear and apricot and pineapple and cherry), canned, light syrup, solids and liquids', '243.00', 'Fruits&and&Fruit&Juices');
INSERT INTO `food` VALUES ('09105', 'Fruit salad, (peach and pear and apricot and pineapple and cherry), canned, heavy syrup, solids and liquids', '305.00', 'Fruits&and&Fruit&Juices');
INSERT INTO `food` VALUES ('09106', 'Fruit salad, (peach and pear and apricot and pineapple and cherry), canned, extra heavy syrup, solids and liquids', '368.00', 'Fruits&and&Fruit&Juices');
INSERT INTO `food` VALUES ('10001', 'Pork, fresh, carcass, separable lean and fat, raw', '1573.00', 'Pork&Products');
INSERT INTO `food` VALUES ('10002', 'Pork, fresh, composite of trimmed retail cuts (leg, loin, shoulder), separable lean only, raw', '562.00', 'Pork&Products');
INSERT INTO `food` VALUES ('10003', 'Pork, fresh, composite of trimmed leg, loin, shoulder, and spareribs, (includes cuts to be cured), separable lean and fat, raw', '884.00', 'Pork&Products');
INSERT INTO `food` VALUES ('10004', 'Pork, fresh, backfat, raw', '3397.00', 'Pork&Products');
INSERT INTO `food` VALUES ('10005', 'Pork, fresh, belly, raw', '2167.00', 'Pork&Products');
INSERT INTO `food` VALUES ('10010', 'Pork, fresh, leg (ham), whole, separable lean only, raw', '569.00', 'Pork&Products');
INSERT INTO `food` VALUES ('11046', 'Beans, navy, mature seeds, sprouted, raw', '280.00', 'Vegetables&and&Vegetable&Products');
INSERT INTO `food` VALUES ('11047', 'Beans, navy, mature seeds, sprouted, cooked, boiled, drained, without salt', '325.00', 'Vegetables&and&Vegetable&Products');
INSERT INTO `food` VALUES ('11048', 'Beans, pinto, immature seeds, frozen, unprepared', '711.00', 'Vegetables&and&Vegetable&Products');
INSERT INTO `food` VALUES ('11049', 'Beans, pinto, immature seeds, frozen, cooked, boiled, drained, without salt', '678.00', 'Vegetables&and&Vegetable&Products');
INSERT INTO `food` VALUES ('11050', 'Beans, shellie, canned, solids and liquids', '126.00', 'Vegetables&and&Vegetable&Products');
INSERT INTO `food` VALUES ('22402', 'Beef macaroni with tomato sauce, frozen entree, reduced fat', '475.00', 'Meals,&Entrees,&and&Side&Dishes');
INSERT INTO `food` VALUES ('22522', 'Pasta with Sliced Franks in Tomato Sauce, canned entree', '375.00', 'Meals,&Entrees,&and&Side&Dishes');
INSERT INTO `food` VALUES ('22528', 'Turkey Pot Pie, frozen entree', '736.00', 'Meals,&Entrees,&and&Side&Dishes');
INSERT INTO `food` VALUES ('32012', 'Pizza rolls, frozen, unprepared', '1371.00', 'Meals,&Entrees,&and&Side&Dishes');
INSERT INTO `food` VALUES ('32015', 'Turnover, cheese-filled, tomato-based sauce, frozen, unprepared', '984.00', 'Meals,&Entrees,&and&Side&Dishes');
INSERT INTO `food` VALUES ('42236', 'Cereals ready-to-eat, frosted oat cereal with marshmallows', '1674.00', 'Breakfast&Cereals');
INSERT INTO `food` VALUES ('43218', 'Cereals ready-to-eat, ALPEN', '1473.00', 'Breakfast&Cereals');
INSERT INTO `food` VALUES ('43245', 'Cereals ready-to-eat, wheat and bran, presweetened with nuts and fruits', '1611.00', 'Breakfast&Cereals');
INSERT INTO `food` VALUES ('43483', 'Millet, puffed', '1481.00', 'Breakfast&Cereals');

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
INSERT INTO `intake` VALUES ('0815fb26-983f-4379-aa05-1c0c4d492144', '09105', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-28 21:42:58');
INSERT INTO `intake` VALUES ('175d38f3-b917-4dc5-b91b-55d955210396', '43218', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-26 09:34:13');
INSERT INTO `intake` VALUES ('24b2f2df-50e7-46d8-a53d-79fb3d3c106a', '32012', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2.00', '2016-04-26 19:58:45');
INSERT INTO `intake` VALUES ('270f4c65-49c6-4e83-ab3a-1f23df9f36d7', '11050', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-28 15:01:16');
INSERT INTO `intake` VALUES ('438b2a5a-a137-4e02-b038-d2c9efde90ff', '09102', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-28 22:20:28');
INSERT INTO `intake` VALUES ('5cc35030-3218-4409-bf4d-6b746cbeec44', '32012', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-26 12:24:33');
INSERT INTO `intake` VALUES ('725cacb6-cdef-4c44-8462-fe025a76606a', '09103', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-28 22:28:35');
INSERT INTO `intake` VALUES ('770f2db0-88da-45a4-9d0c-ff57457130f8', '11050', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-28 21:45:37');
INSERT INTO `intake` VALUES ('7bca0b09-67ba-4f66-8265-5936ada4d0d5', '11049', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-25 09:47:49');
INSERT INTO `intake` VALUES ('85cfda67-0546-4924-a4f8-fe2d1dd37a44', '08129', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-27 22:02:30');
INSERT INTO `intake` VALUES ('9096db0b-acb2-4cdc-a60f-ca3640d23fb3', '09106', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '5.00', '2016-04-25 17:36:56');
INSERT INTO `intake` VALUES ('938bef14-7665-4600-a6a0-2da900d067c9', '09102', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-28 21:43:12');
INSERT INTO `intake` VALUES ('93a4c965-7f6b-4547-b9fc-711d6f4915f6', '11050', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '5.00', '2016-04-27 12:23:01');
INSERT INTO `intake` VALUES ('a4467e85-c945-48e6-9490-42691914a4dc', '09103', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2.00', '2016-04-26 16:26:27');
INSERT INTO `intake` VALUES ('c529748e-ad79-4b97-9169-0576b30a70ce', '43483', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-25 09:10:00');
INSERT INTO `intake` VALUES ('ce5df8ce-b56c-427c-8acb-a9a2e53dc44a', '10010', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-28 19:10:16');
INSERT INTO `intake` VALUES ('d92f99b6-580f-4373-856e-d3608bbba2b2', '11048', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-28 12:10:52');
INSERT INTO `intake` VALUES ('e121c7e5-863b-4617-a7cc-0aab450afabd', '06010', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-28 13:41:44');
INSERT INTO `intake` VALUES ('e1d3085f-3f5c-4a4d-88e3-342074ae5ad0', '22528', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-28 19:40:52');
INSERT INTO `intake` VALUES ('f89c6697-be0a-4f99-89f6-65c5fc2aadea', '11047', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2.00', '2016-04-25 13:58:21');
INSERT INTO `intake` VALUES ('ff380d1f-c923-4bea-9922-f26d67ee1c00', '43483', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '1.00', '2016-04-27 11:44:00');

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
INSERT INTO `report` VALUES ('2f539059-5579-4b89-afe7-797e3252f9ca', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2016-03-25 12:00:00', '2222.04', '5600.00', '2341.00', '3000.00', '3377.96');
INSERT INTO `report` VALUES ('6c29b392-2aaf-4055-8511-c12a6fd75254', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2016-03-24 12:00:00', '2144.50', '4332.00', '5434.00', '2010.00', '2187.50');
INSERT INTO `report` VALUES ('7ad47ebc-6558-4539-b005-dfd5d1d95104', '23394d4e-b3cd-49cb-9251-ff38286333de', '2016-04-28 15:33:03', '2887.34', '0.00', '0.00', '500.00', '2887.34');
INSERT INTO `report` VALUES ('8e19d60f-ba52-4757-940f-5e957015fceb', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2016-03-23 12:00:00', '2403.14', '1203.00', '7809.00', '500.00', '102.00');
INSERT INTO `report` VALUES ('b9002ec8-12c3-44aa-9711-e2ea8d2c540f', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2016-03-27 12:00:00', '2756.26', '2314.00', '18471.00', '500.00', '321.00');
INSERT INTO `report` VALUES ('b9f0207a-527b-4bb1-b7ba-5da123b2aca5', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2016-03-22 12:00:00', '2359.22', '1200.00', '6483.00', '500.00', '1204.00');
INSERT INTO `report` VALUES ('c3a0b811-be5c-47c9-8f52-5cdd19820b50', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2016-04-27 11:43:41', '3552.63', '2513.00', '2232.00', '450.00', '1039.63');
INSERT INTO `report` VALUES ('de5dad29-098a-40d2-918d-5c7e9ae02161', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2016-04-28 12:10:58', '3324.70', '3335.00', '2021.00', '500.00', '-10.30');
INSERT INTO `report` VALUES ('e49245e3-12a7-4af0-a275-64ff565712c6', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2016-04-25 17:13:12', '5376.12', '4649.00', '3920.00', '5000.00', '727.12');
INSERT INTO `report` VALUES ('e7e1f008-9f4a-4347-9bbe-fe281b8c3c68', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2016-03-26 12:00:00', '2453.21', '1266.00', '9321.00', '900.00', '231.00');
INSERT INTO `report` VALUES ('ff161a79-97aa-46be-a27a-759206ea5fea', 'c26d67b3-ad09-4330-b424-0413bcc0cec5', '2016-04-26 09:18:41', '3763.28', '6004.00', '2427.00', '300.00', '-2240.72');

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
  `goal` int(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0eb8f722-2548-4454-b006-e342347d5a89', '123', 'Jams', '26', '0', '182.00', '71.80', '5', '1205', '1787.49', '500');
INSERT INTO `user` VALUES ('1', '123', 'Amy', '22', '1', '173.00', '53.50', '3', '1745', '1383.55', '99');
INSERT INTO `user` VALUES ('1477013d-590d-48aa-8b7f-28a258dba159', '123', 'Jams', '26', '0', '182.00', '71.80', '5', '1205', '1787.49', '500');
INSERT INTO `user` VALUES ('2', '123', 'Tom', '23', '0', '183.00', '74.30', '4', '1549', '1847.15', '500');
INSERT INTO `user` VALUES ('23394d4e-b3cd-49cb-9251-ff38286333de', 'test', 'test', '23', '1', '169.00', '69.00', '5', '3690', '1519.65', '500');
INSERT INTO `user` VALUES ('3', '123', 'Helen', '21', '1', '165.00', '55.10', '2', '1845', '1388.73', '500');
INSERT INTO `user` VALUES ('45c6b517-7505-43be-9fb5-7664d9d74ba8', '2', '2', '2', '1', '2.00', '2.00', '5', '2', '668.46', '555');
INSERT INTO `user` VALUES ('4dfddc93-a597-4c0e-bffe-394e892c6b19', 'Happy', '123', '28', '1', '165.00', '69.00', '1', '1325', '1488.85', '140');
INSERT INTO `user` VALUES ('7097b9c5-2f9f-438d-9d80-05cdba79005e', '123', 'Chris', '29', '0', '190.00', '80.30', '4', '1693', '1924.09', '500');
INSERT INTO `user` VALUES ('c26d67b3-ad09-4330-b424-0413bcc0cec5', '1', '1', '1', '1', '1.00', '1.00', '4', '1', '661.73', '500');

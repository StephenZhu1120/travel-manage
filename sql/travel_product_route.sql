/*
 Navicat MySQL Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : rm-2zezty3lne7psro7m8o.mysql.rds.aliyuncs.com:3306
 Source Schema         : aoyou-travel

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 13/05/2021 00:51:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for travel_product_route
-- ----------------------------
DROP TABLE IF EXISTS `travel_product_route`;
CREATE TABLE `travel_product_route`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '路线id',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '所属产品id',
  `route_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路线名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '路线价格',
  `transport_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交通工具描述',
  `transport_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '交通工具部分价格',
  `hotel_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '宾馆描述',
  `hotel_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '宾馆部分价格',
  `travel_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '旅行描述',
  `travel_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '旅行部分价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of travel_product_route
-- ----------------------------
INSERT INTO `travel_product_route` VALUES (1, 1, '艺术深度游', 1358.80, '高铁往返一等车厢', 288.80, '艺术风情江南民宅', 488.00, '拙政园+乌镇+西湖 尽享江南风情', 582.00);

SET FOREIGN_KEY_CHECKS = 1;

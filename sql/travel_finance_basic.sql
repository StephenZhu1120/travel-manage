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

 Date: 13/05/2021 00:50:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for travel_finance_basic
-- ----------------------------
DROP TABLE IF EXISTS `travel_finance_basic`;
CREATE TABLE `travel_finance_basic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '对应订单编号',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '交易金额',
  `trade_type` int(11) NULL DEFAULT NULL COMMENT '交易方向（支付/退款）',
  `comment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交易备注',
  `start_time` datetime NULL DEFAULT NULL COMMENT '发起时间',
  `trade_time` datetime NULL DEFAULT NULL COMMENT '交易时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

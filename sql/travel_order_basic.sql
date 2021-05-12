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

 Date: 13/05/2021 00:50:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for travel_order_basic
-- ----------------------------
DROP TABLE IF EXISTS `travel_order_basic`;
CREATE TABLE `travel_order_basic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `product_id` int(11) NULL DEFAULT NULL COMMENT '下单产品id',
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `route_id` int(11) NULL DEFAULT NULL COMMENT '具体路线id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '下单用户id',
  `phonenumber` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '下单手机号',
  `travel_time` datetime NULL DEFAULT NULL COMMENT '旅行时间',
  `order_time` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `people_number` int(11) NULL DEFAULT NULL COMMENT '订单人数',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单价格',
  `order_status` int(11) NULL DEFAULT NULL COMMENT '订单状态',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `pay_comment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付备注',
  `pay_way` int(11) NULL DEFAULT NULL COMMENT '支付方式',
  `refund_time` datetime NULL DEFAULT NULL COMMENT '退款时间',
  `refund_comment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '退款备注',
  `edit_time` datetime NULL DEFAULT NULL COMMENT '最后编辑时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

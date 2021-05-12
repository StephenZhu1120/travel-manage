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

 Date: 13/05/2021 00:51:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for travel_product_basic
-- ----------------------------
DROP TABLE IF EXISTS `travel_product_basic`;
CREATE TABLE `travel_product_basic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '旅游产品id',
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '旅游产品名称',
  `product_status` int(11) NULL DEFAULT NULL COMMENT '旅游产品状态',
  `product_day` int(11) NULL DEFAULT NULL COMMENT '旅行天数',
  `create_time` datetime NULL DEFAULT NULL COMMENT '产品创建时间',
  `edit_time` datetime NULL DEFAULT NULL COMMENT '产品最后编辑时间',
  `product_design` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '产品策划（市场部）',
  `product_plan` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '产品计划（计调部）',
  `birthland` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '出发地',
  `destination` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '目的地',
  `price_start` decimal(10, 5) NULL DEFAULT NULL COMMENT '起始最低价格',
  `order_number` int(11) NULL DEFAULT NULL COMMENT '订单完成数量',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品展示文字',
  `img_url` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片链接地址',
  `product_detail_ads` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '图片宣传内容',
  `route_number` int(11) NULL DEFAULT NULL COMMENT '路线数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

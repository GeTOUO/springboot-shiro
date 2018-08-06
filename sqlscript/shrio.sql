/*
 Navicat Premium Data Transfer

 Source Server         : 本地_msdata
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3406
 Source Schema         : shrio

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 06/08/2018 17:21:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for SYS_PERMISSION
-- ----------------------------
DROP TABLE IF EXISTS `SYS_PERMISSION`;
CREATE TABLE `SYS_PERMISSION`  (
  `UUID` varchar(34) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLE`;
CREATE TABLE `SYS_ROLE`  (
  `UUID` varchar(34) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `ROLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for USER_INFO
-- ----------------------------
DROP TABLE IF EXISTS `USER_INFO`;
CREATE TABLE `USER_INFO`  (
  `UUID` char(36) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_hungarian_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

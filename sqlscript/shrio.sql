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

 Date: 07/08/2018 12:33:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for SYS_PERMISSION
-- ----------------------------
DROP TABLE IF EXISTS `SYS_PERMISSION`;
CREATE TABLE `SYS_PERMISSION`  (
  `UUID` varchar(36) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLE`;
CREATE TABLE `SYS_ROLE`  (
  `UUID` varchar(36) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `ROLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NULL DEFAULT NULL,
  PRIMARY KEY (`UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for SYS_ROLE_PERMISSION
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLE_PERMISSION`;
CREATE TABLE `SYS_ROLE_PERMISSION`  (
  `SYS_PERMISSION_UUID` varchar(36) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `SYS_ROLE_UUID` varchar(36) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  PRIMARY KEY (`SYS_PERMISSION_UUID`, `SYS_ROLE_UUID`) USING BTREE,
  INDEX `role`(`SYS_ROLE_UUID`) USING BTREE,
  CONSTRAINT `role` FOREIGN KEY (`SYS_ROLE_UUID`) REFERENCES `SYS_ROLE` (`UUID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `permission` FOREIGN KEY (`SYS_PERMISSION_UUID`) REFERENCES `SYS_PERMISSION` (`UUID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for SYS_ROLE_USER
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLE_USER`;
CREATE TABLE `SYS_ROLE_USER`  (
  `USER_INFO_UUID` varchar(36) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `SYS_ROLE_UUID` varchar(36) CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  PRIMARY KEY (`USER_INFO_UUID`, `SYS_ROLE_UUID`) USING BTREE,
  INDEX `sysRole`(`SYS_ROLE_UUID`) USING BTREE,
  CONSTRAINT `userInfo` FOREIGN KEY (`USER_INFO_UUID`) REFERENCES `USER_INFO` (`UUID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sysRole` FOREIGN KEY (`SYS_ROLE_UUID`) REFERENCES `SYS_ROLE` (`UUID`) ON DELETE RESTRICT ON UPDATE RESTRICT
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

/*
 Navicat Premium Data Transfer

 Source Server         : LocalHost
 Source Server Type    : MariaDB
 Source Server Version : 100314
 Source Host           : localhost:3306
 Source Schema         : aiexaminer

 Target Server Type    : MariaDB
 Target Server Version : 100314
 File Encoding         : 65001

 Date: 07/08/2020 22:58:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Article ID',
  `user_id` int(10) NOT NULL COMMENT 'User ID of the Article Createor',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'Article title',
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Article text',
  `create_time` timestamp(0) NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT 'Create time of article',
  `status` enum('normal','draft','hidden','pending') CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT 'normal' COMMENT 'Special status of article',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_attachment
-- ----------------------------
DROP TABLE IF EXISTS `article_attachment`;
CREATE TABLE `article_attachment`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `article_id` int(10) NOT NULL,
  `attachment_id` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_aricle_and_attchment`(`article_id`, `attachment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `hash` char(32) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `type` enum('webp','jpg','gif','png','webm','zip','rar','7z','gz','bz2','mp4','flv','swf','txt','xz') CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `reference_num` int(10) NOT NULL DEFAULT 1,
  `create_time` timestamp(0) NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `size` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_hash_and_type`(`hash`, `type`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `article_id` int(10) NOT NULL,
  `parent_comment_id` int(10) NOT NULL DEFAULT 0,
  `author_id` int(10) NOT NULL,
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `status` enum('normal','draft','hidden','pending') CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT 'normal' COMMENT 'Special status of comment',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `article_id`(`article_id`, `parent_comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for options
-- ----------------------------
DROP TABLE IF EXISTS `options`;
CREATE TABLE `options`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_key`(`key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` char(60) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `email` varchar(70) CHARACTER SET ascii COLLATE ascii_general_ci NULL DEFAULT NULL,
  `phone` bigint(20) NULL DEFAULT NULL COMMENT '0为未填，负数为+86xxx国际格式，正数国内号码省略+86',
  `role` smallint(10) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `login_time` timestamp(0) NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `create_ip` varchar(38) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT '',
  `login_ip` varchar(38) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT '',
  `mongo_key` char(24) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `unique_name`(`name`) USING BTREE,
  UNIQUE INDEX `unique_mongo_key`(`mongo_key`) USING BTREE,
  UNIQUE INDEX `unique_phone`(`phone`) USING BTREE,
  UNIQUE INDEX `unique_email`(`email`) USING BTREE,
  UNIQUE INDEX `fastfetch`(`password`, `role`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

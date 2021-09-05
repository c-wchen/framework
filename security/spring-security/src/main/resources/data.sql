/*
 Navicat Premium Data Transfer

 Source Server         : wchen_localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 31/05/2021 16:42:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of w_permission
-- ----------------------------
INSERT INTO `w_permission` VALUES (1001, 'p1', '资源1', '/test/p1');
INSERT INTO `w_permission` VALUES (1002, 'p2', '资源2', '/test/p2');
INSERT INTO `w_permission` VALUES (1003, 'p3', '资源3', '/test/p3');
INSERT INTO `w_permission` VALUES (1004, 'p4', '资源4', '/test/p4');

-- ----------------------------
-- Records of w_role
-- ----------------------------
INSERT INTO `w_role` VALUES (1001, 'admin1', '管理员1');
INSERT INTO `w_role` VALUES (1002, 'admin2', '管理员2');
INSERT INTO `w_role` VALUES (1003, 'admin3', '管理员3');
INSERT INTO `w_role` VALUES (1004, 'admin4', '管理员4');

-- ----------------------------
-- Records of w_role_permissions
-- ----------------------------
INSERT INTO `w_role_permissions` VALUES (1001, 1001);
INSERT INTO `w_role_permissions` VALUES (1002, 1002);
INSERT INTO `w_role_permissions` VALUES (1003, 1003);
INSERT INTO `w_role_permissions` VALUES (1004, 1004);

-- ----------------------------
-- Records of w_user
-- ----------------------------
INSERT INTO `w_user` VALUES (1001, 'p1', 1, '$2a$10$zopH1COZovnyEPRr041N.e96HEGEhIsXnbA9l3vM2aZQGTRweVgYK', '$2a$10$zopH1COZovnyEPRr041N.e');
INSERT INTO `w_user` VALUES (1002, 'p2', 1, '$2a$10$9vqdvJWrOCCEi.vlErcIW.9qfmNMd.dNqwD5LZKedo3QH4oO.yTqi', '$2a$10$9vqdvJWrOCCEi.vlErcIW.');
INSERT INTO `w_user` VALUES (1003, 'p3', 1, '$2a$10$PolZq/gja81I5CrJ72PBSOJFgXfOCksNLNID/Tm6CrWYT9989RRLK', '$2a$10$PolZq/gja81I5CrJ72PBSO');
INSERT INTO `w_user` VALUES (1004, 'p4', 1, '$2a$10$yDw3t/3VNn/8CgRqd1LRbO9/Uh3b2mTBqsVZhCkMVW/nmOTz3KPgS', '$2a$10$yDw3t/3VNn/8CgRqd1LRbO');

-- ----------------------------
-- Records of w_user_roles
-- ----------------------------
INSERT INTO `w_user_roles` VALUES (1001, 1001);
INSERT INTO `w_user_roles` VALUES (1002, 1002);
INSERT INTO `w_user_roles` VALUES (1003, 1003);
INSERT INTO `w_user_roles` VALUES (1004, 1004);

SET FOREIGN_KEY_CHECKS = 1;

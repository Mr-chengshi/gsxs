/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2022-05-03 20:51:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `xid` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sid` varchar(50) NOT NULL,
  `introduction` varchar(512) DEFAULT NULL,
  `score` int(10) DEFAULT NULL,
  `sex` enum('女','男') CHARACTER SET utf8mb4 DEFAULT '男',
  `interests` varchar(512) DEFAULT NULL,
  `status` enum('0','1') DEFAULT '1',
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`xid`,`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '10085', '123', '123456789', null, null, '男', null, '1', null);
INSERT INTO `user` VALUES ('2', 'lisi', '10086', '123', '987654321', null, null, '男', null, '1', null);
INSERT INTO `user` VALUES ('3', 'wangwu', '10087', '123', '323434234', null, null, '男', null, '1', null);
INSERT INTO `user` VALUES ('4', '成事123', '10088', '123', '123434', '成事是最帅', '99999', '男', '唱跳rap篮球', '1', '1372901301@qq.com');
INSERT INTO `user` VALUES ('6', '用户', '10089', '123', '123', null, null, '男', null, '1', null);
INSERT INTO `user` VALUES ('7', '用户', '1000', '123', '123', null, null, '男', null, '1', null);
INSERT INTO `user` VALUES ('8', '测试', '10001', '123', '123', '成事是最帅的', null, '男', '玩', '1', '');

/*
 Navicat MySQL Data Transfer

 Source Server         : ypl-mysql-本机
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 31/07/2020 14:34:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for upms_permission
-- ----------------------------
DROP TABLE IF EXISTS `upms_permission`;
CREATE TABLE `upms_permission`  (
  `permission_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `system_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '所属系统',
  `pid` int(10) NULL DEFAULT NULL COMMENT '所属上级',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型(1:目录,2:菜单,3:按钮)',
  `permission_value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `uri` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `ctime` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `orders` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  `tenant_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '000000',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of upms_permission
-- ----------------------------
INSERT INTO `upms_permission` VALUES (1, NULL, 0, '系统设置', 1, NULL, NULL, NULL, 1, NULL, 5, '0');
INSERT INTO `upms_permission` VALUES (2, NULL, 1, '用户管理', 2, NULL, 'html/sys/user.html', NULL, 1, NULL, 4, '0');
INSERT INTO `upms_permission` VALUES (3, NULL, 1, '部门管理', 2, NULL, 'html/sys/dept.html', NULL, 1, NULL, 3, '0');
INSERT INTO `upms_permission` VALUES (4, NULL, 1, '角色管理', 2, NULL, 'html/sys/role.html', NULL, 1, NULL, 2, '0');
INSERT INTO `upms_permission` VALUES (5, NULL, 1, '权限管理', 2, NULL, 'html/sys/permission.html', NULL, 1, NULL, 1, '0');
INSERT INTO `upms_permission` VALUES (6, NULL, 0, '待处理', 1, NULL, NULL, 'zmdi zmdi-widgets', 1, NULL, 99, NULL);
INSERT INTO `upms_permission` VALUES (7, NULL, 6, 'SUSAR', 2, NULL, 'html/unfinished/unfinish.html', NULL, 1, NULL, 98, '0');
INSERT INTO `upms_permission` VALUES (8, NULL, 6, '登记平台', 2, NULL, 'html/unfinished/unfinish.html', NULL, 1, NULL, 96, '1');
INSERT INTO `upms_permission` VALUES (9, NULL, 6, '其他', 2, NULL, 'html/unfinished/unfinish.html', NULL, 1, NULL, 93, '3');
INSERT INTO `upms_permission` VALUES (10, NULL, 6, '公文', 2, NULL, 'html/unfinished/unfinish.html', NULL, 1, NULL, 94, '2');
INSERT INTO `upms_permission` VALUES (11, NULL, 6, 'DSUR', 2, NULL, 'html/unfinished/unfinish.html', NULL, 1, NULL, 95, '4');
INSERT INTO `upms_permission` VALUES (12, NULL, 6, '其他潜在', 2, NULL, 'html/unfinished/unfinish.html', NULL, 1, NULL, 97, '5');
INSERT INTO `upms_permission` VALUES (13, NULL, 0, '审核中', 1, NULL, NULL, 'zmdi zmdi-widgets', 1, NULL, 92, NULL);
INSERT INTO `upms_permission` VALUES (14, NULL, 13, 'SUSAR', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 91, '0&status=0');
INSERT INTO `upms_permission` VALUES (15, NULL, 13, '登记平台', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 89, '1&status=0');
INSERT INTO `upms_permission` VALUES (16, NULL, 13, '其他', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 86, '3&status=0');
INSERT INTO `upms_permission` VALUES (17, NULL, 13, '公文', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 87, '2&status=0');
INSERT INTO `upms_permission` VALUES (18, NULL, 13, 'DSUR', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 88, '4&status=0');
INSERT INTO `upms_permission` VALUES (19, NULL, 13, '其他潜在', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 90, '5&status=0');
INSERT INTO `upms_permission` VALUES (20, NULL, 0, '已处理', 1, NULL, NULL, 'zmdi zmdi-widgets', 1, NULL, 85, NULL);
INSERT INTO `upms_permission` VALUES (21, NULL, 20, 'SUSAR', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 84, '0&status=');
INSERT INTO `upms_permission` VALUES (22, NULL, 20, '登记平台', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 82, '1&status=');
INSERT INTO `upms_permission` VALUES (23, NULL, 20, '其他', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 79, '3&status=');
INSERT INTO `upms_permission` VALUES (24, NULL, 20, '公文', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 80, '2&status=');
INSERT INTO `upms_permission` VALUES (25, NULL, 20, 'DSUR', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 81, '4&status=');
INSERT INTO `upms_permission` VALUES (26, NULL, 20, '其他潜在', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 83, '5&status=');
INSERT INTO `upms_permission` VALUES (27, NULL, 0, '已完成', 1, NULL, NULL, 'zmdi zmdi-widgets', 1, NULL, 78, NULL);
INSERT INTO `upms_permission` VALUES (28, NULL, 27, 'SUSAR', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 77, '0&status=1');
INSERT INTO `upms_permission` VALUES (29, NULL, 27, '登记平台', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 75, '1&status=1');
INSERT INTO `upms_permission` VALUES (30, NULL, 27, '其他', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 72, '3&status=1');
INSERT INTO `upms_permission` VALUES (31, NULL, 27, '公文', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 73, '2&status=1');
INSERT INTO `upms_permission` VALUES (32, NULL, 27, 'DSUR', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 74, '4&status=1');
INSERT INTO `upms_permission` VALUES (33, NULL, 27, '其他潜在', 2, NULL, 'html/completed/completed.html', NULL, 1, NULL, 76, '5&status=1');
INSERT INTO `upms_permission` VALUES (34, NULL, 0, '全部任务', 1, NULL, NULL, 'zmdi zmdi-widgets', 1, NULL, 71, NULL);
INSERT INTO `upms_permission` VALUES (35, NULL, 34, 'SUSAR', 2, NULL, 'html/completed/whole.html', NULL, 1, NULL, 70, '0');
INSERT INTO `upms_permission` VALUES (36, NULL, 34, '登记平台', 2, NULL, 'html/completed/whole.html', NULL, 1, NULL, 68, '1');
INSERT INTO `upms_permission` VALUES (37, NULL, 34, '其他', 2, NULL, 'html/completed/whole.html', NULL, 1, NULL, 65, '3');
INSERT INTO `upms_permission` VALUES (38, NULL, 34, '公文', 2, NULL, 'html/completed/whole.html', NULL, 1, NULL, 66, '2');
INSERT INTO `upms_permission` VALUES (39, NULL, 34, 'DSUR', 2, NULL, 'html/completed/whole.html', NULL, 1, NULL, 67, '4');
INSERT INTO `upms_permission` VALUES (40, NULL, 34, '其他潜在', 2, NULL, 'html/completed/whole.html', NULL, 1, NULL, 69, '5');

-- ----------------------------
-- Table structure for upms_role
-- ----------------------------
DROP TABLE IF EXISTS `upms_role`;
CREATE TABLE `upms_role`  (
  `role_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色标题',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `ctime` bigint(20) NOT NULL COMMENT '创建时间',
  `orders` bigint(20) NOT NULL COMMENT '排序',
  `tenant_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '000000',
  `dept_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_role
-- ----------------------------
INSERT INTO `upms_role` VALUES (1, '专员', NULL, NULL, 20200523, 1, NULL, 1);
INSERT INTO `upms_role` VALUES (2, '联络员', NULL, NULL, 20200523, 2, NULL, 1);
INSERT INTO `upms_role` VALUES (3, '主审', NULL, NULL, 20200523, 3, NULL, 1);
INSERT INTO `upms_role` VALUES (4, '参审', NULL, NULL, 20200523, 4, NULL, 1);
INSERT INTO `upms_role` VALUES (5, '部长', NULL, NULL, 20200523, 5, NULL, 1);
INSERT INTO `upms_role` VALUES (6, '联络员', NULL, NULL, 20200523, 1, NULL, 2);
INSERT INTO `upms_role` VALUES (7, '主审', NULL, NULL, 20200523, 2, NULL, 2);
INSERT INTO `upms_role` VALUES (8, '参审', NULL, NULL, 20200523, 3, NULL, 2);
INSERT INTO `upms_role` VALUES (9, '部长', NULL, NULL, 20200523, 4, NULL, 2);
INSERT INTO `upms_role` VALUES (10, '联络员', NULL, NULL, 20200523, 1, NULL, 3);
INSERT INTO `upms_role` VALUES (11, '主审', NULL, NULL, 20200523, 2, NULL, 3);
INSERT INTO `upms_role` VALUES (12, '参审', NULL, NULL, 20200523, 3, NULL, 3);
INSERT INTO `upms_role` VALUES (13, '部长', NULL, NULL, 20200523, 4, NULL, 3);
INSERT INTO `upms_role` VALUES (14, '联络员', NULL, NULL, 20200523, 1, NULL, 4);
INSERT INTO `upms_role` VALUES (15, '主审', NULL, NULL, 20200523, 2, NULL, 4);
INSERT INTO `upms_role` VALUES (16, '参审', NULL, NULL, 20200523, 3, NULL, 4);
INSERT INTO `upms_role` VALUES (17, '部长', NULL, NULL, 20200523, 4, NULL, 4);
INSERT INTO `upms_role` VALUES (18, '联络员', NULL, NULL, 20200523, 1, NULL, 5);
INSERT INTO `upms_role` VALUES (19, '主审', NULL, NULL, 20200523, 2, NULL, 5);
INSERT INTO `upms_role` VALUES (20, '参审', NULL, NULL, 20200523, 3, NULL, 5);
INSERT INTO `upms_role` VALUES (21, '部长', NULL, NULL, 20200523, 4, NULL, 5);
INSERT INTO `upms_role` VALUES (22, '联络员', NULL, NULL, 20200523, 1, NULL, 6);
INSERT INTO `upms_role` VALUES (23, '主审', NULL, NULL, 20200523, 2, NULL, 6);
INSERT INTO `upms_role` VALUES (24, '参审', NULL, NULL, 20200523, 3, NULL, 6);
INSERT INTO `upms_role` VALUES (25, '部长', NULL, NULL, 20200523, 4, NULL, 6);
INSERT INTO `upms_role` VALUES (26, '联络员', NULL, NULL, 20200523, 1, NULL, 7);
INSERT INTO `upms_role` VALUES (27, '主审', NULL, NULL, 20200523, 2, NULL, 7);
INSERT INTO `upms_role` VALUES (28, '参审', NULL, NULL, 20200523, 3, NULL, 7);
INSERT INTO `upms_role` VALUES (29, '部长', NULL, NULL, 20200523, 4, NULL, 7);
INSERT INTO `upms_role` VALUES (30, '联络员', NULL, NULL, 20200523, 1, NULL, 8);
INSERT INTO `upms_role` VALUES (31, '主审', NULL, NULL, 20200523, 2, NULL, 8);
INSERT INTO `upms_role` VALUES (32, '参审', NULL, NULL, 20200523, 3, NULL, 8);
INSERT INTO `upms_role` VALUES (33, '部长', NULL, NULL, 20200523, 4, NULL, 8);
INSERT INTO `upms_role` VALUES (34, '联络员', NULL, NULL, 20200523, 1, NULL, 9);
INSERT INTO `upms_role` VALUES (35, '主审', NULL, NULL, 20200523, 2, NULL, 9);
INSERT INTO `upms_role` VALUES (36, '参审', NULL, NULL, 20200523, 3, NULL, 9);
INSERT INTO `upms_role` VALUES (37, '部长', NULL, NULL, 20200523, 4, NULL, 9);
INSERT INTO `upms_role` VALUES (38, '联络员', NULL, NULL, 20200523, 1, NULL, 10);
INSERT INTO `upms_role` VALUES (39, '主审', NULL, NULL, 20200523, 2, NULL, 10);
INSERT INTO `upms_role` VALUES (40, '参审', NULL, NULL, 20200523, 3, NULL, 10);
INSERT INTO `upms_role` VALUES (41, '部长', NULL, NULL, 20200523, 4, NULL, 10);
INSERT INTO `upms_role` VALUES (42, '联络员', NULL, NULL, 20200523, 1, NULL, 11);
INSERT INTO `upms_role` VALUES (43, '主审', NULL, NULL, 20200523, 2, NULL, 11);
INSERT INTO `upms_role` VALUES (44, '参审', NULL, NULL, 20200523, 3, NULL, 11);
INSERT INTO `upms_role` VALUES (45, '部长', NULL, NULL, 20200523, 4, NULL, 11);

-- ----------------------------
-- Table structure for upms_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `upms_role_permission`;
CREATE TABLE `upms_role_permission`  (
  `role_permission_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` int(10) UNSIGNED NOT NULL COMMENT '角色编号',
  `permission_id` int(10) UNSIGNED NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`role_permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1534 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_role_permission
-- ----------------------------
INSERT INTO `upms_role_permission` VALUES (237, 3, 6);
INSERT INTO `upms_role_permission` VALUES (238, 3, 7);
INSERT INTO `upms_role_permission` VALUES (239, 3, 8);
INSERT INTO `upms_role_permission` VALUES (240, 3, 9);
INSERT INTO `upms_role_permission` VALUES (241, 3, 10);
INSERT INTO `upms_role_permission` VALUES (242, 3, 11);
INSERT INTO `upms_role_permission` VALUES (243, 3, 12);
INSERT INTO `upms_role_permission` VALUES (244, 3, 13);
INSERT INTO `upms_role_permission` VALUES (245, 3, 14);
INSERT INTO `upms_role_permission` VALUES (246, 3, 15);
INSERT INTO `upms_role_permission` VALUES (247, 3, 16);
INSERT INTO `upms_role_permission` VALUES (248, 3, 17);
INSERT INTO `upms_role_permission` VALUES (249, 3, 18);
INSERT INTO `upms_role_permission` VALUES (250, 3, 19);
INSERT INTO `upms_role_permission` VALUES (251, 3, 27);
INSERT INTO `upms_role_permission` VALUES (252, 3, 28);
INSERT INTO `upms_role_permission` VALUES (253, 3, 29);
INSERT INTO `upms_role_permission` VALUES (254, 3, 30);
INSERT INTO `upms_role_permission` VALUES (255, 3, 31);
INSERT INTO `upms_role_permission` VALUES (256, 3, 32);
INSERT INTO `upms_role_permission` VALUES (257, 3, 33);
INSERT INTO `upms_role_permission` VALUES (258, 5, 6);
INSERT INTO `upms_role_permission` VALUES (259, 5, 7);
INSERT INTO `upms_role_permission` VALUES (260, 5, 8);
INSERT INTO `upms_role_permission` VALUES (261, 5, 9);
INSERT INTO `upms_role_permission` VALUES (262, 5, 10);
INSERT INTO `upms_role_permission` VALUES (263, 5, 11);
INSERT INTO `upms_role_permission` VALUES (264, 5, 12);
INSERT INTO `upms_role_permission` VALUES (265, 5, 13);
INSERT INTO `upms_role_permission` VALUES (266, 5, 14);
INSERT INTO `upms_role_permission` VALUES (267, 5, 15);
INSERT INTO `upms_role_permission` VALUES (268, 5, 16);
INSERT INTO `upms_role_permission` VALUES (269, 5, 17);
INSERT INTO `upms_role_permission` VALUES (270, 5, 18);
INSERT INTO `upms_role_permission` VALUES (271, 5, 19);
INSERT INTO `upms_role_permission` VALUES (272, 5, 27);
INSERT INTO `upms_role_permission` VALUES (273, 5, 28);
INSERT INTO `upms_role_permission` VALUES (274, 5, 29);
INSERT INTO `upms_role_permission` VALUES (275, 5, 30);
INSERT INTO `upms_role_permission` VALUES (276, 5, 31);
INSERT INTO `upms_role_permission` VALUES (277, 5, 32);
INSERT INTO `upms_role_permission` VALUES (278, 5, 33);
INSERT INTO `upms_role_permission` VALUES (279, 5, 34);
INSERT INTO `upms_role_permission` VALUES (280, 5, 35);
INSERT INTO `upms_role_permission` VALUES (281, 5, 36);
INSERT INTO `upms_role_permission` VALUES (282, 5, 37);
INSERT INTO `upms_role_permission` VALUES (283, 5, 38);
INSERT INTO `upms_role_permission` VALUES (284, 5, 39);
INSERT INTO `upms_role_permission` VALUES (285, 5, 40);
INSERT INTO `upms_role_permission` VALUES (286, 6, 6);
INSERT INTO `upms_role_permission` VALUES (287, 6, 7);
INSERT INTO `upms_role_permission` VALUES (288, 6, 8);
INSERT INTO `upms_role_permission` VALUES (289, 6, 9);
INSERT INTO `upms_role_permission` VALUES (290, 6, 10);
INSERT INTO `upms_role_permission` VALUES (291, 6, 11);
INSERT INTO `upms_role_permission` VALUES (292, 6, 12);
INSERT INTO `upms_role_permission` VALUES (293, 6, 20);
INSERT INTO `upms_role_permission` VALUES (294, 6, 21);
INSERT INTO `upms_role_permission` VALUES (295, 6, 22);
INSERT INTO `upms_role_permission` VALUES (296, 6, 23);
INSERT INTO `upms_role_permission` VALUES (297, 6, 24);
INSERT INTO `upms_role_permission` VALUES (298, 6, 25);
INSERT INTO `upms_role_permission` VALUES (299, 6, 26);
INSERT INTO `upms_role_permission` VALUES (300, 7, 6);
INSERT INTO `upms_role_permission` VALUES (301, 7, 7);
INSERT INTO `upms_role_permission` VALUES (302, 7, 8);
INSERT INTO `upms_role_permission` VALUES (303, 7, 9);
INSERT INTO `upms_role_permission` VALUES (304, 7, 10);
INSERT INTO `upms_role_permission` VALUES (305, 7, 11);
INSERT INTO `upms_role_permission` VALUES (306, 7, 12);
INSERT INTO `upms_role_permission` VALUES (307, 7, 20);
INSERT INTO `upms_role_permission` VALUES (308, 7, 21);
INSERT INTO `upms_role_permission` VALUES (309, 7, 22);
INSERT INTO `upms_role_permission` VALUES (310, 7, 23);
INSERT INTO `upms_role_permission` VALUES (311, 7, 24);
INSERT INTO `upms_role_permission` VALUES (312, 7, 25);
INSERT INTO `upms_role_permission` VALUES (313, 7, 26);
INSERT INTO `upms_role_permission` VALUES (314, 7, 34);
INSERT INTO `upms_role_permission` VALUES (315, 7, 35);
INSERT INTO `upms_role_permission` VALUES (316, 7, 36);
INSERT INTO `upms_role_permission` VALUES (317, 7, 37);
INSERT INTO `upms_role_permission` VALUES (318, 7, 38);
INSERT INTO `upms_role_permission` VALUES (319, 7, 39);
INSERT INTO `upms_role_permission` VALUES (320, 7, 40);
INSERT INTO `upms_role_permission` VALUES (321, 8, 6);
INSERT INTO `upms_role_permission` VALUES (322, 8, 7);
INSERT INTO `upms_role_permission` VALUES (323, 8, 8);
INSERT INTO `upms_role_permission` VALUES (324, 8, 9);
INSERT INTO `upms_role_permission` VALUES (325, 8, 10);
INSERT INTO `upms_role_permission` VALUES (326, 8, 11);
INSERT INTO `upms_role_permission` VALUES (327, 8, 12);
INSERT INTO `upms_role_permission` VALUES (328, 8, 20);
INSERT INTO `upms_role_permission` VALUES (329, 8, 21);
INSERT INTO `upms_role_permission` VALUES (330, 8, 22);
INSERT INTO `upms_role_permission` VALUES (331, 8, 23);
INSERT INTO `upms_role_permission` VALUES (332, 8, 24);
INSERT INTO `upms_role_permission` VALUES (333, 8, 25);
INSERT INTO `upms_role_permission` VALUES (334, 8, 26);
INSERT INTO `upms_role_permission` VALUES (342, 9, 6);
INSERT INTO `upms_role_permission` VALUES (343, 9, 7);
INSERT INTO `upms_role_permission` VALUES (344, 9, 8);
INSERT INTO `upms_role_permission` VALUES (345, 9, 9);
INSERT INTO `upms_role_permission` VALUES (346, 9, 10);
INSERT INTO `upms_role_permission` VALUES (347, 9, 11);
INSERT INTO `upms_role_permission` VALUES (348, 9, 12);
INSERT INTO `upms_role_permission` VALUES (349, 9, 20);
INSERT INTO `upms_role_permission` VALUES (350, 9, 21);
INSERT INTO `upms_role_permission` VALUES (351, 9, 22);
INSERT INTO `upms_role_permission` VALUES (352, 9, 23);
INSERT INTO `upms_role_permission` VALUES (353, 9, 24);
INSERT INTO `upms_role_permission` VALUES (354, 9, 25);
INSERT INTO `upms_role_permission` VALUES (355, 9, 26);
INSERT INTO `upms_role_permission` VALUES (356, 9, 34);
INSERT INTO `upms_role_permission` VALUES (357, 9, 35);
INSERT INTO `upms_role_permission` VALUES (358, 9, 36);
INSERT INTO `upms_role_permission` VALUES (359, 9, 37);
INSERT INTO `upms_role_permission` VALUES (360, 9, 38);
INSERT INTO `upms_role_permission` VALUES (361, 9, 39);
INSERT INTO `upms_role_permission` VALUES (362, 9, 40);
INSERT INTO `upms_role_permission` VALUES (363, 18, 6);
INSERT INTO `upms_role_permission` VALUES (364, 18, 7);
INSERT INTO `upms_role_permission` VALUES (365, 18, 8);
INSERT INTO `upms_role_permission` VALUES (366, 18, 9);
INSERT INTO `upms_role_permission` VALUES (367, 18, 10);
INSERT INTO `upms_role_permission` VALUES (368, 18, 11);
INSERT INTO `upms_role_permission` VALUES (369, 18, 12);
INSERT INTO `upms_role_permission` VALUES (370, 18, 20);
INSERT INTO `upms_role_permission` VALUES (371, 18, 21);
INSERT INTO `upms_role_permission` VALUES (372, 18, 22);
INSERT INTO `upms_role_permission` VALUES (373, 18, 23);
INSERT INTO `upms_role_permission` VALUES (374, 18, 24);
INSERT INTO `upms_role_permission` VALUES (375, 18, 25);
INSERT INTO `upms_role_permission` VALUES (376, 18, 26);
INSERT INTO `upms_role_permission` VALUES (377, 19, 6);
INSERT INTO `upms_role_permission` VALUES (378, 19, 7);
INSERT INTO `upms_role_permission` VALUES (379, 19, 8);
INSERT INTO `upms_role_permission` VALUES (380, 19, 9);
INSERT INTO `upms_role_permission` VALUES (381, 19, 10);
INSERT INTO `upms_role_permission` VALUES (382, 19, 11);
INSERT INTO `upms_role_permission` VALUES (383, 19, 12);
INSERT INTO `upms_role_permission` VALUES (384, 19, 20);
INSERT INTO `upms_role_permission` VALUES (385, 19, 21);
INSERT INTO `upms_role_permission` VALUES (386, 19, 22);
INSERT INTO `upms_role_permission` VALUES (387, 19, 23);
INSERT INTO `upms_role_permission` VALUES (388, 19, 24);
INSERT INTO `upms_role_permission` VALUES (389, 19, 25);
INSERT INTO `upms_role_permission` VALUES (390, 19, 26);
INSERT INTO `upms_role_permission` VALUES (391, 19, 34);
INSERT INTO `upms_role_permission` VALUES (392, 19, 35);
INSERT INTO `upms_role_permission` VALUES (393, 19, 36);
INSERT INTO `upms_role_permission` VALUES (394, 19, 37);
INSERT INTO `upms_role_permission` VALUES (395, 19, 38);
INSERT INTO `upms_role_permission` VALUES (396, 19, 39);
INSERT INTO `upms_role_permission` VALUES (397, 19, 40);
INSERT INTO `upms_role_permission` VALUES (398, 20, 6);
INSERT INTO `upms_role_permission` VALUES (399, 20, 7);
INSERT INTO `upms_role_permission` VALUES (400, 20, 8);
INSERT INTO `upms_role_permission` VALUES (401, 20, 9);
INSERT INTO `upms_role_permission` VALUES (402, 20, 10);
INSERT INTO `upms_role_permission` VALUES (403, 20, 11);
INSERT INTO `upms_role_permission` VALUES (404, 20, 12);
INSERT INTO `upms_role_permission` VALUES (405, 20, 20);
INSERT INTO `upms_role_permission` VALUES (406, 20, 21);
INSERT INTO `upms_role_permission` VALUES (407, 20, 22);
INSERT INTO `upms_role_permission` VALUES (408, 20, 23);
INSERT INTO `upms_role_permission` VALUES (409, 20, 24);
INSERT INTO `upms_role_permission` VALUES (410, 20, 25);
INSERT INTO `upms_role_permission` VALUES (411, 20, 26);
INSERT INTO `upms_role_permission` VALUES (412, 21, 6);
INSERT INTO `upms_role_permission` VALUES (413, 21, 7);
INSERT INTO `upms_role_permission` VALUES (414, 21, 8);
INSERT INTO `upms_role_permission` VALUES (415, 21, 9);
INSERT INTO `upms_role_permission` VALUES (416, 21, 10);
INSERT INTO `upms_role_permission` VALUES (417, 21, 11);
INSERT INTO `upms_role_permission` VALUES (418, 21, 12);
INSERT INTO `upms_role_permission` VALUES (419, 21, 20);
INSERT INTO `upms_role_permission` VALUES (420, 21, 21);
INSERT INTO `upms_role_permission` VALUES (421, 21, 22);
INSERT INTO `upms_role_permission` VALUES (422, 21, 23);
INSERT INTO `upms_role_permission` VALUES (423, 21, 24);
INSERT INTO `upms_role_permission` VALUES (424, 21, 25);
INSERT INTO `upms_role_permission` VALUES (425, 21, 26);
INSERT INTO `upms_role_permission` VALUES (426, 21, 34);
INSERT INTO `upms_role_permission` VALUES (427, 21, 35);
INSERT INTO `upms_role_permission` VALUES (428, 21, 36);
INSERT INTO `upms_role_permission` VALUES (429, 21, 37);
INSERT INTO `upms_role_permission` VALUES (430, 21, 38);
INSERT INTO `upms_role_permission` VALUES (431, 21, 39);
INSERT INTO `upms_role_permission` VALUES (432, 21, 40);
INSERT INTO `upms_role_permission` VALUES (433, 26, 6);
INSERT INTO `upms_role_permission` VALUES (434, 26, 7);
INSERT INTO `upms_role_permission` VALUES (435, 26, 8);
INSERT INTO `upms_role_permission` VALUES (436, 26, 9);
INSERT INTO `upms_role_permission` VALUES (437, 26, 10);
INSERT INTO `upms_role_permission` VALUES (438, 26, 11);
INSERT INTO `upms_role_permission` VALUES (439, 26, 12);
INSERT INTO `upms_role_permission` VALUES (440, 26, 20);
INSERT INTO `upms_role_permission` VALUES (441, 26, 21);
INSERT INTO `upms_role_permission` VALUES (442, 26, 22);
INSERT INTO `upms_role_permission` VALUES (443, 26, 23);
INSERT INTO `upms_role_permission` VALUES (444, 26, 24);
INSERT INTO `upms_role_permission` VALUES (445, 26, 25);
INSERT INTO `upms_role_permission` VALUES (446, 26, 26);
INSERT INTO `upms_role_permission` VALUES (447, 27, 6);
INSERT INTO `upms_role_permission` VALUES (448, 27, 7);
INSERT INTO `upms_role_permission` VALUES (449, 27, 8);
INSERT INTO `upms_role_permission` VALUES (450, 27, 9);
INSERT INTO `upms_role_permission` VALUES (451, 27, 10);
INSERT INTO `upms_role_permission` VALUES (452, 27, 11);
INSERT INTO `upms_role_permission` VALUES (453, 27, 12);
INSERT INTO `upms_role_permission` VALUES (454, 27, 20);
INSERT INTO `upms_role_permission` VALUES (455, 27, 21);
INSERT INTO `upms_role_permission` VALUES (456, 27, 22);
INSERT INTO `upms_role_permission` VALUES (457, 27, 23);
INSERT INTO `upms_role_permission` VALUES (458, 27, 24);
INSERT INTO `upms_role_permission` VALUES (459, 27, 25);
INSERT INTO `upms_role_permission` VALUES (460, 27, 26);
INSERT INTO `upms_role_permission` VALUES (461, 27, 34);
INSERT INTO `upms_role_permission` VALUES (462, 27, 35);
INSERT INTO `upms_role_permission` VALUES (463, 27, 36);
INSERT INTO `upms_role_permission` VALUES (464, 27, 37);
INSERT INTO `upms_role_permission` VALUES (465, 27, 38);
INSERT INTO `upms_role_permission` VALUES (466, 27, 39);
INSERT INTO `upms_role_permission` VALUES (467, 27, 40);
INSERT INTO `upms_role_permission` VALUES (468, 28, 6);
INSERT INTO `upms_role_permission` VALUES (469, 28, 7);
INSERT INTO `upms_role_permission` VALUES (470, 28, 8);
INSERT INTO `upms_role_permission` VALUES (471, 28, 9);
INSERT INTO `upms_role_permission` VALUES (472, 28, 10);
INSERT INTO `upms_role_permission` VALUES (473, 28, 11);
INSERT INTO `upms_role_permission` VALUES (474, 28, 12);
INSERT INTO `upms_role_permission` VALUES (475, 28, 20);
INSERT INTO `upms_role_permission` VALUES (476, 28, 21);
INSERT INTO `upms_role_permission` VALUES (477, 28, 22);
INSERT INTO `upms_role_permission` VALUES (478, 28, 23);
INSERT INTO `upms_role_permission` VALUES (479, 28, 24);
INSERT INTO `upms_role_permission` VALUES (480, 28, 25);
INSERT INTO `upms_role_permission` VALUES (481, 28, 26);
INSERT INTO `upms_role_permission` VALUES (482, 29, 6);
INSERT INTO `upms_role_permission` VALUES (483, 29, 7);
INSERT INTO `upms_role_permission` VALUES (484, 29, 8);
INSERT INTO `upms_role_permission` VALUES (485, 29, 9);
INSERT INTO `upms_role_permission` VALUES (486, 29, 10);
INSERT INTO `upms_role_permission` VALUES (487, 29, 11);
INSERT INTO `upms_role_permission` VALUES (488, 29, 12);
INSERT INTO `upms_role_permission` VALUES (489, 29, 20);
INSERT INTO `upms_role_permission` VALUES (490, 29, 21);
INSERT INTO `upms_role_permission` VALUES (491, 29, 22);
INSERT INTO `upms_role_permission` VALUES (492, 29, 23);
INSERT INTO `upms_role_permission` VALUES (493, 29, 24);
INSERT INTO `upms_role_permission` VALUES (494, 29, 25);
INSERT INTO `upms_role_permission` VALUES (495, 29, 26);
INSERT INTO `upms_role_permission` VALUES (496, 29, 34);
INSERT INTO `upms_role_permission` VALUES (497, 29, 35);
INSERT INTO `upms_role_permission` VALUES (498, 29, 36);
INSERT INTO `upms_role_permission` VALUES (499, 29, 37);
INSERT INTO `upms_role_permission` VALUES (500, 29, 38);
INSERT INTO `upms_role_permission` VALUES (501, 29, 39);
INSERT INTO `upms_role_permission` VALUES (502, 29, 40);
INSERT INTO `upms_role_permission` VALUES (552, 41, 6);
INSERT INTO `upms_role_permission` VALUES (553, 41, 7);
INSERT INTO `upms_role_permission` VALUES (554, 41, 8);
INSERT INTO `upms_role_permission` VALUES (555, 41, 9);
INSERT INTO `upms_role_permission` VALUES (556, 41, 10);
INSERT INTO `upms_role_permission` VALUES (557, 41, 11);
INSERT INTO `upms_role_permission` VALUES (558, 41, 12);
INSERT INTO `upms_role_permission` VALUES (559, 41, 20);
INSERT INTO `upms_role_permission` VALUES (560, 41, 21);
INSERT INTO `upms_role_permission` VALUES (561, 41, 22);
INSERT INTO `upms_role_permission` VALUES (562, 41, 23);
INSERT INTO `upms_role_permission` VALUES (563, 41, 24);
INSERT INTO `upms_role_permission` VALUES (564, 41, 25);
INSERT INTO `upms_role_permission` VALUES (565, 41, 26);
INSERT INTO `upms_role_permission` VALUES (566, 41, 34);
INSERT INTO `upms_role_permission` VALUES (567, 41, 35);
INSERT INTO `upms_role_permission` VALUES (568, 41, 36);
INSERT INTO `upms_role_permission` VALUES (569, 41, 37);
INSERT INTO `upms_role_permission` VALUES (570, 41, 38);
INSERT INTO `upms_role_permission` VALUES (571, 41, 39);
INSERT INTO `upms_role_permission` VALUES (572, 41, 40);
INSERT INTO `upms_role_permission` VALUES (622, 10, 6);
INSERT INTO `upms_role_permission` VALUES (623, 10, 7);
INSERT INTO `upms_role_permission` VALUES (624, 10, 8);
INSERT INTO `upms_role_permission` VALUES (625, 10, 9);
INSERT INTO `upms_role_permission` VALUES (626, 10, 10);
INSERT INTO `upms_role_permission` VALUES (627, 10, 11);
INSERT INTO `upms_role_permission` VALUES (628, 10, 12);
INSERT INTO `upms_role_permission` VALUES (629, 10, 20);
INSERT INTO `upms_role_permission` VALUES (630, 10, 21);
INSERT INTO `upms_role_permission` VALUES (631, 10, 22);
INSERT INTO `upms_role_permission` VALUES (632, 10, 23);
INSERT INTO `upms_role_permission` VALUES (633, 10, 24);
INSERT INTO `upms_role_permission` VALUES (634, 10, 25);
INSERT INTO `upms_role_permission` VALUES (635, 10, 26);
INSERT INTO `upms_role_permission` VALUES (678, 11, 6);
INSERT INTO `upms_role_permission` VALUES (679, 11, 7);
INSERT INTO `upms_role_permission` VALUES (680, 11, 8);
INSERT INTO `upms_role_permission` VALUES (681, 11, 9);
INSERT INTO `upms_role_permission` VALUES (682, 11, 10);
INSERT INTO `upms_role_permission` VALUES (683, 11, 11);
INSERT INTO `upms_role_permission` VALUES (684, 11, 12);
INSERT INTO `upms_role_permission` VALUES (685, 11, 20);
INSERT INTO `upms_role_permission` VALUES (686, 11, 21);
INSERT INTO `upms_role_permission` VALUES (687, 11, 22);
INSERT INTO `upms_role_permission` VALUES (688, 11, 23);
INSERT INTO `upms_role_permission` VALUES (689, 11, 24);
INSERT INTO `upms_role_permission` VALUES (690, 11, 25);
INSERT INTO `upms_role_permission` VALUES (691, 11, 26);
INSERT INTO `upms_role_permission` VALUES (692, 11, 34);
INSERT INTO `upms_role_permission` VALUES (693, 11, 35);
INSERT INTO `upms_role_permission` VALUES (694, 11, 36);
INSERT INTO `upms_role_permission` VALUES (695, 11, 37);
INSERT INTO `upms_role_permission` VALUES (696, 11, 38);
INSERT INTO `upms_role_permission` VALUES (697, 11, 39);
INSERT INTO `upms_role_permission` VALUES (698, 11, 40);
INSERT INTO `upms_role_permission` VALUES (699, 12, 6);
INSERT INTO `upms_role_permission` VALUES (700, 12, 7);
INSERT INTO `upms_role_permission` VALUES (701, 12, 8);
INSERT INTO `upms_role_permission` VALUES (702, 12, 9);
INSERT INTO `upms_role_permission` VALUES (703, 12, 10);
INSERT INTO `upms_role_permission` VALUES (704, 12, 11);
INSERT INTO `upms_role_permission` VALUES (705, 12, 12);
INSERT INTO `upms_role_permission` VALUES (706, 12, 20);
INSERT INTO `upms_role_permission` VALUES (707, 12, 21);
INSERT INTO `upms_role_permission` VALUES (708, 12, 22);
INSERT INTO `upms_role_permission` VALUES (709, 12, 23);
INSERT INTO `upms_role_permission` VALUES (710, 12, 24);
INSERT INTO `upms_role_permission` VALUES (711, 12, 25);
INSERT INTO `upms_role_permission` VALUES (712, 12, 26);
INSERT INTO `upms_role_permission` VALUES (713, 13, 6);
INSERT INTO `upms_role_permission` VALUES (714, 13, 7);
INSERT INTO `upms_role_permission` VALUES (715, 13, 8);
INSERT INTO `upms_role_permission` VALUES (716, 13, 9);
INSERT INTO `upms_role_permission` VALUES (717, 13, 10);
INSERT INTO `upms_role_permission` VALUES (718, 13, 11);
INSERT INTO `upms_role_permission` VALUES (719, 13, 12);
INSERT INTO `upms_role_permission` VALUES (720, 13, 20);
INSERT INTO `upms_role_permission` VALUES (721, 13, 21);
INSERT INTO `upms_role_permission` VALUES (722, 13, 22);
INSERT INTO `upms_role_permission` VALUES (723, 13, 23);
INSERT INTO `upms_role_permission` VALUES (724, 13, 24);
INSERT INTO `upms_role_permission` VALUES (725, 13, 25);
INSERT INTO `upms_role_permission` VALUES (726, 13, 26);
INSERT INTO `upms_role_permission` VALUES (727, 13, 34);
INSERT INTO `upms_role_permission` VALUES (728, 13, 35);
INSERT INTO `upms_role_permission` VALUES (729, 13, 36);
INSERT INTO `upms_role_permission` VALUES (730, 13, 37);
INSERT INTO `upms_role_permission` VALUES (731, 13, 38);
INSERT INTO `upms_role_permission` VALUES (732, 13, 39);
INSERT INTO `upms_role_permission` VALUES (733, 13, 40);
INSERT INTO `upms_role_permission` VALUES (734, 14, 6);
INSERT INTO `upms_role_permission` VALUES (735, 14, 7);
INSERT INTO `upms_role_permission` VALUES (736, 14, 8);
INSERT INTO `upms_role_permission` VALUES (737, 14, 9);
INSERT INTO `upms_role_permission` VALUES (738, 14, 10);
INSERT INTO `upms_role_permission` VALUES (739, 14, 11);
INSERT INTO `upms_role_permission` VALUES (740, 14, 12);
INSERT INTO `upms_role_permission` VALUES (741, 14, 20);
INSERT INTO `upms_role_permission` VALUES (742, 14, 21);
INSERT INTO `upms_role_permission` VALUES (743, 14, 22);
INSERT INTO `upms_role_permission` VALUES (744, 14, 23);
INSERT INTO `upms_role_permission` VALUES (745, 14, 24);
INSERT INTO `upms_role_permission` VALUES (746, 14, 25);
INSERT INTO `upms_role_permission` VALUES (747, 14, 26);
INSERT INTO `upms_role_permission` VALUES (748, 15, 6);
INSERT INTO `upms_role_permission` VALUES (749, 15, 7);
INSERT INTO `upms_role_permission` VALUES (750, 15, 8);
INSERT INTO `upms_role_permission` VALUES (751, 15, 9);
INSERT INTO `upms_role_permission` VALUES (752, 15, 10);
INSERT INTO `upms_role_permission` VALUES (753, 15, 11);
INSERT INTO `upms_role_permission` VALUES (754, 15, 12);
INSERT INTO `upms_role_permission` VALUES (755, 15, 20);
INSERT INTO `upms_role_permission` VALUES (756, 15, 21);
INSERT INTO `upms_role_permission` VALUES (757, 15, 22);
INSERT INTO `upms_role_permission` VALUES (758, 15, 23);
INSERT INTO `upms_role_permission` VALUES (759, 15, 24);
INSERT INTO `upms_role_permission` VALUES (760, 15, 25);
INSERT INTO `upms_role_permission` VALUES (761, 15, 26);
INSERT INTO `upms_role_permission` VALUES (762, 15, 34);
INSERT INTO `upms_role_permission` VALUES (763, 15, 35);
INSERT INTO `upms_role_permission` VALUES (764, 15, 36);
INSERT INTO `upms_role_permission` VALUES (765, 15, 37);
INSERT INTO `upms_role_permission` VALUES (766, 15, 38);
INSERT INTO `upms_role_permission` VALUES (767, 15, 39);
INSERT INTO `upms_role_permission` VALUES (768, 15, 40);
INSERT INTO `upms_role_permission` VALUES (769, 16, 6);
INSERT INTO `upms_role_permission` VALUES (770, 16, 7);
INSERT INTO `upms_role_permission` VALUES (771, 16, 8);
INSERT INTO `upms_role_permission` VALUES (772, 16, 9);
INSERT INTO `upms_role_permission` VALUES (773, 16, 10);
INSERT INTO `upms_role_permission` VALUES (774, 16, 11);
INSERT INTO `upms_role_permission` VALUES (775, 16, 12);
INSERT INTO `upms_role_permission` VALUES (776, 16, 20);
INSERT INTO `upms_role_permission` VALUES (777, 16, 21);
INSERT INTO `upms_role_permission` VALUES (778, 16, 22);
INSERT INTO `upms_role_permission` VALUES (779, 16, 23);
INSERT INTO `upms_role_permission` VALUES (780, 16, 24);
INSERT INTO `upms_role_permission` VALUES (781, 16, 25);
INSERT INTO `upms_role_permission` VALUES (782, 16, 26);
INSERT INTO `upms_role_permission` VALUES (783, 17, 6);
INSERT INTO `upms_role_permission` VALUES (784, 17, 7);
INSERT INTO `upms_role_permission` VALUES (785, 17, 8);
INSERT INTO `upms_role_permission` VALUES (786, 17, 9);
INSERT INTO `upms_role_permission` VALUES (787, 17, 10);
INSERT INTO `upms_role_permission` VALUES (788, 17, 11);
INSERT INTO `upms_role_permission` VALUES (789, 17, 12);
INSERT INTO `upms_role_permission` VALUES (790, 17, 20);
INSERT INTO `upms_role_permission` VALUES (791, 17, 21);
INSERT INTO `upms_role_permission` VALUES (792, 17, 22);
INSERT INTO `upms_role_permission` VALUES (793, 17, 23);
INSERT INTO `upms_role_permission` VALUES (794, 17, 24);
INSERT INTO `upms_role_permission` VALUES (795, 17, 25);
INSERT INTO `upms_role_permission` VALUES (796, 17, 26);
INSERT INTO `upms_role_permission` VALUES (797, 17, 34);
INSERT INTO `upms_role_permission` VALUES (798, 17, 35);
INSERT INTO `upms_role_permission` VALUES (799, 17, 36);
INSERT INTO `upms_role_permission` VALUES (800, 17, 37);
INSERT INTO `upms_role_permission` VALUES (801, 17, 38);
INSERT INTO `upms_role_permission` VALUES (802, 17, 39);
INSERT INTO `upms_role_permission` VALUES (803, 17, 40);
INSERT INTO `upms_role_permission` VALUES (804, 22, 6);
INSERT INTO `upms_role_permission` VALUES (805, 22, 7);
INSERT INTO `upms_role_permission` VALUES (806, 22, 8);
INSERT INTO `upms_role_permission` VALUES (807, 22, 9);
INSERT INTO `upms_role_permission` VALUES (808, 22, 10);
INSERT INTO `upms_role_permission` VALUES (809, 22, 11);
INSERT INTO `upms_role_permission` VALUES (810, 22, 12);
INSERT INTO `upms_role_permission` VALUES (811, 22, 20);
INSERT INTO `upms_role_permission` VALUES (812, 22, 21);
INSERT INTO `upms_role_permission` VALUES (813, 22, 22);
INSERT INTO `upms_role_permission` VALUES (814, 22, 23);
INSERT INTO `upms_role_permission` VALUES (815, 22, 24);
INSERT INTO `upms_role_permission` VALUES (816, 22, 25);
INSERT INTO `upms_role_permission` VALUES (817, 22, 26);
INSERT INTO `upms_role_permission` VALUES (818, 23, 6);
INSERT INTO `upms_role_permission` VALUES (819, 23, 7);
INSERT INTO `upms_role_permission` VALUES (820, 23, 8);
INSERT INTO `upms_role_permission` VALUES (821, 23, 9);
INSERT INTO `upms_role_permission` VALUES (822, 23, 10);
INSERT INTO `upms_role_permission` VALUES (823, 23, 11);
INSERT INTO `upms_role_permission` VALUES (824, 23, 12);
INSERT INTO `upms_role_permission` VALUES (825, 23, 20);
INSERT INTO `upms_role_permission` VALUES (826, 23, 21);
INSERT INTO `upms_role_permission` VALUES (827, 23, 22);
INSERT INTO `upms_role_permission` VALUES (828, 23, 23);
INSERT INTO `upms_role_permission` VALUES (829, 23, 24);
INSERT INTO `upms_role_permission` VALUES (830, 23, 25);
INSERT INTO `upms_role_permission` VALUES (831, 23, 26);
INSERT INTO `upms_role_permission` VALUES (832, 23, 34);
INSERT INTO `upms_role_permission` VALUES (833, 23, 35);
INSERT INTO `upms_role_permission` VALUES (834, 23, 36);
INSERT INTO `upms_role_permission` VALUES (835, 23, 37);
INSERT INTO `upms_role_permission` VALUES (836, 23, 38);
INSERT INTO `upms_role_permission` VALUES (837, 23, 39);
INSERT INTO `upms_role_permission` VALUES (838, 23, 40);
INSERT INTO `upms_role_permission` VALUES (839, 24, 6);
INSERT INTO `upms_role_permission` VALUES (840, 24, 7);
INSERT INTO `upms_role_permission` VALUES (841, 24, 8);
INSERT INTO `upms_role_permission` VALUES (842, 24, 9);
INSERT INTO `upms_role_permission` VALUES (843, 24, 10);
INSERT INTO `upms_role_permission` VALUES (844, 24, 11);
INSERT INTO `upms_role_permission` VALUES (845, 24, 12);
INSERT INTO `upms_role_permission` VALUES (846, 24, 20);
INSERT INTO `upms_role_permission` VALUES (847, 24, 21);
INSERT INTO `upms_role_permission` VALUES (848, 24, 22);
INSERT INTO `upms_role_permission` VALUES (849, 24, 23);
INSERT INTO `upms_role_permission` VALUES (850, 24, 24);
INSERT INTO `upms_role_permission` VALUES (851, 24, 25);
INSERT INTO `upms_role_permission` VALUES (852, 24, 26);
INSERT INTO `upms_role_permission` VALUES (853, 25, 6);
INSERT INTO `upms_role_permission` VALUES (854, 25, 7);
INSERT INTO `upms_role_permission` VALUES (855, 25, 8);
INSERT INTO `upms_role_permission` VALUES (856, 25, 9);
INSERT INTO `upms_role_permission` VALUES (857, 25, 10);
INSERT INTO `upms_role_permission` VALUES (858, 25, 11);
INSERT INTO `upms_role_permission` VALUES (859, 25, 12);
INSERT INTO `upms_role_permission` VALUES (860, 25, 20);
INSERT INTO `upms_role_permission` VALUES (861, 25, 21);
INSERT INTO `upms_role_permission` VALUES (862, 25, 22);
INSERT INTO `upms_role_permission` VALUES (863, 25, 23);
INSERT INTO `upms_role_permission` VALUES (864, 25, 24);
INSERT INTO `upms_role_permission` VALUES (865, 25, 25);
INSERT INTO `upms_role_permission` VALUES (866, 25, 26);
INSERT INTO `upms_role_permission` VALUES (867, 25, 34);
INSERT INTO `upms_role_permission` VALUES (868, 25, 35);
INSERT INTO `upms_role_permission` VALUES (869, 25, 36);
INSERT INTO `upms_role_permission` VALUES (870, 25, 37);
INSERT INTO `upms_role_permission` VALUES (871, 25, 38);
INSERT INTO `upms_role_permission` VALUES (872, 25, 39);
INSERT INTO `upms_role_permission` VALUES (873, 25, 40);
INSERT INTO `upms_role_permission` VALUES (874, 30, 6);
INSERT INTO `upms_role_permission` VALUES (875, 30, 7);
INSERT INTO `upms_role_permission` VALUES (876, 30, 8);
INSERT INTO `upms_role_permission` VALUES (877, 30, 9);
INSERT INTO `upms_role_permission` VALUES (878, 30, 10);
INSERT INTO `upms_role_permission` VALUES (879, 30, 11);
INSERT INTO `upms_role_permission` VALUES (880, 30, 12);
INSERT INTO `upms_role_permission` VALUES (881, 30, 20);
INSERT INTO `upms_role_permission` VALUES (882, 30, 21);
INSERT INTO `upms_role_permission` VALUES (883, 30, 22);
INSERT INTO `upms_role_permission` VALUES (884, 30, 23);
INSERT INTO `upms_role_permission` VALUES (885, 30, 24);
INSERT INTO `upms_role_permission` VALUES (886, 30, 25);
INSERT INTO `upms_role_permission` VALUES (887, 30, 26);
INSERT INTO `upms_role_permission` VALUES (888, 31, 6);
INSERT INTO `upms_role_permission` VALUES (889, 31, 7);
INSERT INTO `upms_role_permission` VALUES (890, 31, 8);
INSERT INTO `upms_role_permission` VALUES (891, 31, 9);
INSERT INTO `upms_role_permission` VALUES (892, 31, 10);
INSERT INTO `upms_role_permission` VALUES (893, 31, 11);
INSERT INTO `upms_role_permission` VALUES (894, 31, 12);
INSERT INTO `upms_role_permission` VALUES (895, 31, 20);
INSERT INTO `upms_role_permission` VALUES (896, 31, 21);
INSERT INTO `upms_role_permission` VALUES (897, 31, 22);
INSERT INTO `upms_role_permission` VALUES (898, 31, 23);
INSERT INTO `upms_role_permission` VALUES (899, 31, 24);
INSERT INTO `upms_role_permission` VALUES (900, 31, 25);
INSERT INTO `upms_role_permission` VALUES (901, 31, 26);
INSERT INTO `upms_role_permission` VALUES (902, 31, 34);
INSERT INTO `upms_role_permission` VALUES (903, 31, 35);
INSERT INTO `upms_role_permission` VALUES (904, 31, 36);
INSERT INTO `upms_role_permission` VALUES (905, 31, 37);
INSERT INTO `upms_role_permission` VALUES (906, 31, 38);
INSERT INTO `upms_role_permission` VALUES (907, 31, 39);
INSERT INTO `upms_role_permission` VALUES (908, 31, 40);
INSERT INTO `upms_role_permission` VALUES (909, 32, 6);
INSERT INTO `upms_role_permission` VALUES (910, 32, 7);
INSERT INTO `upms_role_permission` VALUES (911, 32, 8);
INSERT INTO `upms_role_permission` VALUES (912, 32, 9);
INSERT INTO `upms_role_permission` VALUES (913, 32, 10);
INSERT INTO `upms_role_permission` VALUES (914, 32, 11);
INSERT INTO `upms_role_permission` VALUES (915, 32, 12);
INSERT INTO `upms_role_permission` VALUES (916, 32, 20);
INSERT INTO `upms_role_permission` VALUES (917, 32, 21);
INSERT INTO `upms_role_permission` VALUES (918, 32, 22);
INSERT INTO `upms_role_permission` VALUES (919, 32, 23);
INSERT INTO `upms_role_permission` VALUES (920, 32, 24);
INSERT INTO `upms_role_permission` VALUES (921, 32, 25);
INSERT INTO `upms_role_permission` VALUES (922, 32, 26);
INSERT INTO `upms_role_permission` VALUES (923, 33, 6);
INSERT INTO `upms_role_permission` VALUES (924, 33, 7);
INSERT INTO `upms_role_permission` VALUES (925, 33, 8);
INSERT INTO `upms_role_permission` VALUES (926, 33, 9);
INSERT INTO `upms_role_permission` VALUES (927, 33, 10);
INSERT INTO `upms_role_permission` VALUES (928, 33, 11);
INSERT INTO `upms_role_permission` VALUES (929, 33, 12);
INSERT INTO `upms_role_permission` VALUES (930, 33, 20);
INSERT INTO `upms_role_permission` VALUES (931, 33, 21);
INSERT INTO `upms_role_permission` VALUES (932, 33, 22);
INSERT INTO `upms_role_permission` VALUES (933, 33, 23);
INSERT INTO `upms_role_permission` VALUES (934, 33, 24);
INSERT INTO `upms_role_permission` VALUES (935, 33, 25);
INSERT INTO `upms_role_permission` VALUES (936, 33, 26);
INSERT INTO `upms_role_permission` VALUES (937, 33, 34);
INSERT INTO `upms_role_permission` VALUES (938, 33, 35);
INSERT INTO `upms_role_permission` VALUES (939, 33, 36);
INSERT INTO `upms_role_permission` VALUES (940, 33, 37);
INSERT INTO `upms_role_permission` VALUES (941, 33, 38);
INSERT INTO `upms_role_permission` VALUES (942, 33, 39);
INSERT INTO `upms_role_permission` VALUES (943, 33, 40);
INSERT INTO `upms_role_permission` VALUES (944, 34, 6);
INSERT INTO `upms_role_permission` VALUES (945, 34, 7);
INSERT INTO `upms_role_permission` VALUES (946, 34, 8);
INSERT INTO `upms_role_permission` VALUES (947, 34, 9);
INSERT INTO `upms_role_permission` VALUES (948, 34, 10);
INSERT INTO `upms_role_permission` VALUES (949, 34, 11);
INSERT INTO `upms_role_permission` VALUES (950, 34, 12);
INSERT INTO `upms_role_permission` VALUES (951, 34, 20);
INSERT INTO `upms_role_permission` VALUES (952, 34, 21);
INSERT INTO `upms_role_permission` VALUES (953, 34, 22);
INSERT INTO `upms_role_permission` VALUES (954, 34, 23);
INSERT INTO `upms_role_permission` VALUES (955, 34, 24);
INSERT INTO `upms_role_permission` VALUES (956, 34, 25);
INSERT INTO `upms_role_permission` VALUES (957, 34, 26);
INSERT INTO `upms_role_permission` VALUES (958, 35, 6);
INSERT INTO `upms_role_permission` VALUES (959, 35, 7);
INSERT INTO `upms_role_permission` VALUES (960, 35, 8);
INSERT INTO `upms_role_permission` VALUES (961, 35, 9);
INSERT INTO `upms_role_permission` VALUES (962, 35, 10);
INSERT INTO `upms_role_permission` VALUES (963, 35, 11);
INSERT INTO `upms_role_permission` VALUES (964, 35, 12);
INSERT INTO `upms_role_permission` VALUES (965, 35, 20);
INSERT INTO `upms_role_permission` VALUES (966, 35, 21);
INSERT INTO `upms_role_permission` VALUES (967, 35, 22);
INSERT INTO `upms_role_permission` VALUES (968, 35, 23);
INSERT INTO `upms_role_permission` VALUES (969, 35, 24);
INSERT INTO `upms_role_permission` VALUES (970, 35, 25);
INSERT INTO `upms_role_permission` VALUES (971, 35, 26);
INSERT INTO `upms_role_permission` VALUES (972, 35, 34);
INSERT INTO `upms_role_permission` VALUES (973, 35, 35);
INSERT INTO `upms_role_permission` VALUES (974, 35, 36);
INSERT INTO `upms_role_permission` VALUES (975, 35, 37);
INSERT INTO `upms_role_permission` VALUES (976, 35, 38);
INSERT INTO `upms_role_permission` VALUES (977, 35, 39);
INSERT INTO `upms_role_permission` VALUES (978, 35, 40);
INSERT INTO `upms_role_permission` VALUES (979, 36, 6);
INSERT INTO `upms_role_permission` VALUES (980, 36, 7);
INSERT INTO `upms_role_permission` VALUES (981, 36, 8);
INSERT INTO `upms_role_permission` VALUES (982, 36, 9);
INSERT INTO `upms_role_permission` VALUES (983, 36, 10);
INSERT INTO `upms_role_permission` VALUES (984, 36, 11);
INSERT INTO `upms_role_permission` VALUES (985, 36, 12);
INSERT INTO `upms_role_permission` VALUES (986, 36, 20);
INSERT INTO `upms_role_permission` VALUES (987, 36, 21);
INSERT INTO `upms_role_permission` VALUES (988, 36, 22);
INSERT INTO `upms_role_permission` VALUES (989, 36, 23);
INSERT INTO `upms_role_permission` VALUES (990, 36, 24);
INSERT INTO `upms_role_permission` VALUES (991, 36, 25);
INSERT INTO `upms_role_permission` VALUES (992, 36, 26);
INSERT INTO `upms_role_permission` VALUES (993, 37, 6);
INSERT INTO `upms_role_permission` VALUES (994, 37, 7);
INSERT INTO `upms_role_permission` VALUES (995, 37, 8);
INSERT INTO `upms_role_permission` VALUES (996, 37, 9);
INSERT INTO `upms_role_permission` VALUES (997, 37, 10);
INSERT INTO `upms_role_permission` VALUES (998, 37, 11);
INSERT INTO `upms_role_permission` VALUES (999, 37, 12);
INSERT INTO `upms_role_permission` VALUES (1000, 37, 20);
INSERT INTO `upms_role_permission` VALUES (1001, 37, 21);
INSERT INTO `upms_role_permission` VALUES (1002, 37, 22);
INSERT INTO `upms_role_permission` VALUES (1003, 37, 23);
INSERT INTO `upms_role_permission` VALUES (1004, 37, 24);
INSERT INTO `upms_role_permission` VALUES (1005, 37, 25);
INSERT INTO `upms_role_permission` VALUES (1006, 37, 26);
INSERT INTO `upms_role_permission` VALUES (1007, 37, 34);
INSERT INTO `upms_role_permission` VALUES (1008, 37, 35);
INSERT INTO `upms_role_permission` VALUES (1009, 37, 36);
INSERT INTO `upms_role_permission` VALUES (1010, 37, 37);
INSERT INTO `upms_role_permission` VALUES (1011, 37, 38);
INSERT INTO `upms_role_permission` VALUES (1012, 37, 39);
INSERT INTO `upms_role_permission` VALUES (1013, 37, 40);
INSERT INTO `upms_role_permission` VALUES (1014, 38, 6);
INSERT INTO `upms_role_permission` VALUES (1015, 38, 7);
INSERT INTO `upms_role_permission` VALUES (1016, 38, 8);
INSERT INTO `upms_role_permission` VALUES (1017, 38, 9);
INSERT INTO `upms_role_permission` VALUES (1018, 38, 10);
INSERT INTO `upms_role_permission` VALUES (1019, 38, 11);
INSERT INTO `upms_role_permission` VALUES (1020, 38, 12);
INSERT INTO `upms_role_permission` VALUES (1021, 38, 20);
INSERT INTO `upms_role_permission` VALUES (1022, 38, 21);
INSERT INTO `upms_role_permission` VALUES (1023, 38, 22);
INSERT INTO `upms_role_permission` VALUES (1024, 38, 23);
INSERT INTO `upms_role_permission` VALUES (1025, 38, 24);
INSERT INTO `upms_role_permission` VALUES (1026, 38, 25);
INSERT INTO `upms_role_permission` VALUES (1027, 38, 26);
INSERT INTO `upms_role_permission` VALUES (1028, 39, 6);
INSERT INTO `upms_role_permission` VALUES (1029, 39, 7);
INSERT INTO `upms_role_permission` VALUES (1030, 39, 8);
INSERT INTO `upms_role_permission` VALUES (1031, 39, 9);
INSERT INTO `upms_role_permission` VALUES (1032, 39, 10);
INSERT INTO `upms_role_permission` VALUES (1033, 39, 11);
INSERT INTO `upms_role_permission` VALUES (1034, 39, 12);
INSERT INTO `upms_role_permission` VALUES (1035, 39, 20);
INSERT INTO `upms_role_permission` VALUES (1036, 39, 21);
INSERT INTO `upms_role_permission` VALUES (1037, 39, 22);
INSERT INTO `upms_role_permission` VALUES (1038, 39, 23);
INSERT INTO `upms_role_permission` VALUES (1039, 39, 24);
INSERT INTO `upms_role_permission` VALUES (1040, 39, 25);
INSERT INTO `upms_role_permission` VALUES (1041, 39, 26);
INSERT INTO `upms_role_permission` VALUES (1042, 39, 34);
INSERT INTO `upms_role_permission` VALUES (1043, 39, 35);
INSERT INTO `upms_role_permission` VALUES (1044, 39, 36);
INSERT INTO `upms_role_permission` VALUES (1045, 39, 37);
INSERT INTO `upms_role_permission` VALUES (1046, 39, 38);
INSERT INTO `upms_role_permission` VALUES (1047, 39, 39);
INSERT INTO `upms_role_permission` VALUES (1048, 39, 40);
INSERT INTO `upms_role_permission` VALUES (1049, 40, 6);
INSERT INTO `upms_role_permission` VALUES (1050, 40, 7);
INSERT INTO `upms_role_permission` VALUES (1051, 40, 8);
INSERT INTO `upms_role_permission` VALUES (1052, 40, 9);
INSERT INTO `upms_role_permission` VALUES (1053, 40, 10);
INSERT INTO `upms_role_permission` VALUES (1054, 40, 11);
INSERT INTO `upms_role_permission` VALUES (1055, 40, 12);
INSERT INTO `upms_role_permission` VALUES (1056, 40, 20);
INSERT INTO `upms_role_permission` VALUES (1057, 40, 21);
INSERT INTO `upms_role_permission` VALUES (1058, 40, 22);
INSERT INTO `upms_role_permission` VALUES (1059, 40, 23);
INSERT INTO `upms_role_permission` VALUES (1060, 40, 24);
INSERT INTO `upms_role_permission` VALUES (1061, 40, 25);
INSERT INTO `upms_role_permission` VALUES (1062, 40, 26);
INSERT INTO `upms_role_permission` VALUES (1063, 42, 6);
INSERT INTO `upms_role_permission` VALUES (1064, 42, 7);
INSERT INTO `upms_role_permission` VALUES (1065, 42, 8);
INSERT INTO `upms_role_permission` VALUES (1066, 42, 9);
INSERT INTO `upms_role_permission` VALUES (1067, 42, 10);
INSERT INTO `upms_role_permission` VALUES (1068, 42, 11);
INSERT INTO `upms_role_permission` VALUES (1069, 42, 12);
INSERT INTO `upms_role_permission` VALUES (1070, 42, 20);
INSERT INTO `upms_role_permission` VALUES (1071, 42, 21);
INSERT INTO `upms_role_permission` VALUES (1072, 42, 22);
INSERT INTO `upms_role_permission` VALUES (1073, 42, 23);
INSERT INTO `upms_role_permission` VALUES (1074, 42, 24);
INSERT INTO `upms_role_permission` VALUES (1075, 42, 25);
INSERT INTO `upms_role_permission` VALUES (1076, 42, 26);
INSERT INTO `upms_role_permission` VALUES (1077, 43, 6);
INSERT INTO `upms_role_permission` VALUES (1078, 43, 7);
INSERT INTO `upms_role_permission` VALUES (1079, 43, 8);
INSERT INTO `upms_role_permission` VALUES (1080, 43, 9);
INSERT INTO `upms_role_permission` VALUES (1081, 43, 10);
INSERT INTO `upms_role_permission` VALUES (1082, 43, 11);
INSERT INTO `upms_role_permission` VALUES (1083, 43, 12);
INSERT INTO `upms_role_permission` VALUES (1084, 43, 20);
INSERT INTO `upms_role_permission` VALUES (1085, 43, 21);
INSERT INTO `upms_role_permission` VALUES (1086, 43, 22);
INSERT INTO `upms_role_permission` VALUES (1087, 43, 23);
INSERT INTO `upms_role_permission` VALUES (1088, 43, 24);
INSERT INTO `upms_role_permission` VALUES (1089, 43, 25);
INSERT INTO `upms_role_permission` VALUES (1090, 43, 26);
INSERT INTO `upms_role_permission` VALUES (1091, 43, 34);
INSERT INTO `upms_role_permission` VALUES (1092, 43, 35);
INSERT INTO `upms_role_permission` VALUES (1093, 43, 36);
INSERT INTO `upms_role_permission` VALUES (1094, 43, 37);
INSERT INTO `upms_role_permission` VALUES (1095, 43, 38);
INSERT INTO `upms_role_permission` VALUES (1096, 43, 39);
INSERT INTO `upms_role_permission` VALUES (1097, 43, 40);
INSERT INTO `upms_role_permission` VALUES (1098, 44, 6);
INSERT INTO `upms_role_permission` VALUES (1099, 44, 7);
INSERT INTO `upms_role_permission` VALUES (1100, 44, 8);
INSERT INTO `upms_role_permission` VALUES (1101, 44, 9);
INSERT INTO `upms_role_permission` VALUES (1102, 44, 10);
INSERT INTO `upms_role_permission` VALUES (1103, 44, 11);
INSERT INTO `upms_role_permission` VALUES (1104, 44, 12);
INSERT INTO `upms_role_permission` VALUES (1105, 44, 20);
INSERT INTO `upms_role_permission` VALUES (1106, 44, 21);
INSERT INTO `upms_role_permission` VALUES (1107, 44, 22);
INSERT INTO `upms_role_permission` VALUES (1108, 44, 23);
INSERT INTO `upms_role_permission` VALUES (1109, 44, 24);
INSERT INTO `upms_role_permission` VALUES (1110, 44, 25);
INSERT INTO `upms_role_permission` VALUES (1111, 44, 26);
INSERT INTO `upms_role_permission` VALUES (1112, 45, 6);
INSERT INTO `upms_role_permission` VALUES (1113, 45, 7);
INSERT INTO `upms_role_permission` VALUES (1114, 45, 8);
INSERT INTO `upms_role_permission` VALUES (1115, 45, 9);
INSERT INTO `upms_role_permission` VALUES (1116, 45, 10);
INSERT INTO `upms_role_permission` VALUES (1117, 45, 11);
INSERT INTO `upms_role_permission` VALUES (1118, 45, 12);
INSERT INTO `upms_role_permission` VALUES (1119, 45, 20);
INSERT INTO `upms_role_permission` VALUES (1120, 45, 21);
INSERT INTO `upms_role_permission` VALUES (1121, 45, 22);
INSERT INTO `upms_role_permission` VALUES (1122, 45, 23);
INSERT INTO `upms_role_permission` VALUES (1123, 45, 24);
INSERT INTO `upms_role_permission` VALUES (1124, 45, 25);
INSERT INTO `upms_role_permission` VALUES (1125, 45, 26);
INSERT INTO `upms_role_permission` VALUES (1126, 45, 34);
INSERT INTO `upms_role_permission` VALUES (1127, 45, 35);
INSERT INTO `upms_role_permission` VALUES (1128, 45, 36);
INSERT INTO `upms_role_permission` VALUES (1129, 45, 37);
INSERT INTO `upms_role_permission` VALUES (1130, 45, 38);
INSERT INTO `upms_role_permission` VALUES (1131, 45, 39);
INSERT INTO `upms_role_permission` VALUES (1132, 45, 40);
INSERT INTO `upms_role_permission` VALUES (1508, 1, 6);
INSERT INTO `upms_role_permission` VALUES (1509, 1, 7);
INSERT INTO `upms_role_permission` VALUES (1510, 1, 8);
INSERT INTO `upms_role_permission` VALUES (1511, 1, 9);
INSERT INTO `upms_role_permission` VALUES (1512, 1, 10);
INSERT INTO `upms_role_permission` VALUES (1513, 1, 11);
INSERT INTO `upms_role_permission` VALUES (1514, 1, 12);
INSERT INTO `upms_role_permission` VALUES (1515, 1, 13);
INSERT INTO `upms_role_permission` VALUES (1516, 1, 14);
INSERT INTO `upms_role_permission` VALUES (1517, 1, 15);
INSERT INTO `upms_role_permission` VALUES (1518, 1, 16);
INSERT INTO `upms_role_permission` VALUES (1519, 1, 17);
INSERT INTO `upms_role_permission` VALUES (1520, 1, 18);
INSERT INTO `upms_role_permission` VALUES (1521, 1, 19);
INSERT INTO `upms_role_permission` VALUES (1522, 1, 27);
INSERT INTO `upms_role_permission` VALUES (1523, 1, 28);
INSERT INTO `upms_role_permission` VALUES (1524, 1, 29);
INSERT INTO `upms_role_permission` VALUES (1525, 1, 30);
INSERT INTO `upms_role_permission` VALUES (1526, 1, 31);
INSERT INTO `upms_role_permission` VALUES (1527, 1, 32);
INSERT INTO `upms_role_permission` VALUES (1528, 1, 33);
INSERT INTO `upms_role_permission` VALUES (1529, 1, 1);
INSERT INTO `upms_role_permission` VALUES (1530, 1, 2);
INSERT INTO `upms_role_permission` VALUES (1531, 1, 3);
INSERT INTO `upms_role_permission` VALUES (1532, 1, 4);
INSERT INTO `upms_role_permission` VALUES (1533, 1, 5);

-- ----------------------------
-- Table structure for upms_user
-- ----------------------------
DROP TABLE IF EXISTS `upms_user`;
CREATE TABLE `upms_user`  (
  `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '帐号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码MD5(密码+盐)',
  `salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `realname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(4) NULL DEFAULT NULL COMMENT '性别',
  `dept_id` int(10) NULL DEFAULT NULL,
  `locked` tinyint(4) NULL DEFAULT NULL COMMENT '状态(0:正常,1:锁定,2:失效)',
  `ctime` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `tenant_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '00000' COMMENT '租户ID',
  `target_id` int(10) NULL DEFAULT NULL,
  `target_type` tinyint(2) NULL DEFAULT 0,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 117 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_user
-- ----------------------------
INSERT INTO `upms_user` VALUES (62, 'liuwendong', 'EA48576F30BE1669971699C09AD05C94', '123456', '刘文东', NULL, NULL, NULL, NULL, 1, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (63, 'zhongpv', 'EA48576F30BE1669971699C09AD05C94', '123456', '中药 pv', NULL, '13233332222', 'aaa@bb.com', 0, 2, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (64, 'zhongzs', 'EA48576F30BE1669971699C09AD05C94', '123456', '中药 主审', NULL, NULL, NULL, 1, 2, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (65, 'zhongcs', 'EA48576F30BE1669971699C09AD05C94', '123456', '中药 参审', NULL, '13233332222', NULL, NULL, 2, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (66, 'zhongbz', 'EA48576F30BE1669971699C09AD05C94', '123456', '中药 部长', NULL, '13111112222', NULL, NULL, 2, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (67, 'shengpv', 'EA48576F30BE1669971699C09AD05C94', '123456', '生物 pv', NULL, NULL, NULL, NULL, 5, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (68, 'shengzs', 'EA48576F30BE1669971699C09AD05C94', '123456', '生物 主审', NULL, '13211113333', 'aaa@bb.com', 0, 5, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (69, 'shengcs', 'EA48576F30BE1669971699C09AD05C94', '123456', '生物 参审', NULL, NULL, NULL, NULL, 5, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (70, 'shengbz', 'EA48576F30BE1669971699C09AD05C94', '123456', '生物 部长', NULL, '13211113333', NULL, NULL, 5, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (72, 'zhonglinpv', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '中药临床 pv', NULL, '13211113333', '', 0, 7, 0, 1590583279767, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (74, 'zhonglinzs', '30C65E068BD186796F72E59190B0A305', '6f6d762d9b0844749b5bd20b07e49878', '中药临床 主审', NULL, '13211113333', '', 1, 7, 0, 1590584239273, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (75, 'zhonglincs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '中药临床 参审', NULL, '13211113333', '', 0, 7, 0, 1590583279767, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (76, 'zhonglinbz', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '中药临床 部长', NULL, '13211113333', '', 0, 7, 0, 1590583279767, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (77, 'shenglinpv', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '生物临床 pv', NULL, '13211113333', '', 0, 10, 0, 1590583279767, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (78, 'shenglinzs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '生物临床 主审', NULL, '13211113333', '', 0, 10, 0, 1590583279767, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (79, 'shenglincs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '生物临床 参审', NULL, '13211113333', '', 0, 10, 0, 1590583279767, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (80, 'shenglinbz', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '生物临床 部长', NULL, '13211113333', '', 0, 10, 0, 1590583279767, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (81, 'risk17', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', 'risk17', NULL, '13211113333', '', 0, 1, 0, 1590583279767, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (82, 'risk18', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', 'risk18', NULL, '13211113333', '', 0, 1, 0, 1590583279767, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (83, '江苏恒瑞医药股份有限公司', 'BDECB0819F35F326C5F413A1E5298AD7', '563e17b1c48c411f9223cdab8035ee79', '江苏恒瑞医药股份有限公司', NULL, '13795205731', 'jihong.wu@innoventbio.com', 1, 1, 0, 1591945134359, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (84, 'risk19', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', 'risk19', NULL, NULL, NULL, 0, 1, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (85, 'hua1pv', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药药学1 pv', NULL, NULL, NULL, 0, 3, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (86, 'hua1zs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药药学1 主审', NULL, NULL, NULL, 0, 3, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (87, 'hua1cs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药药学1 参审', NULL, NULL, NULL, 0, 3, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (88, 'hua1bz', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药药学1 部长', NULL, NULL, NULL, 0, 3, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (89, 'hua2pv', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药药学2 pv', NULL, NULL, NULL, 0, 4, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (90, 'hua2zs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药药学2 主审', NULL, NULL, NULL, 0, 4, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (91, 'hua2cs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药药学2 参审', NULL, NULL, NULL, 0, 4, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (92, 'hua2bz', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药药学2 部长', NULL, NULL, NULL, 0, 4, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (93, 'yaopv', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '药理毒理学 pv', NULL, NULL, NULL, 0, 6, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (94, 'yaozs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '药理毒理学 主审', NULL, NULL, NULL, 0, 6, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (95, 'yaocs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '药理毒理学 参审', NULL, NULL, NULL, 0, 6, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (96, 'yaobz', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '药理毒理学 部长', NULL, NULL, NULL, 0, 6, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (97, 'hualin1pv', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药临床1 pv', NULL, NULL, NULL, 0, 8, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (98, 'hualin1zs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药临床1 主审', NULL, NULL, NULL, 0, 8, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (99, 'hualin1cs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药临床1 参审', NULL, NULL, NULL, 0, 8, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (100, 'hualin1bz', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药临床1 部长', NULL, NULL, NULL, 0, 8, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (101, 'hualin2pv', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药临床2 pv', NULL, NULL, NULL, 0, 9, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (102, 'hualin2zs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药临床2 主审', NULL, NULL, NULL, 0, 9, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (103, 'hualin2cs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药临床2 参审', NULL, NULL, NULL, 0, 9, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (104, 'hualin2bz', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '化药临床2 部长', NULL, NULL, NULL, 0, 9, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (105, 'tongpv', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '统计与临床药理学 pv', NULL, NULL, NULL, 0, 11, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (106, 'tongzs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '统计与临床药理学部 主审', NULL, NULL, NULL, 0, 11, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (107, 'tongcs', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '统计与临床药理学部 参审', NULL, NULL, NULL, 0, 11, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (108, 'tongbz', '840C225C7C6932ADBB451D7D199ACDFE', '5cabc8bc4a7a46f3923e00972b900de9', '统计与临床药理学部 部长', NULL, NULL, NULL, 0, 11, 0, NULL, '00000', NULL, 0);
INSERT INTO `upms_user` VALUES (109, 'ypl01', 'CC71EB408477952C3D4E777959BA0E08', 'fbffb4dd5eed4de28208fcd32396ecb8', 'ypl01', NULL, '15708989110', 'yangpeilin@wondersgroup.com', 1, 1, 0, 1593396339696, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (110, 'ypl02', '9F6D938E9D47BF9D258626A4F89F4C66', '522ce9831ea849fba9ed9d1b5e061886', 'ypl02', NULL, '15708989110', 'yangpeilin@wondersgroup.com', 1, 10, 0, 1594018408307, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (111, 'ypl021', '7A02C4CB2F0EAB5489EDFBACC3CA5838', 'f913963012e84b14b950f532e476e9a6', 'ypl021', NULL, '15708989110', 'yangpeilin@wondersgroup.com', 1, 8, 0, 1594018437673, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (112, 'ypl022', 'E3F6E83A10AB2E360223BC235E89D22A', '0cc95d82b5bf47b992be813fc194394a', 'ypl022', NULL, '15708989110', 'yangpeilin@wondersgroup.com', 1, 8, 0, 1594018511784, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (113, 'ypl03', '8698984F7A8D913044FB01093832799B', '6bee9f43f5c047ba89fe5382ce6ad267', 'ypl03', NULL, '15708989110', 'yangpeilin@wondersgroup.com', 1, 3, 0, 1594018564520, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (114, 'ypl031', 'F5B24C5A2C51B006E2F43A98E1BA0313', '3a6d3eab82cd4e7da69792a646cdbf62', 'ypl031', NULL, '15708989110', 'yangpeilin@wondersgroup.com', 1, 3, 0, 1594018626556, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (115, 'ypl032', 'B0E0DE9C05C90255D518311D98BC175F', '73d7a40e05264770b84d43434d75e212', 'ypl032', NULL, '15708989110', 'yangpeilin@wondersgroup.com', 1, 3, 0, 1594018720523, NULL, NULL, NULL);
INSERT INTO `upms_user` VALUES (116, 'ypl020', '8D9BC973A62BEB5AEFBC326F5FD50410', 'ec06020b7af04ba4931a6254cb1ce598', 'ypl020', NULL, '15708989110', 'yangpeilin@wondersgroup.com', 1, 8, 0, 1594025934629, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for upms_user_role
-- ----------------------------
DROP TABLE IF EXISTS `upms_user_role`;
CREATE TABLE `upms_user_role`  (
  `user_role_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户编号',
  `role_id` int(10) NULL DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upms_user_role
-- ----------------------------
INSERT INTO `upms_user_role` VALUES (29, 63, 6);
INSERT INTO `upms_user_role` VALUES (30, 64, 7);
INSERT INTO `upms_user_role` VALUES (31, 65, 8);
INSERT INTO `upms_user_role` VALUES (32, 66, 9);
INSERT INTO `upms_user_role` VALUES (34, 68, 19);
INSERT INTO `upms_user_role` VALUES (35, 69, 20);
INSERT INTO `upms_user_role` VALUES (36, 70, 21);
INSERT INTO `upms_user_role` VALUES (37, 72, 26);
INSERT INTO `upms_user_role` VALUES (38, 74, 27);
INSERT INTO `upms_user_role` VALUES (39, 75, 28);
INSERT INTO `upms_user_role` VALUES (40, 76, 29);
INSERT INTO `upms_user_role` VALUES (46, 84, 1);
INSERT INTO `upms_user_role` VALUES (47, 81, 3);
INSERT INTO `upms_user_role` VALUES (48, 82, 5);
INSERT INTO `upms_user_role` VALUES (51, 67, 18);
INSERT INTO `upms_user_role` VALUES (56, 85, 10);
INSERT INTO `upms_user_role` VALUES (57, 77, 38);
INSERT INTO `upms_user_role` VALUES (58, 78, 39);
INSERT INTO `upms_user_role` VALUES (59, 79, 40);
INSERT INTO `upms_user_role` VALUES (60, 80, 41);
INSERT INTO `upms_user_role` VALUES (61, 86, 11);
INSERT INTO `upms_user_role` VALUES (62, 87, 12);
INSERT INTO `upms_user_role` VALUES (63, 88, 13);
INSERT INTO `upms_user_role` VALUES (64, 89, 14);
INSERT INTO `upms_user_role` VALUES (65, 90, 15);
INSERT INTO `upms_user_role` VALUES (66, 91, 16);
INSERT INTO `upms_user_role` VALUES (67, 92, 17);
INSERT INTO `upms_user_role` VALUES (68, 93, 22);
INSERT INTO `upms_user_role` VALUES (69, 94, 23);
INSERT INTO `upms_user_role` VALUES (70, 95, 24);
INSERT INTO `upms_user_role` VALUES (71, 96, 25);
INSERT INTO `upms_user_role` VALUES (72, 97, 30);
INSERT INTO `upms_user_role` VALUES (73, 98, 31);
INSERT INTO `upms_user_role` VALUES (74, 99, 32);
INSERT INTO `upms_user_role` VALUES (75, 100, 33);
INSERT INTO `upms_user_role` VALUES (76, 101, 34);
INSERT INTO `upms_user_role` VALUES (77, 102, 35);
INSERT INTO `upms_user_role` VALUES (78, 103, 36);
INSERT INTO `upms_user_role` VALUES (79, 104, 37);
INSERT INTO `upms_user_role` VALUES (80, 105, 42);
INSERT INTO `upms_user_role` VALUES (81, 106, 43);
INSERT INTO `upms_user_role` VALUES (82, 107, 44);
INSERT INTO `upms_user_role` VALUES (83, 108, 45);
INSERT INTO `upms_user_role` VALUES (91, 62, 1);
INSERT INTO `upms_user_role` VALUES (103, 111, 32);
INSERT INTO `upms_user_role` VALUES (104, 112, 33);
INSERT INTO `upms_user_role` VALUES (105, 113, 11);
INSERT INTO `upms_user_role` VALUES (106, 114, 12);
INSERT INTO `upms_user_role` VALUES (107, 115, 13);
INSERT INTO `upms_user_role` VALUES (109, 109, 1);
INSERT INTO `upms_user_role` VALUES (110, 110, 39);
INSERT INTO `upms_user_role` VALUES (111, 116, 30);

SET FOREIGN_KEY_CHECKS = 1;

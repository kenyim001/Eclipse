DROP database IF EXISTS ttmstest;
CREATE database ttmstest DEFAULT CHARACTER SET utf8;
use ttmstest;
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(500) DEFAULT NULL COMMENT '授权(如：user:create)',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COMMENT='资源管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '信息面板', '请求路径', '1', '1', null, null, null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('2', '消息中心', '请求路径', '1', '2', null, null, null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('3', '产品管理', '请求路径', '1', '3', null, null, null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('4', '销售管理', '请求路径', '1', '4', null, null, null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('5', '资源管理', '请求路径', '1', '5', null, null, null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('6', '财务管理', '请求路径', '1', '6', null, null, null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('7', '供销管理', '请求路径', '1', '7', null, null, null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('8', '系统管理', '请求路径', '1', '8', null, null, null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('9', '信息面板', '请求路径', '1', '9', null, '1', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('10', '通知管理', '请求路径', '1', '10', null, '2', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('11', '项目', '请求路径', '1', '11', null, '3', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('12', '团号', '请求路径', '1', '12', null, '3', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('13', '产品', '请求路径', '1', '13', null, '3', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('14', '政策', '请求路径', '1', '14', null, '3', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('15', '订单', '请求路径', '1', '15', null, '4', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('16', '旅游资源', '请求路径', '1', '16', null, '5', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('17', '导游资源', '请求路径', '1', '17', null, '5', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('18', '附件', '请求路径', '1', '18', null, '5', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('19', '供应商', '请求路径', '1', '19', null, '7', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('20', '成本', '请求路径', '1', '20', null, '6', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('21', '渠道商', '请求路径', '1', '21', null, '7', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('22', '分销商', '请求路径', '1', '22', null, '7', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('23', '用户权限', '请求路径', '1', '23', null, '8', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('24', '系统配置', '请求路径', '1', '24', null, '8', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('25', '日志管理', '请求路径', '1', '25', null, '8', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('26', '发布通知', '请求路径', '1', '26', null, '9', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('27', '通知管理', '请求路径', '1', '27', null, '9', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('28', '项目信息管理', '请求路径', '1', '28', null, '11', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('29', '团号管理', '请求路径', '1', '29', null, '12', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('30', '创建产品', '请求路径', '1', '30', null, '13', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('31', '产品列表', '请求路径', '1', '31', null, '13', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('32', '产品分类', '请求路径', '1', '32', null, '13', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('33', '价格政策', '请求路径', '1', '33', null, '14', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('34', '分销商管理', '请求路径', '1', '34', null, '22', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('35', '订单管理', '请求路径', '1', '35', null, '15', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('36', '世界大洲', '请求路径', '1', '36', null, '16', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('37', '国家地区', '请求路径', '1', '37', null, '16', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('38', '城市', '请求路径', '1', '38', null, '16', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('39', '导游信息管理', '请求路径', '1', '39', null, '17', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('40', '附件管理', '请求路径', '1', '40', null, '18', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('41', '供应商管理', '请求路径', '1', '41', null, '19', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('42', '成本审核', '请求路径', '1', '42', null, '20', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('43', '渠道信息管理', '请求路径', '1', '43', null, '21', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('44', '渠道商管理', '请求路径', '1', '44', null, '21', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('45', '用户管理', '请求路径', '1', '45', null, '23', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('46', '菜单管理', '请求路径', '1', '46', null, '23', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('47', '角色管理', '请求路径', '1', '47', null, '23', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('48', '组织机构参数', '请求路径', '1', '48', null, '23', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('49', '操作日志', '请求路径', '1', '49', null, '25', null, '2017-07-12 15:15:59', '2017-07-12 15:15:59', 'admin', 'admin');
INSERT INTO `sys_menu` VALUES ('72', '查看', '', '2', '1', null, '26', 'user:lislt', '2017-07-13 16:09:09', '2017-07-13 16:09:09', null, null);
INSERT INTO `sys_menu` VALUES ('73', '发布', '', '2', '2', null, '26', 'user:publish', '2017-07-13 16:09:48', '2017-07-13 16:09:48', null, null);
INSERT INTO `sys_menu` VALUES ('74', '查看', '', '2', '1', null, '27', 'user:list', '2017-07-13 16:10:16', '2017-07-13 16:10:16', null, null);
INSERT INTO `sys_menu` VALUES ('75', '新增', '', '2', '2', null, '27', 'user:add', '2017-07-13 16:10:37', '2017-07-13 16:10:37', null, null);
INSERT INTO `sys_menu` VALUES ('76', '修改', '', '2', '3', null, '27', 'user:update', '2017-07-13 16:11:07', '2017-07-13 16:11:07', null, null);
INSERT INTO `sys_menu` VALUES ('77', '删除', '', '2', '4', null, '27', 'user:delete', '2017-07-13 16:11:29', '2017-07-13 16:11:29', null, null);
INSERT INTO `sys_menu` VALUES ('78', '查看', '', '2', '1', null, '10', 'user:add', '2017-07-13 16:11:53', '2017-07-13 16:11:53', null, null);
INSERT INTO `sys_menu` VALUES ('79', '新增', '', '2', '2', null, '10', 'user:add', '2017-07-13 16:12:10', '2017-07-13 16:12:10', null, null);
INSERT INTO `sys_menu` VALUES ('80', '修改', '', '2', '3', null, '10', 'user:update', '2017-07-13 16:12:27', '2017-07-13 16:12:27', null, null);
INSERT INTO `sys_menu` VALUES ('81', '删除', '', '2', '4', null, '10', 'user:delete', '2017-07-13 16:12:44', '2017-07-13 16:12:44', null, null);
INSERT INTO `sys_menu` VALUES ('82', '查看', '', '2', '1', null, '28', 'user:list', '2017-07-13 16:13:09', '2017-07-13 16:13:09', null, null);
INSERT INTO `sys_menu` VALUES ('83', '新增', '', '2', '2', null, '28', 'user：add', '2017-07-13 16:13:27', '2017-07-13 16:13:27', null, null);
INSERT INTO `sys_menu` VALUES ('84', '修改', '', '2', '3', null, '28', 'user:update', '2017-07-13 16:13:46', '2017-07-13 16:13:46', null, null);
INSERT INTO `sys_menu` VALUES ('85', '查看', '', '2', '1', null, '29', 'user:list', '2017-07-13 16:14:59', '2017-07-13 16:14:59', null, null);
INSERT INTO `sys_menu` VALUES ('86', '新增', '', '2', '2', null, '29', 'user:add', '2017-07-13 16:15:16', '2017-07-13 16:15:16', null, null);
INSERT INTO `sys_menu` VALUES ('87', '修改', '', '2', '3', null, '29', 'user:update', '2017-07-13 16:15:35', '2017-07-13 16:15:35', null, null);
INSERT INTO `sys_menu` VALUES ('88', '保存', '', '2', '1', null, '30', 'user:save', '2017-07-13 16:16:27', '2017-07-13 16:23:12', null, null);
INSERT INTO `sys_menu` VALUES ('89', '查询', '', '2', '1', null, '31', 'user:list', '2017-07-13 16:16:45', '2017-07-13 16:24:34', null, null);
INSERT INTO `sys_menu` VALUES ('90', '修改', '', '2', '2', null, '31', 'user:edit', '2017-07-13 16:17:12', '2017-07-13 16:17:12', null, null);
INSERT INTO `sys_menu` VALUES ('91', '查看', '', '2', '1', null, '33', 'user:list', '2017-07-13 16:17:45', '2017-07-13 16:17:45', null, null);
INSERT INTO `sys_menu` VALUES ('92', '新增', '', '2', '2', null, '33', 'user:add', '2017-07-13 16:18:03', '2017-07-13 16:18:03', null, null);
INSERT INTO `sys_menu` VALUES ('93', '修改', '', '2', '3', null, '33', 'user:edit', '2017-07-13 16:18:22', '2017-07-13 16:18:22', null, null);
INSERT INTO `sys_menu` VALUES ('94', '查看', '', '2', '1', null, '35', 'user:view', '2017-07-13 16:18:42', '2017-07-13 16:18:42', null, null);
INSERT INTO `sys_menu` VALUES ('95', '查看', '', '2', '1', null, '36', 'user:view', '2017-07-13 16:19:06', '2017-07-13 16:19:06', null, null);
INSERT INTO `sys_menu` VALUES ('96', '新增', '', '2', '2', null, '36', 'user:add', '2017-07-13 16:19:21', '2017-07-13 16:19:21', null, null);
INSERT INTO `sys_menu` VALUES ('97', '修改', '', '2', '3', null, '36', 'user:edit', '2017-07-13 16:19:40', '2017-07-13 16:19:40', null, null);
INSERT INTO `sys_menu` VALUES ('98', '查看', '', '2', '1', null, '37', 'user:view', '2017-07-13 16:20:01', '2017-07-13 16:20:01', null, null);
INSERT INTO `sys_menu` VALUES ('99', '新增', '', '2', '2', null, '37', 'user:add', '2017-07-13 16:20:20', '2017-07-13 16:20:20', null, null);
INSERT INTO `sys_menu` VALUES ('100', '修改', '', '2', '3', null, '37', 'user:edit', '2017-07-13 16:20:37', '2017-07-13 16:20:37', null, null);
INSERT INTO `sys_menu` VALUES ('101', '查看', '', '2', '1', null, '38', 'user:view', '2017-07-13 16:21:01', '2017-07-13 16:21:01', null, null);
INSERT INTO `sys_menu` VALUES ('102', '新增', '', '2', '2', null, '38', 'user:add', '2017-07-13 16:21:20', '2017-07-13 16:21:20', null, null);
INSERT INTO `sys_menu` VALUES ('103', '修改', '', '2', '3', null, '38', 'user:edit', '2017-07-13 16:21:36', '2017-07-13 16:21:36', null, null);
INSERT INTO `sys_menu` VALUES ('104', '查看', '', '2', '1', null, '39', 'user:view', '2017-07-13 16:21:55', '2017-07-13 16:21:55', null, null);
INSERT INTO `sys_menu` VALUES ('105', '新增', '', '2', '2', null, '39', 'user:add', '2017-07-13 16:22:13', '2017-07-13 16:22:13', null, null);
INSERT INTO `sys_menu` VALUES ('106', '修改', '', '2', '3', null, '39', 'user:edit', '2017-07-13 16:22:38', '2017-07-13 16:22:38', null, null);
INSERT INTO `sys_menu` VALUES ('107', '待售', '', '2', '3', null, '31', 'user:onsale', '2017-07-13 16:25:00', '2017-07-13 16:25:00', null, null);
INSERT INTO `sys_menu` VALUES ('108', '上架', '', '2', '4', null, '31', 'user:online', '2017-07-13 16:25:26', '2017-07-13 16:25:26', null, null);
INSERT INTO `sys_menu` VALUES ('109', '下架', '', '2', '5', null, '31', 'user:offline', '2017-07-13 16:25:47', '2017-07-13 16:25:47', null, null);
INSERT INTO `sys_menu` VALUES ('110', '库存分销', '', '2', '6', null, '31', 'user:productDist', '2017-07-13 16:26:27', '2017-07-13 16:26:27', null, null);
INSERT INTO `sys_menu` VALUES ('111', '价格政策', '', '2', '7', null, '31', 'user:productPricePolice', '2017-07-13 16:26:57', '2017-07-13 16:26:57', null, null);
INSERT INTO `sys_menu` VALUES ('112', '附件', '', '2', '8', null, '31', 'user:attachment', '2017-07-13 16:27:18', '2017-07-13 16:27:18', null, null);
INSERT INTO `sys_menu` VALUES ('113', '导游信息', '', '2', '9', null, '31', 'user:productGuides', '2017-07-13 16:27:44', '2017-07-13 16:27:44', null, null);
INSERT INTO `sys_menu` VALUES ('114', '行程设置', '', '2', '11', null, '31', 'user:productSchedual', '2017-07-13 16:28:11', '2017-07-13 16:28:11', null, null);
INSERT INTO `sys_menu` VALUES ('115', '查看', '', '2', '1', null, '46', 'user:list', '2017-07-13 16:33:41', '2017-07-13 16:33:41', null, null);
INSERT INTO `sys_menu` VALUES ('116', '新增', '', '2', '2', null, '46', 'user:add', '2017-07-13 16:34:02', '2017-07-13 16:34:02', null, null);
INSERT INTO `sys_menu` VALUES ('117', '修改', '', '2', '3', null, '46', 'user:edit', '2017-07-13 16:34:25', '2017-07-13 16:34:25', null, null);
INSERT INTO `sys_menu` VALUES ('118', '删除', '', '2', '4', null, '46', 'user:delete', '2017-07-13 16:34:46', '2017-07-13 16:34:46', null, null);
INSERT INTO `sys_menu` VALUES ('119', '查看', '', '2', '1', null, '45', 'user:list', '2017-07-13 16:35:05', '2017-07-14 14:27:16', null, null);
INSERT INTO `sys_menu` VALUES ('120', '查看', '', '2', '1', null, '47', 'user:list', '2017-07-13 16:35:26', '2017-07-13 16:35:26', null, null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('31', '18', '3');
INSERT INTO `sys_role_menu` VALUES ('32', '18', '11');
INSERT INTO `sys_role_menu` VALUES ('33', '18', '28');
INSERT INTO `sys_role_menu` VALUES ('34', '18', '82');
INSERT INTO `sys_role_menu` VALUES ('35', '18', '83');
INSERT INTO `sys_role_menu` VALUES ('36', '18', '84');
INSERT INTO `sys_role_menu` VALUES ('37', '18', '12');
INSERT INTO `sys_role_menu` VALUES ('38', '18', '29');
INSERT INTO `sys_role_menu` VALUES ('39', '18', '85');
INSERT INTO `sys_role_menu` VALUES ('40', '18', '86');
INSERT INTO `sys_role_menu` VALUES ('41', '18', '87');
INSERT INTO `sys_role_menu` VALUES ('42', '18', '13');
INSERT INTO `sys_role_menu` VALUES ('43', '18', '30');
INSERT INTO `sys_role_menu` VALUES ('44', '18', '88');
INSERT INTO `sys_role_menu` VALUES ('45', '18', '31');
INSERT INTO `sys_role_menu` VALUES ('46', '18', '89');
INSERT INTO `sys_role_menu` VALUES ('47', '18', '90');
INSERT INTO `sys_role_menu` VALUES ('48', '18', '107');
INSERT INTO `sys_role_menu` VALUES ('49', '18', '108');
INSERT INTO `sys_role_menu` VALUES ('50', '18', '109');
INSERT INTO `sys_role_menu` VALUES ('51', '18', '110');
INSERT INTO `sys_role_menu` VALUES ('52', '18', '111');
INSERT INTO `sys_role_menu` VALUES ('53', '18', '112');
INSERT INTO `sys_role_menu` VALUES ('54', '18', '113');
INSERT INTO `sys_role_menu` VALUES ('55', '18', '114');
INSERT INTO `sys_role_menu` VALUES ('56', '18', '32');
INSERT INTO `sys_role_menu` VALUES ('57', '18', '14');
INSERT INTO `sys_role_menu` VALUES ('58', '18', '33');
INSERT INTO `sys_role_menu` VALUES ('59', '18', '91');
INSERT INTO `sys_role_menu` VALUES ('60', '18', '92');
INSERT INTO `sys_role_menu` VALUES ('61', '18', '93');
INSERT INTO `sys_role_menu` VALUES ('62', '18', '8');
INSERT INTO `sys_role_menu` VALUES ('63', '18', '23');
INSERT INTO `sys_role_menu` VALUES ('64', '18', '45');
INSERT INTO `sys_role_menu` VALUES ('65', '18', '119');
INSERT INTO `sys_role_menu` VALUES ('66', '18', '46');
INSERT INTO `sys_role_menu` VALUES ('67', '18', '115');
INSERT INTO `sys_role_menu` VALUES ('68', '18', '116');
INSERT INTO `sys_role_menu` VALUES ('69', '18', '117');
INSERT INTO `sys_role_menu` VALUES ('70', '18', '118');
INSERT INTO `sys_role_menu` VALUES ('71', '18', '47');
INSERT INTO `sys_role_menu` VALUES ('72', '18', '120');
INSERT INTO `sys_role_menu` VALUES ('73', '18', '48');
INSERT INTO `sys_role_menu` VALUES ('74', '18', '24');
INSERT INTO `sys_role_menu` VALUES ('75', '18', '25');
INSERT INTO `sys_role_menu` VALUES ('76', '18', '49');
INSERT INTO `sys_role_menu` VALUES ('209', '31', '2');
INSERT INTO `sys_role_menu` VALUES ('210', '31', '10');
INSERT INTO `sys_role_menu` VALUES ('211', '31', '78');
INSERT INTO `sys_role_menu` VALUES ('212', '31', '79');
INSERT INTO `sys_role_menu` VALUES ('213', '31', '80');
INSERT INTO `sys_role_menu` VALUES ('214', '31', '81');
INSERT INTO `sys_role_menu` VALUES ('215', '17', '3');
INSERT INTO `sys_role_menu` VALUES ('216', '17', '11');
INSERT INTO `sys_role_menu` VALUES ('217', '17', '28');
INSERT INTO `sys_role_menu` VALUES ('218', '17', '82');
INSERT INTO `sys_role_menu` VALUES ('219', '17', '83');
INSERT INTO `sys_role_menu` VALUES ('220', '17', '84');
INSERT INTO `sys_role_menu` VALUES ('221', '17', '12');
INSERT INTO `sys_role_menu` VALUES ('222', '17', '29');
INSERT INTO `sys_role_menu` VALUES ('223', '17', '85');
INSERT INTO `sys_role_menu` VALUES ('224', '17', '86');
INSERT INTO `sys_role_menu` VALUES ('225', '17', '87');
INSERT INTO `sys_role_menu` VALUES ('226', '17', '13');
INSERT INTO `sys_role_menu` VALUES ('227', '17', '30');
INSERT INTO `sys_role_menu` VALUES ('228', '17', '88');
INSERT INTO `sys_role_menu` VALUES ('229', '17', '31');
INSERT INTO `sys_role_menu` VALUES ('230', '17', '89');
INSERT INTO `sys_role_menu` VALUES ('231', '17', '90');
INSERT INTO `sys_role_menu` VALUES ('232', '17', '107');
INSERT INTO `sys_role_menu` VALUES ('233', '17', '108');
INSERT INTO `sys_role_menu` VALUES ('234', '17', '109');
INSERT INTO `sys_role_menu` VALUES ('235', '17', '110');
INSERT INTO `sys_role_menu` VALUES ('236', '17', '111');
INSERT INTO `sys_role_menu` VALUES ('237', '17', '112');
INSERT INTO `sys_role_menu` VALUES ('238', '17', '113');
INSERT INTO `sys_role_menu` VALUES ('239', '17', '114');
INSERT INTO `sys_role_menu` VALUES ('240', '17', '32');
INSERT INTO `sys_role_menu` VALUES ('241', '17', '14');
INSERT INTO `sys_role_menu` VALUES ('242', '17', '33');
INSERT INTO `sys_role_menu` VALUES ('243', '17', '91');
INSERT INTO `sys_role_menu` VALUES ('244', '17', '92');
INSERT INTO `sys_role_menu` VALUES ('245', '17', '93');
INSERT INTO `sys_role_menu` VALUES ('246', '17', '8');
INSERT INTO `sys_role_menu` VALUES ('247', '17', '23');
INSERT INTO `sys_role_menu` VALUES ('248', '17', '45');
INSERT INTO `sys_role_menu` VALUES ('249', '17', '119');
INSERT INTO `sys_role_menu` VALUES ('250', '17', '46');
INSERT INTO `sys_role_menu` VALUES ('251', '17', '115');
INSERT INTO `sys_role_menu` VALUES ('252', '17', '116');
INSERT INTO `sys_role_menu` VALUES ('253', '17', '117');
INSERT INTO `sys_role_menu` VALUES ('254', '17', '118');
INSERT INTO `sys_role_menu` VALUES ('255', '17', '47');
INSERT INTO `sys_role_menu` VALUES ('256', '17', '120');
INSERT INTO `sys_role_menu` VALUES ('257', '17', '48');
INSERT INTO `sys_role_menu` VALUES ('258', '17', '24');
INSERT INTO `sys_role_menu` VALUES ('259', '17', '25');
INSERT INTO `sys_role_menu` VALUES ('260', '17', '49');
INSERT INTO `sys_role_menu` VALUES ('261', '32', '2');
INSERT INTO `sys_role_menu` VALUES ('262', '32', '10');
INSERT INTO `sys_role_menu` VALUES ('263', '32', '78');
INSERT INTO `sys_role_menu` VALUES ('264', '32', '79');
INSERT INTO `sys_role_menu` VALUES ('265', '32', '80');
INSERT INTO `sys_role_menu` VALUES ('266', '32', '81');
INSERT INTO `sys_role_menu` VALUES ('292', '33', '1');
INSERT INTO `sys_role_menu` VALUES ('293', '33', '9');
INSERT INTO `sys_role_menu` VALUES ('294', '33', '26');
INSERT INTO `sys_role_menu` VALUES ('295', '33', '72');
INSERT INTO `sys_role_menu` VALUES ('296', '33', '73');
INSERT INTO `sys_role_menu` VALUES ('297', '33', '27');
INSERT INTO `sys_role_menu` VALUES ('298', '33', '74');
INSERT INTO `sys_role_menu` VALUES ('299', '33', '75');
INSERT INTO `sys_role_menu` VALUES ('300', '33', '76');
INSERT INTO `sys_role_menu` VALUES ('301', '33', '77');
INSERT INTO `sys_role_menu` VALUES ('302', '33', '5');
INSERT INTO `sys_role_menu` VALUES ('303', '33', '16');
INSERT INTO `sys_role_menu` VALUES ('304', '33', '37');
INSERT INTO `sys_role_menu` VALUES ('305', '33', '98');
INSERT INTO `sys_role_menu` VALUES ('306', '33', '99');
INSERT INTO `sys_role_menu` VALUES ('307', '33', '100');
INSERT INTO `sys_role_menu` VALUES ('308', '33', '38');
INSERT INTO `sys_role_menu` VALUES ('309', '33', '101');
INSERT INTO `sys_role_menu` VALUES ('310', '33', '102');
INSERT INTO `sys_role_menu` VALUES ('311', '33', '103');
INSERT INTO `sys_role_menu` VALUES ('312', '33', '17');
INSERT INTO `sys_role_menu` VALUES ('313', '33', '39');
INSERT INTO `sys_role_menu` VALUES ('314', '33', '104');
INSERT INTO `sys_role_menu` VALUES ('315', '33', '105');
INSERT INTO `sys_role_menu` VALUES ('316', '33', '106');
INSERT INTO `sys_role_menu` VALUES ('317', '33', '18');
INSERT INTO `sys_role_menu` VALUES ('318', '33', '40');
INSERT INTO `sys_role_menu` VALUES ('319', '33', '8');
INSERT INTO `sys_role_menu` VALUES ('320', '33', '23');
INSERT INTO `sys_role_menu` VALUES ('321', '33', '45');
INSERT INTO `sys_role_menu` VALUES ('322', '33', '119');
INSERT INTO `sys_role_menu` VALUES ('323', '33', '46');
INSERT INTO `sys_role_menu` VALUES ('324', '33', '115');
INSERT INTO `sys_role_menu` VALUES ('325', '33', '116');
INSERT INTO `sys_role_menu` VALUES ('326', '33', '117');
INSERT INTO `sys_role_menu` VALUES ('327', '33', '118');
INSERT INTO `sys_role_menu` VALUES ('328', '33', '47');
INSERT INTO `sys_role_menu` VALUES ('329', '33', '120');
INSERT INTO `sys_role_menu` VALUES ('330', '33', '48');
INSERT INTO `sys_role_menu` VALUES ('331', '33', '24');
INSERT INTO `sys_role_menu` VALUES ('332', '33', '25');
INSERT INTO `sys_role_menu` VALUES ('333', '33', '49');

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('1', '系统管理员', '系统管理员', '2017-07-13 17:44:11', '2017-07-13 17:44:18', 'admin', 'admin');
INSERT INTO `sys_roles` VALUES ('2', '产品经理', '产品经理', '2017-07-13 17:44:47', '2017-07-13 17:44:50', 'admin', 'admin');
INSERT INTO `sys_roles` VALUES ('3', '产品信息专员', '产品信息专员', null, null, null, null);
INSERT INTO `sys_roles` VALUES ('17', 'aadd', 'ssssxx', '2017-07-14 15:43:57', '2017-07-14 19:06:04', null, null);
INSERT INTO `sys_roles` VALUES ('18', '项目经理', '项目经理', '2017-07-14 15:46:21', '2017-07-14 15:46:21', null, null);
INSERT INTO `sys_roles` VALUES ('30', 'gfsd', 'gfsd', '2017-07-14 19:03:18', '2017-07-14 19:03:18', null, null);
INSERT INTO `sys_roles` VALUES ('31', 'trew', 'rew', '2017-07-14 19:05:52', '2017-07-14 19:05:52', null, null);
INSERT INTO `sys_roles` VALUES ('32', 'trw', 'trewtrew', '2017-07-14 19:06:11', '2017-07-14 19:06:11', null, null);
INSERT INTO `sys_roles` VALUES ('33', 'fdsa', 'fdsa', '2017-07-14 19:07:23', '2017-07-14 19:07:47', null, null);

-- ----------------------------
-- Table structure for tms_projects
-- ----------------------------
DROP TABLE IF EXISTS `tms_projects`;
CREATE TABLE `tms_projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL COMMENT '类型',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `beginDate` datetime DEFAULT NULL COMMENT '电话',
  `endDate` datetime DEFAULT NULL COMMENT '电子邮箱',
  `address` varchar(100) DEFAULT NULL COMMENT '电话',
  `valid` tinyint(1) DEFAULT '1' COMMENT '有效标志',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '新增时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '更新时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '更新用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tms_projects
-- ----------------------------
INSERT INTO `tms_projects` VALUES ('4', 'TPCN-20170701-CHN-PEK-001', '2017年澳大利亚乌鲁鲁马拉松', '2017-07-21 00:00:00', '2017-07-25 00:00:00', null, '1', '专属红土马拉松，乌鲁鲁巨岩10km排酸跑，高碳晚餐，赛后安排乌鲁鲁日落，卡塔丘塔徒步，特色原野星光秀', '2017-07-05 14:19:13', '2017-07-07 14:30:48', null, null);
INSERT INTO `tms_projects` VALUES ('5', 'TP-20170710-USA-NY-001', '2017美国纽约马拉松', '2017-08-01 00:00:00', '2017-08-08 00:00:00', null, '1', '跑步纵览纽约城市魅力，热情的观众和专业的跑步组织', '2017-07-05 14:19:14', '2017-07-06 15:52:44', null, null);
INSERT INTO `tms_projects` VALUES ('6', 'TP-20170710-DEU-BER-001', '2017德国柏林马拉松自由行', '2017-08-11 00:00:00', '2017-08-20 00:00:00', null, '1', '落地参团，往返接送机服务,赛前晚餐+赛后特色餐，全程专业摄影摄像', '2017-07-05 14:19:14', '2017-07-06 15:52:44', null, null);
INSERT INTO `tms_projects` VALUES ('7', 'TP-20170710-FIN-HEL-001', '2017 徒步北欧探梦布道石', '2017-09-10 00:00:00', '2017-09-20 00:00:00', null, '1', '勇攀布道石，全程四星酒店，浮士德，诗丽雅双游轮，畅游三峡湾，安徒生博物馆，伊埃斯科城堡', '2017-07-05 14:19:14', '2017-07-05 14:19:14', null, null);

-- ----------------------------
-- Table structure for tms_teams
-- ----------------------------
DROP TABLE IF EXISTS `tms_teams`;
CREATE TABLE `tms_teams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '团名称',
  `projectId` int(11) DEFAULT NULL COMMENT '项目id',
  `valid` tinyint(1) DEFAULT '1' COMMENT '是否有效',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tms_teams
-- ----------------------------
INSERT INTO `tms_teams` VALUES ('11', '2017美国纽约马拉松3日团', '5', '1', '2017美国纽约马拉松3日团Happy', '2017-07-06 10:34:23', '2017-07-06 10:34:23', null, null);
INSERT INTO `tms_teams` VALUES ('12', '2017美国纽约马拉松5日团', '5', '1', '2017美国纽约马拉松3日团Happy', '2017-07-06 10:34:23', '2017-07-06 10:34:23', null, null);
INSERT INTO `tms_teams` VALUES ('23', '2017美国纽约马拉松6日团', '5', '1', '2017美国纽约马拉松6日团.....', '2017-07-06 14:46:51', '2017-07-07 11:23:36', null, null);
INSERT INTO `tms_teams` VALUES ('24', '2017美国纽约马拉松7日团', '5', '1', '2017美国纽约马拉松7日团', '2017-07-06 14:53:57', '2017-07-07 11:23:36', null, null);
INSERT INTO `tms_teams` VALUES ('25', '2017 德国柏林马拉松3日游', '6', '0', '2017 德国柏林马拉松3日游。。。', '2017-07-06 16:00:37', '2017-07-06 16:43:50', null, null);
INSERT INTO `tms_teams` VALUES ('26', '2017 德国柏林马拉松4日游', '6', '0', '2017 德国柏林马拉松4日游.。。。', '2017-07-06 16:04:12', '2017-07-06 16:43:50', null, null);


DROP TABLE IF EXISTS `tms_product_types`;
CREATE TABLE `tms_product_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COMMENT='资源管理';

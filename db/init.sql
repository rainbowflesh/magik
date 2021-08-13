SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `sex` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '张三', '123', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (2, 'lisi', '李四', '123', '男', '777@qq.com', '北京市');
INSERT INTO `user` VALUES (3, 'lisi1', '李四1', '123', '男', '777@qq.com', '北京市');
INSERT INTO `user` VALUES (5, 'lisi3', '李四', '123', '男', '777@qq.com', '北京市');
INSERT INTO `user` VALUES (6, 'lisi4', '李四', '123', '男', '777@qq.com', '北京市');
INSERT INTO `user` VALUES (7, 'lisi5', '李四', '123', '男', '777@qq.com', '北京市');
INSERT INTO `user` VALUES (8, 'lisi6', '李四', '123', '男', '777@qq.com', '北京市');
INSERT INTO `user` VALUES (9, 'lisi7', '李四', '123', '男', '777@qq.com', '北京市');
INSERT INTO `user` VALUES (10, 'lisi8', '李四', '123', '男', '777@qq.com', '北京市');
INSERT INTO `user` VALUES (11, 'lisi9', '李四', '123', '男', '777@qq.com', '北京市');
INSERT INTO `user` VALUES (17, 'zhangsan1', '张三1', '123', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (18, 'zhangsan2', '张三2', '123', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (19, 'zhangsan3', '张三3', '123', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (20, 'zhangsan4', '张三4', '123', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (21, 'zhangsan5', '张三5', '123', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (22, 'zhangsan6', '张三6', '123', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (23, 'zhangsan7', '张三7', '123', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (24, 'zhangsan8', '张三8', '123', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (25, 'migumi', 'migu头', 'migumigu', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (26, 'adminshudewei', 'shudewei', '123456', '男', '888@qq.com', '呼伦贝尔');
INSERT INTO `user` VALUES (27, 'admin', '管理员', 'khidi_km@water!@#6666', '男', '888@qq.com', '呼伦贝尔');

SET FOREIGN_KEY_CHECKS = 1;
ALTER TABLE user DROP COLUMN sex;
ALTER TABLE user DROP COLUMN email;
ALTER TABLE user DROP COLUMN address;
ALTER TABLE user add COLUMN isExist boolean not null default true;
create TABLE userInfo(
                         id int primary key auto_increment not null,
                         login_name varchar(255) unique key,
                         email varchar(255),
                         address varchar(255)
);
insert into userInfo (login_name, email, address) values ('admin','catkingmagnumdemon@gmail.com','幻想乡');
create table userRole(
  id int primary key auto_increment not null,
  login_name varchar(255) unique key not null,
  role varchar(255) not null
);
insert into userRole(login_name, role) values ('admin','admin');
insert into userRole(login_name, role) values ('migumi','user');
alter table userinfo rename user_info;
alter table userrole rename user_role;
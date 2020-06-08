
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(32) NOT NULL COMMENT '账号',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `state` char(1) DEFAULT NULL COMMENT '账号状态.0:未激活,1:正常状态,2：用户被锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(128) NOT NULL,
  `description` varchar(512) NOT NULL COMMENT '角色描述',
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL,
  `sys_user_id` bigint(20) NOT NULL,
  `sys_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `sys_user`(`id`,`username`,`name`,`password`,`salt`,`state`) values (1,'admin','管理员','123456','8d78869f470951332959580424d4bf4f','0'),(2,'chenzw','chenzw','123456','uiwueylm','0'),(3,'zhangsan','张三','123456','eteokues','0');

insert  into `sys_role`(`id`,`name`,`description`,`available`) values (1,'ROLE_ADMIN','用户管理员',1),(2,'ROLE_USER','普通用户',1);

insert  into `sys_user_role`(`id`,`sys_user_id`,`sys_role_id`) values (1,1,1), (2,1,2), (3,2,2);



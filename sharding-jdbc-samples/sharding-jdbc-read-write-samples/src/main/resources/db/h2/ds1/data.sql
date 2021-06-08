-- DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id bigint(64) not null,
	name varchar(100) not null,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

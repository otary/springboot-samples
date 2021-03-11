DROP TABLE IF EXISTS `java_types_entity`;
CREATE TABLE `java_types_entity`  (
  `id` varchar(64) NULL,
  `byte_type` bit(1) NULL DEFAULT NULL,
  `short_type` tinyint(4) NULL DEFAULT NULL,
  `character_type` char(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `integer_type` int(12) NULL DEFAULT NULL,
  `float_type` float NULL DEFAULT NULL,
  `long_type` int(11) NULL DEFAULT NULL,
  `double_type` double NULL DEFAULT NULL,
  `bytes_type` blob NULL,
  `bigdecimal_type` bigint(20) NULL DEFAULT NULL,
  `boolean_type` bit(1) NULL DEFAULT NULL,
  `enum_type` varchar(500) null default null
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

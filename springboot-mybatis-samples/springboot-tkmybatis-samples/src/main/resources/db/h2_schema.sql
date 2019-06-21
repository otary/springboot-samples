DROP TABLE IF EXISTS `java_types_entity`;
CREATE TABLE `java_types_entity`  (
  `byte_type` CHAR(1) NULL DEFAULT NULL,
  `short_type` tinyint(4) NULL DEFAULT NULL,
  `character_type` char(2)  NULL DEFAULT NULL,
  `integer_type` int(12) NULL DEFAULT NULL,
  `float_type` double NULL DEFAULT NULL,
  `long_type` bigint(12) NULL DEFAULT NULL,
  `double_type` double NULL DEFAULT NULL,
  `bytes_type` binary NULL,
  `bigdecimal_type` bigint(20) NULL DEFAULT NULL,
  `boolean_type` boolean NULL DEFAULT NULL,
  `date_type` date NULL DEFAULT NULL
)



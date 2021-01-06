
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `count`;
CREATE TABLE `count` (
  `user_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户Id',
  `num_count` int(11) NOT NULL DEFAULT '0' COMMENT '用户记录值总和',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='count 表';

INSERT INTO `count` VALUES ('uuid', '2222');

DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录Id',
  `user_id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '用户Id',
  `num` int(11) NOT NULL DEFAULT '0' COMMENT '记录值',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Record 表';

INSERT INTO `record` VALUES ('1', 'string', '0');

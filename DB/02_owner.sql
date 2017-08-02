CREATE TABLE `owner` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `telephone_number` varchar(20) DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  `settlements_id` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

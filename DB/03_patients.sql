CREATE TABLE `patients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `race` varchar(50) DEFAULT NULL,
  `species` varchar(50) NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `owner_id` mediumint(9) NOT NULL,
  `birth_date` date NOT NULL,
  `death_date` date DEFAULT NULL,
  `weight` smallint(6) DEFAULT NULL,
  `microchip_id` mediumint(9) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `alive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `owner_id` (`owner_id`),
  CONSTRAINT `patients_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

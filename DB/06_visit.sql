CREATE TABLE `visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Visit_Date` date NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `visit_description` varchar(1000) DEFAULT NULL,
  `drugs_description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `doctor_id` (`doctor_id`),
  KEY `patient_id` (`patient_id`),
  CONSTRAINT `visit_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `visit_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

CREATE TABLE `user_account` (
  `id_AC` bigint(10) NOT NULL AUTO_INCREMENT,
  `id_BA` bigint(10),
  `email` varchar(200) DEFAULT NULL,
  `login` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_AC`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `billing_account` (
  `id_BA` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `surname` varchar(40) DEFAULT NULL,
  `login` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_BA`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `wallet` (
  `id_WALLET` bigint(10) NOT NULL AUTO_INCREMENT,
  `id_BA` bigint(10) NOT NULL,
  `funds` double(12,2) DEFAULT 0,
  `isDefault` boolean DEFAULT false,
  PRIMARY KEY (`id_WALLET`),
  FOREIGN KEY ('id_BA') REFERENCES billing_account('id_BA')
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `film` (
  `id_FILM` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `date_release` DATE DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  'cost_rent' double(12,2) DEFAULT 0,
  'cost_buy' double(12,2) DEFAULT 0,
  PRIMARY KEY (`id_FILM`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE `film_crew` (
  `id_CREW` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `id_FILM` bigint(10) NOT NULL,
  `crew_role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_CREW`),
  FOREIGN KEY ('id_FILM') REFERENCES film('id_FILM')
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE 'review' (
  'id_REVIEW' bigint(10) NOT NULL AUTO_INCREMENT,
  'id_FILM' bigint(10) NOT NULL,
  'id_AC' bigint(10) NOT NULL,
  'mark' int(2) NOT NULL,
  'date' DATETIME NOT NULL,
  'description' varchar(5000),
  PRIMARY KEY (`id_REVIEW`),
  FOREIGN KEY ('id_FILM') REFERENCES film('id_FILM'),
  FOREIGN KEY ('id_AC') REFERENCES user_account('id_AC')
) ENGINE=InnoDB AUTO_INCREMENT=1;

CREATE TABLE 'subscription' (
  'id_SUB' bigint(10) NOT NULL,
  'id_AC' bigint(10) NOT NULL,
  'id_FILM' bigint(10) NOT NULL,
  'date_sub' DATE NOT NULL,
  'type' varchar(10) NOT NULL,
  'isValid' boolean DEFAULT true,
  'date_exp' DATE DEFAULT NULL,
  PRIMARY KEY (`id_SUB`),
  FOREIGN KEY ('id_FILM') REFERENCES film('id_FILM'),
  FOREIGN KEY ('id_AC') REFERENCES user_account('id_AC')
) ENGINE=InnoDB AUTO_INCREMENT=1;
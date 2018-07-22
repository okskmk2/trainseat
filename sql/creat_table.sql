CREATE TABLE `tb_train_log` (
	`id` INT(7) NOT NULL AUTO_INCREMENT,
	`reg_dt` VARCHAR(19) NOT NULL DEFAULT '0',
	`message` VARCHAR(50) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=127
;

CREATE TABLE `tb_train_management_log` (
	`id` INT(7) NOT NULL AUTO_INCREMENT,
	`reg_dt` VARCHAR(19) NOT NULL,
	`message` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=161
;

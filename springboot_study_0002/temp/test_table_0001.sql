CREATE TABLE `test_table_0001` (
	`seq_no` INT(11) NOT NULL AUTO_INCREMENT,
	`value1` VARCHAR(100) NULL DEFAULT '0' COLLATE 'utf8mb3_general_ci',
	`value2` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`value3` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`reg_dt` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`seq_no`) USING BTREE
)
COLLATE='utf8mb3_general_ci'
ENGINE=InnoDB
;

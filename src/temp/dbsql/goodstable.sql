CREATE TABLE `system_test`.`goods` (
  `id` INT NOT NULL,
  `Goods_Name` VARCHAR(45) NULL,
  `Goods_type` VARCHAR(45) NULL,
  `price`  DOUBLE NULL,
  `miaosha_price` DOUBLE NULL,
  `imgpath` VARCHAR(45) NULL,
  `content` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
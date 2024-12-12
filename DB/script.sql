-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MetalDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `MetalDB` ;

-- -----------------------------------------------------
-- Schema MetalDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MetalDB` DEFAULT CHARACTER SET utf8 ;
USE `MetalDB` ;

-- -----------------------------------------------------
-- Table `MetalBands`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MetalBands` ;

CREATE TABLE IF NOT EXISTS `MetalBands` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name_Of_Band` VARCHAR(45) NOT NULL,
  `Year_Founded` YEAR NOT NULL,
  `Popular_Song` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Metal Bands_UNIQUE` (`Name_Of_Band` ASC),
  UNIQUE INDEX `Popular_Song_UNIQUE` (`Popular_Song` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS student;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'student' IDENTIFIED BY 'student';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'student';
GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'student';
GRANT ALL ON * TO 'student';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `MetalBands`
-- -----------------------------------------------------
START TRANSACTION;
USE `MetalDB`;
INSERT INTO `MetalBands` (`id`, `Name_Of_Band`, `Year_Founded`, `Popular_Song`) VALUES (1, 'Sevendust', 1994, 'black');
INSERT INTO `MetalBands` (`id`, `Name_Of_Band`, `Year_Founded`, `Popular_Song`) VALUES (2, 'Disturbed', 1994, 'down with the sickness');
INSERT INTO `MetalBands` (`id`, `Name_Of_Band`, `Year_Founded`, `Popular_Song`) VALUES (3, 'Trivium', 1998, 'shogun');
INSERT INTO `MetalBands` (`id`, `Name_Of_Band`, `Year_Founded`, `Popular_Song`) VALUES (4, 'Bad Wolves', 2017, 'zombie');

COMMIT;


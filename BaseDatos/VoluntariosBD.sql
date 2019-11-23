-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema voluntariobd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `voluntariobd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `voluntariobd` ;

-- -----------------------------------------------------
-- Table `voluntariobd`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voluntariobd`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `voluntariobd`.`usuarios` (
  `id_usuario` INT(4) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(25) NOT NULL,
  `contrasenya` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(25) NOT NULL,
  `apellido1` VARCHAR(25) NOT NULL,
  `apellido2` VARCHAR(25) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `telefono` INT(9) NOT NULL,
  `correo` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `voluntariobd`.`eventos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voluntariobd`.`eventos` ;

CREATE TABLE IF NOT EXISTS `voluntariobd`.`eventos` (
  `id_evento` INT(4) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(50) NOT NULL,
  `ubicacion` VARCHAR(50) NOT NULL,
  `hora_registro` TIME NOT NULL,
  `fecha_registro` DATE NOT NULL,
  `hora_evento` TIME NOT NULL,
  `fecha_evento` DATE NOT NULL,
  `descripcion` VARCHAR(500) NULL DEFAULT NULL,
  `num_ayudante` INT(4) NOT NULL,
  `inscrito` TINYINT(1) NOT NULL,
  `aceptado` TINYINT(1) NOT NULL,
  `confirmado` TINYINT(1) NOT NULL,
  `id_necesitado` INT(4) NOT NULL,
  PRIMARY KEY (`id_evento`),
  INDEX `FK_evento_necesitado_idx` (`id_necesitado` ASC),
  CONSTRAINT `FK_evento_necesitado`
    FOREIGN KEY (`id_necesitado`)
    REFERENCES `voluntariobd`.`usuarios` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `voluntariobd`.`ayudantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voluntariobd`.`ayudantes` ;

CREATE TABLE IF NOT EXISTS `voluntariobd`.`ayudantes` (
  `id_usuario` INT(4) NOT NULL,
  `id_evento` INT(4) NOT NULL,
  PRIMARY KEY (`id_usuario`, `id_evento`),
  INDEX `FK_ayudante_usuario_idx` (`id_usuario` ASC),
  INDEX `FK_ayudante_evento_idx` (`id_evento` ASC),
  CONSTRAINT `FK_ayudante_evento`
    FOREIGN KEY (`id_evento`)
    REFERENCES `voluntariobd`.`eventos` (`id_evento`),
  CONSTRAINT `FK_ayudante_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `voluntariobd`.`usuarios` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

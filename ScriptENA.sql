create database requerimiento;
USE `requerimiento` ;
CREATE TABLE IF NOT EXISTS `requerimiento`.`gerencias` (
  `ID` INT NOT NULL,
  `Nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID`));
  
CREATE TABLE IF NOT EXISTS `requerimiento`.`departamentos` (
  `ID` INT NOT NULL,
  `Nombre` VARCHAR(30) NOT NULL,
  `Gerencia` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_gerencia` (`Gerencia` ASC) VISIBLE,
  CONSTRAINT `fk_gerencia`
    FOREIGN KEY (`Gerencia`)
    REFERENCES `requerimiento`.`gerencias` (`ID`));

CREATE TABLE IF NOT EXISTS `requerimiento`.`empleados` (
  `ID` INT NOT NULL,
  `Nombre` VARCHAR(30) NOT NULL,
  `Departamento` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_departamento` (`Departamento` ASC) VISIBLE,
  CONSTRAINT `fk_departamento`
    FOREIGN KEY (`Departamento`)
    REFERENCES `requerimiento`.`departamentos` (`ID`));

CREATE TABLE IF NOT EXISTS `requerimiento`.`requerimientos` (
  `ID` INT NOT NULL,
  `Gerencia` INT NOT NULL,
  `Departamento` INT NOT NULL,
  `Asignado` INT NOT NULL,
  `Detalle` TEXT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_gerencia_requerimiento` (`Gerencia` ASC) VISIBLE,
  INDEX `fk_departamento_requerimiento` (`Departamento` ASC) VISIBLE,
  INDEX `fk_asignado_requerimiento` (`Asignado` ASC) VISIBLE,
  CONSTRAINT `fk_asignado_requerimiento`
    FOREIGN KEY (`Asignado`)
    REFERENCES `requerimiento`.`empleados` (`ID`),
  CONSTRAINT `fk_departamento_requerimiento`
    FOREIGN KEY (`Departamento`)
    REFERENCES `requerimiento`.`departamentos` (`ID`),
  CONSTRAINT `fk_gerencia_requerimiento`
    FOREIGN KEY (`Gerencia`)
    REFERENCES `requerimiento`.`gerencias` (`ID`));

CREATE TABLE IF NOT EXISTS `requerimiento`.`usuarios` (
  `ID` INT NOT NULL,
  `Nombre` VARCHAR(30) NOT NULL,
  `Area` VARCHAR(30) NOT NULL,
  `Usuario` VARCHAR(30) NOT NULL,
  `Pass` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID`))


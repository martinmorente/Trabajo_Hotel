CREATE SCHEMA IF NOT EXISTS `Hotel` DEFAULT CHARACTER SET utf8 ;
USE `Hotel` ;

-- -----------------------------------------------------
-- Table `mydb`.`Habitaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`Habitaciones` (
  `idHabitacion` INT NOT NULL AUTO_INCREMENT,
  `TipoHab` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NOT NULL,
  `Disponibilidad` TINYINT NOT NULL,
  PRIMARY KEY (`idHabitacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Servicios_Extras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`Servicios_Extras` (
  `idServicios_Extra` INT NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(45) NULL,
  `Precio` DOUBLE NULL,
  PRIMARY KEY (`idServicios_Extra`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`Personal` (
  `idPersonal` INT NOT NULL AUTO_INCREMENT,
  `Cocina` VARCHAR(45) NOT NULL,
  `Limpieza` VARCHAR(45) NOT NULL,
  `Reparación` VARCHAR(45) NOT NULL,
  `Servicios_Extras_idServicios_Extra` INT NOT NULL,
  PRIMARY KEY (`idPersonal`, `Servicios_Extras_idServicios_Extra`),
  INDEX `fk_Personal_Servicios_Extras1_idx` (`Servicios_Extras_idServicios_Extra` ASC) VISIBLE,
  CONSTRAINT `fk_Personal_Servicios_Extras1`
    FOREIGN KEY (`Servicios_Extras_idServicios_Extra`)
    REFERENCES `Hotel`.`Servicios_Extras` (`idServicios_Extra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ingresos_Caja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`Ingresos_Caja` (
  `idIngresos_Caja` INT NOT NULL AUTO_INCREMENT,
  `Impuestos_IVA` DOUBLE NULL,
  `Pagos_Personal` INT NULL,
  `Ingresos_Totales` DOUBLE NULL,
  `Personal_idPersonal` INT NOT NULL,
  PRIMARY KEY (`idIngresos_Caja`, `Personal_idPersonal`),
  INDEX `fk_Ingresos_Caja_Personal1_idx` (`Personal_idPersonal` ASC) VISIBLE,
  CONSTRAINT `fk_Ingresos_Caja_Personal1`
    FOREIGN KEY (`Personal_idPersonal`)
    REFERENCES `Hotel`.`Personal` (`idPersonal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`Reservas` (
  `idReserva` INT NOT NULL AUTO_INCREMENT,
  `Ingresos_Caja_idIngresos_Caja` INT NOT NULL,
  `Habitaciones_idHabitacion` INT NOT NULL,
  PRIMARY KEY (`idReserva`, `Ingresos_Caja_idIngresos_Caja`, `Habitaciones_idHabitacion`),
  INDEX `fk_Reservas_Ingresos_Caja1_idx` (`Ingresos_Caja_idIngresos_Caja` ASC) VISIBLE,
  INDEX `fk_Reservas_Habitaciones1_idx` (`Habitaciones_idHabitacion` ASC) VISIBLE,
  CONSTRAINT `fk_Reservas_Ingresos_Caja1`
    FOREIGN KEY (`Ingresos_Caja_idIngresos_Caja`)
    REFERENCES `Hotel`.`Ingresos_Caja` (`idIngresos_Caja`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservas_Habitaciones1`
    FOREIGN KEY (`Habitaciones_idHabitacion`)
    REFERENCES `Hotel`.`Habitaciones` (`idHabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`Clientes` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `Nombre_Cliente` VARCHAR(45) NOT NULL,
  `DNI_Cliente` VARCHAR(9) NOT NULL,
  `Cantidad_Cliente` INT NOT NULL,
  `Fecha_Entrada` DATETIME NOT NULL,
  `Fecha_Salida` DATETIME NOT NULL,
  `Reservas_idReserva` INT NOT NULL,
  `Reservas_Ingresos_Caja_idIngresos_Caja` INT NOT NULL,
  `Reservas_Habitaciones_idHabitacion` INT NOT NULL,
  PRIMARY KEY (`idCliente`, `Reservas_idReserva`, `Reservas_Ingresos_Caja_idIngresos_Caja`, `Reservas_Habitaciones_idHabitacion`),
  INDEX `fk_Clientes_Reservas1_idx` (`Reservas_idReserva` ASC, `Reservas_Ingresos_Caja_idIngresos_Caja` ASC, `Reservas_Habitaciones_idHabitacion` ASC) VISIBLE,
  CONSTRAINT `fk_Clientes_Reservas1`
    FOREIGN KEY (`Reservas_idReserva` , `Reservas_Ingresos_Caja_idIngresos_Caja` , `Reservas_Habitaciones_idHabitacion`)
    REFERENCES `Hotel`.`Reservas` (`idReserva` , `Ingresos_Caja_idIngresos_Caja` , `Habitaciones_idHabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE USER IF NOT EXISTS "tester"@"localhost" IDENTIFIED BY "Tester31=?*";

GRANT SELECT,INSERT ON Hotel.* TO "tester";

flush privileges;
/*Run this file in mySQL after it has been installed to create the schema and tables needed for this system.*/

CREATE SCHEMA `spring_hibernate` ;

CREATE TABLE `spring_hibernate`.`employee` (
  `emp_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `salary` INT NULL,
  PRIMARY KEY (`emp_id`));

CREATE TABLE `spring_hibernate`.`inventory` (
  `inv_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `quantityStored` INT NULL,
  `quantityOrdered` INT NULL,
  PRIMARY KEY (`inv_id`));
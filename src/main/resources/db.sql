# CREATE DATABASE Journal;

CREATE TABLE  `student` (
  `idstudent` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `group` INT NOT NULL,
  PRIMARY KEY (`idstudent`));

CREATE TABLE `mark`(
`idstudent` INT ,
`idsubject` INT ,
`mark`   INT ,
FOREIGN KEY (idstudent) REFERENCES student(idstudent),
FOREIGN KEY (idsubject) REFERENCES subject(idsubject)
);

CREATE TABLE `subject` (
  `idsubject` INT NOT NULL AUTO_INCREMENT,
  `nameofsubject` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idsubject`));
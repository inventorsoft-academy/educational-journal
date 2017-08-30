# CREATE DATABASE Journal;

CREATE TABLE  STUDENTS (
  `id` SERIAL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `group` INT NOT NULL,
  PRIMARY KEY (`id`));



CREATE TABLE MARKS(
  id SERIAL,
student_id INT ,
subject_id INT ,
mark   INT ,
FOREIGN KEY (student_id) REFERENCES student(idstudent),
FOREIGN KEY (subject_id) REFERENCES subject(idsubject),
  PRIMARY KEY (id)
);



CREATE TABLE SUBJECTS (
  id SERIAL,
  nameofsubject VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
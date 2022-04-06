CREATE TABLE students (
  student_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NULL,
  last_name VARCHAR(45) NULL,
  year_of_study INT NULL,
  gender VARCHAR(45) NULL,
  cnp VARCHAR(13) NULL,
  PRIMARY KEY (student_id),
  UNIQUE INDEX student_id_UNIQUE (student_id ASC) VISIBLE);




  CREATE TABLE courses (
    course_id INT NOT NULL AUTO_INCREMENT,
    course_title VARCHAR(45) NULL,
    credits INT NULL,
    UNIQUE INDEX course_id_UNIQUE (course_id ASC) VISIBLE,
    PRIMARY KEY (course_id));




CREATE TABLE students_courses (
  student_id INT NOT NULL,
  course_id INT NOT NULL,
  PRIMARY KEY (student_id, course_id));

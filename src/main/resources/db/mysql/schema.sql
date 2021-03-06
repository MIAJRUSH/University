CREATE SCHEMA IF NOT EXISTS university DEFAULT CHARACTER SET utf8;
USE university;

CREATE TABLE IF NOT EXISTS lesson_types
(
	id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(20)  NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS teacher_positions
(
	id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(20)  NOT NULL,
	PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS groups_table
(
	id              INT UNSIGNED       NOT NULL AUTO_INCREMENT,
	name            VARCHAR(20) UNIQUE NOT NULL,
	students_number INT UNSIGNED       NOT NULL DEFAULT 0,
	PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS subjects
(
	id           INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name         VARCHAR(45)  NOT NULL,
	hours_number INT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS students
(
	id          INT UNSIGNED     NOT NULL AUTO_INCREMENT,
	name        VARCHAR(100)     NOT NULL,
	course      TINYINT UNSIGNED NOT NULL DEFAULT 1,
	phone_number VARCHAR(10)      NOT NULL,
	email       VARCHAR(45)      NULL,
	group_id    INT UNSIGNED     NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (group_id) REFERENCES groups_table (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS teachers
(
	id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name        VARCHAR(100) NOT NULL,
	phone_number VARCHAR(10)  NOT NULL,
	position    INT UNSIGNED NOT NULL DEFAULT 1,
	PRIMARY KEY (id),
	FOREIGN KEY (position) REFERENCES teacher_positions (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS lessons
(
	uuid        INT UNSIGNED NOT NULL AUTO_INCREMENT,
	subject_id  INT UNSIGNED NOT NULL,
	teacher_id  INT UNSIGNED NOT NULL,
	lesson_type INT UNSIGNED NOT NULL,
	PRIMARY KEY (uuid),
	FOREIGN KEY (subject_id) REFERENCES subjects (id),
	FOREIGN KEY (teacher_id) REFERENCES teachers (id),
	FOREIGN KEY (lesson_type) REFERENCES lesson_types (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS progress
(
	uuid       INT UNSIGNED     NOT NULL AUTO_INCREMENT,
	student_id INT UNSIGNED     NOT NULL,
	subject_id INT UNSIGNED     NOT NULL,
	grade      TINYINT UNSIGNED NOT NULL,
	PRIMARY KEY (uuid),
	FOREIGN KEY (subject_id) REFERENCES subjects (id),
	FOREIGN KEY (subject_id) REFERENCES subjects (id)
) ENGINE = InnoDB;
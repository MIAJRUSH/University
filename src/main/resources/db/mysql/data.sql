-- ---------------------------------------------
-- lesson_types
-- ---------------------------------------------
INSERT IGNORE INTO lesson_types (name)
VALUES ('Lecture');
INSERT IGNORE INTO lesson_types (name)
VALUES ('Laboratory work');
INSERT IGNORE INTO lesson_types (name)
VALUES ('Practical lesson');
INSERT IGNORE INTO lesson_types (name)
VALUES ('Seminar');

-- ---------------------------------------------
-- teacher_position
-- ---------------------------------------------
INSERT IGNORE INTO teacher_positions (name)
VALUES ('Instructor');
INSERT IGNORE INTO teacher_positions (name)
VALUES ('Senior lecturer');
INSERT IGNORE INTO teacher_positions (name)
VALUES ('Professor');
INSERT IGNORE INTO teacher_positions (name)
VALUES ('Docent');

-- ---------------------------------------------
-- groups_table
-- ---------------------------------------------
INSERT IGNORE INTO groups_table (name, students_number)
VALUES ('Engineering', 1);
INSERT IGNORE INTO groups_table (name, students_number)
VALUES ('Security', 1);
INSERT IGNORE INTO groups_table (name, students_number)
VALUES ('Mathematics', 1);
INSERT IGNORE INTO groups_table (name, students_number)
VALUES ('Informatics', 1);
INSERT IGNORE INTO groups_table (name, students_number)
VALUES ('Computer system', 1);

-- ---------------------------------------------
-- subjects
-- ---------------------------------------------
INSERT IGNORE INTO subjects (name, hours_number)
VALUES ('Mathematics', 40);
INSERT IGNORE INTO subjects (name, hours_number)
VALUES ('Physics', 20);
INSERT IGNORE INTO subjects (name, hours_number)
VALUES ('Programming', 80);
INSERT IGNORE INTO subjects (name, hours_number)
VALUES ('Web-development', 60);
INSERT IGNORE INTO subjects (name, hours_number)
VALUES ('Database', 50);
INSERT IGNORE INTO subjects (name, hours_number)
VALUES ('Physical education', 100);

-- ---------------------------------------------
-- students
-- ---------------------------------------------
INSERT IGNORE INTO students (name, course, phone_number, email, group_id)
VALUES ('Trevor Garrison', 1, 9998889988, 'garrison@gmail.com', 1);
INSERT IGNORE INTO students (name, course, phone_number, email, group_id)
VALUES ('Justin Farmer', 2, 9998887766, 'farmer@gmail.com', 2);
INSERT IGNORE INTO students (name, course, phone_number, email, group_id)
VALUES ('Ryan Crossman', 3, 9998885544, 'crossman@gmail.com', 3);
INSERT IGNORE INTO students (name, course, phone_number, email, group_id)
VALUES ('Abigail Charlson', 4, 9998883322, 'charlson@gmail.com', 4);
INSERT IGNORE INTO students (name, course, phone_number, email, group_id)
VALUES ('Deborah Lee', 5, 9998881100, 'lee@gmail.com', 5);

-- ---------------------------------------------
-- teachers
-- ---------------------------------------------
INSERT IGNORE INTO teachers (name, phone_number, position)
VALUES ('Katie Addington', 1001001010, 1);
INSERT IGNORE INTO teachers (name, phone_number, position)
VALUES ('Francis Gilbert', 1002002020, 2);
INSERT IGNORE INTO teachers (name, phone_number, position)
VALUES ('Emily Carroll', 1003003030, 3);
INSERT IGNORE INTO teachers (name, phone_number, position)
VALUES ('Zhoshua Scott', 1004004040, 4);

-- ---------------------------------------------
-- lessons
-- ---------------------------------------------
INSERT IGNORE INTO lessons (subject_id, teacher_id, lesson_type)
VALUES (3, 1, 1);
INSERT IGNORE INTO lessons (subject_id, teacher_id, lesson_type)
VALUES (3, 1, 3);
INSERT IGNORE INTO lessons (subject_id, teacher_id, lesson_type)
VALUES (3, 1, 2);
INSERT IGNORE INTO lessons (subject_id, teacher_id, lesson_type)
VALUES (1, 2, 1);
INSERT IGNORE INTO lessons (subject_id, teacher_id, lesson_type)
VALUES (2, 3, 1);
INSERT IGNORE INTO lessons (subject_id, teacher_id, lesson_type)
VALUES (4, 1, 2);
INSERT IGNORE INTO lessons (subject_id, teacher_id, lesson_type)
VALUES (5, 4, 3);

-- ---------------------------------------------
-- progress
-- ---------------------------------------------
INSERT IGNORE INTO progress (student_id, subject_id, grade)
VALUES (1, 3, 5);
INSERT IGNORE INTO progress (student_id, subject_id, grade)
VALUES (2, 1, 3);
INSERT IGNORE INTO progress (student_id, subject_id, grade)
VALUES (3, 4, 4);
INSERT IGNORE INTO progress (student_id, subject_id, grade)
VALUES (4, 5, 5);
INSERT IGNORE INTO progress (student_id, subject_id, grade)
VALUES (5, 2, 2);

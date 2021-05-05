package com.github.miajrush.university.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple JavaBean domain object representing a teacher position.
 */
@Entity
@Table(name = "teacher_positions")
public class TeacherPosition extends NamedEntity {
	public TeacherPosition() {}
}

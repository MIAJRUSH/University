package com.github.miajrush.university.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple JavaBean domain object representing a lesson type.
 */
@Entity
@Table(name = "lesson_types")
public class LessonType extends NamedEntity {
	public LessonType() {}
	
	@Override
	public String toString() {
		return "LessonType{" + "name='" + name + '\'' + '}';
	}
}

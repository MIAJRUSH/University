package com.github.miajrush.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Simple JavaBean domain object representing a lesson.
 */
@EqualsAndHashCode(of = "", callSuper = true)
@Data
@Entity
@Table(name = "lessons")
public class Lesson extends BaseEntityProperty {
	@NotNull
	@OneToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "lesson_type")
	private LessonType lessonType;
}

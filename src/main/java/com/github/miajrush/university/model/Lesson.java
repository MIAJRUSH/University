package com.github.miajrush.university.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Simple JavaBean domain object representing a lesson.
 */
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
	
	public Lesson() {}
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public LessonType getLessonType() {
		return lessonType;
	}
	
	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}
}

package com.github.miajrush.university.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Simple JavaBean domain object representing a teacher.
 */
@Entity
@Table(name = "teachers")
public class Teacher extends NamedEntity {
	@Pattern(regexp = "\\d{10}", message = "Must be 10 digits")
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "position")
	private TeacherPosition position;
	
	public Teacher() {}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public TeacherPosition getPosition() {
		return position;
	}
	
	public void setPosition(TeacherPosition position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "Teacher{" + "name='" + name + '\'' + '}';
	}
}

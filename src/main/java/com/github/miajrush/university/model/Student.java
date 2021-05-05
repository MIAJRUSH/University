package com.github.miajrush.university.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Simple JavaBean domain object representing a student.
 */
@Entity
@Table(name = "students")
public class Student extends NamedEntity {
	@NotNull
	@Min(value = 1, message = "Too small")
	@Max(value = 5, message = "Too large")
	@Column(name = "course")
	private Integer course;
	
	@Pattern(regexp = "\\d{10}", message = "Must be 10 digits")
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Email(message = "Must be valid")
	@Column(name = "email")
	private String email;
	
	@NotNull
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "group_id")
	private Group group;
	
	public Student() {}
	
	public Integer getCourse() {
		return course;
	}
	
	public void setCourse(Integer course) {
		this.course = course;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
}

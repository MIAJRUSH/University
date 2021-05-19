package com.github.miajrush.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(of = "", callSuper = true)
@Data
@Entity
@Table(name = "teachers")
public class Teacher extends NamedEntity {
	@Pattern(regexp = "\\d{10}", message = "Must be 10 digits")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "position")
	private TeacherPosition position;
}

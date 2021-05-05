package com.github.miajrush.university.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Simple JavaBean domain object representing a progress.
 */
@EqualsAndHashCode(of = "", callSuper = true)
@Data
@Entity
@Table(name = "progress")
public class Progress extends BaseEntityProperty {
	@NotNull
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@NotNull
	@Min(value = 1, message = "Too small")
	@Max(value = 5, message = "Too large")
	@Column(name = "grade")
	private Byte grade;
}

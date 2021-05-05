package com.github.miajrush.university.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * Simple JavaBean domain object representing a subject.
 */
@Entity
@Table(name = "subjects")
public class Subject extends NamedEntity {
	@NotNull
	@PositiveOrZero(message = "Must be positive or zero")
	@Column(name = "hours_number")
	private Integer hoursNumber;
	
	public Subject() {}
	
	public Integer getHoursNumber() {
		return hoursNumber;
	}
	
	public void setHoursNumber(Integer hoursNumber) {
		this.hoursNumber = hoursNumber;
	}
}

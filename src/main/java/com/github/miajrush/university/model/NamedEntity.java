package com.github.miajrush.university.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

/**
 * Simple JavaBean domain object adds a name property to {@link BaseEntity}. Used as a base class for objects needing
 * these properties.
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {
	@NotBlank
	@Length(min = 2, message = "Too short")
	@Length(max = 255, message = "Too long")
	@Column(name = "name")
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

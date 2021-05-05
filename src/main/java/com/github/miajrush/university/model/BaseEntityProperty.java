package com.github.miajrush.university.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.util.Objects;

/**
 * Simple JavaBean domain object with an uuid property. Used as a base class for objects needing this property.
 */
@MappedSuperclass
public class BaseEntityProperty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid")
	protected Integer id;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (!(o instanceof BaseEntityProperty)) {
			return false;
		}
		
		return Objects.equals(id, ((BaseEntityProperty) o).id);
	}
}

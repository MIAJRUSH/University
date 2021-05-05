package com.github.miajrush.university.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple JavaBean domain object representing a group.
 */
@Entity
@Table(name = "groups_table")
public class Group extends NamedEntity {
	@NotNull
	@PositiveOrZero(message = "Must be positive or zero")
	@Column(name = "students_number")
	private Integer studentsNumber;
	
	@NotNull
	@OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
	private List<Student> students;
	
	public Group() {
		studentsNumber = 0;
		students = new ArrayList<>();
	}
	
	/**
	 * Add a student to the list and increase the students number
	 *
	 * @param student the {@link Student} to be add to list
	 */
	public void addStudent(Student student) {
		students.add(student);
		studentsNumber++;
	}
	
	/**
	 * Remove a student from the list and decrease the students number
	 *
	 * @param student the {@link Student} to be delete from list
	 */
	public void removeStudent(Student student) {
		students.remove(student);
		studentsNumber--;
	}
	
	public Integer getStudentsNumber() {
		return studentsNumber;
	}
	
	public void setStudentsNumber(Integer studentsNumber) {
		this.studentsNumber = studentsNumber;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		return "Group{" + "id=" + id + ", studentsNumber=" + studentsNumber + ", name='" + name + '\'' + '}';
	}
}

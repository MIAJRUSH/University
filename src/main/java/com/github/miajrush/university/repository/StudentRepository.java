package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Student;

import java.util.List;

/**
 * Repository class for {@link Student} domain objects
 */
public interface StudentRepository {
	/**
	 * Retrieve all {@link Student}s from the data store.
	 *
	 * @return a {@link List} of {@link Student}s
	 */
	List<Student> findAll();
	
	/**
	 * Retrieve a {@link Student} from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the {@link Student} if found
	 */
	Student findById(Integer id);
	
	/**
	 * Save a {@link Student} to the data store.
	 *
	 * @param student the {@link Student} to save
	 */
	void save(Student student);
	
	/**
	 * Update a {@link Student} to the data store.
	 *
	 * @param student the {@link Student} to update
	 */
	void update(Student student);
	
	/**
	 * Delete a {@link Student} from the data store.
	 *
	 * @param student the {@link Student} to delete
	 */
	void delete(Student student);
}

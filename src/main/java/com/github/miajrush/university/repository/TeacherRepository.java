package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Teacher;

import java.util.List;

/**
 * Repository class for {@link Teacher} domain objects
 */
public interface TeacherRepository {
	/**
	 * Retrieve all {@link Teacher}s from the data store.
	 *
	 * @return a {@link List} of {@link Teacher}s
	 */
	List<Teacher> findAll();
	
	/**
	 * Retrieve a {@link Teacher} from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the {@link Teacher} if found
	 */
	Teacher findById(Integer id);
	
	/**
	 * Save a {@link Teacher} to the data store.
	 *
	 * @param teacher the {@link Teacher} to save
	 */
	void save(Teacher teacher);
	
	/**
	 * Update a {@link Teacher} to the data store.
	 *
	 * @param teacher the {@link Teacher} to update
	 */
	void update(Teacher teacher);
	
	/**
	 * Delete a {@link Teacher} from the data store.
	 *
	 * @param teacher the {@link Teacher} to delete
	 */
	void delete(Teacher teacher);
}

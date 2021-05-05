package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Subject;

import java.util.List;

/**
 * Repository class for {@link Subject} domain objects
 */
public interface SubjectRepository {
	/**
	 * Retrieve all {@link Subject}s from the data store.
	 *
	 * @return a {@link List} of {@link Subject}s
	 */
	List<Subject> findAll();
	
	/**
	 * Retrieve a {@link Subject} from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the {@link Subject} if found
	 */
	Subject findById(Integer id);
	
	/**
	 * Save a {@link Subject} to the data store.
	 *
	 * @param subject the {@link Subject} to save
	 */
	void save(Subject subject);
	
	/**
	 * Update a {@link Subject} to the data store.
	 *
	 * @param subject the {@link Subject} to update
	 */
	void update(Subject subject);
	
	/**
	 * Delete a {@link Subject} from the data store.
	 *
	 * @param subject the {@link Subject} to delete
	 */
	void delete(Subject subject);
}

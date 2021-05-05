package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Progress;

import java.util.List;

/**
 * Repository class for {@link Progress} domain objects
 */
public interface ProgressRepository {
	/**
	 * Retrieve all {@link Progress}s from the data store.
	 *
	 * @return a {@link List} of {@link Progress}
	 */
	List<Progress> findAll();
	
	/**
	 * Retrieve a {@link Progress} from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the {@link Progress} if found
	 */
	Progress findById(Integer id);
	
	/**
	 * Save a {@link Progress} to the data store.
	 *
	 * @param progress the {@link Progress} to save
	 */
	void save(Progress progress);
	
	/**
	 * Update a {@link Progress} to the data store.
	 *
	 * @param progress the {@link Progress} to update
	 */
	void update(Progress progress);
	
	/**
	 * Delete a {@link Progress} from the data store.
	 *
	 * @param progress the {@link Progress} to delete
	 */
	void delete(Progress progress);
}

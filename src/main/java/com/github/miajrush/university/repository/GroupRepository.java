package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Group;

import java.util.List;

/**
 * Repository class for {@link Group} domain objects
 */
public interface GroupRepository {
	/**
	 * Retrieve all {@link Group}s from the data store.
	 *
	 * @return a {@link List} of {@link Group}s
	 */
	List<Group> findAll();
	
	/**
	 * Retrieve a {@link Group} from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the {@link Group} if found
	 */
	Group findById(Integer id);
	
	/**
	 * Save a {@link Group} to the data store.
	 *
	 * @param group the {@link Group} to save
	 */
	void save(Group group);
	
	/**
	 * Update a {@link Group} to the data store.
	 *
	 * @param group the {@link Group} to update
	 */
	void update(Group group);
	
	/**
	 * Delete a {@link Group} from the data store.
	 *
	 * @param group the {@link Group} to delete
	 */
	void delete(Group group);
}

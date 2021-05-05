package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Lesson;

import java.util.List;

/**
 * Repository class for {@link Lesson} domain objects
 */
public interface LessonRepository {
	/**
	 * Retrieve all {@link Lesson}s from the data store.
	 *
	 * @return a {@link List} of {@link Lesson}s
	 */
	List<Lesson> findAll();
	
	/**
	 * Retrieve a {@link Lesson} from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the {@link Lesson} if found
	 */
	Lesson findById(Integer id);
	
	/**
	 * Save a {@link Lesson} to the data store.
	 *
	 * @param lesson the {@link Lesson} to save
	 */
	void save(Lesson lesson);
	
	/**
	 * Update a {@link Lesson} to the data store.
	 *
	 * @param lesson the {@link Lesson} to update
	 */
	void update(Lesson lesson);
	
	/**
	 * Delete a {@link Lesson} from the data store.
	 *
	 * @param lesson the {@link Lesson} to delete
	 */
	void delete(Lesson lesson);
}

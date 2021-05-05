package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.LessonType;

import java.util.List;

/**
 * Repository class for {@link LessonType} domain objects
 */
public interface LessonTypeRepository {
	/**
	 * Retrieve all {@link LessonType}s from the data store.
	 *
	 * @return a {@link List} of {@link LessonType}s
	 */
	List<LessonType> findAll();
	
	/**
	 * Retrieve a {@link LessonType} from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the {@link LessonType} if found
	 */
	LessonType findById(Integer id);
	
	/**
	 * Save a {@link LessonType} to the data store.
	 *
	 * @param lessonType the {@link LessonType} to save
	 */
	void save(LessonType lessonType);
	
	/**
	 * Update a {@link LessonType} to the data store.
	 *
	 * @param lessonType the {@link LessonType} to update
	 */
	void update(LessonType lessonType);
	
	/**
	 * Delete a {@link LessonType} from the data store.
	 *
	 * @param lessonType the {@link LessonType} to delete
	 */
	void delete(LessonType lessonType);
}

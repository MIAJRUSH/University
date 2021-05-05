package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.TeacherPosition;

import java.util.List;

/**
 * Repository class for {@link TeacherPosition} domain objects
 */
public interface TeacherPositionRepository {
	/**
	 * Retrieve all {@link TeacherPosition}s from the data store.
	 *
	 * @return a {@link List} of {@link TeacherPosition}s
	 */
	List<TeacherPosition> findAll();
	
	/**
	 * Retrieve a {@link TeacherPosition} from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the {@link TeacherPosition} if found
	 */
	TeacherPosition findById(Integer id);
	
	/**
	 * Save a {@link TeacherPosition} to the data store.
	 *
	 * @param teacherPosition the {@link TeacherPosition} to save
	 */
	void save(TeacherPosition teacherPosition);
	
	/**
	 * Update a {@link TeacherPosition} to the data store.
	 *
	 * @param teacherPosition the {@link TeacherPosition} to update
	 */
	void update(TeacherPosition teacherPosition);
	
	/**
	 * Delete a {@link TeacherPosition} from the data store.
	 *
	 * @param teacherPosition the {@link TeacherPosition} to delete
	 */
	void delete(TeacherPosition teacherPosition);
}

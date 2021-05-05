package com.github.miajrush.university.service;

import com.github.miajrush.university.model.LessonType;
import com.github.miajrush.university.repository.LessonTypeRepository;
import com.github.miajrush.university.web.controller.LessonController;

import java.util.List;

/**
 * Used as a facade for a {@link LessonController}. For more information on the methods, see {@link
 * LessonTypeRepository}.
 */
public interface LessonTypeService {
	List<LessonType> findAll();
	
	LessonType findById(Integer id);
	
	void save(LessonType lessonType);
	
	void update(LessonType lessonType);
	
	void delete(LessonType lessonType);
}

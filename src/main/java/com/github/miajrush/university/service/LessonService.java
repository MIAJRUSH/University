package com.github.miajrush.university.service;

import com.github.miajrush.university.model.Lesson;
import com.github.miajrush.university.repository.LessonRepository;
import com.github.miajrush.university.web.controller.LessonController;
import com.github.miajrush.university.web.controller.SubjectController;
import com.github.miajrush.university.web.controller.TeacherController;

import java.util.List;

/**
 * Used as a facade for {@link LessonController}, {@link SubjectController} and {@link TeacherController}. For more
 * information on the methods, see {@link LessonRepository}.
 */
public interface LessonService {
	List<Lesson> findAll();
	
	Lesson findById(Integer id);
	
	void save(Lesson lesson);
	
	void update(Lesson lesson);
	
	void delete(Lesson lesson);
}

package com.github.miajrush.university.service;

import com.github.miajrush.university.model.Teacher;
import com.github.miajrush.university.repository.TeacherRepository;
import com.github.miajrush.university.web.controller.LessonController;
import com.github.miajrush.university.web.controller.TeacherController;

import java.util.List;

/**
 * Used as a facade for {@link TeacherController} and {@link LessonController}. For more information on the methods, see
 * {@link TeacherRepository}.
 */
public interface TeacherService {
	List<Teacher> findAll();
	
	Teacher findById(Integer id);
	
	void save(Teacher teacher);
	
	void update(Teacher teacher);
	
	void delete(Teacher teacher);
}

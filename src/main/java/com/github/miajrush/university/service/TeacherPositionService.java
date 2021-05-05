package com.github.miajrush.university.service;

import com.github.miajrush.university.model.TeacherPosition;
import com.github.miajrush.university.repository.TeacherPositionRepository;
import com.github.miajrush.university.web.controller.TeacherController;

import java.util.List;

/**
 * Used as a facade for a {@link TeacherController}. For more information on the methods, see {@link
 * TeacherPositionRepository}.
 */
public interface TeacherPositionService {
	List<TeacherPosition> findAll();
	
	TeacherPosition findById(Integer id);
	
	void save(TeacherPosition teacherPosition);
	
	void update(TeacherPosition teacherPosition);
	
	void delete(TeacherPosition teacherPosition);
}

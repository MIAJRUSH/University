package com.github.miajrush.university.service;

import com.github.miajrush.university.model.Subject;
import com.github.miajrush.university.repository.SubjectRepository;
import com.github.miajrush.university.web.controller.LessonController;
import com.github.miajrush.university.web.controller.ProgressController;
import com.github.miajrush.university.web.controller.SubjectController;

import java.util.List;

/**
 * Used as a facade for {@link SubjectController}, {@link LessonController} and {@link ProgressController}. For more
 * information on the methods, see {@link SubjectRepository}.
 */
public interface SubjectService {
	List<Subject> findAll();
	
	Subject findById(Integer id);
	
	void save(Subject subject);
	
	void update(Subject subject);
	
	void delete(Subject subject);
}

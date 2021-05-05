package com.github.miajrush.university.service;

import com.github.miajrush.university.model.Progress;
import com.github.miajrush.university.repository.ProgressRepository;
import com.github.miajrush.university.web.controller.ProgressController;
import com.github.miajrush.university.web.controller.SubjectController;

import java.util.List;

/**
 * Used as a facade for {@link ProgressController} and {@link SubjectController}. For more information on the methods,
 * see {@link ProgressRepository}.
 */
public interface ProgressService {
	List<Progress> findAll();
	
	Progress findById(Integer id);
	
	void save(Progress progress);
	
	void update(Progress progress);
	
	void delete(Progress progress);
}

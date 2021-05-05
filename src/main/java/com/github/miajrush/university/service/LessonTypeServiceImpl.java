package com.github.miajrush.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.miajrush.university.model.LessonType;
import com.github.miajrush.university.repository.LessonTypeRepository;

import java.util.List;

/**
 * Implementation of the {@link LessonTypeService} interface and a placeholder for @Transactional annotations.
 */
@Service
@Transactional
public class LessonTypeServiceImpl implements LessonTypeService {
	private final LessonTypeRepository repository;
	
	@Autowired
	public LessonTypeServiceImpl(LessonTypeRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<LessonType> findAll() {
		return repository.findAll();
	}
	
	@Override
	public LessonType findById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public void save(LessonType lessonType) {
		repository.save(lessonType);
	}
	
	@Override
	public void update(LessonType lessonType) {
		repository.update(lessonType);
	}
	
	@Override
	public void delete(LessonType lessonType) {
		repository.delete(lessonType);
	}
}

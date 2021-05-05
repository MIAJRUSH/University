package com.github.miajrush.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.miajrush.university.model.Lesson;
import com.github.miajrush.university.repository.LessonRepository;

import java.util.List;

/**
 * Implementation of the {@link LessonService} interface and a placeholder for @Transactional annotations.
 */
@Service
@Transactional
public class LessonServiceImpl implements LessonService {
	private final LessonRepository lessonRepository;
	
	@Autowired
	public LessonServiceImpl(LessonRepository lessonRepository) {
		this.lessonRepository = lessonRepository;
	}
	
	@Override
	public List<Lesson> findAll() {
		return lessonRepository.findAll();
	}
	
	@Override
	public Lesson findById(Integer id) {
		return lessonRepository.findById(id);
	}
	
	@Override
	public void save(Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	@Override
	public void update(Lesson lesson) {
		lessonRepository.update(lesson);
	}
	
	@Override
	public void delete(Lesson lesson) {
		lessonRepository.delete(lesson);
	}
}

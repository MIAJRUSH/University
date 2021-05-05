package com.github.miajrush.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.miajrush.university.model.TeacherPosition;
import com.github.miajrush.university.repository.TeacherPositionRepository;

import java.util.List;

/**
 * Implementation of the {@link TeacherPositionService} interface and a placeholder for @Transactional annotations.
 */
@Service
@Transactional
public class TeacherPositionServiceImpl implements TeacherPositionService {
	private final TeacherPositionRepository repository;
	
	@Autowired
	public TeacherPositionServiceImpl(TeacherPositionRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<TeacherPosition> findAll() {
		return repository.findAll();
	}
	
	@Override
	public TeacherPosition findById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public void save(TeacherPosition teacherPosition) {
		repository.save(teacherPosition);
	}
	
	@Override
	public void update(TeacherPosition teacherPosition) {
		repository.update(teacherPosition);
	}
	
	@Override
	public void delete(TeacherPosition teacherPosition) {
		repository.delete(teacherPosition);
	}
}

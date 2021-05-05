package com.github.miajrush.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.miajrush.university.model.Teacher;
import com.github.miajrush.university.repository.TeacherRepository;

import java.util.List;

/**
 * Implementation of the {@link TeacherService} interface and a placeholder for @Transactional annotations.
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	private final TeacherRepository repository;
	
	@Autowired
	public TeacherServiceImpl(TeacherRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Teacher> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Teacher findById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public void save(Teacher teacher) {
		repository.save(teacher);
	}
	
	@Override
	public void update(Teacher teacher) {
		repository.update(teacher);
	}
	
	@Override
	public void delete(Teacher teacher) {
		repository.delete(teacher);
	}
}

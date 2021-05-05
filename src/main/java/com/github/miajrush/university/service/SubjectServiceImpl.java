package com.github.miajrush.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.miajrush.university.model.Subject;
import com.github.miajrush.university.repository.SubjectRepository;

import java.util.List;

/**
 * Implementation of the {@link SubjectService} interface and a placeholder for @Transactional annotations.
 */
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	private final SubjectRepository repository;
	
	@Autowired
	public SubjectServiceImpl(SubjectRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Subject> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Subject findById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public void save(Subject subject) {
		repository.save(subject);
	}
	
	@Override
	public void update(Subject subject) {
		repository.update(subject);
	}
	
	@Override
	public void delete(Subject subject) {
		repository.delete(subject);
	}
}

package com.github.miajrush.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.miajrush.university.model.Progress;
import com.github.miajrush.university.repository.ProgressRepository;

import java.util.List;

/**
 * Implementation of the {@link ProgressService} interface and a placeholder for @Transactional annotations.
 */
@Service
@Transactional
public class ProgressServiceImpl implements ProgressService {
	private final ProgressRepository progressRepository;
	
	@Autowired
	public ProgressServiceImpl(ProgressRepository progressRepository) {
		this.progressRepository = progressRepository;
	}
	
	@Override
	public List<Progress> findAll() {
		return progressRepository.findAll();
	}
	
	@Override
	public Progress findById(Integer id) {
		return progressRepository.findById(id);
	}
	
	@Override
	public void save(Progress progress) {
		progressRepository.save(progress);
	}
	
	@Override
	public void update(Progress progress) {
		progressRepository.update(progress);
	}
	
	@Override
	public void delete(Progress progress) {
		progressRepository.delete(progress);
	}
}

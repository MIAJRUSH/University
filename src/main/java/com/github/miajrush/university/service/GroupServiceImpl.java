package com.github.miajrush.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.miajrush.university.model.Group;
import com.github.miajrush.university.repository.GroupRepository;

import java.util.List;

/**
 * Implementation of the {@link GroupService} interface and a placeholder for @Transactional annotations.
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {
	private final GroupRepository repository;
	
	@Autowired
	public GroupServiceImpl(GroupRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Group> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Group findById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public void save(Group group) {
		repository.save(group);
	}
	
	@Override
	public void update(Group group) {
		repository.update(group);
	}
	
	@Override
	public void delete(Group group) {
		repository.delete(group);
	}
}

package com.github.miajrush.university.service;

import com.github.miajrush.university.model.Group;
import com.github.miajrush.university.repository.GroupRepository;
import com.github.miajrush.university.web.controller.GroupController;
import com.github.miajrush.university.web.controller.StudentController;

import java.util.List;

/**
 * Used as a facade for {@link GroupController} and {@link StudentController}. For more information on the methods, see
 * {@link GroupRepository}.
 */
public interface GroupService {
	List<Group> findAll();
	
	Group findById(Integer id);
	
	void save(Group group);
	
	void update(Group group);
	
	void delete(Group group);
}

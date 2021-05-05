package com.github.miajrush.university.service;

import com.github.miajrush.university.model.Group;
import com.github.miajrush.university.model.Student;
import com.github.miajrush.university.repository.StudentRepository;
import com.github.miajrush.university.web.controller.GroupController;
import com.github.miajrush.university.web.controller.ProgressController;
import com.github.miajrush.university.web.controller.StudentController;

import java.util.List;

/**
 * Used as a facade for {@link StudentController}, {@link GroupController} and {@link ProgressController}. For more
 * information on the methods, see {@link StudentRepository}.
 */
public interface StudentService {
	List<Student> findAll();
	
	Student findById(Integer id);
	
	void save(Student student);
	
	void update(Student student, Group oldGroup);
	
	void delete(Student student);
}

package com.github.miajrush.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.miajrush.university.model.Group;
import com.github.miajrush.university.model.Student;
import com.github.miajrush.university.repository.StudentRepository;

import java.util.List;

/**
 * Implementation of the {@link StudentService} interface and a placeholder for @Transactional annotations.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;
	private final GroupService groupService;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository, GroupService groupService) {
		this.studentRepository = studentRepository;
		this.groupService = groupService;
	}
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	@Override
	public Student findById(Integer id) {
		return studentRepository.findById(id);
	}
	
	/**
	 * We need to add the student to students list and then save the student.
	 *
	 * @param student the {@link Student} to save
	 */
	@Override
	public void save(Student student) {
		student.getGroup().addStudent(student);
		studentRepository.save(student);
	}
	
	/**
	 * We need to transfer the student to another group.
	 *
	 * @param student the {@link Student} to save
	 * @param oldGroup the {@link Group} that stores data about old group.
	 */
	@Override
	public void update(Student student, Group oldGroup) {
		if (!oldGroup.equals(student.getGroup())) {
			oldGroup.removeStudent(student);
			student.getGroup().addStudent(student);
			groupService.update(oldGroup);
		}
		
		studentRepository.update(student);
	}
	
	/**
	 * We need to remove the student from students list and then delete the student.
	 *
	 * @param student the {@link Student} to delete
	 */
	@Override
	public void delete(Student student) {
		student.getGroup().removeStudent(student);
		studentRepository.delete(student);
	}
}

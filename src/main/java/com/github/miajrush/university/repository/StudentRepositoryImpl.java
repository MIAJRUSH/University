package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * JPA implementation of the {@link StudentRepository} interface.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Student> findAll() {
		return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
	}
	
	@Override
	public Student findById(Integer id) {
		Student student = em.find(Student.class, id);
		if (student == null) {
			throw new RuntimeException("Entity isn't found");
		}
		return student;
	}
	
	/**
	 * We need to update the student group data and then save the student.
	 *
	 * @param student the {@link Student} to save
	 */
	@Override
	public void save(Student student) {
		em.persist(em.merge(student));
	}
	
	@Override
	public void update(Student student) {
		em.merge(student);
	}
	
	@Override
	public void delete(Student student) {
		em.remove(em.merge(student));
	}
}

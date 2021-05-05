package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * JPA implementation of the {@link TeacherRepository} interface.
 */
@Repository
public class TeacherRepositoryImpl implements TeacherRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Teacher> findAll() {
		return em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
	}
	
	@Override
	public Teacher findById(Integer id) {
		Teacher teacher = em.find(Teacher.class, id);
		if (teacher == null) {
			throw new RuntimeException("Entity isn't found");
		}
		return teacher;
	}
	
	@Override
	public void save(Teacher teacher) {
		em.persist(teacher);
	}
	
	@Override
	public void update(Teacher teacher) {
		em.merge(teacher);
	}
	
	@Override
	public void delete(Teacher teacher) {
		em.remove(em.merge(teacher));
	}
}

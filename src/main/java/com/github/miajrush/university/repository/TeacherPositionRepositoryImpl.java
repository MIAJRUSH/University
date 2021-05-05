package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.TeacherPosition;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * JPA implementation of the {@link TeacherPositionRepository} interface.
 */
@Repository
public class TeacherPositionRepositoryImpl implements TeacherPositionRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<TeacherPosition> findAll() {
		return em.createQuery("SELECT tp FROM TeacherPosition tp", TeacherPosition.class).getResultList();
	}
	
	@Override
	public TeacherPosition findById(Integer id) {
		TeacherPosition teacherPosition = em.find(TeacherPosition.class, id);
		if (teacherPosition == null) {
			throw new RuntimeException("Entity isn't found");
		}
		return teacherPosition;
	}
	
	@Override
	public void save(TeacherPosition teacherPosition) {
		em.persist(teacherPosition);
	}
	
	@Override
	public void update(TeacherPosition teacherPosition) {
		em.merge(teacherPosition);
	}
	
	@Override
	public void delete(TeacherPosition teacherPosition) {
		em.remove(em.merge(teacherPosition));
	}
}

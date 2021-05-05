package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.LessonType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * JPA implementation of the {@link LessonTypeRepository} interface.
 */
@Repository
public class LessonTypeRepositoryImpl implements LessonTypeRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<LessonType> findAll() {
		return em.createQuery("SELECT lt FROM LessonType lt", LessonType.class).getResultList();
	}
	
	@Override
	public LessonType findById(Integer id) {
		LessonType lessonType = em.find(LessonType.class, id);
		if (lessonType == null) {
			throw new RuntimeException("Entity isn't found");
		}
		return lessonType;
	}
	
	@Override
	public void save(LessonType lessonType) {
		em.persist(lessonType);
	}
	
	@Override
	public void update(LessonType lessonType) {
		em.merge(lessonType);
	}
	
	@Override
	public void delete(LessonType lessonType) {
		em.remove(lessonType);
	}
}

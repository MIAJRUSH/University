package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Lesson;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * JPA implementation of the {@link LessonRepository} interface.
 */
@Repository
public class LessonRepositoryImpl implements LessonRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Lesson> findAll() {
		return em.createQuery("SELECT l FROM Lesson l", Lesson.class).getResultList();
	}
	
	@Override
	public Lesson findById(Integer id) {
		Lesson lesson = em.find(Lesson.class, id);
		if (lesson == null) {
			throw new RuntimeException("Entity isn't found");
		}
		return lesson;
	}
	
	@Override
	public void save(Lesson lesson) {
		em.persist(lesson);
	}
	
	@Override
	public void update(Lesson lesson) {
		em.merge(lesson);
	}
	
	@Override
	public void delete(Lesson lesson) {
		em.remove(lesson);
	}
}

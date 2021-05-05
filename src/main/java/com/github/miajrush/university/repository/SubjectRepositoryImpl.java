package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Subject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * JPA implementation of the {@link SubjectRepository} interface.
 */
@Repository
public class SubjectRepositoryImpl implements SubjectRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Subject> findAll() {
		return em.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
	}
	
	@Override
	public Subject findById(Integer id) {
		Subject subject = em.find(Subject.class, id);
		if (subject == null) {
			throw new RuntimeException("Entity isn't found");
		}
		return subject;
	}
	
	@Override
	public void save(Subject subject) {
		em.persist(subject);
	}
	
	@Override
	public void update(Subject subject) {
		em.merge(subject);
	}
	
	@Override
	public void delete(Subject subject) {
		em.remove(em.merge(subject));
	}
}

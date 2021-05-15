package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Progress;
import com.github.miajrush.university.web.exception.NoSuchEntityException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * JPA implementation of the {@link ProgressRepository} interface.
 */
@Repository
public class ProgressRepositoryImpl implements ProgressRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Progress> findAll() {
		return em.createQuery("SELECT p FROM Progress p", Progress.class).getResultList();
	}
	
	@Override
	public Progress findById(Integer id) {
		Progress progress = em.find(Progress.class, id);
		if (progress == null) {
			throw new NoSuchEntityException(Progress.class, id);
		}
		return progress;
	}
	
	@Override
	public void save(Progress progress) {
		em.persist(progress);
	}
	
	@Override
	public void update(Progress progress) {
		em.merge(progress);
	}
	
	@Override
	public void delete(Progress progress) {
		em.remove(em.merge(progress));
	}
}

package com.github.miajrush.university.repository;

import com.github.miajrush.university.model.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * JPA implementation of the {@link GroupRepository} interface.
 */
@Repository
public class GroupRepositoryImpl implements GroupRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Group> findAll() {
		return em.createQuery("SELECT g FROM Group g", Group.class).getResultList();
	}
	
	@Override
	public Group findById(Integer id) {
		Group group = em.find(Group.class, id);
		if (group == null) {
			throw new RuntimeException();
		}
		return group;
	}
	
	@Override
	public void save(Group group) {
		em.persist(group);
	}
	
	@Override
	public void update(Group group) {
		em.merge(group);
	}
	
	@Override
	public void delete(Group group) {
		em.remove(em.merge(group));
	}
}

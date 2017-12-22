package com.app.mvc.dao.imp;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.app.mvc.dao.IGradeDAO;
import com.app.mvc.entity.Grade;

public class GradeDaoImp implements IGradeDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public <S extends Grade> S save(S entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Grade update(Grade entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public <S extends Grade> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Grade> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(em.find(Grade.class, id));
	}

	@Override
	public boolean existsById(Long id) {
		if (em.find(Grade.class, id) != null) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Grade> findAll() {
		Iterable<Grade> grades;
		Query q = em.createQuery("from Grade g");
		grades = q.getResultList();
		return grades;
	}

	@Override
	public Iterable<Grade> findAllById(Iterable<Long> ids) {
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		if (existsById(id)) {
			em.remove(em.find(Grade.class, id));
		}
	}

	@Override
	public void delete(Grade entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void deleteAll(Iterable<? extends Grade> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}

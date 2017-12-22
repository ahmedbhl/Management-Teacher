package com.app.mvc.dao.imp;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.app.mvc.dao.IUserDAO;
import com.app.mvc.entity.User;

public class UserDaoImp implements IUserDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public <S extends User> S save(S entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public User update(User entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findById(Long id) {
		return Optional.ofNullable(em.find(User.class, id));
	}

	@Override
	public boolean existsById(Long id) {
		if (em.find(User.class, id) != null) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<User> findAll() {

		Iterable<User> users;
		Query q = em.createQuery("from User u");
		users = q.getResultList();
		return users;
	}

	@Override
	public Iterable<User> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		em.remove(em.find(User.class, id));
	}

	@Override
	public void delete(User entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public User findBypassword(String password, String mail) {
		Query q = em.createQuery("from User u where u.password=?1 AND u.mail=?2").setParameter(1, password)
				.setParameter(2, mail);
		if (!q.getResultList().isEmpty()) {
			return (User) q.getSingleResult();
		}
		return null;
	}

	@Override
	public Boolean findByMail(String mail) {
		Query q = em.createQuery("from User u where u.mail=?1").setParameter(1, mail);
		if (!q.getResultList().isEmpty()) {
			return true;
		}
		return false;
	}

}

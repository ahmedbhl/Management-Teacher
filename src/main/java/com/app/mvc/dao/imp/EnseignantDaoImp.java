package com.app.mvc.dao.imp;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.app.mvc.dao.IEnseignantDAO;
import com.app.mvc.entity.Enseignant;
import com.app.mvc.utils.CryptPassword;

public class EnseignantDaoImp implements IEnseignantDAO {
	@PersistenceContext
	EntityManager em;

	CryptPassword cryptMD5;

	public void setCryptMD5(CryptPassword cryptMD5) {
		this.cryptMD5 = cryptMD5;
	}

	@Override
	public <S extends Enseignant> S save(S entity) {

		entity.setPassword(cryptMD5.getCryptedPassword());
		em.persist(entity);
		return entity;
	}

	@Override
	public Enseignant update(Enseignant entity) {

		em.merge(entity);
		return entity;
	}

	@Override
	public <S extends Enseignant> Iterable<S> saveAll(Iterable<S> entities) {

		for (Enseignant entity : entities) {
			em.persist(entity);
		}
		return entities;
	}

	@Override
	public Optional<Enseignant> findById(Long id) {

		return Optional.ofNullable(em.find(Enseignant.class, id));
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Enseignant> findAll() {

		Query q = em.createQuery("from Enseignant e");
		return q.getResultList();

	}

	@Override
	public Iterable<Enseignant> findAllById(Iterable<Long> ids) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Enseignant entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void deleteAll(Iterable<? extends Enseignant> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Enseignant findEnsById(Long id) {
		return em.find(Enseignant.class, id);

	}

	@Override
	public void saveAll(List<Enseignant> entities) {

		for (Enseignant entity : entities) {
			em.persist(entity);
		}
	}

	@Override
	public Boolean findByMail(String mail) {
		Query q = em.createQuery("from Enseignant e where e.mail=?1").setParameter(1, mail);
		if (!q.getResultList().isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Enseignant findBypassword(String password, String mail) {
		Query q = em.createQuery("from Enseignant e where e.password=?1 AND e.mail=?2").setParameter(1, password)
				.setParameter(2, mail);
		if (!q.getResultList().isEmpty()) {
			return (Enseignant) q.getSingleResult();
		}
		return null;
	}

	@Override
	public Enseignant FindByUsername(String username) {
		Query q = em.createQuery("from Enseignant e where e.mail=?1").setParameter(1, username);
		return (Enseignant) q.getSingleResult();

	}

}

package com.app.mvc.dao.imp;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.app.mvc.dao.ISeanceDAO;
import com.app.mvc.entity.Seance;

public class SeanceDaoImp implements ISeanceDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public <S extends Seance> S save(S entity) {

		em.persist(entity);
		return entity;
	}

	@Override
	public Seance update(Seance entity) {

		em.merge(entity);
		return entity;
	}

	@Override
	public <S extends Seance> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Seance> findById(Long id) {
		return Optional.ofNullable(em.find(Seance.class, id));
	}

	@Override
	public boolean existsById(Long id) {
		Seance seance = em.find(Seance.class, id);
		if (seance != null) {
			return true;

		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Seance> findAll() {
		Iterable<Seance> seances;
		Query q = em.createQuery("from Seance s ");
		seances = q.getResultList();

		return seances;
	}

	@Override
	public Iterable<Seance> findAllById(Iterable<Long> ids) {
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

		if (existsById(id)) {
			em.remove(em.find(Seance.class, id));
		}

		// Query q = em.createQuery("delete from seance s where s.idSeance
		// =:"+id
		// ).setParameter("idSeance", id);

	}

	@Override
	public void delete(Seance entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void deleteAll(Iterable<? extends Seance> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Seance> findAllById(Long id) {
		Iterable<Seance> Seances;
		Query q = em.createQuery("from Seance s where s.chargeEnseignant.idChargeEnseignant=?1").setParameter(1, id);
		Seances = q.getResultList();
		return (List<Seance>) Seances;
	}

}

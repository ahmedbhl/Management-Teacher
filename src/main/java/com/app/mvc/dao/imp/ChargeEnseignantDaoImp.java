package com.app.mvc.dao.imp;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.app.mvc.dao.IChargeEnseignantDAO;
import com.app.mvc.entity.ChargeEnseignant;

public class ChargeEnseignantDaoImp implements IChargeEnseignantDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public <S extends ChargeEnseignant> S save(S entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public ChargeEnseignant update(ChargeEnseignant entity) {

		em.merge(entity);
		return entity;
	}

	@Override
	public <S extends ChargeEnseignant> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ChargeEnseignant> findById(Long id) {

		return Optional.ofNullable(em.find(ChargeEnseignant.class, id));
	}

	@Override
	public boolean existsById(Long id) {

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<ChargeEnseignant> findAll() {
		Iterable<ChargeEnseignant> chargeEnseignants;
		Query q = em.createQuery("from ChargeEnseignant ch");
		chargeEnseignants = q.getResultList();
		return chargeEnseignants;

	}

	@Override
	public Iterable<ChargeEnseignant> findAllById(Iterable<Long> ids) {
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
	public void delete(ChargeEnseignant entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void deleteAll(Iterable<? extends ChargeEnseignant> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {

	}

	public void addAbsence(ChargeEnseignant entity, int nobmreAbs, String typeSeance) {
		Double newNbreTotale = new Double(0);
		Double nbrTotale = nobmreAbs * 1.5;

		switch (typeSeance) {
		case "Cours":

			newNbreTotale = entity.getNbreAnsenceCoursTot() + nbrTotale;
			entity.setNbreAnsenceCoursTot(newNbreTotale);

			break;
		case "TP":

			newNbreTotale = entity.getNbreAnsenceTpTot() + nbrTotale;
			entity.setNbreAnsenceTpTot(newNbreTotale);
			break;
		case "TD":

			newNbreTotale = entity.getNbreAnsenceTdTot() + nbrTotale;
			entity.setNbreAnsenceTdTot(newNbreTotale);
			break;
		}

		em.merge(entity);

	}

	public void removAbsence(ChargeEnseignant entity, int nobmreAbs, String typeSeance) {

		Double newNbreTotale = new Double(0);
		Double nbrTotale = nobmreAbs * 1.5;

		switch (typeSeance) {
		case "Cours":

			newNbreTotale = entity.getNbreAnsenceCoursTot() - nbrTotale;
			entity.setNbreAnsenceCoursTot(newNbreTotale);

			break;
		case "TP":

			newNbreTotale = entity.getNbreAnsenceTpTot() - nbrTotale;
			entity.setNbreAnsenceTpTot(newNbreTotale);
			break;
		case "TD":

			newNbreTotale = entity.getNbreAnsenceTdTot() - nbrTotale;
			entity.setNbreAnsenceTdTot(newNbreTotale);
			break;
		}

		em.merge(entity);

	}

	@Override
	public void updateAbsence(Long id, int nobmreAbs, String typeSeance, Boolean absence, String action,
			Boolean oldAbsence) {
		ChargeEnseignant entity = findById(id).get();
		switch (action) {
		case "add":
			if (absence == false) {
				addAbsence(entity, nobmreAbs, typeSeance);
			}
			break;
		case "update":
			if (oldAbsence == false && absence == true) {
				removAbsence(entity, nobmreAbs, typeSeance);
			}
			if (oldAbsence == true && absence == false) {
				addAbsence(entity, nobmreAbs, typeSeance);
			}
			break;
		case "remove":
			if (absence == false) {
				removAbsence(entity, nobmreAbs, typeSeance);
			}
			break;

		}

	}

	@Override
	public Boolean isExistChBySemestre(ChargeEnseignant charge) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<ChargeEnseignant> findAllById(Long ids) {
		Iterable<ChargeEnseignant> chargeEnseignants;
		Query q = em.createQuery("from ChargeEnseignant ch where ch.enseignant.idutilisateur=?1").setParameter(1, ids);
		chargeEnseignants = q.getResultList();
		return chargeEnseignants;
	}

}

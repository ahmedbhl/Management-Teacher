package com.app.mvc.dao.imp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.app.mvc.dao.ISemestreDAO;
import com.app.mvc.entity.Semestre;

public class SemestreDaoImpl implements ISemestreDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public <S extends Semestre> S save(S entity) {

		em.persist(entity);
		return entity;
	}

	@Override
	public Semestre update(Semestre entity) {

		em.merge(entity);
		return entity;
	}

	@Override
	public <S extends Semestre> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Semestre> findById(Long id) {
		return Optional.ofNullable(em.find(Semestre.class, id));
	}

	@Override
	public boolean existsById(Long id) {
		if (em.find(Semestre.class, id) != null) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Semestre> findAll() {
		Iterable<Semestre> semestres;
		Query q = em.createQuery("from Semestre s ");
		semestres = q.getResultList();
		return semestres;
	}

	@Override
	public Iterable<Semestre> findAllById(Iterable<Long> ids) {
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
		em.remove(em.find(Semestre.class, id));
	}

	@Override
	public void delete(Semestre entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		// em.remove(em.merge(entity));
	}

	@Override
	public void deleteAll(Iterable<? extends Semestre> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Semestre> findAllByDate() {
		Date startDate = new Date();
		Date endDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar now = Calendar.getInstance(); // Gets the current date and time
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;

		if (8 < month && month <= 12) {
			try {
				startDate = dateFormat.parse(year + "/08/30");
				endDate = dateFormat.parse((year + 1) + "/07/01");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (1 <= month && month <= 6) {
			try {
				startDate = dateFormat.parse((year - 1) + "/08/30");
				endDate = dateFormat.parse(year + "/07/01");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		List<Semestre> semestres;
		String query = "FROM Semestre s  WHERE s.date_deb > ?1 AND s.date_fin < ?2";
		Query q = em.createQuery(query).setParameter(1, startDate, TemporalType.DATE).setParameter(2, endDate,
				TemporalType.DATE);
		semestres = q.getResultList();
		return semestres;

	}

}

package com.app.mvc.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.IChargeEnseignantDAO;
import com.app.mvc.entity.ChargeEnseignant;
import com.app.mvc.service.IServiceChargeEnseignant;

@Transactional
public class serviceChargeEnseignantImp implements IServiceChargeEnseignant {

	IChargeEnseignantDAO dao;

	public void setDao(IChargeEnseignantDAO dao) {
		this.dao = dao;
	}

	@Override
	public ChargeEnseignant save(ChargeEnseignant entity) {
		return dao.save(entity);
	}

	@Override
	public ChargeEnseignant update(ChargeEnseignant entity) {
		return dao.update(entity);
	}

	@Override
	public void delete(ChargeEnseignant entity) {
		dao.delete(entity);
	}

	@Override
	public Iterable<ChargeEnseignant> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public ChargeEnseignant findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public void updateAbsence(Long id, int nobmreAbs, String typeSeance, Boolean absence, String action,Boolean oldAbsence) {
		dao.updateAbsence(id, nobmreAbs, typeSeance, absence, action,oldAbsence);
	}

	@Override
	public Iterable<ChargeEnseignant> findAllById(Long ids) {
		
		return dao.findAllById(ids);
	}

}

package com.app.mvc.service.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.ISeanceDAO;
import com.app.mvc.entity.Seance;
import com.app.mvc.service.IServiceSeance;

@Transactional
public class ServiceSeanceImp implements IServiceSeance {

	ISeanceDAO dao;

	public void setDao(ISeanceDAO dao) {
		this.dao = dao;
	}

	@Override
	public Seance save(Seance entity) {
		return dao.save(entity);
	}

	@Override
	public Seance findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public Iterable<Seance> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void delete(Seance entity) {
		dao.delete(entity);
	}

	@Override
	public Seance update(Seance entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Seance> findAllById(Long id) {
		// TODO Auto-generated method stub
		return dao.findAllById(id);
	}

}

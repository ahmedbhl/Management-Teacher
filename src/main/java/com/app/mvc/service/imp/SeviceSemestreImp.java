package com.app.mvc.service.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.ISemestreDAO;
import com.app.mvc.entity.Semestre;
import com.app.mvc.service.IServiceSemestre;

@Transactional
public class SeviceSemestreImp implements IServiceSemestre {

	ISemestreDAO dao;

	public void setDao(ISemestreDAO dao) {
		this.dao = dao;
	}

	@Override
	public Semestre save(Semestre entity) {
		return dao.save(entity);
	}

	@Override
	public Semestre update(Semestre entity) {
		return dao.update(entity);
	}

	@Override
	public Semestre findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return dao.existsById(id);
	}

	@Override
	public Iterable<Semestre> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void delete(Semestre entity) {
		dao.delete(entity);
	}

	@Override
	public List<Semestre> findAllByDate() {
		return dao.findAllByDate();
	}

}

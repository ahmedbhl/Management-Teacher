package com.app.mvc.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.IGradeDAO;
import com.app.mvc.entity.Grade;
import com.app.mvc.service.IServiceGrade;

@Transactional
public class ServiceGradeImp implements IServiceGrade {

	IGradeDAO dao;

	public void setDao(IGradeDAO dao) {
		this.dao = dao;
	}

	@Override
	public Grade save(Grade entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Grade update(Grade entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public Grade findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return dao.existsById(id);
	}

	@Override
	public Iterable<Grade> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void delete(Grade entity) {
		dao.delete(entity);
	}

}

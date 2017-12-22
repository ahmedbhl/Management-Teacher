package com.app.mvc.service.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.IEnseignantDAO;
import com.app.mvc.entity.Enseignant;
import com.app.mvc.service.IServiceEnseignant;

@Transactional
public class ServiceEnseignantImp implements IServiceEnseignant {

	IEnseignantDAO dao;

	public void setDao(IEnseignantDAO dao) {
		this.dao = dao;
	}

	@Override
	public Enseignant findEnsById(Long id) {
		return dao.findEnsById(id);
	}

	@Override
	public void delete(Enseignant entity) {
		dao.delete(entity);
	}

	@Override
	public Iterable<Enseignant> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Enseignant save(Enseignant entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public Enseignant update(Enseignant entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public Enseignant findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public void saveAll(List<Enseignant> entities) {
		dao.saveAll(entities);

	}

	@Override
	public Boolean findByMail(String mail) {
		return dao.findByMail(mail);
	}

	@Override
	public Enseignant findBypassword(String password,String mail) {
		return dao.findBypassword(password,mail);
	}

	@Override
	public Enseignant FindByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.FindByUsername(username);
	}

}

package com.app.mvc.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.IUserDAO;
import com.app.mvc.entity.User;
import com.app.mvc.service.IServiceUser;

@Transactional
public class ServiceUserImp implements IServiceUser {

	IUserDAO dao;

	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}

	@Override
	public User save(User entity) {
		return dao.save(entity);
	}

	@Override
	public User findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public boolean existsById(Long id) {
		return dao.existsById(id);
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void delete(User entity) {
		dao.delete(entity);
	}

	@Override
	public void update(User entity) {
		dao.update(entity);
	}

	@Override
	public User findBypassword(String password,String mail) {
		return dao.findBypassword(password,mail);
	}

	@Override
	public Boolean findByMail(String mail) {
		// TODO Auto-generated method stub
		return dao.findByMail(mail);
	}

}

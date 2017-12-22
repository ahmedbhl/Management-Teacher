package com.app.mvc.service.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.mvc.dao.IRoleUserDAO;
import com.app.mvc.entity.Enseignant;
import com.app.mvc.entity.RoleUser;
import com.app.mvc.entity.User;
import com.app.mvc.service.IServiceRoleUser;

@Transactional
public class ServiceRoleUserImpl implements IServiceRoleUser {

	IRoleUserDAO dao;

	public void setDao(IRoleUserDAO dao) {
		this.dao = dao;
	}

	@Override
	public RoleUser save(RoleUser entity) {
		// TODO Auto-generated method stub
		return dao.save(entity);
	}

	@Override
	public RoleUser update(RoleUser entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public RoleUser findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return dao.existsById(id);
	}

	@Override
	public Iterable<RoleUser> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void delete(RoleUser entity) {
		dao.delete(entity);
	}

	@Override
	public void saveRoleUser(Enseignant user) {
		dao.saveRoleUser(user);
	}

	@Override
	public void saveRoleAdmin(User User) {
		dao.saveRoleAdmin(User);
	}

	@Override
	public void updateToAdmin(Long iduser) {
		dao.updateToAdmin(iduser);
	}

	@Override
	public void updateToUser(Long iduser) {
		dao.updateToUser(iduser);

	}

	@Override
	public void saveAllRoleUser(List<Enseignant> user) {
		dao.saveAllRoleUser(user);
	}

}

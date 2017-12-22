package com.app.mvc.service;

import java.util.List;

import com.app.mvc.entity.Enseignant;
import com.app.mvc.entity.RoleUser;
import com.app.mvc.entity.User;

public interface IServiceRoleUser {

	public RoleUser save(RoleUser entity);

	public RoleUser findById(Long id);

	public boolean existsById(Long id);

	public Iterable<RoleUser> findAll();

	public void deleteById(Long id);

	public void delete(RoleUser entitys);

	public RoleUser update(RoleUser entity);

	public void saveRoleUser(Enseignant user);
	
	public void saveAllRoleUser(List<Enseignant> user);

	public void saveRoleAdmin(User User);
	
	public void updateToAdmin(Long iduser);

	public void updateToUser(Long iduser);

}
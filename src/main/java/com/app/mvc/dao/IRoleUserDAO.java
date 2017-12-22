package com.app.mvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.mvc.entity.Enseignant;
import com.app.mvc.entity.RoleUser;
import com.app.mvc.entity.User;

public interface IRoleUserDAO extends CrudRepository<RoleUser, Long> {

	public RoleUser update(RoleUser entity);

	public void updateToAdmin(Long iduser);

	public void updateToUser(Long iduser);

	public void saveRoleUser(Enseignant user);

	public void saveRoleAdmin(User User);
	
	public void saveAllRoleUser(List<Enseignant> user);


}

package com.app.mvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.mvc.entity.Enseignant;

public interface IEnseignantDAO extends CrudRepository<Enseignant, Long> {

	public Enseignant findEnsById(Long id);

	public Enseignant update(Enseignant entity);

	public void saveAll(List<Enseignant> entities);
	
	public Boolean findByMail(String mail);
		
	public Enseignant FindByUsername(String username);
	
	public Enseignant findBypassword(String password,String mail);

}

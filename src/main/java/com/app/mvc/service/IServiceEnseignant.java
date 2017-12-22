package com.app.mvc.service;

import java.util.List;

import com.app.mvc.entity.Enseignant;

public interface IServiceEnseignant {

	public Enseignant findEnsById(Long id);

	public void delete(Enseignant entity);

	public Iterable<Enseignant> findAll();

	public Enseignant save(Enseignant entity);

	public Enseignant update(Enseignant entity);

	public Enseignant findById(Long id);

	public void saveAll(List<Enseignant> entities);

	public Boolean findByMail(String mail);

	public Enseignant findBypassword(String password, String mail);

	public Enseignant FindByUsername(String username);
}

package com.app.mvc.service;

import java.util.List;

import com.app.mvc.entity.Semestre;

public interface IServiceSemestre {
	public Semestre save(Semestre entity);

	public Semestre update(Semestre entity);

	public Semestre findById(Long id);

	public boolean existsById(Long id);

	public Iterable<Semestre> findAll();

	public void deleteById(Long id);

	public void delete(Semestre entity);
	
	public List<Semestre> findAllByDate();

}

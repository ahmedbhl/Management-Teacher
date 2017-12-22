package com.app.mvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.mvc.entity.Semestre;

public interface ISemestreDAO extends CrudRepository<Semestre, Long>{

	public Semestre update(Semestre entity);
	
	public List<Semestre> findAllByDate();

}

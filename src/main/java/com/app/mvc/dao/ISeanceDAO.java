package com.app.mvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.mvc.entity.Seance;

public interface ISeanceDAO extends CrudRepository<Seance, Long> {

	public Seance update(Seance entity);

	public List<Seance> findAllById(Long id);

}

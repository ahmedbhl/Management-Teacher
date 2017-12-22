package com.app.mvc.service;

import java.util.List;

import com.app.mvc.entity.Seance;

public interface IServiceSeance {
	public Seance save(Seance entity);

	public Seance update(Seance entity);

	public Seance findById(Long id);

	public Iterable<Seance> findAll();

	public void deleteById(Long id);

	public void delete(Seance entity);

	public List<Seance> findAllById(Long id);

}

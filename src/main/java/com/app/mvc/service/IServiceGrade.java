
package com.app.mvc.service;

import com.app.mvc.entity.Grade;

public interface IServiceGrade {

	public Grade save(Grade entity);

	public Grade findById(Long id);

	public boolean existsById(Long id);

	public Iterable<Grade> findAll();

	public void deleteById(Long id);

	public void delete(Grade grades);

	public Grade update(Grade entity);

}

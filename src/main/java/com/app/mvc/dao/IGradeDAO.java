package com.app.mvc.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.mvc.entity.Grade;

public interface IGradeDAO extends CrudRepository<Grade, Long> {

	public Grade update(Grade entity);

}

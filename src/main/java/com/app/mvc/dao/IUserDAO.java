package com.app.mvc.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.mvc.entity.User;

public interface IUserDAO extends CrudRepository<User, Long> {

	public User update(User entity);

	public User findBypassword(String password, String mail);

	public Boolean findByMail(String mail);

}

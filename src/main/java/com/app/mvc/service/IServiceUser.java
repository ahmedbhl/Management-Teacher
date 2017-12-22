package com.app.mvc.service;

import com.app.mvc.entity.User;

public interface IServiceUser {

	public User save(User entity);

	public User findById(Long id);

	public boolean existsById(Long id);

	public Iterable<User> findAll();

	public void deleteById(Long id);

	public void delete(User entity);

	public void update(User entity);

	public User findBypassword(String password, String mail);

	public Boolean findByMail(String mail);

}

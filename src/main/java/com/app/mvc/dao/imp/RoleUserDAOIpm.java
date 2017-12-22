package com.app.mvc.dao.imp;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.app.mvc.dao.IRoleUserDAO;
import com.app.mvc.entity.Enseignant;
import com.app.mvc.entity.RoleUser;
import com.app.mvc.entity.User;

public class RoleUserDAOIpm implements IRoleUserDAO {

	@PersistenceContext
	EntityManager em;
	private static final String ROLE_USER = "ROLE_USER";
	private static final String ROLE_ADMIN = "ROLE_ADMIN";

	@Override
	public <S extends RoleUser> S save(S entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public RoleUser update(RoleUser entity) {
		em.merge(entity);
		return entity;
	}

	@Override
	public <S extends RoleUser> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<RoleUser> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(em.find(RoleUser.class, id));
	}

	@Override
	public boolean existsById(Long id) {
		if (em.find(RoleUser.class, id) != null) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<RoleUser> findAll() {
		Iterable<RoleUser> RoleUsers;
		Query q = em.createQuery("from RoleUser g");
		RoleUsers = q.getResultList();
		return RoleUsers;
	}

	@Override
	public Iterable<RoleUser> findAllById(Iterable<Long> ids) {
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		if (existsById(id)) {
			em.remove(em.find(RoleUser.class, id));
		}
	}

	@Override
	public void delete(RoleUser entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void deleteAll(Iterable<? extends RoleUser> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveRoleUser(Enseignant user) {

		em.persist(new RoleUser(ROLE_USER, user));
	}

	@Override
	public void saveRoleAdmin(User user) {
		em.persist(new RoleUser(ROLE_ADMIN, user));

	}

	@Override
	public void updateToAdmin(Long iduser) {
		RoleUser roleuser = em.find(RoleUser.class, iduser);
		roleuser.setRoleName(ROLE_ADMIN);
		em.merge(roleuser);
	}

	@Override
	public void updateToUser(Long iduser) {
		RoleUser roleuser = em.find(RoleUser.class, iduser);
		roleuser.setRoleName(ROLE_USER);
		em.merge(roleuser);

	}

	@Override
	public void saveAllRoleUser(List<Enseignant> user) {

		for (Enseignant enseignant : user) {
			
			em.persist(new RoleUser(ROLE_USER, enseignant));
		}

	}

}

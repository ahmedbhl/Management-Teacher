package com.app.mvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class RoleUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRoleuser;
	private String roleName;
	@ManyToOne
	@JoinColumn(name = "idutilisateur")
	private Utilisateur user;
	
	@Transient
	private String nameOfRole;

	public RoleUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleUser(String roleName, Utilisateur user) {
		super();
		this.roleName = roleName;
		this.user = user;
	}

	public Long getIdRoleuser() {
		return idRoleuser;
	}

	public void setIdRoleuser(Long idRoleuser) {
		this.idRoleuser = idRoleuser;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public String getNameOfRole() {
		return nameOfRole.substring(5);
	}

	public void setNameOfRole(String nameOfRole) {
		this.nameOfRole = nameOfRole;
	}
	

}

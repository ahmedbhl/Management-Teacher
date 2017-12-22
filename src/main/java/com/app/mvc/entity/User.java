package com.app.mvc.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
// @PrimaryKeyJoinColumn(name="idutilisateur")
public class User extends Utilisateur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}

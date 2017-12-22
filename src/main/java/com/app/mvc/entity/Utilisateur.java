package com.app.mvc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idutilisateur;
	@Column(unique = true)
	@Email
	@NotNull(message = "Champ obligatoire")
	@Pattern(regexp="^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w{2,}([-.]\\w+)*$",message="Le champ doit être une adresse e-mail")
	private String mail;
	private String password;
	@NotNull(message = "Champ obligatoire")
	@Size(min=3, max = 13, message = "Le nom doit comporter entre 3 et 13 caractères")
	private String nom;
	@Size(min=3, max = 13, message = "Le prenom doit comporter entre 3 et 13 caractères")
	@NotNull(message = "Champ obligatoire")
	private String prenom;

	@OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE })
	private List<RoleUser> roleUsers;
	private boolean Actived;
	@Transient
	private Boolean etat;

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(Long idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<RoleUser> getRoleUsers() {
		return roleUsers;
	}

	public void setRoleUsers(List<RoleUser> roleUsers) {
		this.roleUsers = roleUsers;
	}

	public boolean isActived() {
		return Actived;
	}

	public void setActived(boolean actived) {
		Actived = actived;
	}

	public Boolean getEtat() {
		return isActived();
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

}

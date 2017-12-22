package com.app.mvc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Enseignant extends Utilisateur {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3576105270128610030L;

	@Transient
	private String fullName;
	// @Pattern(regexp = "[0-9]+")
	// @NumberFormat(style = Style.NUMBER)
	@NotNull(message = "Champ Obligatoir")
	private Long RIB;
	@OneToMany(mappedBy = "enseignant", cascade = { CascadeType.REMOVE })
	private Set<ChargeEnseignant> chargeEnseignant;

	@NotNull(message = "Champ Obligatoir")
	// @Valid
	@ManyToOne
	@JoinColumn(name = "idGrade")
	private Grade Grade;

	public Enseignant() {
		super();
	}

	public Long getRIB() {
		return RIB;
	}

	public void setRIB(Long rIB) {
		RIB = rIB;
	}

	public Set<ChargeEnseignant> getChargeEnseignant() {
		return chargeEnseignant;
	}

	public void setChargeEnseignant(Set<ChargeEnseignant> chargeEnseignant) {
		this.chargeEnseignant = chargeEnseignant;
	}

	public Grade getGrade() {
		return Grade;
	}

	public void setGrade(Grade grade) {
		Grade = grade;
	}

	public String getFullName() {
		return getNom() + " " + getPrenom();
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}

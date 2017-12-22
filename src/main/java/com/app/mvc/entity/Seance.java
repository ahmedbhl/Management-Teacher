package com.app.mvc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Seance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSeance;
	@NotNull(message = "Champ obligatoire")
	@Size(min = 2, max = 40)
	private String nomSeance;
	@NotNull(message = "Champ obligatoire")
	@Max(6)
	private int nbreSeance;
	@NotNull(message = "Champ obligatoire")
	@Temporal(TemporalType.DATE)
	private Date date;
	@NotNull(message = "Champ obligatoire")
	private Boolean absence;
	@Transient
	private Boolean oldAbsence;
	@NotNull(message = "Champ obligatoire")
	@ManyToOne
	@JoinColumn(name = "idChargeEnseignant")
	private ChargeEnseignant chargeEnseignant;
	@NotNull(message = "Champ obligatoire")
	private String type;
	@NotNull(message = "Champ obligatoire")
	@NotEmpty.List(value = { @NotEmpty })
	@ElementCollection(targetClass = String.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<String> heureSeances;

	public Seance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(Long idSeance) {
		this.idSeance = idSeance;
	}

	public String getNomSeance() {
		return nomSeance;
	}

	public void setNomSeance(String nomSeance) {
		this.nomSeance = nomSeance;
	}

	public int getNbreSeance() {
		return nbreSeance;
	}

	public void setNbreSeance(int nbreSeance) {
		this.nbreSeance = nbreSeance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getAbsence() {
		return absence;
	}

	public void setAbsence(Boolean absence) {
		this.absence = absence;
	}

	public ChargeEnseignant getChargeEnseignant() {
		return chargeEnseignant;
	}

	public void setChargeEnseignant(ChargeEnseignant chargeEnseignant) {
		this.chargeEnseignant = chargeEnseignant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getHeureSeances() {
		return heureSeances;
	}

	public void setHeureSeances(List<String> heureSeances) {
		this.heureSeances = heureSeances;
	}

	public Boolean getOldAbsence() {
		return oldAbsence;
	}

	public void setOldAbsence(Boolean oldAbsence) {
		this.oldAbsence = oldAbsence;
	}

}

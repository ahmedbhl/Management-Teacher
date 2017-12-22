package com.app.mvc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class ChargeEnseignant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idChargeEnseignant;
	
	@NotNull(message = "Champ obligatoire")
	@ManyToOne
	@JoinColumn(name = "idutilisateur")
	private Enseignant enseignant;
	
	@NotNull(message = "Champ obligatoire")
	@ManyToOne
	@JoinColumn(name = "idSemestre")
	private Semestre semestre;
	@NotNull(message = "Champ obligatoire")
	@Min(1)
	private Double nbreTdTot=0.0;
	@NotNull(message = "Champ obligatoire")
	@Min(1)
	private Double nbreTpTot=0.0;
	@NotNull(message = "Champ obligatoire")
	@Min(1)
	private Double nbreCoursTot=0.0;
	
	private Double nbreAnsenceTdTot=0.0;
	private Double nbreAnsenceTpTot=0.0;
	private Double nbreAnsenceCoursTot=0.0;   
	private Double SalaireNet=0.0;
	private Double SalaireBrut=0.0;
	@OneToMany(mappedBy = "chargeEnseignant", cascade = { CascadeType.REMOVE},fetch = FetchType.EAGER)
	private List<Seance> seances;

	public ChargeEnseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChargeEnseignant(Long idChargeEnseignant) {
		super();
		this.idChargeEnseignant = idChargeEnseignant;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Double getNbreTdTot() {
		return nbreTdTot;
	}

	public void setNbreTdTot(Double nbreTdTot) {
		this.nbreTdTot = nbreTdTot;
	}

	public Double getNbreTpTot() {
		return nbreTpTot;
	}

	public void setNbreTpTot(Double nbreTpTot) {
		this.nbreTpTot = nbreTpTot;
	}

	public Double getNbreCoursTot() {
		return nbreCoursTot;
	}

	public void setNbreCoursTot(Double nbreCoursTot) {
		this.nbreCoursTot = nbreCoursTot;
	}

	public Double getSalaireNet() {
		return SalaireNet;
	}

	public void setSalaireNet(Double salaireNet) {
		SalaireNet = salaireNet;
	}

	public Double getSalaireBrut() {
		return SalaireBrut;
	}

	public void setSalaireBrut(Double salaireBrut) {
		SalaireBrut = salaireBrut;
	}

	public Long getIdChargeEnseignant() {
		return idChargeEnseignant;
	}

	public void setIdChargeEnseignant(Long idChargeEnseignant) {
		this.idChargeEnseignant = idChargeEnseignant;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public Double getNbreAnsenceTdTot() {
		return nbreAnsenceTdTot;
	}

	public void setNbreAnsenceTdTot(Double nbreAnsenceTdTot) {
		this.nbreAnsenceTdTot = nbreAnsenceTdTot;
	}

	public Double getNbreAnsenceTpTot() {
		return nbreAnsenceTpTot;
	}

	public void setNbreAnsenceTpTot(Double nbreAnsenceTpTot) {
		this.nbreAnsenceTpTot = nbreAnsenceTpTot;
	}

	public Double getNbreAnsenceCoursTot() {
		return nbreAnsenceCoursTot;
	}

	public void setNbreAnsenceCoursTot(Double nbreAnsenceCoursTot) {
		this.nbreAnsenceCoursTot = nbreAnsenceCoursTot;
	}
	
}

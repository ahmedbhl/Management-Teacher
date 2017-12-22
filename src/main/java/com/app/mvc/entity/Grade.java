package com.app.mvc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idGrade;
	@NotNull(message = "Champ obligatoire")
	@Size(min=4,max=10)
	private String description;
	@NotNull(message = "Champ obligatoire")
	@Min(1)
	private Double prixTdH=0.0;
	@NotNull(message = "Champ obligatoire")
	@Min(1)
	private Double prixTpH=0.0;
	@NotNull(message = "Champ obligatoire")
	@Min(1)
	private Double prixCoursH=0.0;
	@OneToMany(mappedBy = "Grade",cascade={CascadeType.REMOVE})
	private List<Enseignant> enseignants;

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdGrade() {
		return idGrade;
	}

	public void setIdGrade(Long idGrade) {
		this.idGrade = idGrade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrixTdH() {
		return prixTdH;
	}

	public void setPrixTdH(Double prixTdH) {
		this.prixTdH = prixTdH;
	}

	public Double getPrixTpH() {
		return prixTpH;
	}

	public void setPrixTpH(Double prixTpH) {
		this.prixTpH = prixTpH;
	}

	public Double getPrixCoursH() {
		return prixCoursH;
	}

	public void setPrixCoursH(Double prixCoursH) {
		this.prixCoursH = prixCoursH;
	}

	public List<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

}

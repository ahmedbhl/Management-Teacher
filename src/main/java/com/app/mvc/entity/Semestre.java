package com.app.mvc.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Semestre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSemestre;
	@NotNull(message = "Champ obligatoire")
	@Size(min = 6, message = "La description doit contenir au moins 6 caractères")
	private String description;
	@NotNull(message = "Champ obligatoire")
	// @Past(message = "La Date de début doit être inférieur a la date de fin")
	@Temporal(TemporalType.DATE)
	private Date date_deb;
	@NotNull(message = "Champ obligatoire")
	@Future(message = "La date de fin doit se situer dans le futur")
	@Temporal(TemporalType.DATE)
	private Date date_fin;
	@OneToMany(mappedBy = "semestre", cascade = { CascadeType.REMOVE })
	private List<ChargeEnseignant> ChargeEnseignant;
	
	private String fullDescription;

	public Semestre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(Long idSemestre) {
		this.idSemestre = idSemestre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_deb() {
		return date_deb;
	}

	public void setDate_deb(Date date_deb) {
		this.date_deb = date_deb;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public List<ChargeEnseignant> getChargeEnseignant() {
		return ChargeEnseignant;
	}

	public void setChargeEnseignant(List<ChargeEnseignant> chargeEnseignant) {
		ChargeEnseignant = chargeEnseignant;
	}

	public String getFullDescription() {
		int month= Integer.parseInt(new SimpleDateFormat("MM").format(getDate_deb()));
		String df;
		String db;
		if(month<8)
		{
			 df=String.valueOf(Integer.parseInt(new SimpleDateFormat("yyyy").format(getDate_fin())));
			 db=String.valueOf(Integer.parseInt(new SimpleDateFormat("yyyy").format(getDate_deb()))-1);
		}
		else
		{
			 df=String.valueOf(Integer.parseInt(new SimpleDateFormat("yyyy").format(getDate_fin()))+1);
			 db=String.valueOf(Integer.parseInt(new SimpleDateFormat("yyyy").format(getDate_deb())));
		}
		
		
		fullDescription =getDescription()+" | "+db+"-"+df ;
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

}

package com.app.mvc.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.mvc.entity.ChargeEnseignant;

public interface IChargeEnseignantDAO extends CrudRepository<ChargeEnseignant, Long> {

	public ChargeEnseignant update(ChargeEnseignant entity);

	public void updateAbsence(Long id, int nobmreAbs, String typeSeance, Boolean absence, String action,
			Boolean oldAbsence);

	public Boolean isExistChBySemestre(ChargeEnseignant charge);

	public Iterable<ChargeEnseignant> findAllById(Long ids);

}

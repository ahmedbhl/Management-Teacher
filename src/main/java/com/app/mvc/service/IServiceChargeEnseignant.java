package com.app.mvc.service;

import com.app.mvc.entity.ChargeEnseignant;

public interface IServiceChargeEnseignant {

	public ChargeEnseignant save(ChargeEnseignant entity);

	public void delete(ChargeEnseignant entity);

	public Iterable<ChargeEnseignant> findAll();

	public ChargeEnseignant update(ChargeEnseignant entity);

	public ChargeEnseignant findById(Long id);

	public void updateAbsence(Long id, int nobmreAbs, String typeSeance, Boolean absence, String action,Boolean oldAbsence);
	
	public Iterable<ChargeEnseignant> findAllById(Long ids);


}

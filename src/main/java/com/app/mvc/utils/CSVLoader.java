package com.app.mvc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.mvc.dao.IEnseignantDAO;
import com.app.mvc.entity.Enseignant;

public class CSVLoader {

	@PersistenceContext
	EntityManager em;
	CryptPassword cryptMD5;
	String line = "";
	String cvsSplitBy = ";";
	
	@Autowired
	IEnseignantDAO IEnseignantDAO;

	public void setCryptMD5(CryptPassword cryptMD5) {
		this.cryptMD5 = cryptMD5;
	}

	public CSVLoader() {
		super();

	}

	public List<Enseignant> readCsvUsingLoad(InputStream csvFile) {
		List<Enseignant> enseigants = new ArrayList<Enseignant>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] enseignantcsv = line.split(cvsSplitBy);
				Enseignant ens=getEnseignant(enseignantcsv);
				if(!IEnseignantDAO.findByMail(ens.getMail()))
				{
				enseigants.add(ens);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return enseigants;
	}

	public Enseignant getEnseignant(String[] enseignantcsv) throws NumberFormatException, IOException {
		Enseignant enseignant = new Enseignant();
		enseignant.setActived(false);
		enseignant.setNom(enseignantcsv[1]);
		enseignant.setPrenom(enseignantcsv[2]);
		enseignant.setMail(enseignantcsv[0]);
		enseignant.setRIB(Long.parseLong(enseignantcsv[3]));
		enseignant.setPassword(cryptMD5.getCryptedPassword(enseignantcsv[4].toString()));
		return enseignant;
	}

	public Boolean checkRib(InputStream csvFile) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] enseignantcsv = line.split(cvsSplitBy);
				try {
					Long.parseLong(enseignantcsv[3]);
				} catch (Exception e) {
					return false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

}

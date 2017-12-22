package com.app.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.mvc.entity.ChargeEnseignant;
import com.app.mvc.entity.Enseignant;
import com.app.mvc.entity.Seance;
import com.app.mvc.service.IServiceChargeEnseignant;
import com.app.mvc.service.IServiceEnseignant;
import com.app.mvc.service.IServiceSeance;

@Controller
@RequestMapping(value = "/user")
public class CurrentUserController {

	@Autowired
	IServiceChargeEnseignant IServiceChargeEnseignant;
	@Autowired
	IServiceEnseignant IServiceEnseignant;
	@Autowired
	IServiceSeance IServiceSeance;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Enseignant enseignant = IServiceEnseignant.FindByUsername(authentication.getName());
		model.addAttribute("user", enseignant);
		return "HomeUser/home";
	}

	@RequestMapping("/charges")
	public String getListChargeEnseignantUser(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Enseignant enseignant = IServiceEnseignant.FindByUsername(authentication.getName());
		Iterable<ChargeEnseignant> chenseignants = IServiceChargeEnseignant.findAllById(enseignant.getIdutilisateur());

		model.addAttribute("listechargeens", chenseignants);
		return "HomeUser/charge";
	}

	@RequestMapping("/seances")
	public String getListSeances(Model model) {
		List<Seance> seances = new ArrayList<Seance>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Enseignant enseignant = IServiceEnseignant.FindByUsername(authentication.getName());
		Iterable<ChargeEnseignant> chenseignants = IServiceChargeEnseignant.findAllById(enseignant.getIdutilisateur());
		for (ChargeEnseignant chargeEnseignant : chenseignants) {
			seances.addAll(IServiceSeance.findAllById(chargeEnseignant.getIdChargeEnseignant()));
		}
		model.addAttribute("listeseances", seances);
		return "HomeUser/seances";
	}
	
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public String details(Model model, @PathVariable("id") Long idChargeEseignant) {
		if (idChargeEseignant != null) {
			ChargeEnseignant chargeEnseignant = IServiceChargeEnseignant.findById(idChargeEseignant);
			if (chargeEnseignant != null) {
				model.addAttribute("chargeenseignant", chargeEnseignant);
			}

		}
		return "HomeUser/detail";

	}

}

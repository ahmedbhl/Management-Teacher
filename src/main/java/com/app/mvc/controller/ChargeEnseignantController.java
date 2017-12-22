package com.app.mvc.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.mvc.entity.ChargeEnseignant;
import com.app.mvc.entity.Enseignant;
import com.app.mvc.entity.Semestre;
import com.app.mvc.service.IServiceChargeEnseignant;
import com.app.mvc.service.IServiceEnseignant;
import com.app.mvc.service.IServiceSemestre;

@Controller
@RequestMapping(value = "/chargeEnseignants")
public class ChargeEnseignantController {
	@Autowired
	IServiceChargeEnseignant IServiceChargeEnseignant;
	@Autowired
	IServiceEnseignant IServiceEnseignant;
	@Autowired
	IServiceSemestre IServiceSemestre;

	@RequestMapping("/")
	public String getListChargeEnseignant(Model model) {
		Iterable<ChargeEnseignant> chenseignants = IServiceChargeEnseignant.findAll();

		if (chenseignants == null) {
			chenseignants = new ArrayList<ChargeEnseignant>();
		}
		model.addAttribute("listechargeens", chenseignants);
		return "chargeEnseignant/chargeEnseignants";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterChargerEnseignant(Model model) {
		ChargeEnseignant chargeenseignant = new ChargeEnseignant();
		Iterable<Enseignant> enseignants = IServiceEnseignant.findAll();
		Iterable<Semestre> Semestres = IServiceSemestre.findAllByDate();
		if (enseignants == null) {
			enseignants = new ArrayList<Enseignant>();
		}
		if (Semestres == null) {
			Semestres = new ArrayList<Semestre>();
		}
		model.addAttribute("Semestres", Semestres);
		model.addAttribute("enseignants", enseignants);
		model.addAttribute("chargeenseignant", chargeenseignant);
		return "chargeEnseignant/ajouterChargeEseignant";

	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String save(Model model, @Valid @ModelAttribute("chargeenseignant") ChargeEnseignant chargeenseignant, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			Iterable<Enseignant> enseignants = IServiceEnseignant.findAll();
			Iterable<Semestre> Semestres = IServiceSemestre.findAllByDate();
			if (enseignants == null) {
				enseignants = new ArrayList<Enseignant>();
			}
			if (Semestres == null) {
				Semestres = new ArrayList<Semestre>();
			}
			model.addAttribute("Semestres", Semestres);
			model.addAttribute("enseignants", enseignants);
			return "chargeEnseignant/ajouterChargeEseignant";
		} else {
			if (chargeenseignant != null) {
				if (chargeenseignant.getIdChargeEnseignant() != null) {
					IServiceChargeEnseignant.update(chargeenseignant);
					redirectAttributes.addFlashAttribute("successMsg",
							"Le Charge d'enseignant a été modifié avec succès");
				} else {

					IServiceChargeEnseignant.save(chargeenseignant);
					redirectAttributes.addFlashAttribute("successMsg",
							"Le Charge d'enseignant a été ajouté avec succès");
				}
			}
		}
		return "redirect:/chargeEnseignants/";

	}

	@RequestMapping(value = "/modifier/{id}", method = RequestMethod.GET)
	public String update(Model model, @PathVariable("id") Long idChargeEseignant) {

		if (idChargeEseignant != null) {
			ChargeEnseignant chargeEnseignant = IServiceChargeEnseignant.findById(idChargeEseignant);
			Iterable<Enseignant> enseignants = IServiceEnseignant.findAll();
			Iterable<Semestre> Semestres = IServiceSemestre.findAllByDate();
			if (enseignants == null) {
				enseignants = new ArrayList<Enseignant>();
			}
			if (Semestres == null) {
				Semestres = new ArrayList<Semestre>();
			}
			model.addAttribute("Semestres", Semestres);
			model.addAttribute("enseignants", enseignants);
			if (chargeEnseignant != null) {
				model.addAttribute("chargeenseignant", chargeEnseignant);
			}
		}
		return "chargeEnseignant/updateChargeEnseignant";

	}

	@RequestMapping(value = "/supprimer/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable("id") Long idChargeEseignant) {
		if (idChargeEseignant != null) {
			ChargeEnseignant chargeEnseignant = IServiceChargeEnseignant.findById(idChargeEseignant);
			if (chargeEnseignant != null) {
				IServiceChargeEnseignant.delete(chargeEnseignant);
			}

		}
		return "redirect:/chargeEnseignants/";

	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public String details(Model model, @PathVariable("id") Long idChargeEseignant) {
		if (idChargeEseignant != null) {
			ChargeEnseignant chargeEnseignant = IServiceChargeEnseignant.findById(idChargeEseignant);
			if (chargeEnseignant != null) {
				model.addAttribute("chargeenseignant", chargeEnseignant);
			}

		}
		return "chargeEnseignant/detaills";

	}

}

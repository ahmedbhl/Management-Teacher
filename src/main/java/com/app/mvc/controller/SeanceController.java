package com.app.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.mvc.entity.ChargeEnseignant;
import com.app.mvc.entity.Seance;
import com.app.mvc.service.IServiceChargeEnseignant;
import com.app.mvc.service.IServiceSeance;

@Controller
@RequestMapping(value = "seances")
public class SeanceController {
	@Autowired
	IServiceSeance IServiceSeance;

	@Autowired
	IServiceChargeEnseignant IServiceChargeEnseignant;

	@InitBinder
	public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/")
	public String getListSeance(Model model) {
		Iterable<Seance> seances = IServiceSeance.findAll();
		model.addAttribute("listeseances", seances);
		return "Seance/seance";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterSeance(Model model) {
		Seance seance = new Seance();
		Iterable<ChargeEnseignant> chargeEnseignant = IServiceChargeEnseignant.findAll();
		if (chargeEnseignant == null) {
			chargeEnseignant = new ArrayList<ChargeEnseignant>();
		}
		model.addAttribute("seance", seance);
		model.addAttribute("chargeEnseignants", chargeEnseignant);
		return "Seance/ajouterSeance";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String saveEnseignant(Model model, @Valid Seance seance, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			Iterable<ChargeEnseignant> chargeEnseignant = IServiceChargeEnseignant.findAll();
			if (chargeEnseignant == null) {
				chargeEnseignant = new ArrayList<ChargeEnseignant>();
			}
			model.addAttribute("chargeEnseignants", chargeEnseignant);
			return "Seance/ajouterSeance";
		} else {
			if (seance != null) {
				if (seance.getIdSeance() != null) {
					seance.setNbreSeance(seance.getHeureSeances().size());
					IServiceSeance.update(seance);
					IServiceChargeEnseignant.updateAbsence(seance.getChargeEnseignant().getIdChargeEnseignant(),
							seance.getNbreSeance(), seance.getType(), seance.getAbsence(), "update",
							seance.getOldAbsence());
				} else {
					if (seance != null) {
						seance.setNbreSeance(seance.getHeureSeances().size());
					}
					IServiceSeance.save(seance);
					IServiceChargeEnseignant.updateAbsence(seance.getChargeEnseignant().getIdChargeEnseignant(),
							seance.getNbreSeance(), seance.getType(), seance.getAbsence(), "add",
							seance.getOldAbsence());
				}
			}
		}
		return "redirect:/seances/";
	}

	@RequestMapping("/supprimer/{id}")
	public String deleteEnseignant(@PathVariable("id") Long idSeance, Model model) {
		if (idSeance != null) {
			Seance seance = IServiceSeance.findById(idSeance);
			if (seance != null) {
				IServiceChargeEnseignant.updateAbsence(seance.getChargeEnseignant().getIdChargeEnseignant(),
						seance.getNbreSeance(), seance.getType(), seance.getAbsence(), "remove",
						seance.getOldAbsence());
				IServiceSeance.delete(seance);

			}
		}
		return "redirect:/seances/";
	}

	@RequestMapping("/modifier/{id}")
	public String updateEnseignant(@PathVariable("id") Long idSeance, Model model) {
		if (idSeance != null) {

			Seance seance = IServiceSeance.findById(idSeance);
			Iterable<ChargeEnseignant> chargeEnseignant = IServiceChargeEnseignant.findAll();
			if (chargeEnseignant == null) {
				chargeEnseignant = new ArrayList<ChargeEnseignant>();
			}
			model.addAttribute("chargeEnseignants", chargeEnseignant);
			if (seance != null) {
				seance.setOldAbsence(seance.getAbsence());
				model.addAttribute("seance", seance);
			}
		}
		return "Seance/updateSeance";
	}

	@RequestMapping("/modifierEtat/{id}")
	public String modifierEtat(@PathVariable("id") Long idSeance, Model model) {
		if (idSeance != null) {

			Seance seance = IServiceSeance.findById(idSeance);
			if (seance != null) {
				seance.setOldAbsence(seance.getAbsence());
				seance.setAbsence(!seance.getAbsence());
				IServiceSeance.update(seance);
				IServiceChargeEnseignant.updateAbsence(seance.getChargeEnseignant().getIdChargeEnseignant(),
						seance.getNbreSeance(), seance.getType(), seance.getAbsence(), "update",
						seance.getOldAbsence());

			}
		}
		return "redirect:/seances/";
	}

}

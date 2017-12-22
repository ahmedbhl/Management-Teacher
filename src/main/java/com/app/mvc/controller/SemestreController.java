package com.app.mvc.controller;

import java.text.SimpleDateFormat;
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

import com.app.mvc.entity.Semestre;
import com.app.mvc.service.IServiceSemestre;

@Controller
@RequestMapping(value = "/semestres")
public class SemestreController {
	@Autowired
	IServiceSemestre IServiceSemestre;

	@InitBinder
	public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/")
	public String getListSemestre(Model model) {
		Iterable<Semestre> semestres = IServiceSemestre.findAll();
		model.addAttribute("listesemestres", semestres);
		return "Semestre/semestre";

	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterSemestre(Model model) {
		Semestre semestre = new Semestre();
		model.addAttribute("semestre", semestre);
		return "Semestre/ajouterSemestre";

	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String save(@Valid Semestre semestre, BindingResult result, RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {

			return "Semestre/ajouterSemestre";
		} else {
			if (semestre != null) {
				if (semestre.getIdSemestre() != null) {
					IServiceSemestre.update(semestre);
					redirectAttributes.addFlashAttribute("successMsg", "Le semestre a été modifié avec succès");
				} else {
					IServiceSemestre.save(semestre);
					redirectAttributes.addFlashAttribute("successMsg", "Le semestre a été ajouté avec succès");
				}
			}
		}
		return "redirect:/semestres/";
	}

	@RequestMapping(value = "/modifier/{idsemestre}")
	public String edit(Model model, @PathVariable("idsemestre") Long id) {
		if (id != null) {
			Semestre semestre = IServiceSemestre.findById(id);
			if (semestre != null) {
				model.addAttribute("semestre", semestre);
			}
		}
		return "Semestre/ajouterSemestre";
	}

	@RequestMapping(value = "/supprimer/{idsemestre}")
	public String delete(Model model, @PathVariable("idsemestre") Long id) {
		if (id != null) {
			Semestre semestre = IServiceSemestre.findById(id);
			if (semestre != null) {
				IServiceSemestre.delete(semestre);
			}
		}
		return "redirect:/semestres/";
	}

}
package com.app.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.mvc.entity.Grade;
import com.app.mvc.service.IServiceGrade;

@Controller
@RequestMapping(value = "/grades")
public class GradeController {
	@Autowired
	IServiceGrade IServiceGrade;

	@RequestMapping("/")
	public String getListGrade(Model model) {
		Iterable<Grade> grade = IServiceGrade.findAll();
		model.addAttribute("listegrades", grade);
		return "Grade/grade";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String save(Model model,@Valid Grade grade,BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {

			return "Grade/ajouterGrade";
		} else {
		if (grade != null) {
			if (grade.getIdGrade() != null) {
				IServiceGrade.update(grade);
			} else {
				IServiceGrade.save(grade);
			}
		}
		}
		return "redirect:/grades/";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String AjouterGrade(Model model) {
		Grade grade = new Grade();
		model.addAttribute("grade", grade);
		return "Grade/ajouterGrade";
	}

	@RequestMapping(value = "/modifier/{id}", method = RequestMethod.GET)
	public String updateGrade(Model model, @PathVariable("id") Long idGrade) {
		if (idGrade != null) {
			Grade grade = IServiceGrade.findById(idGrade);
			if (grade != null) {
				model.addAttribute("grade", grade);
			}

		}
		return "Grade/ajouterGrade";
	}

	@RequestMapping("/supprimer/{id}")
	public String deleteGrade(@PathVariable("id") Long idGrade) {
		if (idGrade != null) {
			Grade grades = IServiceGrade.findById(idGrade);
			if (grades != null) {
				IServiceGrade.delete(grades);
			}
		}
		return "redirect:/grades/";
	}

}

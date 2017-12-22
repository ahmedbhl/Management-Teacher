package com.app.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.mvc.entity.Enseignant;
import com.app.mvc.entity.Grade;
import com.app.mvc.service.IServiceEnseignant;
import com.app.mvc.service.IServiceGrade;
import com.app.mvc.service.IServiceRoleUser;
import com.app.mvc.utils.CSVLoader;
import com.app.mvc.utils.CryptPassword;
import com.app.mvc.utils.SendMailTLS;

@Controller
@RequestMapping(value = "/enseignants")
public class EnseignantController {

	@Autowired
	IServiceEnseignant IServiceEnseignant;
	@Autowired
	IServiceGrade IServiceGrade;
	@Autowired
	IServiceRoleUser IServiceRoleUser;
	@Autowired
	CryptPassword CryptPassword;
	@Autowired
	SendMailTLS SendMailTLS;
	@Autowired
	CSVLoader CSVLoader;

	@RequestMapping("/")
	public String getListEnseignant(Model model) {
		Iterable<Enseignant> enseignants = IServiceEnseignant.findAll();
		model.addAttribute("listeens", enseignants);
		return "enseignant/enseignants";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterEnseignant(Model model) {
		Enseignant enseignant = new Enseignant();
		model.addAttribute("enseignant", enseignant);
		Iterable<Grade> grades = IServiceGrade.findAll();
		if (grades == null) {
			grades = new ArrayList<Grade>();
		}
		model.addAttribute("grades", grades);
		return "enseignant/ajouterEnseignant";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String saveEnseignant(Model model,@Valid Enseignant enseignant,BindingResult result, RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			Iterable<Grade> grades = IServiceGrade.findAll();
			if (grades == null) {
				grades = new ArrayList<Grade>();
			}
			model.addAttribute("grades", grades);
			return "enseignant/ajouterEnseignant";
		} else {

		if (enseignant != null) {
			if(IServiceEnseignant.findByMail(enseignant.getMail()))
			{
				result.rejectValue("mail", "error.enseignant", "Un enseignant existe déjà pour cet e-mail.");
				Iterable<Grade> grades = IServiceGrade.findAll();
				if (grades == null) {
					grades = new ArrayList<Grade>();
				}
				model.addAttribute("grades", grades);
				return "enseignant/ajouterEnseignant";
			}
			if (enseignant.getIdutilisateur() != null) {
				IServiceEnseignant.update(enseignant);
				redirectAttributes.addFlashAttribute("successMsg", "L'enseignant a été modifié avec succès");
			} else {
				
				enseignant.setPassword(CryptPassword.getCryptedPassword(enseignant.getPassword()));
				IServiceEnseignant.save(enseignant);
				IServiceRoleUser.saveRoleUser(enseignant);
				redirectAttributes.addFlashAttribute("successMsg", "L'enseignant a été ajouté avec succès");

			}
		}
		}
		return "redirect:/enseignants/";
		
	}

	@RequestMapping("/supprimer/{id}")
	public String deleteEnseignant(@PathVariable("id") Long idEnseignant, Model model) {
		if (idEnseignant != null) {
			Enseignant enseignant = IServiceEnseignant.findEnsById(idEnseignant);
			if (enseignant != null) {
				IServiceEnseignant.delete(enseignant);
			}
		}
		return "redirect:/enseignants/";
	}

	@RequestMapping("/modifier/{id}")
	public String updateEnseignant(@PathVariable("id") Long idEnseignant, Model model) {
		if (idEnseignant != null) {

			Enseignant enseignant = IServiceEnseignant.findById(idEnseignant);
			Iterable<Grade> grades = IServiceGrade.findAll();

			if (grades == null) {
				grades = new ArrayList<Grade>();
			}
			model.addAttribute("grades", grades);
			if (enseignant != null) {
				model.addAttribute("enseignant", enseignant);
			}
		}
		return "enseignant/ajouterEnseignant";
	}

	@RequestMapping("/modifierEtat/{id}")
	public String modifierEtat(@PathVariable("id") Long idUser, Model model) {
		if (idUser != null) {

			Enseignant Enseignant = IServiceEnseignant.findById(idUser);
			if (Enseignant != null) {
				Enseignant.setActived(!Enseignant.isActived());
				IServiceEnseignant.update(Enseignant);
			}
		}
		return "redirect:/enseignants/";
	}

	@RequestMapping("/sendPassword/{id}")
	public String sendPassword(@PathVariable("id") Long idUser, Model model) {
		if (idUser != null) {

			Enseignant Enseignant = IServiceEnseignant.findById(idUser);
			if (Enseignant != null) {
				Enseignant.setActived(!Enseignant.isActived());
				// SendMailTLS.sendMailPasswod(Enseignant.getMail(),"xxx","xxx");
			}
		}
		return "redirect:/enseignants/";
	}

	@RequestMapping(value = "/importer")
	public String importer(Model model, @RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) throws IOException {
		String[] fileFrags = file.getOriginalFilename().split("\\.");
		 String extension = fileFrags[fileFrags.length-1];
		if(file.isEmpty())
		{
			
			redirectAttributes.addFlashAttribute("errorupload", true);
			redirectAttributes.addFlashAttribute("erroruploadmsg", "Erreur lors du téléchargement, veuillez vérifier que votre fichier n'est pas vide");
		    return "redirect:/enseignants/";
		}
		else
		{
		if(!extension.equals("csv") || CSVLoader.checkRib(file.getInputStream())==false)
		{
			redirectAttributes.addFlashAttribute("errorupload", true);
			redirectAttributes.addFlashAttribute("erroruploadmsg", "Erreur de téléchargement, veuillez vérifier le format de fichier (CSV) ou la structure de contenu et le RIB");
		    return "redirect:/enseignants/";
		}
		List<Enseignant> enseignants = CSVLoader.readCsvUsingLoad(file.getInputStream());
		IServiceEnseignant.saveAll(enseignants);
		IServiceRoleUser.saveAllRoleUser(enseignants);
		redirectAttributes.addFlashAttribute("successMsg", "La liste des enseignants a été ajoutée avec succès.<br>"+enseignants.size()+" "+"enseignants ajoutés avec succès");
		System.out.println(enseignants.size());
		return "redirect:/enseignants/";
		}
	}
	
	@RequestMapping(value="/checkMail")
	@ResponseBody
	public boolean  checkMail(@RequestParam("mail") String mail){
	 return IServiceEnseignant.findByMail(mail);
	}
	
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getErrorPage() {
		return "redirect:/Access_Denied/404";
	}
}

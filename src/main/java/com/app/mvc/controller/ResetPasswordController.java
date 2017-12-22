package com.app.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.mvc.entity.Enseignant;
import com.app.mvc.entity.User;
import com.app.mvc.service.IServiceEnseignant;
import com.app.mvc.service.IServiceUser;
import com.app.mvc.utils.CryptPassword;

@Controller
@RequestMapping(value = "/reset")
public class ResetPasswordController {

	@Autowired
	IServiceUser IServiceUser;
	@Autowired
	IServiceEnseignant IServiceEnseignant;
	@Autowired
	CryptPassword cryptMD5;

	@RequestMapping(value = "/")
	public String resetpassword(ModelMap model) {

		return "login/resetpassword";
	}

	@RequestMapping(value = "/nvmotdepasse", method = RequestMethod.POST)
	public String reset(ModelMap model, @RequestParam String key, @RequestParam String mail) {
		Enseignant enseignant = IServiceEnseignant.findBypassword(key, mail);
		User user = IServiceUser.findBypassword(key, mail);
		if (enseignant != null) {
			model.addAttribute("userid", enseignant.getIdutilisateur());
			model.addAttribute("action", enseignant);
			return "login/resetpasswordForm";
		} else if (user != null) {
			model.addAttribute("user", user);
			model.addAttribute("action", user);
			return "login/resetpasswordForm";
		} else {
			model.addAttribute("msgerror", "Le clé ou le mail invalide.");
			model.addAttribute("error", "true");
			return "login/resetpassword";
		}
	}

	@RequestMapping(value = "/savepassword")
	public String savepassord(ModelMap model, RedirectAttributes redirectAttributes, @RequestParam String password1,
			@RequestParam String password2, @RequestParam Long id, @RequestParam String action,
			HttpServletRequest request) {

		if (id != null && !action.isEmpty()) {

			Enseignant enseignant = null;
			User user = null;
			if (password1.isEmpty() || password2.isEmpty()) {
				model.addAttribute("msgerror", "les champs ne doivent pas être vides");
				model.addAttribute("error", "true");
				model.addAttribute("userid", id);
				model.addAttribute("action", action);
				return "login/resetpasswordForm";
			}
			if (!password1.equals(password2)) {
				model.addAttribute("msgerror", "les deux mots de passe ne sont pas identiques");
				model.addAttribute("error", "true");
				model.addAttribute("userid", id);
				model.addAttribute("action", action);
				return "login/resetpasswordForm";
			}
			if (action.equals("user")) {
				user = IServiceUser.findById(id);

			} else {
				enseignant = IServiceEnseignant.findById(id);

			}
			if (enseignant != null) {
				enseignant.setPassword(cryptMD5.getCryptedPassword(password1));
				IServiceEnseignant.update(enseignant);
				model.addAttribute("success", "Votre mot de passe mis à jour avec succès.");
				model.addAttribute("error", false);
				id = null;
				action = null;
				//model.clear();
				return "login/resetpassword";
			} else if (user != null) {
				user.setPassword(cryptMD5.getCryptedPassword(password1));
				IServiceUser.update(user);
				model.addAttribute("success", "Votre mot de passe mis à jour avec succès.");
				model.addAttribute("error", false);
				id = null;
				action = null;
				return "login/resetpassword";
			} else {
				model.addAttribute("msgerror", "Une erreur est survenue. veuillez réessayer ultérieurement.");
				model.addAttribute("error", "true");
				return "login/resetpassword";
			}
		} else {
			model.addAttribute("msgerror", "Une erreur est survenue. veuillez réessayer ultérieurement.");
			model.addAttribute("error", "true");
			return "login/resetpassword";
		}
	}
}

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

import com.app.mvc.entity.User;
import com.app.mvc.service.IServiceEnseignant;
import com.app.mvc.service.IServiceRoleUser;
import com.app.mvc.service.IServiceUser;
import com.app.mvc.utils.CryptPassword;

@Controller
@RequestMapping(value = "/Users")
public class UserController {

	@Autowired
	IServiceUser IServiceUser;
	@Autowired
	IServiceRoleUser IServiceRoleUser;
	@Autowired
	CryptPassword CryptPassword;
	@Autowired
	IServiceEnseignant IServiceEnseignant;

	@RequestMapping("/")
	public String getListUser(Model model) {
		Iterable<User> users = IServiceUser.findAll();
		model.addAttribute("users", users);
		return "utilisateur/utilisateur";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterUser(Model model) {
		User User = new User();
		model.addAttribute("user", User);
		return "utilisateur/ajouterUtilisateur";
	}

	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String saveUser(Model model, @Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {

			return "utilisateur/ajouterUtilisateur";
		} else {
			if (user != null) {
				if (IServiceEnseignant.findByMail(user.getMail()) || IServiceUser.findByMail(user.getMail())) {
					result.rejectValue("mail", "error.user", "Un enseignant existe déjà pour cet e-mail.");
					return "utilisateur/ajouterUtilisateur";
				}
				if (user.getIdutilisateur() != null) {
					IServiceUser.update(user);
				} else {
					user.setPassword(CryptPassword.getCryptedPassword(user.getPassword()));
					IServiceUser.save(user);
					IServiceRoleUser.saveRoleAdmin(user);

				}
			}
		}
		return "redirect:/Users/";
	}

	@RequestMapping("/supprimer/{id}")
	public String deleteUser(@PathVariable("id") Long idUser, Model model) {
		if (idUser != null) {
			User User = IServiceUser.findById(idUser);
			if (User != null) {
				IServiceUser.delete(User);
			}
		}
		return "redirect:/Users/";
	}

	@RequestMapping("/modifier/{id}")
	public String updateUser(@PathVariable("id") Long idUser, Model model) {
		if (idUser != null) {

			User User = IServiceUser.findById(idUser);
			if (User != null) {
				model.addAttribute("user", User);
			}
		}
		return "utilisateur/ajouterUtilisateur";
	}

	@RequestMapping("/modifierEtat/{id}")
	public String modifierEtat(@PathVariable("id") Long idUser, Model model) {
		if (idUser != null) {

			User User = IServiceUser.findById(idUser);
			if (User != null) {
				User.setActived(!User.isActived());
				IServiceUser.update(User);
			}
		}
		return "redirect:/Users/";
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getErrorPage() {
		return "redirect:/Access_Denied/404";
	}

}

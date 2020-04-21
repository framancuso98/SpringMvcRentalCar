package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.security.model.Authorities;
import com.spring.security.model.Prenotazione;
import com.spring.security.model.User;
import com.spring.security.service.AuthoritiesService;
import com.spring.security.service.PrenotazioneService;
import com.spring.security.service.UserService;
import com.spring.security.utility.rentalUtil;

@Controller
@SessionAttributes("userLoggato")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthoritiesService authorities;
	
	@Autowired 
	BCryptPasswordEncoder encoder;
	
	@Autowired
	PrenotazioneService prenotazioneService;
	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminHome(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    User userLoggato = userService.findUserByName(currentUserName);
		    model.addAttribute("userLoggato",userLoggato);
		}
		return "admin";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userHome(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    User userLoggato = userService.findUserByName(currentUserName);
		    model.addAttribute("userLoggato",userLoggato);
		    Prenotazione prenotazioneUser = prenotazioneService.findByUtente(userLoggato);
		    model.addAttribute("prenotazioneUser", prenotazioneUser);
		}
		return "user";
	}
	
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public String listaUser(ModelMap model) {
		List<User> lista = userService.listUser();
		model.addAttribute("lista", lista);
		System.out.println(model.getAttribute("userLoggato"));
		return "listaUser";
	}
	
	@RequestMapping(value = "/allUser", method = RequestMethod.POST)
	public String eliminaUser(ModelMap model, @RequestParam("id")String id) {
		int id_user = Integer.parseInt(id);
		User user = userService.getUser(id_user);
		Prenotazione prenotazione = prenotazioneService.findByUtente(user);
		if (prenotazione == null) {
			userService.deleteUser(id_user);
		}
		return listaUser(model);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(ModelMap model) {
		return "addUser";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user,ModelMap model,@RequestParam("ruolo")String ruolo) {
		if(ruolo.equalsIgnoreCase("admin")) {
			String passIniziale = encoder.encode("1234");
			Authorities auth = authorities.getAuth(1);
			user.setAuthority(auth);
			user.setPassword(passIniziale);
			userService.saveUser(user);
		}else if (ruolo.equalsIgnoreCase("utente")) {
			String passIniziale = encoder.encode("1234");
			Authorities auth = authorities.getAuth(2);
			user.setAuthority(auth);
			user.setPassword(passIniziale);
			userService.saveUser(user);
		}else {
			return addUser(model);
		}
		return listaUser(model);
	}
	
	@RequestMapping(value = "/profilo", method = RequestMethod.GET)
	public String profiloUser(ModelMap model) {
		return "profilo";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public String updateUser(ModelMap model) {
		return "updateProfilo";
	}
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String salvaUser(@ModelAttribute User updateUser, ModelMap model,@RequestParam("id_authority")String auth) {
		int id_auth = Integer.parseInt(auth);
		Authorities authority = authorities.getAuth(id_auth);
		updateUser.setAuthority(authority);
		userService.updateUser(updateUser);
		model.remove("userLoggato");
		model.addAttribute("userLoggato", updateUser);
		return profiloUser(model);
	}
	
	@RequestMapping(value = "/registraUser", method = RequestMethod.POST)
	public String registraUser(@ModelAttribute User newUser,ModelMap model) {
		User user = userService.findUserByName(newUser.getName());
		String errore = rentalUtil.validaUser(newUser);
		if (errore.equalsIgnoreCase("ok")) {
			if (user == null) {
				model.remove("newUser");
				String password =encoder.encode(newUser.getPassword());
				newUser.setPassword(password);
				Authorities auth = authorities.getAuth(2);
				newUser.setAuthority(auth);
				userService.saveUser(newUser);
				model.addAttribute("userLoggato",newUser);
				String registrazioneOk = "Registrazione avvenuta con successo,"
						+ "ora puoi accedere per usufruire dei nostri servizi";
				model.addAttribute("erroreOk", registrazioneOk);
				model.remove("errore");
				return "index";
			}else {
				String userName = "Username non disponibile";
				model.addAttribute("errore", userName);
				model.addAttribute("newUser", newUser);
				return "index";
			}	
		}	
		model.addAttribute("errore", errore);
		model.addAttribute("newUser", newUser);
		return "index";

	}
}

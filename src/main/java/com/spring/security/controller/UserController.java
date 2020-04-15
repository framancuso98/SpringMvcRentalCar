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
import com.spring.security.model.User;
import com.spring.security.service.AuthoritiesService;
import com.spring.security.service.UserService;

@Controller
@SessionAttributes("userLoggato")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthoritiesService authorities;
	
	@Autowired 
	BCryptPasswordEncoder encoder;
	
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
		}
		return "user";
	}
	
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public String listaUser(ModelMap model) {
		List<User> lista = userService.list();
		model.addAttribute("lista", lista);
		System.out.println(model.getAttribute("userLoggato"));
		return "listaUser";
	}
	
	@RequestMapping(value = "/allUser", method = RequestMethod.POST)
	public String eliminaUser(ModelMap model, @RequestParam("id")String id) {
		int id_user = Integer.parseInt(id);
		userService.delete(id_user);
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
			userService.save(user);
		}else if (ruolo.equalsIgnoreCase("utente")) {
			String passIniziale = encoder.encode("1234");
			Authorities auth = authorities.getAuth(2);
			user.setAuthority(auth);
			user.setPassword(passIniziale);
			userService.save(user);
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
		userService.update(updateUser);
		model.remove("userLoggato");
		model.addAttribute("userLoggato", updateUser);
		return profiloUser(model);
	}
	
}

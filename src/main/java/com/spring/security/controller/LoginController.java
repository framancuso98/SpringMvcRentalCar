package com.spring.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.security.model.User;
import com.spring.security.service.UserService;

@Controller
@SessionAttributes("userLoggato")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
		return "index";
	}
	
    
	@RequestMapping(value = "/login_post", method = RequestMethod.POST)
    public String loginPage(@RequestParam(value = "error", required = false) String error, 
                            @RequestParam(value = "logout", required = false) String logout,
                            @RequestParam("username") String username,
                            ModelMap model) {
        String errorMessge = null;
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
            System.out.println("Username or Password is incorrect !!");
        }
        if(logout != null) {
            errorMessge = "You have been successfully logged out !!";
            System.out.println("You have been successfully logged out !!");
        }
        model.addAttribute("errorMessge", errorMessge);
        System.out.println("ok");
        System.out.println(username);
        User user = userService.findUserByName(username);
        System.out.println(user);
        model.addAttribute("userLoggato", user);
        return "index" ;
    }
  
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
            model.remove("userLoggato");
        }
        return "index";
    }
}
package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AutoController {

	@RequestMapping(value = "/auto", method = RequestMethod.GET)
    public static String lista() {
		return "listauto";
	}
}

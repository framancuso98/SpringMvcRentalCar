package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.security.model.Auto;
import com.spring.security.model.Categoria;
import com.spring.security.model.Prenotazione;
import com.spring.security.service.AutoService;
import com.spring.security.service.CategoriaService;
import com.spring.security.service.PrenotazioneService;
import com.spring.security.utility.rentalUtil;

@Controller
public class AutoController {

	@Autowired 
	AutoService autoService;
	@Autowired 
	CategoriaService categoriaService;
	@Autowired
	PrenotazioneService prenotazioneService;
	
	@RequestMapping(value = "/allAuto", method = RequestMethod.GET)
	public String listaAuto(ModelMap model) {
		List<Auto> listAuto = autoService.listAuto();
		model.addAttribute("listAuto", listAuto);
		return "listAuto";
	}
	
	@RequestMapping(value = "/allAuto", method = RequestMethod.POST)
	public String listaAuto(ModelMap model, @RequestParam("id")String id) {
		int id_auto = Integer.parseInt(id);
		Auto auto = autoService.findAutoById(id_auto);
		Prenotazione prenotazione = prenotazioneService.findByAuto(auto);
		if (prenotazione == null) {
			autoService.deleteAuto(id_auto);
			return listaAuto(model);
		}else {
			return listaAuto(model);
		}
		
	}
	
	@RequestMapping(value = "/updateAuto", method = RequestMethod.GET)
	public String updateAuto(ModelMap model, @RequestParam("id")String id) {
		int id_auto = Integer.parseInt(id);
		Auto auto = autoService.findAutoById(id_auto);
		List<Categoria> categorie = categoriaService.listaCat();
		model.addAttribute("categorie", categorie);
		model.addAttribute("auto", auto);
		System.out.println(auto.getAnno());
		return "updateAuto";
	}
	
	@RequestMapping(value = "/updateAuto", method = RequestMethod.POST)
	public String updateAuto(ModelMap model,@ModelAttribute Auto updateAuto,
			@RequestParam("id_categoria")String id) {
		int id_categoria = Integer.parseInt(id);
		Categoria categoria = categoriaService.findCatById(id_categoria);
		updateAuto.setCategoria(categoria);
		String errore = rentalUtil.validaAuto(updateAuto);
		if (errore.equalsIgnoreCase("ok")) {
			autoService.updateAuto(updateAuto);
		return listaAuto(model);
		}else {
			model.addAttribute("errore", errore);
			model.addAttribute("auto", updateAuto);
			List<Categoria> categorie = categoriaService.listaCat();
			model.addAttribute("categorie", categorie);
			return "updateAuto";
		}
	}
	
	@RequestMapping(value = "/addAuto", method = RequestMethod.GET)
	public String addAuto(ModelMap model) {
		List<Categoria> categorie = categoriaService.listaCat();
		model.addAttribute("categorie", categorie);
		return "addAuto";
	}
	
	@RequestMapping(value = "/addAuto", method = RequestMethod.POST)
	public String addAuto(ModelMap model, @ModelAttribute Auto auto,
							@RequestParam("categoria_id")String id) {
		int id_cat = Integer.parseInt(id);
		Categoria categoria = categoriaService.findCatById(id_cat);
		auto.setCategoria(categoria);
		String errore = rentalUtil.validaAuto(auto);
		Auto autoTarga = autoService.findAutoByTarga(auto.getTarga().toUpperCase());
		if ( autoTarga == null) {
			if(errore.equalsIgnoreCase("ok")) {
				autoService.saveAuto(auto);
				model.remove("errore");
				return listaAuto(model);
			}else {
				model.addAttribute("errore", errore);
				model.addAttribute("auto", auto);
				return addAuto(model);
			}
		}else {
			String tragaPresente = "Targa già presente";
			model.addAttribute("errore", tragaPresente);
			model.addAttribute("auto", auto);
			return addAuto(model);
		}
	}
	
}


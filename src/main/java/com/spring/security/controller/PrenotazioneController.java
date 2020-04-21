package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.security.model.Auto;
import com.spring.security.model.Prenotazione;
import com.spring.security.model.User;
import com.spring.security.service.AutoService;
import com.spring.security.service.PrenotazioneService;
import com.spring.security.service.UserService;

@SessionAttributes("userLoggato")
@Controller
public class PrenotazioneController {

	@Autowired
	PrenotazioneService prenotazioneService;

	@Autowired 
	AutoService autoService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/allPrenotazione", method = RequestMethod.GET)
	public String listaPrenotazione(ModelMap model) {
		List<Prenotazione> listaPre = prenotazioneService.findAllPrenotazioni();
		model.addAttribute("listaPre", listaPre);
		return "listaPrenotazione";
	}

	@RequestMapping(value = "/accetta", method = RequestMethod.POST )
	public String accettaPre(@RequestParam("id")String id, ModelMap model){
		int id_prenotazione = Integer.parseInt(id);
		Prenotazione prenotazione = prenotazioneService.findById(id_prenotazione);
		prenotazioneService.accettaPrenotazione(prenotazione);
		return listaPrenotazione(model);
	}

	@RequestMapping(value = "/rifiuta", method = RequestMethod.POST )
	public String rifiutaPre(@RequestParam("id")String id, ModelMap model){
		int id_prenotazione = Integer.parseInt(id);
		Prenotazione prenotazione = prenotazioneService.findById(id_prenotazione);
		prenotazioneService.rifiutaPrenotazione(prenotazione);
		return listaPrenotazione(model);
	}

	@RequestMapping(value = "/addPrenotazione", method = RequestMethod.POST )
	public String addPrenotazione(@RequestParam("id_auto")String id_auto,
			@RequestParam("id_user")String id_user,
			ModelMap model){
		int auto_id = Integer.parseInt(id_auto);
		int user_id = Integer.parseInt(id_user);

		User user = userService.getUser(user_id);
		Auto auto = autoService.findAutoById(auto_id);

		Prenotazione p = prenotazioneService.findByUtente(user);
		Prenotazione p2 = prenotazioneService.findByAuto(auto);
		if(p == null) {
			if (p2 == null) {
				Prenotazione prenotazione = new Prenotazione();
				prenotazione.setAuto(auto);
				prenotazione.setUser(user);
				prenotazioneService.aggiungiPrenotazione(prenotazione);
				String erroreOk = "Prenotazione avvenuta con successo";
				model.addAttribute("erroreOk", erroreOk);
			}else {
				List<Auto> listAuto = autoService.listAuto();
				model.addAttribute("listAuto", listAuto);
				String errore = "Auto non disponibile";
				model.addAttribute("errore", errore);
				return "listAuto";
			}
		}else {
			List<Auto> listAuto = autoService.listAuto();
			model.addAttribute("listAuto", listAuto);
			String errore = "Hai già una prenotazione attiva";
			model.addAttribute("errore", errore);
			return "listAuto";
		}
		User userLoggato = (User) model.get("userLoggato");
		Prenotazione prenotazioneUser = prenotazioneService.findByUtente(userLoggato);
	    model.addAttribute("prenotazioneUser", prenotazioneUser);
		return "user";
	}

	@RequestMapping(value = "/eliminaPrenotazione", method = RequestMethod.POST )
	public String eliminaPrenotazione(@RequestParam("idelimina")String id, ModelMap model){
		int id_prenotazione = Integer.parseInt(id);
		Prenotazione prenotazione = prenotazioneService.findById(id_prenotazione);
		prenotazioneService.rimuoviPrenotazione(id_prenotazione);
		return "user";
	}

}

package com.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.dao.PrenotazioneDAO;
import com.spring.security.model.Auto;
import com.spring.security.model.Prenotazione;
import com.spring.security.model.User;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	PrenotazioneDAO prenotazioneDAO;
	
	@Override
	public void aggiungiPrenotazione(Prenotazione p) {
		String stato = "IN SOSPESO";
		p.setStato(stato);
		prenotazioneDAO.aggiungiPrenotazione(p);
	}

	@Override
	public List<Prenotazione> findAllPrenotazioni() {
		List<Prenotazione> lista = prenotazioneDAO.findAllPrenotazioni();
		return lista;
	}

	@Override
	public Prenotazione findById(int id) {
		Prenotazione prenotazione = prenotazioneDAO.findById(id);
		return prenotazione;
	}

	@Override
	public void rimuoviPrenotazione(int id) {
		prenotazioneDAO.rimuoviPrenotazione(id);
	}

	@Override
	public void accettaPrenotazione(Prenotazione p) {
		String stato = "ACCETTATA";
		p.setStato(stato);
		prenotazioneDAO.accettaPrenotazione(p);
	}

	@Override
	public void rifiutaPrenotazione(Prenotazione p) {
		String stato = "RIFIUTATA";
		p.setStato(stato);
		prenotazioneDAO.rifiutaPrenotazione(p);
	}

	@Override
	public Prenotazione findByUtente(User utente) {
		Prenotazione prenotazione = prenotazioneDAO.findByUtente(utente);
		return prenotazione;
	}

	@Override
	public Prenotazione findByAuto(Auto auto) {
		Prenotazione prenotazione = prenotazioneDAO.findByAuto(auto);
		return prenotazione;
	}

}

package com.spring.security.dao;

import java.util.List;

import com.spring.security.model.Auto;
import com.spring.security.model.Prenotazione;
import com.spring.security.model.User;

public interface PrenotazioneDAO {
	
	public void aggiungiPrenotazione(Prenotazione p);
	
	public List<Prenotazione> findAllPrenotazioni();
	
	public Prenotazione findById(int id);
	
	public void rimuoviPrenotazione(int id);
	
	public void accettaPrenotazione(Prenotazione p);
	//cambia lo stato da "IN SOSPESO" ad "ACCETTATA" prendeno in ingresso l'id della prenotazione 
	
	public void rifiutaPrenotazione(Prenotazione p);
	//cambia lo stato da "IN SOSPESO" ad "RIFIUTATA" prendendo in ingresso l'id della prenotazione
	
	public Prenotazione findByUtente(User utente);
	
	public Prenotazione findByAuto(Auto auto);
}

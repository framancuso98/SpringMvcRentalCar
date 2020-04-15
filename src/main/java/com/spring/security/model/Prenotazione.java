package com.spring.security.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="prenotazione_tbl")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String stato;

	//bi-directional many-to-one association to Auto
	@ManyToOne
	@JoinColumn(name="id_auto", nullable=false)
	private Auto auto;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="id_user", nullable=false)
	private User utente;
	
	

	public Prenotazione() {
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public User getUtente() {
		return utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", stato=" + stato + ", auto=" + auto + ", utente=" + utente + "]";
	}

	
}

package com.spring.security.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "auto_tbl")
public class Auto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@NotEmpty
	@Column(name = "costruttore")
	private String costruttore;
	
	@NotEmpty
	@Column(name = "modello")
	private String modello;
	
	@NotEmpty
	@Column(name = "targa")
	private String targa;
	
	@NotEmpty
	@Column(name = "anno")
	private String anno;
	
	//bi-directional many-to-one association to Categoria
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="id_categoria", nullable=false)
		private Categoria categoria;

		//bi-directional many-to-one association to Prenotazione
		@OneToMany(mappedBy="auto", cascade=CascadeType.REMOVE, fetch = FetchType.EAGER)
		private List<Prenotazione> prenotaziones;

		public Auto() {
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCostruttore() {
			return costruttore;
		}

		public void setCostruttore(String costruttore) {
			this.costruttore = costruttore;
		}

		public String getModello() {
			return modello;
		}

		public void setModello(String modello) {
			this.modello = modello;
		}

		public String getTarga() {
			return targa;
		}

		public void setTarga(String targa) {
			this.targa = targa;
		}

		public String getAnno() {
			return anno;
		}

		public void setAnno(String anno) {
			this.anno = anno;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public List<Prenotazione> getPrenotaziones() {
			return prenotaziones;
		}

		public void setPrenotaziones(List<Prenotazione> prenotaziones) {
			this.prenotaziones = prenotaziones;
		}

		@Override
		public String toString() {
			return "Auto [id=" + id + ", costruttore=" + costruttore + ", modello=" + modello + ", targa=" + targa
					+ ", anno=" + anno + ", categoria=" + categoria + ", prenotaziones=" + prenotaziones + "]";
		}

	
	
}

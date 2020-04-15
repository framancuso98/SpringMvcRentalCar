package com.spring.security.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "user_tbl")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@NotEmpty
	@Column(name = "password")
	private String password;
	
	@NotEmpty
	@Column(name="nome")
	private String nome;
	
	@NotEmpty
	@Column(name="cognome")
	private String cognome;
	
	@NotEmpty
	@Column(name="data_nascita")
	private String data_nascita;
	
	@JoinColumn(name = "authority_id")
	@OneToOne
	private Authorities authority;

	
	public User() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(String data_nascita) {
		this.data_nascita = data_nascita;
	}

	public Authorities getAuthority() {
		return authority;
	}

	public void setAuthority(Authorities authority) {
		this.authority = authority;
	}

	/*public boolean isEnabled() {
		if(this.isEnabled == 1) return true;
		else return false;
	}

	public void isEnabled(boolean isEnabled) {
		if(isEnabled) this.isEnabled = 1;
		else this.isEnabled = 0;
	}*/
}
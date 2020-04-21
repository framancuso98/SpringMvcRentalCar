package com.spring.security.utility;

import com.spring.security.model.Auto;
import com.spring.security.model.User;


public class rentalUtil {

	public static String validaAuto(Auto auto) {
		if(auto != null) {
			System.out.println("auto ok");
			if(auto.getCostruttore() != null && auto.getCostruttore().length() >= 3) {
				if(auto.getModello() != null && auto.getModello().length() >= 2) {
					if (auto.getTarga().length() == 7 && auto.getTarga() != null && auto.getTarga().matches("^[a-zA-Z]{2}[0-9]{3,4}[a-zA-Z]{2}$")) {
						auto.setTarga(auto.getTarga().toUpperCase());
						if (auto.getAnno() != null) {
						}else {
							System.out.println("Data immatricolazione non valida o nulla");
							return "Inserire data di immatricolazione";
						}
					}else{
						System.out.println("targa non corretta");
						return "formato targa errato";
					}  
				}else {
					System.out.println("modello non valido");
					return "modello non valido";
				}
			}else {
				System.out.println("costruttore non valido");
				return "costruttore non valido";
			}
		}else {
			System.out.println("auto nulla");
			return "compilare tutti i campi";
		}
		
		return "ok";
	}

	
	
	public static String validaUser(User user) {
		if(user != null){
			System.out.println("user ok");
			if (user.getNome() != null && user.getNome().length() >=3) {
				if (user.getCognome() != null && user.getCognome().length() >=3) {
					if (user.getName() != null && user.getName().length() >= 5) {
						if (user.getPassword() != null && user.getPassword().length() >=5) {

							if (user.getData_nascita() != null && user.getData_nascita().length() >=5) {
							}else {
								System.out.println("data non valida");
								return "Inserire una data di nascita";

							}
						}else {
							System.out.println("password non valida");
							return "password non valida";
						}
					}else {
						System.out.println("Username non valido");
						return "Username non valido";
					}	
				}else {
					System.out.println("Cognome non valido");
					return "Cognome non valido";
				}
			}else {
				System.out.println("Nome non valido");
				return "Nome non valido";	
			}

		}else {
			System.out.println("User nullo");
			return "Compilare i campi";
		}
		System.out.println("user validato");
		return "ok";
	}
}

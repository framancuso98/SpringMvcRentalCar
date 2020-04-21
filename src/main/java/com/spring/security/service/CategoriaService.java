package com.spring.security.service;

import java.util.List;

import com.spring.security.model.Categoria;

public interface CategoriaService {

List<Categoria> listaCat();
	
	Categoria findCatById(int id);
}

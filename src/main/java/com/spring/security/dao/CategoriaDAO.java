package com.spring.security.dao;

import java.util.List;

import com.spring.security.model.Categoria;

public interface CategoriaDAO {

	List<Categoria> listaCat();
	
	Categoria findCatById(int id);
}

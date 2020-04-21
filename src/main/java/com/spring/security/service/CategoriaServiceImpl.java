package com.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.dao.CategoriaDAO;
import com.spring.security.model.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaDAO categoriaDAO;
	@Override
	public List<Categoria> listaCat() {
		List<Categoria> lista = categoriaDAO.listaCat();
		return lista;
	}

	@Override
	public Categoria findCatById(int id) {
		Categoria categoria = categoriaDAO.findCatById(id);
		return categoria;
	}

}

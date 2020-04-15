package com.spring.security.dao;

import java.util.List;

import com.spring.security.model.Auto;

public interface AutoDAO {
	
boolean save(Auto auto);
	
	List<Auto> list();
	
	Auto get(int id);
	
	boolean delete(int id);
	
	Auto findAutoById(int id);
	
}

package com.spring.security.dao;

import java.util.List;

import com.spring.security.model.Auto;

public interface AutoDAO {
	
	void saveAuto(Auto auto);
	
	List<Auto> listAuto();
	
	void deleteAuto(int id);
	
	Auto findAutoById(int id);
	
	void updateAuto(Auto auto);
	
	Auto findAutoByTarga(String targa);
}

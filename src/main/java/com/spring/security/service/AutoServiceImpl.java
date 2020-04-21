package com.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.dao.AutoDAO;
import com.spring.security.model.Auto;

@Service
public class AutoServiceImpl implements AutoService {

	@Autowired 
	AutoDAO autoDAO;
	
	@Override
	public void saveAuto(Auto auto) {
		autoDAO.saveAuto(auto);
	}

	@Override
	public List<Auto> listAuto() {
		List<Auto> list = autoDAO.listAuto();
		return list;
	}

	@Override
	public void deleteAuto(int id) {
		autoDAO.deleteAuto(id);
	}

	@Override
	public Auto findAutoById(int id) {
		Auto auto = autoDAO.findAutoById(id); 
		return auto;
	}

	@Override
	public void updateAuto(Auto auto) {
		autoDAO.updateAuto(auto);
	}

	@Override
	public Auto findAutoByTarga(String targa) {
		Auto auto = autoDAO.findAutoByTarga(targa);
		return auto;
	}

}

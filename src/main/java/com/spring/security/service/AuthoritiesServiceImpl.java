package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.dao.AuthoritiesDAO;
import com.spring.security.model.Authorities;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

	@Autowired
	AuthoritiesDAO authoritiesDAO;
	
	@Override
	public Authorities getAuth(int id) {
		Authorities auth = authoritiesDAO.getAuth(id);
		return auth;
	}

}

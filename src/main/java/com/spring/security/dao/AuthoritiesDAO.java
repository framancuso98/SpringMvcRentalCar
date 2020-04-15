package com.spring.security.dao;

import com.spring.security.model.Authorities;

public interface AuthoritiesDAO {
	
	Authorities getAuth(int id);
	
}

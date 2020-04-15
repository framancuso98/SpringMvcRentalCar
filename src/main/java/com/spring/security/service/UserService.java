package com.spring.security.service;

import java.util.List;

import com.spring.security.model.User;

public interface UserService {
	
	boolean save(User user);
	
	List<User> list();
	
	User get(int id);
	
	boolean delete(int id);
	
	User findUserByName(String name);
	
	public void update(User user);
	
	
}

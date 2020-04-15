package com.spring.security.dao;

import java.util.List;

import com.spring.security.model.User;

public interface UserDAO {
	
	boolean save(User user);
	
	List<User> list();
	
	User get(int id);
	
	boolean delete(int id);
	
	User findUserByName(String name);
	
	public void update(User user);
	
}

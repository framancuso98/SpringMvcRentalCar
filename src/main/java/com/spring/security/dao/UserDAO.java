package com.spring.security.dao;

import java.util.List;

import com.spring.security.model.User;

public interface UserDAO {
	
	void saveUser(User user);
	
	List<User> listUser();
	
	User getUser(int id);
	
	void deleteUser(int id);
	
	User findUserByName(String name);
	
	public void updateUser(User user);
	
}

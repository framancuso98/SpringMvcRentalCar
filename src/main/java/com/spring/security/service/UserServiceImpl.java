package com.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.dao.UserDAO;
import com.spring.security.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	@Override
	public List<User> listUser() {
		List<User> list = userDAO.listUser();
		return list;
	}

	@Override
	public User getUser(int id) {
		User user = userDAO.getUser(id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	@Override
	public User findUserByName(String name) {
		User user = userDAO.findUserByName(name);
		return user;
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

}

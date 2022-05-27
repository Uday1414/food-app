package com.ty.food.service;

import java.util.List;

import com.ty.food.dto.*;
import com.ty.food.dao.*;
public class UserService {
	
	String SECRETE_KEY = "udayapp";

	UserDao userDao = new UserDao();

	public User saveUser(User user) {
		
		return userDao.saveUser(user);
	}

	public User getUserById(int id) {
		User user=userDao.getUserById(id);
		return user;
	}

	public List<User> getAllUsers() {
		List<User> users = userDao.getAllUsers();
		
		return users;
	}

	public User validateUser(String email, String password) {
		return userDao.validateUser(email, password);
	}

	public boolean deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}
}

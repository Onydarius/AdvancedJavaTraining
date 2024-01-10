package com.nagarro.services;


import org.springframework.stereotype.Service;

import com.nagarro.dao.UserDao;
import com.nagarro.model.User;


@Service
public class UserServices {
	UserDao userDao;


	public UserServices() {
		userDao = new UserDao();
	}
	
	public void addUser(User user) {
		userDao.saveUser(user);
	}
	
	public int checkIfExistUser(String username, String password) {
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		
		return userDao.checkuser(user);
	}
}

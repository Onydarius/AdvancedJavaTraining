package com.webserv.repository;

import com.webserv.model.User;

public interface UserRepository {
	public int checkuser(User user);
	
	public int saveUser(User user);
}

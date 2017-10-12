package com.pixelware.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixelware.model.User;
import com.pixelware.model.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserByName(String name) throws SQLException {
		return userDao.getUserByName(name);
	}
	
	public void addUser(User user) throws SQLException {
		userDao.addUser(user);
	}
}
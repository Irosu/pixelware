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
	
	public User getUserByEmail(String email) throws SQLException {
		return userDao.getUserByEmail(email);
	}
	
	public void addUser(User user) throws SQLException {
		userDao.addUser(user);
	}
	
	public boolean checkEmail(String email) throws SQLException {
		return userDao.getEmails().contains(email);
	}
}
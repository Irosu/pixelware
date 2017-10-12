package com.pixelware.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pixelware.model.User;

/**
 * DAO para el User
 *
 * @author irsrg
 */
public interface UserDao {

	User getUserByEmail(String email) throws SQLException;
	
	ArrayList<String> getEmails() throws SQLException;

	void addUser(User user) throws SQLException;
}
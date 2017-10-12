package com.pixelware.model.dao;

import java.sql.SQLException;

import com.pixelware.model.User;

/**
 * DAO para el User
 *
 * @author irsrg
 */
public interface UserDao {

	User getUserByName(String name) throws SQLException;

	void addUser(User user) throws SQLException;
}
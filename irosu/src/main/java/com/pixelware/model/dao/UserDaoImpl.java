package com.pixelware.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pixelware.model.User;

/**
 * Implementación del DAO para el User
 * 
 * @author irsrg
 */
@Component
public class UserDaoImpl implements UserDao {

	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public User getUserByEmail(String email) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {

			String select = "SELECT id, name, email, country, birthDate, password FROM users WHERE email = ?";

			connection = dataSource.getConnection();
			statement = connection.prepareStatement(select);

			statement.setString(1, email);

			rs = statement.executeQuery();

			User user = null;

			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), 
						rs.getString("birthDate"), rs.getString("country"), rs.getString("password"));
			}

			return user;

		} finally {
			if (rs != null) {
				rs.close();
			}

			if (statement != null) {
				statement.close();
			}
			
			if (connection != null) {
				connection.close();
			}
		}
	}

	public void addUser(User user) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			String select = "INSERT INTO users(name, email, country, birthDate, password) VALUES(?, ?, ?, ?, ?)";

			connection = dataSource.getConnection();
			statement = connection.prepareStatement(select);

			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setString(4, user.getBirthDate());
			statement.setString(5, user.getPassword());

			statement.executeUpdate();

		} finally {
			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		}

	}

	public ArrayList<String> getEmails() throws SQLException {

		ArrayList<String> emails = new ArrayList<String>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			String insert = "SELECT email FROM users";

			connection = dataSource.getConnection();
			statement = connection.prepareStatement(insert);
			rs = statement.executeQuery();

			while (rs.next()) {
				emails.add(rs.getString("email"));
			}

		} finally {
			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		}
		
		return emails;
	}
}
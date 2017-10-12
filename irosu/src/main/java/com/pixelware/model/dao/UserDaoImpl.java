package com.pixelware.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.pixelware.model.User;

/**
 * Implementación del DAO para el User
 * 
 * @author irsrg
 */
public class UserDaoImpl implements UserDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public User getUserByName(String name) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {

			String select = "SELECT id, name, email, country, date, password FROM users WHERE name = ?";

			connection = dataSource.getConnection();
			statement = connection.prepareStatement(select);

			statement.setString(1, name);

			rs = statement.executeQuery();

			User user = null;

			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), 
						rs.getString("date"), rs.getString("country"), rs.getString("password"));
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

			String insert = "INSERT INTO users VALUES(?,?, ?,?,?,?)";

			connection = dataSource.getConnection();
			statement = connection.prepareStatement(insert);

			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getCountry());
			statement.setString(5, user.getDate());
			statement.setString(6, user.getPassword());

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
}
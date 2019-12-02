package com.timesheet.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.timesheet.beans.User;

public class UserDAO {

	public static void main(String[] args) {

		UserDAO userdoa = new UserDAO();

		try {
			userdoa.authenticateUser("user1", "password");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() throws SQLException {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); // need this when using MavenTomcat
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TimesheetProject", "root",
					"        ");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public User authenticateUser(String userName, String password) throws SQLException {
		System.out.println("made it into the DAO");
		Connection conn = getConnection();

		userName.toLowerCase();
		User user = new User();

		PreparedStatement stm = conn.prepareStatement("Select * from user where user_name = ? AND password = ?;");
		stm.setString(1, userName);
		stm.setString(2, password);

		ResultSet rs = stm.executeQuery();

		if (rs.next()) {

			user.setUserId(rs.getInt(1));
			user.setRoleId(rs.getInt(2));
			user.setF_name(rs.getString(3));
			user.setL_name(rs.getString(4));

		}

		conn.close();
		return user;
	}

}

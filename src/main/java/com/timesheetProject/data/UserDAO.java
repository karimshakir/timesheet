package com.timesheetProject.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.timesheetProject.beans.User;

public class UserDAO {

	public Connection getConnection() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/chinook", "root", "        ");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public User save(User user) {
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO USER(NAME, EMAIL, MANAGERSTATUS) VALUES(?, ?, ?)",
					new String[] { "userId" });
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setBoolean(3, user.getManagerStatus());
			stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			while (keys.next()) {
				int userId = keys.getInt(1);
				user.setUserId(userId);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return user;
	}

	public User findByUserId(int id) {
		Connection conn = getConnection();
		User user = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement("select userId, * from user where userId=?");
			stmt.setInt(1, id);
			ResultSet results = stmt.executeQuery();
			results.next();
			user = new User(results.getInt(1), results.getString(2), results.getString(3), results.getBoolean(4));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return user;
	}

	// find all users
	public List<User> findAll() {
		Connection conn = getConnection();
		LinkedList<User> results = new LinkedList<>();
		try {
			ResultSet rs = conn.prepareStatement("select * from user").executeQuery();
			while (rs.next()) {
				User a = new User(rs.getInt("userId"), rs.getString("name"), rs.getString("email"), rs.getBoolean("managerStatus"));
				results.add(a);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return results;
	}

	public Set<User> searchByName(String search) {
		Connection conn = getConnection();
		Set<User> results = new HashSet<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from user where name LIKE ?");
			stmt.setString(1, search + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User a = new User(rs.getInt("userId"), rs.getString("name"), rs.getString("email"), rs.getBoolean("managerStatus"));
				results.add(a);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return results;
	}

	public void update(User user) {
		String sql = "update User set name = ? where userId = ?";
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false); //why are we doing this
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(2, user.getUserId());
			stmt.setString(1, user.getName());
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM USER WHERE USERID = ?";
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}

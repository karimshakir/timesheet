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

import com.timesheetProject.beans.*;

public class TimesheetDAO {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://my-sql.comtwymwozca.us-east-2.rds.amazonaws.com:3306/chinook", "admin", "adminadmin");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Timesheet save(Timesheet timesheet) {
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO ARTIST(NAME) VALUES(?)",
					new String[] { "timesheetId" });
			stmt.setString(1, timesheet.getName());
			stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			while (keys.next()) {
				int timesheetId = keys.getInt(1);
				timesheet.setTimesheetId(timesheetId);
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
		return timesheet;
	}

	public Timesheet findByTimesheetId(int id) {
		Connection conn = getConnection();
		Timesheet timesheet = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from timesheet where timesheetId=?");
			stmt.setInt(1, id);
			ResultSet results = stmt.executeQuery();
			results.next();
			timesheet = new Timesheet(results.getInt(1),results.getInt(2),results.getInt(3),
					results.getInt(4),results.getInt(5),results.getInt(6),results.getString(7),
					results.getBoolean(8));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return timesheet;
	}

	public List<Timesheet> findAll() {
		Connection conn = getConnection();
		LinkedList<Timesheet> results = new LinkedList<>();
		try {
			ResultSet rs = conn.prepareStatement("select * from timesheet")
					.executeQuery();
			while (rs.next()) {
				Timesheet a = new Timesheet(rs.getInt("timesheetId"), 
						0, 0, 0, 0, 0, rs.getString("name"), false);
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

	public Set<Timesheet> searchByName(String search) {
		Connection conn = getConnection();
		Set<Timesheet> results = new HashSet<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from timesheet where name LIKE ?");
			stmt.setString(1, search + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Timesheet a = new Timesheet(rs.getInt("timesheetId"), rs.getString("name"));
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

	public void update(Timesheet timesheet) {
		String sql = "update Timesheet set name = ? where timesheetId = ?";
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(2, timesheet.getTimesheetId());
			stmt.setString(1, timesheet.getName());
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
		String sql = "DELETE FROM ARTIST WHERE ARTISTID = ?";
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

package com.timesheet.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.timesheet.beans.Timesheet;

public class TimesheetDAO {

	public Connection getConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); // need this when using MavenTomcat
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TimesheetProject", "root",
					"        ");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Timesheet save(Timesheet timesheet) {
		Connection conn = getConnection();
		try {

			PreparedStatement stmt = conn.prepareStatement(
					"insert into timesheet(user_id," + "timesheetStatus" + " mon_hours, tue_hours, wed_hours, thur_hours, fri_hours,"
							+ " week_ending_date) values(?)",
					new String[] { "timesheet_id" }); // key
			stmt.setInt(1, timesheet.getUserId());
			stmt.setInt(2, timesheet.getTimesheetStatusId());
			stmt.setInt(3, timesheet.getMonHours());
			stmt.setInt(4, timesheet.getTueHours());
			stmt.setInt(5, timesheet.getWedHours());
			stmt.setInt(6, timesheet.getThurHours());
			stmt.setInt(7, timesheet.getFriHours());
			stmt.setString(8, timesheet.getWeekEndingDate());


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
			timesheet = new Timesheet(results.getInt(1), results.getInt(2), results.getInt(3), results.getInt(4),
					results.getInt(5), results.getInt(6), results.getInt(7), results.getInt(7), results.getString(8));
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

	
	public List<Timesheet> findUserTimesheets(int id) {
		Connection conn = getConnection();
		LinkedList<Timesheet> resultsList = new LinkedList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement("select from Timesheet where user_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Timesheet timesheet = new Timesheet(rs.getInt("timesheet_id"), rs.getInt("user_id"), rs.getInt("timesheetStatus_id"),
						rs.getInt("mon_hours"), rs.getInt("tue_hours"), rs.getInt("wed_hours"), rs.getInt("thur_hours"),
						rs.getInt("fri_hours"), rs.getString("week_ending_date"));
				resultsList.add(timesheet);
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
		return resultsList;
	}
	
	public void update(Timesheet timesheet) {
		String sql = "update Timesheet" + "set mon_hours = ?," + "tue_hours = ?," + "wed_hours = ?,"
				+ "thurs_hours = ?," + "fri_hours = ?," + "week_ending_date = ?,"
				+ "where timesheet_id = ?";

		Connection conn = getConnection();

		try {
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, timesheet.getMonHours());
			stmt.setInt(2, timesheet.getTueHours());
			stmt.setInt(3, timesheet.getWedHours());
			stmt.setInt(4, timesheet.getThurHours());
			stmt.setInt(5, timesheet.getFriHours());
			stmt.setString(6, timesheet.getWeekEndingDate());
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
		String sql = "delete from timesheet where timesheet_id = ?";
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
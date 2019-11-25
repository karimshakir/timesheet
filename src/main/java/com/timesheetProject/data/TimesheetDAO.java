package com.timesheetProject.data;

import com.timesheetProject.beans.Timesheet;
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
	
	public static void main(String[] args) {

		Timesheet newtimesheet = new Timesheet(7,2,1,2,3,4,5,"11/20/2019",false, true);

		TimesheetDAO dao = new TimesheetDAO();
		
//		dao.delete(4);
		

		System.out.println(dao.save(newtimesheet)); 

		dao.save(newtimesheet);

	}

	public Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); //need this when using MavenTomcat
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/TimesheetProject", "root", "        ");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Timesheet save(Timesheet timesheet) {
		Connection conn = getConnection();
		try {
			
			PreparedStatement stmt = conn.prepareStatement("insert into timesheet(user_id,"
					+ " mon_hours, tue_hours, wed_hours, thur_hours, fri_hours,"
					+ " week_ending_date, submitted, approved) values(?)",
					new String[] { "timesheet_id" }); //key
			stmt.setInt(1, timesheet.getUserId());
			stmt.setInt(2, timesheet.getMonHours());
			stmt.setInt(3, timesheet.getTueHours());
			stmt.setInt(4, timesheet.getWedHours());
			stmt.setInt(5, timesheet.getThurHours());
			stmt.setInt(6, timesheet.getFriHours());
			stmt.setString(7, timesheet.getWeekEndingDate());
			stmt.setBoolean(8, timesheet.isSubmitted());
			stmt.setBoolean(9, timesheet.isApproved());

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
			PreparedStatement stmt = conn.
					prepareStatement("select * from timesheet where timesheetId=?");
			stmt.setInt(1, id);
			ResultSet results = stmt.executeQuery();
			results.next();
			timesheet = new Timesheet(results.getInt(1),results.getInt(2),
					results.getInt(3),results.getInt(4),results.getInt(5),
					results.getInt(6),results.getInt(7), results.getString(8),
					results.getBoolean(9),results.getBoolean(10));
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
				Timesheet timesheet = new Timesheet
						(rs.getInt("timesheet_id"),
						rs.getInt("user_id"),rs.getInt("mon_hours"),
						rs.getInt("tue_hours"),rs.getInt("wed_hours"),
						rs.getInt("thur_hours"),rs.getInt("fri_hours"),
						rs.getString("week_ending_date"),
						rs.getBoolean("submitted"),
						rs.getBoolean("approved"));
				results.add(timesheet);
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
		String sql = "update Timesheet"
				+	"set mon_hours = ?,"
				+ 	"tue_hours = ?,"
				+	"wed_hours = ?,"
				+ 	"thurs_hours = ?,"
				+ 	"fri_hours = ?,"
				+ 	"week_ending_date = ?,"
				+ 	"submitted = ?,"
				+ 	"approved = ?,"
				+	"where timesheet_id = ?";
				
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
			stmt.setBoolean(7, timesheet.isSubmitted());
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
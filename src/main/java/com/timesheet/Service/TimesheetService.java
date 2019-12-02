package com.timesheet.Service;

import java.sql.SQLException;
import java.util.List;

import com.timesheet.beans.Timesheet;
import com.timesheet.data.TimesheetDAO;

public class TimesheetService {
	
	public static void main(String[] args) {
		TimesheetService ts = new TimesheetService();
		System.out.println(ts.findUserTimesheets(1));
	}
	
	private TimesheetDAO timesheetDAO = new TimesheetDAO();
	
	public Timesheet save(Timesheet timesheet) {
		return timesheetDAO.save(timesheet);
	}
	
	public Timesheet findByTimesheetId(int id) {
		return timesheetDAO.findByTimesheetId(id);

	}
	
	public List<Timesheet> findUserTimesheets(int id) {
		return timesheetDAO.findUserTimesheets(id);
	}

	public void update(Timesheet timesheet) {
		timesheetDAO.update(timesheet);
	}

	public void delete(int id) {
	    	timesheetDAO.delete(id);
	}
	
}
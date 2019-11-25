package com.timesheetProject.Service;


import java.util.List;

import com.timesheetProject.beans.Timesheet;
import com.timesheetProject.data.TimesheetDAO;


public class TimesheetService {

	private TimesheetDAO timesheetDAO = new TimesheetDAO();
	
	public Timesheet save(Timesheet timesheet) {
		return timesheetDAO.save(timesheet);
	}

	public Timesheet findByTimesheetId(int id) {
		return timesheetDAO.findByTimesheetId(id);
	}

	public List<Timesheet> findAll() {
		return timesheetDAO.findAll();
	}

	public void update(Timesheet timesheet) {
		timesheetDAO.update(timesheet);
	}

	public void delete(int id) {
		timesheetDAO.delete(id);
	}
	
}
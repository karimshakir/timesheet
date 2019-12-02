package com.timesheet.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timesheet.Service.TimesheetService;
import com.timesheet.beans.Timesheet;

public class TimesheetController {

	private TimesheetService timesheetService = new TimesheetService();

	public void postTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.getWriter().println(new ObjectMapper().writeValueAsString(
				timesheetService.save(new ObjectMapper().readValue(req.getInputStream(), Timesheet.class))));
		// headers
		resp.setStatus(201);
	}

	public void getTimesheet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		if (req.getParameter("id") != null) {
			resp.getWriter().println(new ObjectMapper()
					.writeValueAsString(timesheetService.findByTimesheetId(Integer.parseInt(req.getParameter("id")))));
		}
	}

	public void putTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		timesheetService.update(new ObjectMapper().readValue(req.getInputStream(), Timesheet.class));
		resp.setStatus(204);

	}

	public void deleteTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		timesheetService.delete(Integer.parseInt(req.getParameter("id")));
		resp.setStatus(204);
	}

}

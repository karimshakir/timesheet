package com.timesheetProject.controllers;

	
	import java.io.IOException;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.fasterxml.jackson.databind.ObjectMapper;
import com.timesheetProject.Service.TimesheetService;

	public class TimesheetController {

		private TimesheetService timesheetService = new TimesheetService();

		// POST /chinook/api/artist
		public void postTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("application/json");
			resp.getWriter().println(new ObjectMapper().writeValueAsString(
					timesheetService.save(new ObjectMapper().readValue(req.getInputStream(), Timesheet.class))));
			// headers
			resp.setStatus(201);
		}

		// GET /chinook/api/artist?id=1
		public void getTimesheet(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
			resp.setContentType("application/json");
			if (req.getParameter("id") != null) {
				resp.getWriter().println(new ObjectMapper()
						.writeValueAsString(timesheetService.findByTimesheetId(Integer.parseInt(req.getParameter("id")))));
			} else if (req.getParameter("name") != null) {
				resp.getWriter().println(
						new ObjectMapper().writeValueAsString(timesheetService.searchByName(req.getParameter("name"))));
			} else {
				resp.getWriter().println(new ObjectMapper()
						.writeValueAsString(timesheetService.findAll()));
			}
		}

		// PUT /chinook/api/artist
		public void putTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("application/json");
			timesheetService.update(new ObjectMapper().readValue(req.getInputStream(), Timesheet.class));
			resp.setStatus(204);
			
		}

		// DELETE /chinook/api/artist?id=1
		public void deleteTimesheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("application/json");
			timesheetService.delete(Integer.parseInt(req.getParameter("id")));
			resp.setStatus(204);
		}

	}

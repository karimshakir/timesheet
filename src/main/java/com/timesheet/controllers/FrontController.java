
package com.timesheet.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	

	private UserController userController = new UserController();
	private TimesheetController timesheetController = new TimesheetController();

	protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		switch (uri) {
		case "/timesheet/api/user":
			System.out.println("successfully made it to USERfrontController");
		if (req.getMethod().equals("POST")) {
			userController.postUser(req, resp);
			return;
		}
			break;
			
		case "/timesheet/api/timesheets":
			System.out.println("successfully made it to TSfrontController");

			if (req.getMethod().equals("POST")) {
				timesheetController.postTimesheet(req, resp);
				return;
			}
			if (req.getMethod().equals("PUT")) {
				timesheetController.putTimesheet(req, resp);
				return;
			}
			if (req.getMethod().equals("GET")) {
				timesheetController.getTimesheet(req, resp);
				return;
			}
			if (req.getMethod().equals("DELETE")) {
				timesheetController.deleteTimesheet(req, resp);
				return;
			}

		default:
			break;	
			
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Front Controller Initialized!");
	}

}
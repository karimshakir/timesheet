package com.timesheet.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timesheet.Service.UserService;
import com.timesheet.beans.User;
import com.timesheet.data.UserDAO;

public class UserController {

	public static void main(String[] args) {
		

	}

	private UserService userService = new UserService();
	private UserDAO ud = new UserDAO();


	
	public void postUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		System.out.println("Made it inside user controller");
		String username = req.getParameter("username");
		String password = req.getParameter("password");


		User user =userService.authenticateUser(username, password);
		System.out.println(user.getF_name());
	
		if (user.getF_name() != null) {
			Cookie userid = new Cookie("UserId", String.valueOf(user.getUserId()));
			
			userid.setMaxAge(2000);
			
			resp.addCookie(userid);
		}
		
		resp.setStatus(201);
	}

}

package com.timesheet.Service;

import java.sql.SQLException;
import java.util.List;

import com.timesheet.beans.User;
import com.timesheet.data.UserDAO;

public class UserService {
	
	public static void main(String[] args) {
		UserService us = new UserService();
		System.out.println(us.authenticateUser("user1", "password")); 
	}

	private UserDAO userDAO = new UserDAO();

//	public User save(User user) {
//		return userDAO.save(user);
//	}
	
	public User authenticateUser(String userName, String password) {
		System.out.println("made it into UserService");
	
			try {
				return userDAO.authenticateUser(userName, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		return null;
	}

//	public User findByUserId(int id) {
//		return userDAO.findByUserId(id);
//	}
//	
//	public void delete(int id) {
//		userDAO.delete(id);
//	}

}


package com.timesheetProject.Service;

import java.util.List;

import com.timesheetProject.beans.User;
import com.timesheetProject.data.UserDAO;

public class UserService {

	private UserDAO userDAO = new UserDAO();

	public User save(User user) {
		return userDAO.save(user);
	}

	public User findByUserId(int id) {
		return userDAO.findByUserId(id);
	}

	public List<User> findAll() {
		return userDAO.findAll();
	}

}

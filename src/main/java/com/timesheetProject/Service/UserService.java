package com.timesheetProject.Service;


	import java.util.List;
	import java.util.Set;

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

		public Set<User> searchByName(String search) {
			return userDAO.searchByName(search);
		}

		public void update(User user) {
			userDAO.update(user);
		}

		public void delete(int id) {
			userDAO.delete(id);
		}
		
	}

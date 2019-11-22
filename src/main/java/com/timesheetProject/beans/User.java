package com.timesheetProject.beans;

public class User {

	private int userId;
	private String name;
	private String email;
	private Boolean managerStatus;
	
	public User() {
		super();
	}
	public User(int userId, String name, String email, Boolean managerStatus) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.managerStatus = managerStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getManagerStatus() {
		return managerStatus;
	}
	public void setManagerStatus(Boolean managerStatus) {
		this.managerStatus = managerStatus;
	}

	
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + userId;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		if (userId != other.userId)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", name=" + name + "]";
//	}

}
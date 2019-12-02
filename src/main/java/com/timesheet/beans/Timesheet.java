package com.timesheet.beans;

public class Timesheet {
	
	private int timesheetId;
	private int userId;
	private int timesheetStatusId;
	private int monHours;
	private int tueHours;
	private int wedHours;
	private int thurHours;
	private int friHours;
	private String weekEndingDate;
	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Timesheet(int timesheetId, int userId, int timesheetStatusId, int monHours, int tueHours, int wedHours,
			int thurHours, int friHours, String weekEndingDate) {
		super();
		this.timesheetId = timesheetId;
		this.userId = userId;
		this.timesheetStatusId = timesheetStatusId;
		this.monHours = monHours;
		this.tueHours = tueHours;
		this.wedHours = wedHours;
		this.thurHours = thurHours;
		this.friHours = friHours;
		this.weekEndingDate = weekEndingDate;
	}
	public int getTimesheetId() {
		return timesheetId;
	}
	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTimesheetStatusId() {
		return timesheetStatusId;
	}
	public void setTimesheetStatusId(int timesheetStatusId) {
		this.timesheetStatusId = timesheetStatusId;
	}
	public int getMonHours() {
		return monHours;
	}
	public void setMonHours(int monHours) {
		this.monHours = monHours;
	}
	public int getTueHours() {
		return tueHours;
	}
	public void setTueHours(int tueHours) {
		this.tueHours = tueHours;
	}
	public int getWedHours() {
		return wedHours;
	}
	public void setWedHours(int wedHours) {
		this.wedHours = wedHours;
	}
	public int getThurHours() {
		return thurHours;
	}
	public void setThurHours(int thurHours) {
		this.thurHours = thurHours;
	}
	public int getFriHours() {
		return friHours;
	}
	public void setFriHours(int friHours) {
		this.friHours = friHours;
	}
	public String getWeekEndingDate() {
		return weekEndingDate;
	}
	public void setWeekEndingDate(String weekEndingDate) {
		this.weekEndingDate = weekEndingDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + friHours;
		result = prime * result + monHours;
		result = prime * result + thurHours;
		result = prime * result + timesheetId;
		result = prime * result + timesheetStatusId;
		result = prime * result + tueHours;
		result = prime * result + userId;
		result = prime * result + wedHours;
		result = prime * result + ((weekEndingDate == null) ? 0 : weekEndingDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Timesheet other = (Timesheet) obj;
		if (friHours != other.friHours)
			return false;
		if (monHours != other.monHours)
			return false;
		if (thurHours != other.thurHours)
			return false;
		if (timesheetId != other.timesheetId)
			return false;
		if (timesheetStatusId != other.timesheetStatusId)
			return false;
		if (tueHours != other.tueHours)
			return false;
		if (userId != other.userId)
			return false;
		if (wedHours != other.wedHours)
			return false;
		if (weekEndingDate == null) {
			if (other.weekEndingDate != null)
				return false;
		} else if (!weekEndingDate.equals(other.weekEndingDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Timesheet [timesheetId=" + timesheetId + ", userId=" + userId + ", timesheetStatusId="
				+ timesheetStatusId + ", monHours=" + monHours + ", tueHours=" + tueHours + ", wedHours=" + wedHours
				+ ", thurHours=" + thurHours + ", friHours=" + friHours + ", weekEndingDate=" + weekEndingDate + "]";
	}
	
}

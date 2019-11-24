package com.timesheetProject.beans;

public class Timesheet {
	
	private int timesheetId;
	private int userId;
	private int monHours;
	private int tueHours;
	private int wedHours;
	private int thurHours;
	private int friHours;
	private String weekEndingDate;
	private boolean submitted;
	private boolean approved;
	
	public Timesheet(int timesheetId, int userId, int monHours, int tueHours, int wedHours, int thurHours,
			int friHours, String weekEndingDate, boolean submitted, boolean approved) {
		super();
		this.timesheetId = timesheetId;
		this.userId = userId;
		this.monHours = monHours;
		this.tueHours = tueHours;
		this.wedHours = wedHours;
		this.thurHours = thurHours;
		this.friHours = friHours;
		this.weekEndingDate = weekEndingDate;
		this.submitted = submitted;
		this.approved = approved;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	public int getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
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
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + friHours;
		result = prime * result + monHours;
		result = prime * result + (submitted ? 1231 : 1237);
		result = prime * result + thurHours;
		result = prime * result + timesheetId;
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
		if (approved != other.approved)
			return false;
		if (friHours != other.friHours)
			return false;
		if (monHours != other.monHours)
			return false;
		if (submitted != other.submitted)
			return false;
		if (thurHours != other.thurHours)
			return false;
		if (timesheetId != other.timesheetId)
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
		return "Timesheet [timesheetId=" + timesheetId + ", userId=" + userId + ", monHours=" + monHours + ", tueHours="
				+ tueHours + ", wedHours=" + wedHours + ", thurHours=" + thurHours + ", friHours=" + friHours
				+ ", weekEndingDate=" + weekEndingDate + ", submitted=" + submitted + ", approved=" + approved + "]";
	}



}

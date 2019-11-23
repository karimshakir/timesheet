package com.timesheetProject.beans;

public class Timesheet {
	
	private int timesheetId;
	private int monHours;
	private int tuesHours;
	private int wedHours;
	private int thurHours;
	private int friHours;
	private String weekEndingDate;
	private boolean status;
	
	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Timesheet(int timesheetId, int monHours, int tuesHours, int wedHours, int thurHours, int friHours,
			String weekEndingDate, boolean status) {
		super();
		this.timesheetId = timesheetId;
		this.monHours = monHours;
		this.tuesHours = tuesHours;
		this.wedHours = wedHours;
		this.thurHours = thurHours;
		this.friHours = friHours;
		this.weekEndingDate = weekEndingDate;
		this.status = status;
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

	public int getTuesHours() {
		return tuesHours;
	}

	public void setTuesHours(int tuesHours) {
		this.tuesHours = tuesHours;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + friHours;
		result = prime * result + monHours;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + thurHours;
		result = prime * result + timesheetId;
		result = prime * result + tuesHours;
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
		if (status != other.status)
			return false;
		if (thurHours != other.thurHours)
			return false;
		if (timesheetId != other.timesheetId)
			return false;
		if (tuesHours != other.tuesHours)
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
		return "Timesheet [timesheetId=" + timesheetId + ", monHours=" + monHours + ", tuesHours=" + tuesHours
				+ ", wedHours=" + wedHours + ", thurHours=" + thurHours + ", friHours=" + friHours + ", weekEndingDate="
				+ weekEndingDate + ", status=" + status + "]";
	}
	


}

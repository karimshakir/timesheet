package com.timesheetProject.beans;

public class Timesheet {
	
	private int timesheetId;
	private int mon_hours;
	private int tues_hours;
	private int wed_hours;
	private int thur_hours;
	private int fri_hours;
	private String week_ending_date;
	
	public Timesheet() {
		super();
	}

	public int getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}
//NOTE: USE ILLEGAL ARGUMENT EXCEPTION FOR HOURS EXCEEDING 8
	public int getMon_hours() {
		return mon_hours;
	}

	public void setMon_hours(int mon_hours) {
		this.mon_hours = mon_hours;
	}

	public int getTues_hours() {
		return tues_hours;
	}

	public void setTues_hours(int tues_hours) {
		this.tues_hours = tues_hours;
	}

	public int getWed_hours() {
		return wed_hours;
	}

	public void setWed_hours(int wed_hours) {
		this.wed_hours = wed_hours;
	}

	public int getThur_hours() {
		return thur_hours;
	}

	public void setThur_hours(int thur_hours) {
		this.thur_hours = thur_hours;
	}

	public int getFri_hours() {
		return fri_hours;
	}

	public void setFri_hours(int fri_hours) {
		this.fri_hours = fri_hours;
	}

	public String getWeek_ending_date() {
		return week_ending_date;
	}

	public void setWeek_ending_date(String week_ending_date) {
		this.week_ending_date = week_ending_date;
	}


	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + timesheetId;
//		result = prime * result + ((week_ending_date == null) ? 0 : week_ending_date.hashCode());
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
//		Timesheet other = (Timesheet) obj;
//		if (userId != other.timesheetId)
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
//		return "Timesheet [timesheetId=" + timesheetId + ", name=" + name + "]";
//	}

}

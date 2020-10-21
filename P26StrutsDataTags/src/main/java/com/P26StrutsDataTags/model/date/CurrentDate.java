package com.P26StrutsDataTags.model.date;

import java.util.Date;

public class CurrentDate {
	private Date currentDate;
	public String execute() {
		setCurrentDate(new Date());
		return "success";
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
}

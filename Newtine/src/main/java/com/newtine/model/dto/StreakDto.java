package com.newtine.model.dto;

import java.util.Date;

public class StreakDto {
	private int userNo;
	private Date healthDate;
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public Date getHealthDate() {
		return healthDate;
	}
	public void setHealthDate(Date healthDate) {
		this.healthDate = healthDate;
	}
	
	
}

package com.newtine.model.dto;

public class UserinfoforfollowDto {
	int userNo;
	String userId;
	
	UserinfoforfollowDto(int userNo, String userId) {
		this.userNo = userNo;
		this.userId = userId;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}

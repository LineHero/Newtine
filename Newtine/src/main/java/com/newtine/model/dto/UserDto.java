package com.newtine.model.dto;

public class UserDto {
	
	private int userNo;
	private String userId;
	private String userPassword;
	private String userNickname;
	private String userName;
	private String userEmail;
	private String userPhoneNumber;
	private boolean userIsadmin;
	private String userProfileFileId;
	private String userProfileFileName;
	
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
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public boolean isUserIsadmin() {
		return userIsadmin;
	}
	public void setUserIsadmin(boolean userIsadmin) {
		this.userIsadmin = userIsadmin;
	}
	public String getUserProfileFileId() {
		return userProfileFileId;
	}
	public void setUserProfileFileId(String userProfileFileId) {
		this.userProfileFileId = userProfileFileId;
	}
	public String getUserProfileFileName() {
		return userProfileFileName;
	}
	public void setUserProfileFileName(String userProfileFileName) {
		this.userProfileFileName = userProfileFileName;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	
}

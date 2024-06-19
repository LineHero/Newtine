package com.newtine.model.dto;

import java.util.Date;

public class ReviewDto {
	private int reviewNo;
	private int userNo;
	private int listNo;
	private String reviewContent;
	private Date reviewDate;
	private double reviewRate;
	
	
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getListNo() {
		return listNo;
	}
	public void setListNo(int listNo) {
		this.listNo = listNo;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public double getReviewRate() {
		return reviewRate;
	}
	public void setReviewRate(double reviewRate) {
		this.reviewRate = reviewRate;
	}
	

}

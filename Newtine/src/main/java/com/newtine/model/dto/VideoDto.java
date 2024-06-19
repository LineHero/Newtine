package com.newtine.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class VideoDto {
	private int videoNo;
	private int userNo;
	private String videoTitle;
	private String videoURL;
	private String videoPart;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date videoDate;
	
	public int getVideoNo() {
		return videoNo;
	}
	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoURL() {
		return videoURL;
	}
	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}
	public String getVideoPart() {
		return videoPart;
	}
	public void setVideoPart(String videoPart) {
		this.videoPart = videoPart;
	}
	public Date getVideoDate() {
		return videoDate;
	}
	public void setVideoDate(Date videoDate) {
		this.videoDate = videoDate;
	}
	
}

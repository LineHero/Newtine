package com.newtine.model.dto;

import java.util.Date;

public class MylistDto {
	private int listNo;
	private int userNo;
	private String listTitle;
	private String listExp;
	private double listRate;
	private int listPart;
	private int listTime;
	private int listPlace;
	private int listViewcnt;
	private boolean listIsofficial;
	private Date listDate;
	private String listUrl;
	
	
	public String getListUrl() {
		return listUrl;
	}
	public void setListUrl(String listUrl) {
		this.listUrl = listUrl;
	}
	public int getListViewcnt() {
		return listViewcnt;
	}
	public void setListViewcnt(int listViewcnt) {
		this.listViewcnt = listViewcnt;
	}
	public int getListNo() {
		return listNo;
	}
	public void setListNo(int listNo) {
		this.listNo = listNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getListTitle() {
		return listTitle;
	}
	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}
	public String getListExp() {
		return listExp;
	}
	public void setListExp(String listExp) {
		this.listExp = listExp;
	}
	public double getListRate() {
		return listRate;
	}
	public void setListRate(double listRate) {
		this.listRate = listRate;
	}
	public int getListPart() {
		return listPart;
	}
	public void setListPart(int listPart) {
		this.listPart = listPart;
	}
	public int getListTime() {
		return listTime;
	}
	public void setListTime(int listTime) {
		this.listTime = listTime;
	}
	public int getListPlace() {
		return listPlace;
	}
	public void setListPlace(int listPlace) {
		this.listPlace = listPlace;
	}
	public boolean isListIsofficial() {
		return listIsofficial;
	}
	public void setListIsofficial(boolean listIsofficial) {
		this.listIsofficial = listIsofficial;
	}
	public Date getListDate() {
		return listDate;
	}
	public void setListDate(Date listDate) {
		this.listDate = listDate;
	}
	
	
}

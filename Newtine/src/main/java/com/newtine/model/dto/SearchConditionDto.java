package com.newtine.model.dto;

public class SearchConditionDto {
	
	private int part;
	private int page;
	private int isofficial;
	private String searchquery;
	
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getIsofficial() {
		return isofficial;
	}
	public void setIsofficial(int isofficial) {
		this.isofficial = isofficial;
	}
	public String getSearchquery() {
		return searchquery;
	}
	public void setSearchquery(String searchquery) {
		this.searchquery = searchquery;
	}
	
	
}

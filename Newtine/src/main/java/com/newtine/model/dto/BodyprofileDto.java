package com.newtine.model.dto;

import java.util.Date;

public class BodyprofileDto {
	private Date measureDate;
	private int userNo;
	private double weight;
	private double muscleMass;
	private double skeletalmuscleMass;
	private double bodyfatPercentage;
	private double height;
	
	
	
	public Date getMeasureDate() {
		return measureDate;
	}
	public void setMeasureDate(Date measureDate) {
		this.measureDate = measureDate;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getMuscleMass() {
		return muscleMass;
	}
	public void setMuscleMass(double muscleMass) {
		this.muscleMass = muscleMass;
	}
	public double getSkeletalmuscleMass() {
		return skeletalmuscleMass;
	}
	public void setSkeletalmuscleMass(double skeletalmuscleMass) {
		this.skeletalmuscleMass = skeletalmuscleMass;
	}
	public double getBodyfatPercentage() {
		return bodyfatPercentage;
	}
	public void setBodyfatPercentage(double bodyfatPercentage) {
		this.bodyfatPercentage = bodyfatPercentage;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	
	
}

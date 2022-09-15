package com.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

public class Tour {
	
	
	private int tourId;
	
	
	private String tourName;
	
		private String description;
	
	
	private int duration;
	
	
	private String startDate;
	
	
	private int amountPP;
	
	 @OneToMany(mappedBy = "tour")
	    private Set<Booked> booking = new HashSet<>();
	
	public Tour() {
		// TODO Auto-generated constructor stub
	}

	

	public Tour(int tourId, String tourName, String description, int duration, String startDate, int amountPP) {
		this.tourId = tourId;
		this.tourName = tourName;
		this.description = description;
		this.duration = duration;
		this.startDate = startDate;
		this.amountPP = amountPP;
	}



	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public int getAmountPP() {
		return amountPP;
	}



	public void setAmountPP(int amountPP) {
		this.amountPP = amountPP;
	}
	
	
	

}

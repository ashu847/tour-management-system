package com.demo.service;

import java.util.List;

import com.demo.entity.Booked;
import com.demo.entity.Tour;

public interface adminServiceDao  {
	
	public boolean validCredential(String id, String pass);
	
	public String addTour(Tour tour);
	
	public String bookTour(Booked booked, int tourId);
	
	public String updatePaymentStatus(int bookid);
	
	public List<Tour> listTour();
	
	public List<Booked> listBook(int customerId);
	
	public List<Booked> listBooked();

}

package com.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.adminRepo;
import com.demo.bookedRepo;
import com.demo.tourRepo;
import com.demo.entity.Admin;
import com.demo.entity.Booked;
import com.demo.entity.Tour;

@Service
public class adminService implements adminServiceDao {
	
	@Autowired
	adminRepo adrepo;
	
	@Autowired
	tourRepo torepo;
	
	@Autowired
	bookedRepo bookrepo;
	
	public boolean validCredential(String id, String pass) {
		Optional<Admin> admin = adrepo.findByUsername(id);
		
		if(admin.isPresent()) {
			if(admin.get().getPass().equals(pass)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		else {
			return false;
		}
		
	}
	
	public String addTour(Tour tour) {
		torepo.save(tour);
		return "Successfully added";
	}
	
	public String bookTour(Booked booked, int tourId) {
		Optional<Tour> tour = torepo.findById(tourId);
        booked.setPrice(tour.get().getAmountPP() * booked.getPassengers());
        booked.setTour(tour.get());
        bookrepo.save(booked);
        return "Booking Added Successfully!";
	}
	
	public String updatePaymentStatus(int bookid) {
		Optional<Booked> bo= bookrepo.findById(bookid);
		bo.get().setStatus(true);
		bookrepo.save(bo.get());
		return "Payment Succesfull";
	}

	public List<Tour> listTour(){
		List<Tour> tours= torepo.findAll();
		return tours;
	}
	
	@Transactional
	public List<Booked> listBook(int customerId){
		List<Booked> bookings= bookrepo.findAllBookedTours(customerId);
		return bookings;
	}
	
	public List<Booked> listBooked(){
		List<Booked> bookeds= bookrepo.findAll();
		return bookeds;
	}
}

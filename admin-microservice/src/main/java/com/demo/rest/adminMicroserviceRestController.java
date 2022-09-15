package com.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Admin;
import com.demo.entity.Booked;
import com.demo.entity.Tour;
import com.demo.service.adminServiceDao;

@RestController
public class adminMicroserviceRestController {
	
	@Autowired
	private adminServiceDao admService;
	
	@PostMapping(value="/adminlogin", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> validateAdmin(@RequestBody Admin admin) {
		boolean res= admService.validCredential(admin.getUsername(), admin.getPass());
		if(res==true) {
			return ResponseEntity.ok("second");
		}
		else {
			return ResponseEntity.ok("{\"status\":\"Invalid user\"}");
		}
		
	}
	
	@PostMapping(value="/addtour", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addTourPackage(@RequestBody Tour tour) {
		admService.addTour(tour);
			return ResponseEntity.ok("{\"status\":\"Tour added\"}");
		}
	
	@PostMapping(value="/booking/add/{tourId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addBooking(@RequestBody Booked booking,@PathVariable("tourId") int tourId){
		System.out.println(tourId);
		System.out.println(booking.getCustomerId());
         admService.bookTour(booking, tourId);
        return ResponseEntity.ok("{\"status\":\"Booking Added Successfully\"}");
    }
	
	@GetMapping(value="/paymentupdate/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updatePayment(@PathVariable("bookingId") int bookid) {
		admService.updatePaymentStatus(bookid);
			return ResponseEntity.ok("{\"status\":\"Payment Updated for Booked tour\"}");
		}
	
	@GetMapping(value="/tourlist")
	public ResponseEntity<List<Tour>> findallTour(){
		
		List<Tour> tours= admService.listTour();
		return ResponseEntity.ok(tours);
		
	}
	
	@GetMapping(value="/booktours/{customerId}")
	public ResponseEntity<List<Booked>> findallTour(@PathVariable("customerId") int customerId){
		
		List<Booked> bookTours= admService.listBook(customerId);
		return ResponseEntity.ok(bookTours);
		
	}
	
	@GetMapping(value="/bookedtours")
	public ResponseEntity<List<Booked>> findallTours(){
		
		List<Booked> bookedTours= admService.listBooked();
		return ResponseEntity.ok(bookedTours);
		
	}
		
	}

	


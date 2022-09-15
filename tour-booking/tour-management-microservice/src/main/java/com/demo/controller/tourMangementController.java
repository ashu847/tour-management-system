package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.Admin;
import com.demo.entity.Booked;
import com.demo.entity.Registration;
import com.demo.entity.Tour;



@Controller
public class tourMangementController {
	
	@Autowired
	RestTemplate rt;
	
	@GetMapping(value = "/registration")
	public String registration(ModelMap map) {
		Registration user = new Registration();
		map.addAttribute("user", user);
		return "registration";

	}
	
	@PostMapping(value = "/registration")
	public ModelAndView registerUser(@ModelAttribute("user") Registration user) {

		ModelAndView mv = new ModelAndView();

		ResponseEntity<String> resp1 = rt.postForEntity("http://localhost:8780/adduser", user, String.class);
		

		String message = resp1.getBody();
		mv.setViewName("registration");
		mv.addObject("mess", message);
		return mv;

	}

	@GetMapping(value = "/login")
	public String login(ModelMap map) {
		Admin admin = new Admin();
		map.addAttribute("admin", admin);
		return "login";
	}

	@PostMapping(value = "/login")
	public ModelAndView loginCheck(@ModelAttribute("admin") Admin admin) {

		ModelAndView mv = new ModelAndView();
		ResponseEntity<String> resp1 = rt.postForEntity("http://localhost:8680/adminlogin/",admin, String.class);
		ResponseEntity<String> resp2 = rt.getForEntity("http://localhost:8780/custlogin/"+admin.getUsername()+"/"+admin.getPass(), String.class);
		
       if(resp1.getBody().equals("second")) {
    	   
    	   //mv.addObject("mess","Admin Login"+admin.getUsername());
			mv.setViewName("adminHome");
       }
       
       else if(resp2.getBody().equals("first")) {
    
    	   ResponseEntity<Registration> resp3 = rt.getForEntity("http://localhost:8780/findcust/"+admin.getUsername(), Registration.class);
    	   mv.addObject("custId",resp3.getBody().getCustomerid());
			mv.setViewName("customerHome");
       }
       
       else {
    	   mv.addObject("mess","Login Failed");
			mv.setViewName("login");
       }
		
		return mv;

	}
	
	@GetMapping(value = "/addtour")
	public String addTour(ModelMap map) {
		Tour tour = new Tour();
		map.addAttribute("tour", tour);
		return "addTour";
	}
	
	@PostMapping(value = "/addtour")
	public ModelAndView addNewTour(@ModelAttribute("tour") Tour tour) {

		ModelAndView mv = new ModelAndView();

		ResponseEntity<String> resp1 = rt.postForEntity("http://localhost:8680/addtour", tour, String.class);
		

		String message = resp1.getBody();
		mv.setViewName("addTour");
		mv.addObject("mess", message);
		return mv;

	}
	
	@GetMapping(value = "/viewtours")
	public ModelAndView viewBookedTours() {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<List<Booked>> resp1 = rt.exchange(
				"http://localhost:8680/bookedtours", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Booked>>() {
				});
		mv.addObject("bookedTours",resp1.getBody());
		mv.setViewName("booktour");
		return mv;
	}
	
	@GetMapping(value = "/listalltour")
	public ModelAndView listTours(@RequestParam("customerId") String customerId) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<List<Tour>> resp1 = rt.exchange(
				"http://localhost:8680/tourlist", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Tour>>() {
				});
		mv.addObject("listTours",resp1.getBody());
		mv.addObject("custId",customerId);
		mv.setViewName("tourlist");
		return mv;
	}
	
	@GetMapping(value = "/booktour")
	public ModelAndView bookTour(@RequestParam("customerId") String customerId, @RequestParam("tourId") int tourId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("custId",customerId);
		mv.addObject("tourId",tourId);
		mv.setViewName("book");
		return mv;

	}
	
	@PostMapping(value = "/booktour")
	public ModelAndView addBooking(@ModelAttribute("booking") Booked booking, @RequestParam("tourId") int tourId) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<String> response = rt.postForEntity("http://localhost:8680/booking/add/" + tourId, booking,
				String.class);

		mv.addObject(response);
		String message = "Booked Successfully. Make Payment! ";
		mv.addObject("message", message);
		mv.setViewName("payment");
		return mv;
	}
	
	@GetMapping(value = "/customer/booked")
	public ModelAndView bookedTours(@RequestParam("customerId") int customerId, ModelMap map) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<List<Booked>> response = rt.exchange("http://localhost:8680/booktours/" + customerId,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Booked>>() {
				});
		mv.setViewName("customerBookedList");
		mv.addObject("list", response.getBody());
		return mv;
	}
	
	@GetMapping(value = "/customer/booking/payment")
	public ModelAndView makeTourPayment(@RequestParam("bookingId") int bookingId) {
		ModelAndView mv = new ModelAndView();
		ResponseEntity<String> response = rt.getForEntity("http://localhost:8680/paymentupdate/" + bookingId,
				String.class);

		mv.addObject(response);
		String message = "Payment Done Successfully!";
		mv.addObject("message", message);
		mv.setViewName("payment");
		return mv;
	}
	
}

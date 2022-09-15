package com.demo.entity;



import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;






public class Booked {



   
    private int bookingId;


    private int customerId;


    private int passengers;



    private double price;



    private boolean status;



   @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TOURID", referencedColumnName = "TOURID")
    private Tour tour;



   public Booked() {
    }



   public Booked(int bookingId, int customerId, int passengers, double price, boolean status) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.passengers = passengers;
        this.price = price;
        this.status = status;
    }



   public int getBookingId() {
        return bookingId;
    }



   public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }



   public int getCustomerId() {
        return customerId;
    }



   public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }



   public int getPassengers() {
        return passengers;
    }



   public void setPassengers(int passengers) {
        this.passengers = passengers;
    }



   public double getPrice() {
        return price;
    }



   public void setPrice(double price) {
        this.price = price;
    }



   public boolean isStatus() {
        return status;
    }



   public void setStatus(boolean status) {
        this.status = status;
    }
    
    public Tour getTour() {
        return tour;
    }



   public void setTour(Tour tour) {
        this.tour = tour;
    }



}
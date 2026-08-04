package com.flightreservation.model;

public class Booking {

    private int bookingId;

    private String bookingDate;

    private String journeyDate;

    private int seats;

    private double totalPrice;

    private String status;

    private int userId;

    private int flightId;

    public Booking() {

    }

    public Booking(int bookingId, String bookingDate, String journeyDate,
            int seats, double totalPrice,
            String status, int userId, int flightId) {

        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.journeyDate = journeyDate;
        this.seats = seats;
        this.totalPrice = totalPrice;
        this.status = status;
        this.userId = userId;
        this.flightId = flightId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

}

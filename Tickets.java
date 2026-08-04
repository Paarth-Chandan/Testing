package com.flightreservation.model;

import javax.validation.constraints.NotBlank;

public class Ticket {

    private int ticketId;

    @NotBlank(message = "Passenger Name is required")
    private String passengerName;

    @NotBlank(message = "Gender is required")
    private String gender;

    private int age;

    private String seatNumber;

    private String pnr;

    private int bookingId;

    public Ticket() {

    }

    public Ticket(int ticketId, String passengerName,
            String gender, int age,
            String seatNumber, String pnr,
            int bookingId) {

        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.gender = gender;
        this.age = age;
        this.seatNumber = seatNumber;
        this.pnr = pnr;
        this.bookingId = bookingId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

}

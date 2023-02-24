package com.ty.SpringBootPharmacyApplication.exception;

public class BookingArrivalDateNotFoundException {
	String message = "Booking Arrival date Not Found";

	public String getMessage() {
		return message;
	}

	public BookingArrivalDateNotFoundException() {
		super();
	}

	public BookingArrivalDateNotFoundException(String message) {
		super();
		this.message = message;
	}

}

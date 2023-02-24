package com.ty.SpringBootPharmacyApplication.exception;

public class BookingArrivalDateNotFoundException extends RuntimeException {
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

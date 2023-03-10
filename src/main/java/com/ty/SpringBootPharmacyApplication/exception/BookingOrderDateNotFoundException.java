package com.ty.SpringBootPharmacyApplication.exception;

public class BookingOrderDateNotFoundException extends RuntimeException {
	String message = "Booking Order Date Not Found";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BookingOrderDateNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BookingOrderDateNotFoundException() {
		super();
	}

}

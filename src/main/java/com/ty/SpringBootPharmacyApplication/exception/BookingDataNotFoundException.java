package com.ty.SpringBootPharmacyApplication.exception;

public class BookingDataNotFoundException extends RuntimeException {
	String message = "Booking Data Not Found";

	public String getMessage() {
		return message;
	}

	public BookingDataNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BookingDataNotFoundException() {
		super();
	}

}

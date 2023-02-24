package com.ty.SpringBootPharmacyApplication.exception;

public class BookingIdNotFoundException extends RuntimeException{
	String message= "Booking Id Not Found";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BookingIdNotFoundException(String message) {
		this.message = message;
	}

	public BookingIdNotFoundException() {
		super();
	}
	
	
	

}

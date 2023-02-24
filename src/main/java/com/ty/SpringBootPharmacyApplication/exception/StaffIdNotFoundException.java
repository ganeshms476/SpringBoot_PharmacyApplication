package com.ty.SpringBootPharmacyApplication.exception;

public class StaffIdNotFoundException extends RuntimeException {
	String message = "staff id   not found ";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public StaffIdNotFoundException() {

	}

	public StaffIdNotFoundException(String message) {
		this.message = message;
	}
}

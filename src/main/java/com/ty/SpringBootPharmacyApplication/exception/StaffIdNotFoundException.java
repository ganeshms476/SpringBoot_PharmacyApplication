package com.ty.SpringBootPharmacyApplication.exception;

public class StaffIdNotFoundException extends RuntimeException {
	String message = "Staff Id Not Found";

	public String getMessage() {
		return message;
	}

	public StaffIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public StaffIdNotFoundException() {
		super();
	}

}

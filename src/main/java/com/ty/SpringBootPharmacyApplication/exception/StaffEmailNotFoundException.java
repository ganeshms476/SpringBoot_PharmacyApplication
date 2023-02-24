package com.ty.SpringBootPharmacyApplication.exception;

public class StaffEmailNotFoundException extends RuntimeException {
	String message = "Staff Email Not found";

	public String getMessage() {
		return message;
	}

	public StaffEmailNotFoundException(String message) {
		super();
		this.message = message;
	}

	public StaffEmailNotFoundException() {
		super();
	}

}

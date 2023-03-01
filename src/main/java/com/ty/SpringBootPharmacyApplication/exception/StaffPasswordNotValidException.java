package com.ty.SpringBootPharmacyApplication.exception;

public class StaffPasswordNotValidException extends RuntimeException {

	String message = "Staff Email is not a Valid Email";

	public String getMessage() {
		return message;
	}

	public StaffPasswordNotValidException(String message) {
		super();
		this.message = message;
	}

	public StaffPasswordNotValidException() {

	}

}

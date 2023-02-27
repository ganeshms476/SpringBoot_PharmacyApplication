package com.ty.SpringBootPharmacyApplication.exception;

public class AdminIdNotFoundException extends RuntimeException {
	String message = "Admin not found for this id";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public AdminIdNotFoundException() {

	}

	public AdminIdNotFoundException(String message) {
		this.message = message;
	}
}

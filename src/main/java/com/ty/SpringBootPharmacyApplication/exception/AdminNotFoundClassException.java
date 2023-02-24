package com.ty.SpringBootPharmacyApplication.exception;

public class AdminNotFoundClassException extends RuntimeException {
	String message = "Admin not found for this id";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public AdminNotFoundClassException() {

	}

	public AdminNotFoundClassException(String message) {
		this.message = message;
	}
}

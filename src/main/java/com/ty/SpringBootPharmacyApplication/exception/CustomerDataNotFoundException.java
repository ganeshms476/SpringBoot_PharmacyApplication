package com.ty.SpringBootPharmacyApplication.exception;

public class CustomerDataNotFoundException extends RuntimeException {
	String message = "Customer Data Not Found";

	public String getMessage() {
		return message;
	}

	public CustomerDataNotFoundException(String message) {
		super();
		this.message = message;
	}

	public CustomerDataNotFoundException() {
		super();
	}

}

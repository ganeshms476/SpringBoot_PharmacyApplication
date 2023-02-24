package com.ty.SpringBootPharmacyApplication.exception;

public class CustomerIdNotFoundException extends RuntimeException {
	String message = "Customer Id Not Found";

	public String getMessage() {
		return message;
	}

	public CustomerIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public CustomerIdNotFoundException() {
		super();
	}

}

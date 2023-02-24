package com.ty.SpringBootPharmacyApplication.exception;

public class CustomerEmailNotFoundException extends RuntimeException {
	String message = "Customer Email Not Found";

	public String getMessage() {
		return message;
	}

	public CustomerEmailNotFoundException(String message) {
		super();
		this.message = message;
	}

	public CustomerEmailNotFoundException() {
		super();
	}

}

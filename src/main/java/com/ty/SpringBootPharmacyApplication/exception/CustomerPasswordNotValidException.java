package com.ty.SpringBootPharmacyApplication.exception;

public class CustomerPasswordNotValidException extends RuntimeException {

	String message = "Customer Password is not valid";

	public String getMessage() {
		return message;
	}

	public CustomerPasswordNotValidException(String message) {
		super();
		this.message = message;
	}

	public CustomerPasswordNotValidException() {
		super();
	}

}

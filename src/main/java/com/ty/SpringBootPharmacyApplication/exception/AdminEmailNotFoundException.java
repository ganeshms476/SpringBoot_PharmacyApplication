package com.ty.SpringBootPharmacyApplication.exception;

public class AdminEmailNotFoundException extends RuntimeException {
	String message = "Adress Id not found Exception";

	public String getMessage() {
		return message;
	}

	public AdminEmailNotFoundException(String message) {
		super();
		this.message = message;
	}

	public AdminEmailNotFoundException() {
		super();
	}
}

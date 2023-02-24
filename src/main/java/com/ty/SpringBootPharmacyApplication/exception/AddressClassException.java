package com.ty.SpringBootPharmacyApplication.exception;

public class AddressClassException extends RuntimeException {
	String message = "Adress Id not found Exception";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public AddressClassException(String message) {
		super();
		this.message = message;
	}

	public AddressClassException() {
		super();
	}

}

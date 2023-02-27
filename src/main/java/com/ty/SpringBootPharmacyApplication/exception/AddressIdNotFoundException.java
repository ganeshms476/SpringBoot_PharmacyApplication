package com.ty.SpringBootPharmacyApplication.exception;

public class AddressIdNotFoundException extends RuntimeException {
	String message = "Adress Id not found Exception";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public AddressIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public AddressIdNotFoundException() {
		super();
	}

}

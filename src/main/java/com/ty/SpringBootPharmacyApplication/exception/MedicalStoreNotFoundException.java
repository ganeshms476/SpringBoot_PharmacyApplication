package com.ty.SpringBootPharmacyApplication.exception;

public class MedicalStoreNotFoundException extends RuntimeException {
	String message = "MedicalStore not found for this id";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public MedicalStoreNotFoundException(String message) {
		super();
		this.message = message;
	}

	public MedicalStoreNotFoundException() {
		super();
	}
}

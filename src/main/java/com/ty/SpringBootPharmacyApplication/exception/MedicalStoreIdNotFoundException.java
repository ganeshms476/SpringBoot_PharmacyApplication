package com.ty.SpringBootPharmacyApplication.exception;

public class MedicalStoreIdNotFoundException extends RuntimeException {
	String message = "MedicalStore not found for this id";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public MedicalStoreIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public MedicalStoreIdNotFoundException() {
		super();
	}
}

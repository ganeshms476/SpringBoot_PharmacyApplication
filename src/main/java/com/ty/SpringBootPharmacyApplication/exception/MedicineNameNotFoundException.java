package com.ty.SpringBootPharmacyApplication.exception;

public class MedicineNameNotFoundException extends RuntimeException {
	String message = "medicine name not found ";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public MedicineNameNotFoundException() {

	}

	public MedicineNameNotFoundException(String message) {
		this.message = message;
	}
}

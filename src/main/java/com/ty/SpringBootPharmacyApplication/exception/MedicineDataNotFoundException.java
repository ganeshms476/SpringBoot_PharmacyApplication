package com.ty.SpringBootPharmacyApplication.exception;

public class MedicineDataNotFoundException extends RuntimeException {
	String message = "medicine data not found ";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public MedicineDataNotFoundException() {

	}

	public MedicineDataNotFoundException(String message) {
		this.message = message;
	}
}

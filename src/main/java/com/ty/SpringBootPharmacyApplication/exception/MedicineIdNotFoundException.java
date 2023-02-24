package com.ty.SpringBootPharmacyApplication.exception;

public class MedicineIdNotFoundException extends RuntimeException {
	String message = "medicine id is not found ";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public MedicineIdNotFoundException() {

	}

	public MedicineIdNotFoundException(String message) {
		this.message = message;
	}
}

package com.ty.SpringBootPharmacyApplication.exception;

public class MedicineIdNotFoundException extends RuntimeException {

	String message = "Medicine Id Not Found";

	public MedicineIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public MedicineIdNotFoundException() {

	}

}

package com.ty.SpringBootPharmacyApplication.exception;

public class MedicalStoreDataNotFoundExcpetion extends RuntimeException {
	String message = "MedicalStore not found for this id";

	public String getMessage() {
		return message;
	}

	public MedicalStoreDataNotFoundExcpetion(String message) {
		super();
		this.message = message;
	}

	public MedicalStoreDataNotFoundExcpetion() {
		super();
	}
}

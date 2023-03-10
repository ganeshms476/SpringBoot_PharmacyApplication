package com.ty.SpringBootPharmacyApplication.exception;

public class AdminPasswordInvalidException extends RuntimeException {
	String message = "Password invalid";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public AdminPasswordInvalidException(String message) {
		super();
		this.message= message;
	}

	public AdminPasswordInvalidException() {
		super();
	}
}

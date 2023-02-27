package com.ty.SpringBootPharmacyApplication.exception;

 
public class StaffEmailNotFoundException extends RuntimeException{
	String message = "staff email  is not found ";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public StaffEmailNotFoundException() {

	}

	public StaffEmailNotFoundException(String message) {
		this.message = message;
	}
 
}

package com.ty.SpringBootPharmacyApplication.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@ControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AddressIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(AddressIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Address not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminEmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(AdminEmailNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Admin Email not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(AdminIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Admin not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MedicalStoreDataNotFoundExcpetion.class)
	public ResponseEntity<ResponseStructure<String>> getException(MedicalStoreDataNotFoundExcpetion ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Medical store not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MedicalStoreIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(MedicalStoreIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("MedicalStore Id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> exceptions = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>();
		for (ObjectError error : exceptions) {
			String fieldname = ((FieldError) error).getField();
			String message = ((FieldError) error).getDefaultMessage();
			map.put(fieldname, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BookingArrivalDateNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(BookingArrivalDateNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("MedicalStore Id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	

}

package com.ty.SpringBootPharmacyApplication.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

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
		structure.setMessage("Address Id not found");
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
		structure.setMessage("Admin Id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminPasswordInvalidException.class)
	public ResponseEntity<ResponseStructure<String>> getException(AdminPasswordInvalidException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Admin password is not valid");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MedicalStoreDataNotFoundExcpetion.class)
	public ResponseEntity<ResponseStructure<String>> getException(MedicalStoreDataNotFoundExcpetion ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Medical store data not found");
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

	@ExceptionHandler(BookingArrivalDateNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(BookingArrivalDateNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Booking Arrival date not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookingDataNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(BookingDataNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Booking data not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookingIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(BookingIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Booking Id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookingOrderDateNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(BookingOrderDateNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Booking Order date not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(CustomerIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Customer Id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerDataNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(CustomerDataNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Customer data not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerEmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(CustomerEmailNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Customer Email is not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerPasswordNotValidException.class)
	public ResponseEntity<ResponseStructure<String>> getException(CustomerPasswordNotValidException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Customer Password is not valid");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MedicineIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(MedicineIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Medicine Id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MedicineDataNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(MedicineDataNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Medicine data not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MedicineNameNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(MedicineNameNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Medicine name is not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StaffIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(StaffIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Staff Id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StaffEmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getException(StaffEmailNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Staff Email is not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StaffPasswordNotValidException.class)
	public ResponseEntity<ResponseStructure<String>> getException(StaffPasswordNotValidException ex) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Staff Password is not valid");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ObjectError> errorList = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>();

		for (ObjectError err : errorList) {
			String feildName = ((FieldError) err).getField();
			String message = err.getDefaultMessage();

			map.put(feildName, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstriantEntityViolationException(ConstraintViolationException constExcep) {

		Set<ConstraintViolation<?>> set = constExcep.getConstraintViolations();
		List<String> list = new ArrayList<>();
		for (ConstraintViolation<?> constViolation : set) {
			String name = constViolation.getMessage();
			list.add(name);
		}
		return new ResponseEntity<Object>(list, HttpStatus.BAD_REQUEST);
	}

}

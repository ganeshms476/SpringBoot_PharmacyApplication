package com.ty.SpringBootPharmacyApplication.controller;

import java.lang.annotation.Retention;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBootPharmacyApplication.dto.Booking;
import com.ty.SpringBootPharmacyApplication.service.BookingService;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BookingController {

	@Autowired
	private BookingService service;

	@ApiOperation(value = "Save Booking", notes = " Api is used to save booking using customer id and medicine id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved booking"),
			@ApiResponse(code = 404, message = "Customer id/medicine id not found") })
	@PostMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking,
			@RequestParam String customer_id, @RequestParam String medicine_id) {
		return service.saveBooking(booking, customer_id, medicine_id);
	}

	@ApiOperation(value = "Update Booking", notes = " Api is used to save booking using booking id and customer id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated booking"),
			@ApiResponse(code = 404, message = "Booking id/customer id not found") })
	@PutMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestBody Booking booking,
			@RequestParam String booking_id, @RequestParam String customer_id) {
		return service.updateBooking(booking, booking_id, customer_id);
	}

	@ApiOperation(value = "Delete Booking", notes = " Api is used to delete booking using booking id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted booking"),
			@ApiResponse(code = 404, message = "Booking id not found") })
	@DeleteMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam String booking_id) {
		return service.deleteBooking(booking_id);
	}

	@ApiOperation(value = "get Booking By Id", notes = " Api is used to get booking using booking id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched booking"),
			@ApiResponse(code = 404, message = "Booking id not found") })
	@GetMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@RequestParam String booking_id) {
		return service.getBookingById(booking_id);
	}

	@ApiOperation(value = "get All Booking By Customer Id", notes = " Api is used to get All booking using customer id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched all booking"),
			@ApiResponse(code = 404, message = "Customer id not found") })
	@GetMapping("/Allbooking")
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBookingByCustomerId(
			@RequestParam String customer_id) {
		return service.getAllBookingByCustomerId(customer_id);
	}
}

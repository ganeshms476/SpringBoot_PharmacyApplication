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

@RestController
public class BookingController {

	@Autowired
	private BookingService service;

	@PostMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking,
			@RequestParam int customer_id, @RequestParam int medicine_id) {
		return service.saveBooking(booking, customer_id, medicine_id);
	}

	@PutMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestBody Booking booking,
			@RequestParam int booking_id, @RequestParam int customer_id) {
		return service.updateBooking(booking, booking_id, customer_id);
	}

	@DeleteMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam int booking_id) {
		return service.deleteBooking(booking_id);
	}

	@GetMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@RequestParam int booking_id) {
		return service.getBookingById(booking_id);
	}

	@GetMapping("/Allbooking")
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBookingByCustomerId(@RequestParam int customer_id) {
		return service.getAllBookingByCustomerId(customer_id);
	}
}

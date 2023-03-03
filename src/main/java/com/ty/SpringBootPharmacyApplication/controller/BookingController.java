package com.ty.SpringBootPharmacyApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBootPharmacyApplication.dto.Address;
import com.ty.SpringBootPharmacyApplication.dto.Booking;
import com.ty.SpringBootPharmacyApplication.service.BookingService;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@RestController
public class BookingController {
	@Autowired
	private BookingService service;
	
	 @PostMapping("/booking")
	 public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestParam int customer_id, @RequestBody Booking booking, @RequestParam int medicine_id){
		 return service.saveBooking(customer_id, booking, medicine_id)
	 }
	 
	 @PutMapping("/booking")
	 public ResponseEntity<ResponseStructure<Booking>> updateAddress(@RequestBody Booking booking,@RequestParam int id){
		 return service.updateAddress(booking, id);
	 }
	 
	 @GetMapping("/booking")
	 public ResponseEntity<ResponseStructure<Booking>> getByIdAddress(@RequestParam int id){
		 return service.getByIdAddress(id);
	 }
	 
	 @DeleteMapping("/booking")
	 public ResponseEntity<ResponseStructure<Booking>> deleteAddress(@RequestParam int id){
		 return service.deleteAddress(id);
	 }
}
}

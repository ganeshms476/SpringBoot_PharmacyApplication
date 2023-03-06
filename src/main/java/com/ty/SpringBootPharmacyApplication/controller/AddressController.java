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
import com.ty.SpringBootPharmacyApplication.service.AddressService;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@RestController
public class AddressController {
	@Autowired
	private AddressService service;
	
	 @PostMapping("/address")
	 public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address){
		 return service.saveAddress(address);
	 }
	 
	 @PutMapping("/address")
	 public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address,@RequestParam String id){
		 return service.updateAddress(address, id);
	 }
	 
	 @GetMapping("/address")
	 public ResponseEntity<ResponseStructure<Address>> getByIdAddress(@RequestParam String id){
		 return service.getByIdAddress(id);
	 }
	 
	 @DeleteMapping("/address")
	 public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam String id){
		 return service.deleteAddress(id);
	 }
}

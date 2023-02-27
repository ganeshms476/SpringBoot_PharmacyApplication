package com.ty.SpringBootPharmacyApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBootPharmacyApplication.dto.Address;
import com.ty.SpringBootPharmacyApplication.service.AddressService;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@RestController
public class AddressController {
	@Autowired
	private AddressService service;
	
	 @PostMapping("/address")
	 public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address){
		 return service.saveAddress(address);
	 }
	 
	 @PutMapping("/address")
	 public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address,int id){
		 return service.updateAddress(address, id);
	 }
	 
	 @GetMapping("/address")
	 public ResponseEntity<ResponseStructure<Address>> getByIdAddress(int id){
		 return service.getByIdAddress(id);
	 }
	 
	 @DeleteMapping("/address")
	 public ResponseEntity<ResponseStructure<Address>> deleteAddress( int id){
		 return service.deleteAddress(id);
	 }
}

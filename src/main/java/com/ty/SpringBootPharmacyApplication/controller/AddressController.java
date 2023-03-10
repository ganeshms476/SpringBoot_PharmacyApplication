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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {
	@Autowired
	private AddressService service;

	@ApiOperation(value = "Save Address", notes = " Api is used to Save the address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Address not found for the given address id") })
	@PostMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}

	@ApiOperation(value = "Update Address", notes = " Api is used to Update the address using address id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Address not found for the given address id") })
	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address,
			@RequestParam String id) {
		return service.updateAddress(address, id);
	}

	@ApiOperation(value = "get Address By Id", notes = " Api is used to get the address using address Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "Address not found for the given address id") })
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getByIdAddress(@RequestParam String id) {
		return service.getByIdAddress(id);
	}

	@ApiOperation(value = "Delete Address", notes = " Api is used to delete the address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Address not found for the given address id") })
	@DeleteMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam String id) {
		return service.deleteAddress(id);
	}
}

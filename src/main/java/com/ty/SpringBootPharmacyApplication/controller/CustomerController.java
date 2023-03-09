package com.ty.SpringBootPharmacyApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBootPharmacyApplication.dto.Customer;
import com.ty.SpringBootPharmacyApplication.service.CustomerService;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;

	@ApiOperation(value = "SignUp Customer", notes = " Api is used to save Customer ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved customer") })
	@PostMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> signUpCustomer(@RequestBody Customer customer) {
		return service.signUpCustomer(customer);
	}

	@ApiOperation(value = "login Customer", notes = " Api is used to login Customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Email/password not found") })
	@GetMapping("/loginCustomer")
	public ResponseEntity<ResponseStructure<Customer>> loginCustomer(@RequestParam String email,
			@RequestParam String password) {
		return service.loginCustomer(email, password);
	}

	@ApiOperation(value = "Update Customer", notes = " Api is used to update the Customer using customer id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Customer not found for the given customer id") })

	@PutMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer,
			@RequestParam String customer_id) {
		return service.updateCustomer(customer, customer_id);
	}

	@ApiOperation(value = "Delete Customer", notes = " Api is used to delete the Customer using customer id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Customer not found for the given customer id") })
	@DeleteMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam String customer_id) {
		return service.deleteCustomer(customer_id);
	}

	@ApiOperation(value = "Get Customer By Id", notes = " Api is used to get Customer using customer id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "Customer not found for the given customer id") })
	@GetMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@RequestParam String customer_id) {
		return service.getCustomerById(customer_id);
	}

	@ApiOperation(value = "Get All Customer", notes = " Api is used to get All Customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated") })
	@GetMapping("/Allcustomer")
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer() {
		return service.getAllCustomer();
	}
}

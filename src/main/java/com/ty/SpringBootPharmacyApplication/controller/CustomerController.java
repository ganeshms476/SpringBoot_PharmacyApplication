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

@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;

	@PostMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> signUpCustomer(@RequestBody Customer customer) {
		return service.signUpCustomer(customer);
	}

	@GetMapping("/loginCustomer")
	public ResponseEntity<ResponseStructure<Customer>> loginCustomer(@RequestAttribute String email,
			@RequestAttribute String password) {
		return service.loginCustomer(email, password);
	}

	@PutMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer,
			@RequestParam int customer_id) {
		return service.updateCustomer(customer, customer_id);
	}

	@DeleteMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam int customer_id) {
		return service.deleteCustomer(customer_id);
	}

	@GetMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@RequestParam int customer_id) {
		return service.getCustomerById(customer_id);
	}

	@GetMapping("/Allcustomer")
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer() {
		return service.getAllCustomer();
	}
}

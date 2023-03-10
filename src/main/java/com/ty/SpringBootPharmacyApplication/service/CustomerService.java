package com.ty.SpringBootPharmacyApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBootPharmacyApplication.dto.Customer;
import com.ty.SpringBootPharmacyApplication.exception.CustomerDataNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.CustomerEmailNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.CustomerIdNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.CustomerPasswordNotValidException;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;
import com.ty.SpringBootPharmacyApplication.dao.CustomerDao;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Customer>> signUpCustomer(Customer customer) {
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		Customer customer2 = customerDao.signUpCustomer(customer);
		structure.setMessage("Successfully saved Customer");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(customer2);
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> loginCustomer(String email, String password) {
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		Customer customer = customerDao.getCustomerByEmail(email);
		if (customer != null) {
			if (password.equals(customer.getPassword())) {
				structure.setMessage("Customer Successfully logged in");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(customer);
				return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
			} else
				throw new CustomerPasswordNotValidException();
		} else
			throw new CustomerEmailNotFoundException();

	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer, String customer_id) {
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		Customer customer2 = customerDao.getCustomerById(customer_id);
		if (customer2 != null) {
			customer.setId(customer_id);
			structure.setMessage("Successfully updated Customer");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(customerDao.updateCustomer(customer, customer_id));
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		} else
			throw new CustomerIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(String customer_id) {
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		Customer customer = customerDao.getCustomerById(customer_id);
		if (customer != null) {
			structure.setMessage("Successfully deleted Customer");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(customerDao.deleteCustomer(customer_id));
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		} else
			throw new CustomerIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(String customer_id) {
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		Customer customer = customerDao.getCustomerById(customer_id);
		if (customer != null) {
			structure.setMessage("Succesfully fetched Customer");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		} else
			throw new CustomerIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer() {
		ResponseStructure<List<Customer>> structure = new ResponseStructure<>();
		List<Customer> list = customerDao.getAllCustomer();
		if (list != null) {
			structure.setMessage("Successfully fetched all the customers");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Customer>>>(structure, HttpStatus.OK);
		} else
			throw new CustomerDataNotFoundException();
	}
}

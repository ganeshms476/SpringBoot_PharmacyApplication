package com.ty.SpringBootPharmacyApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBootPharmacyApplication.dto.Customer;
import com.ty.SpringBootPharmacyApplication.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository repo;

	public Customer signUpCustomer(Customer customer) {
		return repo.save(customer);
	}

	public Customer loginCustomer(String email) {
		return repo.getCustomerByEmail(email);
	}

	public Customer updateCustomer(Customer customer, int customer_id) {
		if (repo.findById(customer_id).isPresent()) {
			customer.setId(customer_id);
			Customer customer2 = repo.save(customer);
			return customer2;
		} else
			return null;

	}

	public Customer deleteCustomer(int customer_id) {
		if (repo.findById(customer_id).isPresent()) {
			Customer customer = repo.findById(customer_id).get();
			repo.delete(customer);
			return customer;
		} else
			return null;
	}

	public Customer getCustomerById(int customer_id) {
		if (repo.findById(customer_id).isPresent()) {
			Customer customer = repo.findById(customer_id).get();
			return customer;
		} else
			return null;
	}

	public Customer getCustomerByEmail(String email) {
		return repo.getCustomerByEmail(email);

	}

	public List<Customer> getAllCustomer() {
		return repo.findAll();

	}
}

package com.ty.SpringBootPharmacyApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.SpringBootPharmacyApplication.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE c.email=?1")
	public Customer getCustomerByEmail(String email);
	
	

}

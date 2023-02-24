package com.ty.SpringBootPharmacyApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBootPharmacyApplication.dto.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

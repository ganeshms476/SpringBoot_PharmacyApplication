package com.ty.springboot_pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_pharmacy.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

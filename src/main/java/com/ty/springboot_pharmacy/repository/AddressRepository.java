package com.ty.springboot_pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_pharmacy.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}

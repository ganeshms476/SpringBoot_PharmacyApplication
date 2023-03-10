package com.ty.SpringBootPharmacyApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBootPharmacyApplication.dto.Address;


public interface AddressRepository extends JpaRepository<Address, String>{

}

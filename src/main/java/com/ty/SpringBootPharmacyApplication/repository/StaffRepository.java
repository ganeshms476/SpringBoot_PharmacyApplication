package com.ty.SpringBootPharmacyApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBootPharmacyApplication.dto.Staff;


public interface StaffRepository extends JpaRepository<Staff, Integer>{

}

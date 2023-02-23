package com.ty.springboot_pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_pharmacy.dto.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

}

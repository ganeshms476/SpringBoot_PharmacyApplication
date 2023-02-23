package com.ty.SpringBootPharmacyApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBootPharmacyApplication.dto.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{

}

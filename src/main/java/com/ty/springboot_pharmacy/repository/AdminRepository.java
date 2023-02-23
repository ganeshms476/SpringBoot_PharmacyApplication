package com.ty.springboot_pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_pharmacy.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}

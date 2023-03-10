package com.ty.SpringBootPharmacyApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.SpringBootPharmacyApplication.dto.Admin;


public interface AdminRepository extends JpaRepository<Admin, String>{
	@Query("Select e from Admin e where e.email=?1")
	public Admin loginUsingEmail(String email);
}

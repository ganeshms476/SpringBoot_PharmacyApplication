package com.ty.SpringBootPharmacyApplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBootPharmacyApplication.dto.Admin;
import com.ty.SpringBootPharmacyApplication.repository.AdminRepository;

@Repository
public class AdminDAO {
	
	@Autowired
	AdminRepository repo;
	
	public Admin saveAdmin(Admin admin) {
		
	}
}

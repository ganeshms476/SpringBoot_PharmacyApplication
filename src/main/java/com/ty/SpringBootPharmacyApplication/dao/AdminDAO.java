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
		return repo.save(admin);
	}

	public Admin loginAdmin(String email) {
		return repo.loginUsingEmail(email);
	}

	public Admin updateAdmin(int id, Admin admin) {
		if (repo.findById(id).isPresent()) {
			admin.setId(id);
			return repo.save(admin);
		} else {
			return null;
		}
	}

	public Admin deleteAdmin(int id) {
		if (repo.findById(id).isPresent()) {
			Admin admin = repo.findById(id).get();
			repo.deleteById(id);
			return admin;
		} else {
			return null;
		}
	}

	public Admin getAdminById(int id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}
}

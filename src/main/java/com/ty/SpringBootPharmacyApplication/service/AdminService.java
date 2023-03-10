package com.ty.SpringBootPharmacyApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBootPharmacyApplication.dao.AdminDAO;
import com.ty.SpringBootPharmacyApplication.dto.Admin;
import com.ty.SpringBootPharmacyApplication.exception.AdminEmailNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.AdminIdNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.AdminPasswordInvalidException;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDAO dao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();

		structure.setMessage("saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(String id, Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (dao.updateAdmin(id, admin) != null) {
			structure.setMessage("Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateAdmin(id, admin));
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		} else {
			throw new AdminIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(String id) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (dao.deleteAdmin(id) != null) {
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteAdmin(id));
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		} else {
			throw new AdminIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(String id) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (dao.getAdminById(id) != null) {
			structure.setMessage("Fetched");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.getAdminById(id));
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		} else {
			throw new AdminIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(String email, String password) {
		Admin admin = dao.loginAdmin(email);
		if (dao.loginAdmin(email) != null) {
			if (admin.getPassword().equals(password)) {
				ResponseStructure<Admin> structure = new ResponseStructure<>();

				structure.setMessage("Logged in");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.loginAdmin(email));
				return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
			} else {
				throw new AdminPasswordInvalidException();
			}

		} else {
			throw new AdminEmailNotFoundException();
		}
	}
}

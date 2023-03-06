package com.ty.SpringBootPharmacyApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBootPharmacyApplication.dto.Admin;
import com.ty.SpringBootPharmacyApplication.service.AdminService;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@PutMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestParam int id, @RequestBody Admin admin) {
		return service.updateAdmin(id, admin);
	}

	@DeleteMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam int id) {
		return service.deleteAdmin(id);
	}

	@GetMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> getAdminByid(@RequestParam int id) {
		return service.getAdminById(id);
	}
	

	@GetMapping("/loginadmin")
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(@RequestParam String email, @RequestParam String password) {
		return service.loginAdmin(email, password);
	}

}

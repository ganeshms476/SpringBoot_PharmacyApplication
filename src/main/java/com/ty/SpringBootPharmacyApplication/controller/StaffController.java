package com.ty.SpringBootPharmacyApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBootPharmacyApplication.dto.Staff;
import com.ty.SpringBootPharmacyApplication.service.StaffService;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@RestController
public class StaffController {
	@Autowired
	private StaffService service;

	@PostMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> signUpStaff(@RequestBody Staff staff, @RequestParam String store_id, @RequestParam String admin_id) {
		return service.signUpStaff(staff, store_id, admin_id);
	}

	@GetMapping("/stafflogin")
	public ResponseEntity<ResponseStructure<Staff>> loginStaff(@RequestParam String email,
			@RequestParam String password) {
		return service.loginStaff(email, password);
	}

	@PutMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff, @RequestParam String staff_id,
			@RequestParam String medicalStore_id) {
		return service.updateStaff(staff, staff_id, medicalStore_id);
	}

	@DeleteMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(@RequestParam String staff_id) {
		return service.deleteStaff(staff_id);
	}

	@GetMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> getStaffById(@RequestParam String staff_id) {
		return service.getStaffById(staff_id);
	}
}

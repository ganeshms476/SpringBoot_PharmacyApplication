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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StaffController {
///	@Autowired
//	private StaffService service;
//	@ApiOperation(value = "Save Staff", notes = " Api is used to Save the staff")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved") })
//	@PostMapping("/staff")
//	public ResponseEntity<ResponseStructure<Staff>> signUpStaff(@RequestBody Staff staff, @RequestParam String store_id,
//			@RequestParam String admin_id) {
//		return service.signUpStaff(staff, store_id, admin_id);
//	}
//
//	@ApiOperation(value = "login staff", notes = " Api is used to staff login")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Login Successfully "),
//			@ApiResponse(code = 404, message = "staff not found for the given staff email and password") })
//	 
//	@GetMapping("/stafflogin")
//	public ResponseEntity<ResponseStructure<Staff>> loginStaff(@RequestParam String email,
//			@RequestParam String password) {
//		return service.loginStaff(email, password);
//	}
//	
//	@ApiOperation(value = "update staff", notes = " Api is used to update the staff")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
//			@ApiResponse(code = 404, message = "staff not found for the given staff id") })
//	@PutMapping("/staff")
//	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff, @RequestParam String staff_id,
//			@RequestParam String admin_id, @RequestParam String medicalStore_id) {
//		return service.updateStaff(staff, staff_id, admin_id, medicalStore_id);
//	}
//	
//	@ApiOperation(value = "delete staff", notes = " Api is used to delete the staff")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
//			@ApiResponse(code = 404, message = "staff not found for the given staff id") })
//	@DeleteMapping("/staff")
//	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(@RequestParam String staff_id) {
//		return service.deleteStaff(staff_id);
//	}
//	
//	@ApiOperation(value = "get staff id", notes = " Api is used to get the address")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
//			@ApiResponse(code = 404, message = "staff not found for the given staff id") })
//	@GetMapping("/staff")
//	public ResponseEntity<ResponseStructure<Staff>> getStaffById(@RequestParam String staff_id) {
//		return service.getStaffById(staff_id);
//	}
}

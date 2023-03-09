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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@ApiOperation(value = "Save Admin", notes = " Api is used to Save the Admin")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved") })
	@PostMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@ApiOperation(value = "Update Admin", notes = " Api is used to update the Admin")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Address not found for the given address id") })
	@PutMapping("/admin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@PathVariable String id, @RequestBody Admin admin) {
		return service.updateAdmin(id, admin);
	}

	@ApiOperation(value = "Delete Admin", notes = " Api is used to delete the Admin")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Admin not found for the given admin id") })
	@DeleteMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam String id) {
		return service.deleteAdmin(id);
	}

	@ApiOperation(value = "get Admin By Id", notes = " Api is used to get the Admin using admin id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "Admin not found for the given admin id") })
	@GetMapping("/admin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> getAdminByid(@PathVariable String id) {
		return service.getAdminById(id);
	}

	@ApiOperation(value = "login Admin", notes = " Api is used to login Admin")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully logged in"),
			@ApiResponse(code = 404, message = "email/password not found") })
	@GetMapping("/loginadmin")
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(@RequestParam String email,
			@RequestParam String password) {
		return service.loginAdmin(email, password);
	}

}

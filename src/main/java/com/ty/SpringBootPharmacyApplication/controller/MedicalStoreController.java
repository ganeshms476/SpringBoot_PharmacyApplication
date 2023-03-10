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

import com.ty.SpringBootPharmacyApplication.dto.MedicalStore;
import com.ty.SpringBootPharmacyApplication.service.MedicalStoreService;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedicalStoreController {
	@Autowired
	private MedicalStoreService service;

	@ApiOperation(value = "Save MedicalStore", notes = " Api is used to save the medical store using address id & admin id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved"),
			@ApiResponse(code = 404, message = "Admin /address id not found") })
	@PostMapping("/medicalstore")
	public ResponseEntity<ResponseStructure<MedicalStore>> saveMedicalStore(@RequestBody MedicalStore medicalStore,
			@RequestParam String admin_id, @RequestParam String address_id) {
		return service.saveMedicalStore(admin_id, medicalStore, address_id);
	}
	
	@ApiOperation(value = "Update MedicalStore", notes = " Api is used to update the medical store")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Medical Store/admin/address id not found") })
	@PutMapping("/medicalstore")
	public ResponseEntity<ResponseStructure<MedicalStore>> updateMedicalStore(@RequestBody MedicalStore medicalStore,
			@RequestParam String medicalStore_id, @RequestParam String admin_id, @RequestParam String address_id) {
		return service.updateMedicalStore(medicalStore, medicalStore_id, admin_id, address_id);
	}
	
	@ApiOperation(value = "Delete MedicalStore", notes = " Api is used to delete medicalstore")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Medical Store id not found") })
	@DeleteMapping("/medicalstore")
	public ResponseEntity<ResponseStructure<MedicalStore>> deleteMedicalStore(@RequestParam String medicalStore_id) {
		return service.deleteById(medicalStore_id);
	}
	@ApiOperation(value = "Get MedicalStore", notes = " Api is used to get medicalstore By id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully fetched"),
			@ApiResponse(code = 404, message = "Medical Store id not found") })
	@GetMapping("/medicalstore")
	public ResponseEntity<ResponseStructure<MedicalStore>> getByMedicalStoreId(@RequestParam String medicalStore_id) {
		return service.getByIdMedicalStore(medicalStore_id);
	}
}

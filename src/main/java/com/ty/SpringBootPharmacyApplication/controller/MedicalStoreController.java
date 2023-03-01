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

@RestController
public class MedicalStoreController {
	@Autowired
	private MedicalStoreService service;
	
	@PostMapping("/medicalstore")
	public ResponseEntity<ResponseStructure<MedicalStore>> saveMedicalStore(@RequestParam int admin_id,@RequestBody MedicalStore medicalStore,@RequestParam int address_id){
		return service.saveMedicalStore(admin_id, medicalStore, address_id);
	}
	
	@PutMapping("/medicalstore")
	public ResponseEntity<ResponseStructure<MedicalStore>> updateMedicalStore (@RequestBody MedicalStore medicalStore,@RequestParam int medicalStore_id,@RequestParam int admin_id,@RequestParam int address_id ){
		return service.updateMedicalStore(medicalStore, medicalStore_id, admin_id, address_id);
	}
	
	@DeleteMapping("/medicalstore")
	public ResponseEntity<ResponseStructure<MedicalStore>> deleteMedicalStore (@RequestParam int medicalStore_id){
		return service.deleteById(medicalStore_id);
	}
	@GetMapping("/medicalstore")
	public ResponseEntity<ResponseStructure<MedicalStore>> getByMedicalStoreId ( @RequestParam int medicalStore_id){
		return service.getByIdMedicalStore(medicalStore_id);
	}
}

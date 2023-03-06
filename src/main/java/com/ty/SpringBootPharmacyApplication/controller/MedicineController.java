package com.ty.SpringBootPharmacyApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBootPharmacyApplication.dto.Medicine;
import com.ty.SpringBootPharmacyApplication.service.MedicineService;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@RestController
public class MedicineController {
	@Autowired
	private MedicineService service;

	@PostMapping("/medicine")
	public ResponseEntity<ResponseStructure<Medicine>> saveMedicine(@RequestBody Medicine medicine,
			@RequestParam String medicalStore_id) {
		return service.saveMedicine(medicine, medicalStore_id);
	}

	@PutMapping("/medicine")
	public ResponseEntity<ResponseStructure<Medicine>> updateMedicine(@RequestBody Medicine medicine,
			@RequestParam String medicine_id, @RequestParam String medicalStore_id) {
		return service.updateMedicine(medicine, medicine_id, medicalStore_id);
	}

	@DeleteMapping("/medicine")
	public ResponseEntity<ResponseStructure<Medicine>> deleteMedicine(@RequestParam String medicine_id) {
		return service.deleteMedicine(medicine_id);
	}

	@GetMapping("/medicine")
	public ResponseEntity<ResponseStructure<Medicine>> getMedicineById(@RequestParam String medicine_id) {
		return service.getMedicineById(medicine_id);
	}

//	@GetMapping("/AllMedicines")
//	public ResponseEntity<ResponseStructure<List<Medicine>>> getAllMedicineByMedicalStoreId(
//			@RequestParam int medicalStore_id) {
//		return service.getAllMedicinesByMedicalStoreId(medicalStore_id);
//	}

}

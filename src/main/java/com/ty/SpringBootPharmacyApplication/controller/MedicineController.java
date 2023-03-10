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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedicineController {
	@Autowired
	private MedicineService service;
	
	@ApiOperation(value = "save medicine", notes = " Api is used to save the medicine")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved")
			  })

	@PostMapping("/medicine")
	public ResponseEntity<ResponseStructure<Medicine>> saveMedicine(@RequestBody Medicine medicine,
			@RequestParam String medicalStore_id) {
		return service.saveMedicine(medicine, medicalStore_id);
	}

	@ApiOperation(value = "update medicine", notes = " Api is used to update the medicine and medicalstore")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
	@ApiResponse(code = 404, message = "medicine not found for the given medicine id and medicalstore") })
	@PutMapping("/medicine")
	public ResponseEntity<ResponseStructure<Medicine>> updateMedicine(@RequestBody Medicine medicine,
			@RequestParam String medicine_id, @RequestParam String medicalStore_id) {
		return service.updateMedicine(medicine, medicine_id, medicalStore_id);
	}
	
	@ApiOperation(value = "delete medicine", notes = " Api is used to delete the medicine")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "medicine not found for the given medicine id") })
	@DeleteMapping("/medicine")
	public ResponseEntity<ResponseStructure<Medicine>> deleteMedicine(@RequestParam String medicine_id) {
		return service.deleteMedicine(medicine_id);
	}
	
	@ApiOperation(value = "get medicine by id", notes = " Api is used to get  the medicine")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully found"),
			@ApiResponse(code = 404, message = "medicine not found for the given medicine id") })
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

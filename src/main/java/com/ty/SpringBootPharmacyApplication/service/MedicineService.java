package com.ty.SpringBootPharmacyApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBootPharmacyApplication.dao.MedicalStoreDao;
import com.ty.SpringBootPharmacyApplication.dao.MedicineDao;
import com.ty.SpringBootPharmacyApplication.dto.MedicalStore;
import com.ty.SpringBootPharmacyApplication.dto.Medicine;
import com.ty.SpringBootPharmacyApplication.exception.MedicalStoreIdNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.MedicineIdNotFoundException;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@Service
public class MedicineService {
	@Autowired
	private MedicineDao medicineDao;

	@Autowired
	private MedicalStoreDao medicalStoreDao;

	public ResponseEntity<ResponseStructure<Medicine>> saveMedicine(Medicine medicine, String medicalStrore_id) {
		ResponseStructure<Medicine> structure = new ResponseStructure<>();
		MedicalStore medicalStore = medicalStoreDao.getById(medicalStrore_id);
		if (medicalStore != null) {
			medicine.setStore(medicalStore);
			structure.setMessage("Successfully saved medicine");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(medicineDao.saveMedicine(medicine));
			return new ResponseEntity<ResponseStructure<Medicine>>(structure, HttpStatus.CREATED);
		} else
			throw new MedicalStoreIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Medicine>> updateMedicine(Medicine medicine, String medicine_id,
			String medicalStore_id) {
		ResponseStructure<Medicine> structure = new ResponseStructure<>();
		Medicine medicine2 = medicineDao.getMedicineById(medicine_id);
		MedicalStore store = medicalStoreDao.getById(medicalStore_id);
		if (store != null) {
			if (medicine != null) {
				medicine.setId(medicine_id);
				structure.setMessage("Successfully updated medicine");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(medicineDao.updateMedicine(medicine, medicine_id));
				return new ResponseEntity<ResponseStructure<Medicine>>(structure, HttpStatus.OK);
			} else
				throw new MedicineIdNotFoundException();

		} else
			throw new MedicalStoreIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Medicine>> deleteMedicine(String medicine_id) {
		ResponseStructure<Medicine> structure = new ResponseStructure<>();
		Medicine medicine2 = medicineDao.getMedicineById(medicine_id);
		if (medicine2 != null) {
			structure.setMessage("Successfully deleted medicine");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medicineDao.deleteMedicine(medicine_id));
			return new ResponseEntity<ResponseStructure<Medicine>>(structure, HttpStatus.OK);
		} else
			throw new MedicineIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Medicine>> getMedicineById(String medicine_id) {
		ResponseStructure<Medicine> structure = new ResponseStructure<>();
		Medicine medicine = medicineDao.getMedicineById(medicine_id);
		if (medicine != null) {
			structure.setMessage("Successfully fetched medicine");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medicine);
			return new ResponseEntity<ResponseStructure<Medicine>>(structure, HttpStatus.OK);
		} else
			throw new MedicineIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Medicine>>> getAllMedicinesByMedicalStoreId(String medicalStore_id) {
		ResponseStructure<List<Medicine>> structure = new ResponseStructure<>();
		MedicalStore store = medicalStoreDao.getById(medicalStore_id);
		if (store != null) {
			structure.setMessage("Successfully fetched all the medicines");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medicineDao.getAllMedicine(medicalStore_id));
			return new ResponseEntity<ResponseStructure<List<Medicine>>>(structure, HttpStatus.OK);
		} else
			throw new MedicalStoreIdNotFoundException();

	}

}

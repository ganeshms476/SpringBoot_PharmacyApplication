package com.ty.SpringBootPharmacyApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBootPharmacyApplication.dto.MedicalStore;
import com.ty.SpringBootPharmacyApplication.dto.Medicine;
import com.ty.SpringBootPharmacyApplication.repository.MedicineRepository;

@Repository
public class MedicineDao {
	@Autowired
	private MedicineRepository repo;
	@Autowired
	private MedicalStoreDao storeDao;

	public Medicine saveMedicine(Medicine medicine) {
		return repo.save(medicine);
	}

	public Medicine updateMedicine(Medicine medicine, int medicine_id) {
		if (repo.findById(medicine_id).isPresent()) {
			medicine.setId(medicine_id);
			Medicine medicine2 = repo.save(medicine);
			return medicine2;
		}
		return null;
	}

	public Medicine deleteMedicine(int medicine_id) {
		if (repo.findById(medicine_id).isPresent()) {
			Medicine medicine = repo.findById(medicine_id).get();
			repo.delete(medicine);
			return medicine;
		}
		return null;
	}

	public Medicine getMedicineById(int medicine_id) {
		if (repo.findById(medicine_id).isPresent()) {
			Medicine medicine = repo.findById(medicine_id).get();
			return medicine;
		}
		return null;
	}

	public List<Medicine> getAllMedicine(int medicalstore_id) {
		MedicalStore store = storeDao.getById(medicalstore_id);
		if (store != null) {
			List<Medicine> list = repo.getAllMedicineByMedicalStore(store);
			return list;
		}
		return null;
	}
	
	
}

package com.ty.SpringBootPharmacyApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.SpringBootPharmacyApplication.dto.MedicalStore;
import com.ty.SpringBootPharmacyApplication.dto.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

//	@Query("SELECT m FROM Medicine m WHERE m.medicalstore.id=?1 ")
//	public List<Medicine> getAllMedicineByMedicalStore(int id);

}

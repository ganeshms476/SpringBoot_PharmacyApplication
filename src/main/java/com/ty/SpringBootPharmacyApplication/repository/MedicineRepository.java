package com.ty.SpringBootPharmacyApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.SpringBootPharmacyApplication.dto.MedicalStore;
import com.ty.SpringBootPharmacyApplication.dto.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String> {

	@Query("select m from Medicine m where m.store=?1")
	public List<Medicine> getAllMedicineByMedicalStore(MedicalStore store);

}

package com.ty.SpringBootPharmacyApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBootPharmacyApplication.dto.Medicine;


public interface MedicineRepository extends JpaRepository<Medicine, Integer>{

}

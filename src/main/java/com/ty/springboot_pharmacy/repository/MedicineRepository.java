package com.ty.springboot_pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_pharmacy.dto.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer>{

}

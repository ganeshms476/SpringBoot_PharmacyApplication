package com.ty.springboot_pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_pharmacy.dto.MedicalStore;

public interface MedicalStoreRepository extends JpaRepository<MedicalStore, Integer>{

}

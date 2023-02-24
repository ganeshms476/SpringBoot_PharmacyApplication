package com.ty.SpringBootPharmacyApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBootPharmacyApplication.dto.MedicalStore;


public interface MedicalStoreRepository extends JpaRepository<MedicalStore, Integer>{

}

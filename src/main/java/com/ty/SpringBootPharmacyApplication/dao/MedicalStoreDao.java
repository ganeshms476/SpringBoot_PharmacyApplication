package com.ty.SpringBootPharmacyApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBootPharmacyApplication.dto.Address;
import com.ty.SpringBootPharmacyApplication.dto.MedicalStore;
import com.ty.SpringBootPharmacyApplication.repository.MedicalStoreRepository;

 

@Repository
public class MedicalStoreDao<AddressRepository> {
	@Autowired
	private MedicalStoreRepository repository;
	@Autowired
	private AddressDao addressDao;
	
	public MedicalStore saveAddress(MedicalStore medicalStore,String  address_id) {
		Address address=addressDao.getByIdAddress(address_id);
		medicalStore.setAddress(address);
		return repository.save(medicalStore);
	}
	public MedicalStore updateAddress(String  id,MedicalStore medicalStore) {
		if(repository.findById(id).isPresent()) {
			medicalStore.setId(id);
			return repository.save(medicalStore);
		}
		else {
			return null;
		}
	}
	public MedicalStore deleteMedicalStore(String  id) {
		MedicalStore store=repository.findById(id).get();
		if(repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return store;
		}
		else {
			return null;
		}
	}
	
	public MedicalStore getById(String  id) { 
		if(repository.findById(id).isPresent()) {
			MedicalStore store=repository.findById(id).get();
			return store;
		}
		else {
			return null;
		}
	}
	 
	 
 
}

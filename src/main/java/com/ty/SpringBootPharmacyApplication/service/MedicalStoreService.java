package com.ty.SpringBootPharmacyApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBootPharmacyApplication.dao.AddressDao;
import com.ty.SpringBootPharmacyApplication.dao.MedicalStoreDao;
import com.ty.SpringBootPharmacyApplication.dto.MedicalStore;
import com.ty.SpringBootPharmacyApplication.exception.MedicalStoreIdNotFoundException;
 
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;
 

@Service
public class MedicalStoreService {
	@Autowired
	private MedicalStoreDao dao;
	
	@Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<MedicalStore>> saveMedicalStore(MedicalStore medicalStore,int address_id){
		ResponseStructure<MedicalStore> structure=new ResponseStructure<MedicalStore>();
		structure.setMessage("successfully medical store is saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAddress(medicalStore, address_id));
		return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<MedicalStore>> updateMedicalStore(MedicalStore medicalStore,int medicalStore_id){
		ResponseStructure<MedicalStore> structure=new ResponseStructure<MedicalStore>();
		MedicalStore  rcvMedicalStore=dao.updateAddress(medicalStore_id, medicalStore);
		if(rcvMedicalStore!=null) {
			structure.setMessage("successfully Branch is updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(rcvMedicalStore);
			return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.FOUND);
		}
		else {
			throw  new   MedicalStoreIdNotFoundException() ;
		}
	}
	
	public ResponseEntity<ResponseStructure<MedicalStore>> getByIdMedicalStore(int medicalStore_id){
		ResponseStructure<MedicalStore> structure=new ResponseStructure<MedicalStore>();
		MedicalStore  rcvMedicalStore=dao.getById(medicalStore_id);
		if(rcvMedicalStore!=null) {
			structure.setMessage("successfully Branch is updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(rcvMedicalStore);
			return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.FOUND);
		}
		else {
			throw  new  MedicalStoreIdNotFoundException() ;
		}
	}
	
	public ResponseEntity<ResponseStructure<MedicalStore>> deleteById(int medicalStore_id){
		ResponseStructure<MedicalStore> structure=new ResponseStructure<MedicalStore>();
		MedicalStore  rcvMedicalStore= dao.deleteMedicalStore(medicalStore_id);
		if(rcvMedicalStore!=null) {
			structure.setMessage("successfully Branch is updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(rcvMedicalStore);
			return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.FOUND);
		}
		else {
			throw  new  MedicalStoreIdNotFoundException() ;
		}
	}
}

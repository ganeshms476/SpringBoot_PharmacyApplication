package com.ty.SpringBootPharmacyApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBootPharmacyApplication.dao.AddressDao;
import com.ty.SpringBootPharmacyApplication.dto.Address;
import com.ty.SpringBootPharmacyApplication.exception.AddressIdNotFoundException;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;
@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> structure=new ResponseStructure<Address>();
		structure.setMessage("Successfully address is saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
	}
	 public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address,String  id){
		 Address rcvAddress=addressDao.updateAddress(address, id);
		 if(rcvAddress!=null) {
			 ResponseStructure<Address> structure=new ResponseStructure<Address>();
				structure.setMessage("Successfully address is updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(addressDao.updateAddress(rcvAddress, id)); 
				return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
		 }
		 else {
			  throw new AddressIdNotFoundException();
		}
	 }
	 public ResponseEntity<ResponseStructure<Address>> deleteAddress(String id){
		 Address rcvAddress=addressDao.deletAddress(id);
		 if(rcvAddress!=null) {
			 ResponseStructure<Address> structure=new ResponseStructure<Address>();
				structure.setMessage("Successfully address is updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(rcvAddress); 
				return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		 }
		 else {
			  throw new AddressIdNotFoundException();
		}
	 }
	 public ResponseEntity<ResponseStructure<Address>> getByIdAddress(String id){
		 Address rcvAddress=addressDao.getByIdAddress(id);
		 if(rcvAddress!=null) {
			 ResponseStructure<Address> structure=new ResponseStructure<Address>();
				structure.setMessage("Successfully address is updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(rcvAddress); 
				return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		 }
		 else {
			  throw new AddressIdNotFoundException();
		}
	 }
}

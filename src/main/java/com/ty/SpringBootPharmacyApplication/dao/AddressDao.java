package com.ty.SpringBootPharmacyApplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBootPharmacyApplication.dto.Address;
import com.ty.SpringBootPharmacyApplication.dto.Admin;
import com.ty.SpringBootPharmacyApplication.repository.AddressRepository;
import com.ty.SpringBootPharmacyApplication.repository.AdminRepository;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepository repo;

	public Address saveAddress(Address address) {
		return repo.save(address);
	}

	public Address updateAddress(Address address, int id) {
		if (repo.findById(id).isPresent()) {
			address.setId(id);
			return repo.save(address);
		} else
			return null;
	}

	public Address deletAddress(int id) {
		Address address = repo.findById(id).get();
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return address;
		} else
			return null;
	}

	public Address getByIdAddress(int id) {
		if (repo.findById(id).isPresent()) {
			Address address2 = repo.findById(id).get();
			return address2;
		} else
			return null;
	}
}

package com.ty.SpringBootPharmacyApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBootPharmacyApplication.dto.MedicalStore;
import com.ty.SpringBootPharmacyApplication.dto.Medicine;
import com.ty.SpringBootPharmacyApplication.dto.Staff;
import com.ty.SpringBootPharmacyApplication.repository.StaffRepository;

@Repository
public class StaffDao {
	@Autowired
	private StaffRepository repo;

	public Staff signUpStaff(Staff staff) {
		return repo.save(staff);
	}

	public Staff loginStaff(String email) {
		return repo.getStaffByEmail(email);
	}

	public Staff updateStaff(Staff staff, int staff_id) {
		if (repo.findById(staff_id).isPresent()) {
			return repo.save(staff);
		} else
			return null;
	}

	public Staff deleteStaff(int staff_id) {
		if (repo.findById(staff_id).isPresent()) {
			Staff staff = repo.findById(staff_id).get();
			repo.delete(staff);
			return staff;
		} else
			return null;
	}

	public Staff getStaffById(int staff_id) {
		if (repo.findById(staff_id).isPresent()) {
			Staff staff = repo.findById(staff_id).get();
			return staff;
		} else
			return null;
	}

	public Staff getStaffByEmail(String email) {
		return repo.getStaffByEmail(email);
	}

	
}

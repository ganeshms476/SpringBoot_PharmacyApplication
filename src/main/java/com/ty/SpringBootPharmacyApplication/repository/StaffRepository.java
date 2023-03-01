package com.ty.SpringBootPharmacyApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.SpringBootPharmacyApplication.dto.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	@Query("SELECT s FROM Staff s WHERE s.EMAIL=?1")
	public Staff getStaffByEmail(String email);
}

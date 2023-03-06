package com.ty.SpringBootPharmacyApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBootPharmacyApplication.dao.AdminDAO;
import com.ty.SpringBootPharmacyApplication.dao.MedicalStoreDao;
import com.ty.SpringBootPharmacyApplication.dao.MedicineDao;
import com.ty.SpringBootPharmacyApplication.dao.StaffDao;
import com.ty.SpringBootPharmacyApplication.dto.Admin;
import com.ty.SpringBootPharmacyApplication.dto.MedicalStore;
import com.ty.SpringBootPharmacyApplication.dto.Medicine;
import com.ty.SpringBootPharmacyApplication.dto.Staff;
import com.ty.SpringBootPharmacyApplication.exception.AdminIdNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.MedicalStoreIdNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.StaffEmailNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.StaffIdNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.StaffPasswordNotValidException;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@Service
public class StaffService {
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private MedicineDao medicineDao;

	@Autowired
	private MedicalStoreDao medicalStoreDao;

	@Autowired
	private AdminDAO adminDao;

	public ResponseEntity<ResponseStructure<Staff>> signUpStaff(Staff staff, String store_id, String admin_id) {
		ResponseStructure<Staff> structure = new ResponseStructure<>();
		MedicalStore store = medicalStoreDao.getById(store_id);
		Admin admin = adminDao.getAdminById(admin_id);
		if (admin != null) {
			if (store != null) {
				staff.setAdmin(admin);
				staff.setStore(store);
				structure.setMessage("Successfully saved Staff");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(staffDao.signUpStaff(staff));
				return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.CREATED);
			} else
				throw new MedicalStoreIdNotFoundException();
		} else
			throw new AdminIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Staff>> loginStaff(String email, String password) {
		ResponseStructure<Staff> structure = new ResponseStructure<>();
		Staff staff = staffDao.getStaffByEmail(email);
		if (staff != null) {
			if (password.equals(staff.getPassword())) {
				structure.setMessage("Staff Successfully logged in");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(staff);
				return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);
			} else
				throw new StaffPasswordNotValidException();
		} else
			throw new StaffEmailNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(Staff staff, String staff_id, String admin_id,
			String medicalStore_id) {
		ResponseStructure<Staff> structure = new ResponseStructure<>();
		MedicalStore medicalStore = medicalStoreDao.getById(medicalStore_id);
		Admin admin = adminDao.getAdminById(admin_id);
		Staff staff1 = staffDao.getStaffById(staff_id);
		if (admin != null) {
			if (medicalStore != null) {
				if (staff1 != null) {
					staff.setId(staff_id);
					staff.setStore(medicalStore);
					staff.setAdmin(admin);
					structure.setMessage("Successfully updated Staff");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(staffDao.updateStaff(staff, staff_id));
					return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);

				} else
					throw new StaffIdNotFoundException();
			} else
				throw new MedicalStoreIdNotFoundException();
		} else
			throw new AdminIdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(String staff_id) {
		ResponseStructure<Staff> structure = new ResponseStructure<>();
		Staff staff = staffDao.getStaffById(staff_id);
		if (staff != null) {
			structure.setMessage("Successfully deleted Staff");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(staffDao.deleteStaff(staff_id));
			return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);
		} else
			throw new StaffIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Staff>> getStaffById(String staff_id) {
		ResponseStructure<Staff> structure = new ResponseStructure<>();
		Staff staff = staffDao.getStaffById(staff_id);
		if (staff != null) {
			structure.setMessage("Successfully fetched Staff");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(staff);
			return new ResponseEntity<ResponseStructure<Staff>>(structure, HttpStatus.OK);
		} else
			throw new StaffIdNotFoundException();
	}

}

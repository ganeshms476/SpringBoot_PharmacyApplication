package com.ty.SpringBootPharmacyApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBootPharmacyApplication.dao.BookingDAO;
import com.ty.SpringBootPharmacyApplication.dto.Booking;
import com.ty.SpringBootPharmacyApplication.dto.Customer;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@Service
public class BookingService {
	
	@Autowired
	private BookingDAO bookingDAO;
	
//	@Autowired
//	private CustomerDao customerdao;
	
//	public ResponseEntity<ResponseStructure<Booking>> saveBooking(int cid,Booking booking){
//		Customer customer = 
//		if(bookingDAO.saveBooking(booking)!=null) {
//			if
//		}else {
//			return null;
//		}
//	}
}

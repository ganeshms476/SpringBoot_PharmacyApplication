package com.ty.SpringBootPharmacyApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBootPharmacyApplication.dao.BookingDAO;
import com.ty.SpringBootPharmacyApplication.dao.CustomerDao;
import com.ty.SpringBootPharmacyApplication.dao.MedicineDao;
import com.ty.SpringBootPharmacyApplication.dto.Booking;
import com.ty.SpringBootPharmacyApplication.dto.Customer;
import com.ty.SpringBootPharmacyApplication.dto.Medicine;
import com.ty.SpringBootPharmacyApplication.exception.BookingIdNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.CustomerDataNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.CustomerIdNotFoundException;
import com.ty.SpringBootPharmacyApplication.exception.MedicineDataNotFoundException;
import com.ty.SpringBootPharmacyApplication.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	private BookingDAO bookingDAO;

	@Autowired
	private CustomerDao customerdao;

	@Autowired
	private MedicineDao medicineDao;

	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking, String customer_id, String medicine_id) {
		ResponseStructure<Booking> structure = new ResponseStructure<>();
		Medicine medicine = medicineDao.getMedicineById(medicine_id);
		Customer customer = customerdao.getCustomerById(customer_id);
		List<Medicine> list = new ArrayList<>();
		list.add(medicine);
		if (customer != null) {
			if (list != null) {
				booking.setMedicines(list);
				booking.setCustomer(customer);
				structure.setMessage("Successfully saved booking");
				structure.setStatus(HttpStatus.CREATED.value());
				structure.setData(bookingDAO.saveBooking(booking));
				return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
			} else
				throw new MedicineDataNotFoundException();
		} else
			throw new CustomerIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking, String booking_id, String customer_id) {
		ResponseStructure<Booking> structure = new ResponseStructure<>();
		Customer customer = customerdao.getCustomerById(customer_id);
		Booking booking1 = bookingDAO.getBookingById(booking_id);
		if (customer != null) {
			if (booking1 != null) {
				booking.setCustomer(customer);
				booking.setId(booking_id);
				structure.setMessage("Successfully booking is updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(bookingDAO.updateBooking(customer_id, booking1));
				return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
			} else
				throw new BookingIdNotFoundException();
		} else
			throw new CustomerIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(String booking_id) {
		ResponseStructure<Booking> structure = new ResponseStructure<>();
		Booking booking = bookingDAO.getBookingById(booking_id);
		if (booking != null) {
			structure.setMessage("Successfully booking deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(bookingDAO.deleteBooking(booking_id));
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		} else
			throw new BookingIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Booking>> getBookingById(String booking_id) {
		ResponseStructure<Booking> structure = new ResponseStructure<>();
		Booking booking = bookingDAO.getBookingById(booking_id);
		if (booking != null) {
			structure.setMessage("Successfully booking fetched");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(booking);
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		} else
			throw new BookingIdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBookingByCustomerId(String customer_id) {
		ResponseStructure<List<Booking>> structure = new ResponseStructure<>();
		Customer customer = customerdao.getCustomerById(customer_id);
		if (customer != null) {
			structure.setMessage("Successfully fetched all bookings");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(bookingDAO.getAllBookingByCustomerId(customer));
			return new ResponseEntity<ResponseStructure<List<Booking>>>(structure, HttpStatus.OK);
		} else
			throw new CustomerDataNotFoundException();
	}
}

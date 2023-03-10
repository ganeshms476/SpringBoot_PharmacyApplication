package com.ty.SpringBootPharmacyApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBootPharmacyApplication.dto.Booking;
import com.ty.SpringBootPharmacyApplication.dto.Customer;
import com.ty.SpringBootPharmacyApplication.repository.BookingRepository;

@Repository
public class BookingDAO {

	@Autowired
	BookingRepository repository;

	public Booking saveBooking(Booking booking) {
		return repository.save(booking);
	}

	public Booking updateBooking(String id, Booking booking) {
		if (repository.findById(id).isPresent()) {
			booking.setId(id);
			return repository.save(booking);
		} else
			return null;
	}

	public Booking deleteBooking(String id) {
		if (repository.findById(id).isPresent()) {
			Booking booking = repository.findById(id).get();
			repository.deleteById(id);
			return booking;
		} else
			return null;
	}

	public Booking getBookingById(String id) {
		if (repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		} else
			return null;
	}

	

	public List<Booking> getAllBookingByCustomerId(Customer customer) {
		
		return repository.getAllBookingByCustomerId(customer);
	}
}

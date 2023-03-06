package com.ty.SpringBootPharmacyApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.SpringBootPharmacyApplication.dto.Booking;
import com.ty.SpringBootPharmacyApplication.dto.Customer;

public interface BookingRepository extends JpaRepository<Booking, String> {
	@Query("SELECT b FROM Booking b WHERE b.customer=?1")
	public List<Booking> getAllBookingByCustomerId(Customer customer);

}

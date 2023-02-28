package com.ty.SpringBootPharmacyApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBootPharmacyApplication.dto.Booking;


public interface BookingRepository extends JpaRepository<Booking, Integer> {

}	

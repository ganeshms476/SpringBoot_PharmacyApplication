package com.ty.springboot_pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_pharmacy.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}

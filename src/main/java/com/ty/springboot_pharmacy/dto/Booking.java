package com.ty.springboot_pharmacy.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	private Date orderDate;
	private int qty;
	private String paymentMode;
	private double totalAmount;
	private String custRev;
	private Date arrivalDate;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany
	private List<Medicine> medicines;
	
}

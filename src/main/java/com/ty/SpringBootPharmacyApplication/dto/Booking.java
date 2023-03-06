package com.ty.SpringBootPharmacyApplication.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@GenericGenerator(name = "id", strategy = "com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator", parameters = {
			@Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "booking_"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	private Date orderDate;
	private int qty;
	private String paymentMode;
	private Date expectedDate;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany
	private List<Medicine> medicines;
	
}

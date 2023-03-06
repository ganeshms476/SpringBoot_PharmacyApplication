package com.ty.SpringBootPharmacyApplication.dto;

import javax.persistence.Entity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@GenericGenerator(name = "id", strategy = "com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator", parameters = {
			@Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "address_"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	private String street;
	private String landmark;
	private String area;
	private String state;
	private int pincode;

}

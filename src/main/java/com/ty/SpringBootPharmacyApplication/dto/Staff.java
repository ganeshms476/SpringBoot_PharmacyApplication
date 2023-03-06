package com.ty.SpringBootPharmacyApplication.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@GenericGenerator(name = "id", strategy = "com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator", parameters = {
			@Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "staff_"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	private String name;
	private String email;
	private String password;
	private long phone;
	private String address;

	@ManyToOne
	private Admin admin;
	@OneToOne
	private MedicalStore store;
}

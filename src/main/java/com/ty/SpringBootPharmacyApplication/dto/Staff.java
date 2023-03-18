package com.ty.SpringBootPharmacyApplication.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator;
import com.ty.SpringBootPharmacyApplication.dto.Admin;
import lombok.Data;

@Data
@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_id")
	@GenericGenerator(name = "staff_id", strategy = "com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator", parameters = {
			@Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "staff_"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name is mandatory")
	private String name;
	@NotBlank(message = "email should not be blank")
	@NotNull(message = "email is mandatory")
	@Pattern(regexp="[a-zA-Z0-9/-]+[@][a-zA-Z]+[/.][a-z]{2,3}", message = "email should be in a valid format")
	private String email;
	@NotBlank(message = "password should not be blank")
	@NotNull(message = "password is mandatory")
	@Pattern(regexp = "[a-zA-Z]+[0-9]+[@/./-_]", message = "password should be in a valid format")
	private String password;
	@NotBlank(message = "phone number should not be blank")
	@NotNull(message = "phone number is mandatory")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "phone number should be in valid format")
	private String phone;
	@NotBlank(message = "address should not be blank")
	@NotNull(message = "address is mandatory")
	private String address;

	@ManyToOne
	private Admin admin;
	
	@OneToOne
	private MedicalStore store;
}

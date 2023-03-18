package com.ty.SpringBootPharmacyApplication.dto;

import javax.persistence.Entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id")
	@GenericGenerator(name = "address_id", strategy = "com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator", parameters = {
			@Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "address_"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	@NotBlank(message = "street should not be blank")
	@NotNull(message = "street is mandatory")
	private String street;
	@NotBlank(message = "landmark should not be blank")
	@NotNull(message = "landmark is mandatory")
	private String landmark;
	@NotBlank(message = "area should not be blank")
	@NotNull(message = "area is mandatory")
	private String area;
	@NotBlank(message = "state should not be blank")
	@NotNull(message = "state is mandatory")
	private String state;
	@NotBlank(message = "pincode should not be blank")
	@NotNull(message = "pincode is mandatory")
	@Pattern(regexp = "[0-9]{6}", message = "pincode should be in valid format")
	private String pincode;

}

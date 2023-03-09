package com.ty.SpringBootPharmacyApplication.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator;

import lombok.Data;

@Data
@Entity
public class MedicalStore {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@GenericGenerator(name = "id", strategy = "com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator", parameters = {
			@Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "store_"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	@NotBlank(message = "address should not be blank")
	@NotNull(message = "address is mandatory")
	private String name;
	@NotBlank(message = "gst should not be blank")
	@NotNull(message = "gst is mandatory")
	@Pattern(regexp = "[1-9]{2}[A-Za-z]{5}[0-9]{4}[a-zA-z]{1}[0-9]{1}[a-zA-z]{1}[0-9]{1}", message = "gst should be in a valid format")
	private String gst;
	@NotBlank(message = "license should not be blank")
	@NotNull(message = "license is mandatory")
	@Pattern(regexp = "[0-9]{6}", message = "license should be in a valid format")
	private String license;
	@NotBlank(message = "landlineno should not be blank")
	@NotNull(message = "landlineno is mandatory")
	@Pattern(regexp = "[2]{1}[0-9]{5}", message = "landLine number should be in a valid format")
	private String landlineNo;

	@ManyToOne
	private Admin admin;

	@OneToOne
	private Address address;

}

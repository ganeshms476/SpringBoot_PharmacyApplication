package com.ty.SpringBootPharmacyApplication.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id")
	@GenericGenerator(name = "booking_id", strategy = "com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator", parameters = {
			@Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "booking_"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	@NotBlank(message = "Orderdate should not be blank")
	@NotNull(message = "Orderdate is mandatory")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Past(message="OrderDate should be in yyyy-mm-dd format only")
	private Date orderDate;
	@NotBlank(message = "qty should not be blank")
	@NotNull(message = "qty is mandatory")
	@Pattern(regexp = "[1-9]{5}", message = "qty should be in valid format")
	private String qty;
	@NotBlank(message = "paymentMode should not be blank")
	@NotNull(message = "paymentMode is mandatory")
	private String paymentMode;
	@NotBlank(message = "Expected date should not be blank")
	@NotNull(message = "Expected date is mandatory")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Past(message="Expected Date should be in yyyy-mm-dd format only")
	private Date expectedDate;

	@ManyToOne
	private Customer customer;

	@OneToMany
	private List<Medicine> medicines;

}

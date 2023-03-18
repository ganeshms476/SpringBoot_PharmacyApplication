package com.ty.SpringBootPharmacyApplication.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "med_id")
	@GenericGenerator(name = "med_id", strategy = "com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator", parameters = {
			@Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "medicine_"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name is mandatory")
	private String name;
	@NotBlank(message = "cost should not be blank")
	@NotNull(message = "cost is mandatory")
	@Pattern(regexp = "[1-9]+", message = "cost should be in valid format")
	private String cost;
	@NotBlank(message = "date should not be blank")
	@NotNull(message = "date is mandatory")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Past(message = "Expected Date should be in yyyy-mm-dd format only")
	private Date date;
	@NotBlank(message = "stockQty should not be blank")
	@NotNull(message = "stockQty is mandatory")
	@Pattern(regexp = "[0-9]+", message = "stock qty should be in valid format")
	private String stockQty;
	@NotBlank(message = "manufacturer should not be blank")
	@NotNull(message = "manufacturer is mandatory")
	private String manfacturer;
	@NotBlank(message = "description should not be blank")
	@NotNull(message = "description is mandatory")
	private String description;

	@ManyToOne
	@JoinColumn
	private MedicalStore store;

}

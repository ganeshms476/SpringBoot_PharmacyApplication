package com.ty.SpringBootPharmacyApplication.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@GenericGenerator(name = "id", strategy = "com.ty.SpringBootPharmacyApplication.util.StringPreFixedIdSequenceGenerator", parameters = {
			@Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "medicine_"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	private String name;
	private int cost;
	private Date date;
	private int stockQty;
	private String manfacturer;
	private String description;
	
	@ManyToOne
	@JoinColumn
	private MedicalStore store;
	
	
}

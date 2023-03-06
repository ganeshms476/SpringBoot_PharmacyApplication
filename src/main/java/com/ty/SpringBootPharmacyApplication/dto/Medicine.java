package com.ty.SpringBootPharmacyApplication.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int cost;
	private String expdate;
	private int stockQty;
	private String manfacturer;
	private String description;
	
	@ManyToOne
	private MedicalStore store;
	
	
}

package com.ty.SpringBootPharmacyApplication.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class MedicalStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gst;
	private String license;
	private long landlineNo;

	@ManyToOne
	private Admin admin;

	@OneToOne
	private Address address;

	@OneToMany
	private List<Medicine> list;
	

}

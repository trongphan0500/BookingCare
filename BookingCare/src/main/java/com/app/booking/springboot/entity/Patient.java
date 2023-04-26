package com.app.booking.springboot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient extends User {

	@Column(name = "blood_type")
	private String bloodType;
	
	private int height;
	
	private int weight;
	
	private String job;
	
	@OneToMany(mappedBy = "patient")
	private List<ExamninationHistory> examninationHistories;
	
	@OneToOne(mappedBy = "patient")
    private Registration registration;
}

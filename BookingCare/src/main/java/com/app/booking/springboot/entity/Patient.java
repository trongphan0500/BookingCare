package com.app.booking.springboot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "patient")
	private List<Registration> registrations;

}

package com.app.booking.springboot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor extends User {

	private int experience;
	
	@OneToMany(mappedBy = "doctor")
	private List<ExamninationHistory> examninationHistories;
	
	@OneToMany(mappedBy = "doctor")
	private List<Registration> registrations;
	
	@OneToMany(mappedBy = "doctor")
	private List<Schedule> schedules;
	
	@ManyToOne
	@JoinColumn(name = "specialization_id")
	private Specialization specialization;
}

package com.app.booking.springboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam_rooms")
public class ExamRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	private String name;
	
	private int maxPatient;
	
	private String desciption;
	
	@OneToMany(mappedBy = "examRoom")
	private List<ExamninationHistory> examninationHistories;
	
	@OneToMany(mappedBy = "examRoom")
	private List<Registration> registrations;
	
	@ManyToOne
	@JoinColumn(name = "specialization_id")
	private Specialization specialization;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPatient() {
		return maxPatient;
	}

	public void setMaxPatient(int maxPatient) {
		this.maxPatient = maxPatient;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	
	
	
	
}

package com.app.booking.springboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "specializations")
public class Specialization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	private String name;
	
	private String image;
	
	@Column(name = "number_exam_rooms")
	private int numberExamRooms;
	
	private String description;
	
	@OneToMany(mappedBy = "specialization")
	private List<ExamRoom> examRooms;
	
	@OneToMany(mappedBy = "specialization")
	private List<Doctor> doctors;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;
	
}

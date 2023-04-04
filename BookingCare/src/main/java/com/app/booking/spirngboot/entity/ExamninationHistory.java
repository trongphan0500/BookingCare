package com.app.booking.spirngboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examnination_historys")
public class ExamninationHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "time_done")
	private Date timeDone;
	
	@Column(name = "time_examination")
	private String timeExamination;	
	
	@Column(name = "re_examination_date")
	private Date reExaminationDate;
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "consultation_id")
//    private Consultation consultation;
	
	@OneToOne(mappedBy = "examninationHistory")
	private Consultation consultation;
	
//	@ManyToMany(mappedBy = "examninationHistories",fetch = FetchType.LAZY)
//	private List<Service> services;
	
	@ManyToOne
	@JoinColumn(name = "exam_room_id")
	private ExamRoom examRoom;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;
	
	@OneToOne(mappedBy = "examninationHistory")
	private Order order;
}

package com.example.doctorcareserver.entity;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTimeDone() {
		return timeDone;
	}

	public void setTimeDone(Date timeDone) {
		this.timeDone = timeDone;
	}

	public String getTimeExamination() {
		return timeExamination;
	}

	public void setTimeExamination(String timeExamination) {
		this.timeExamination = timeExamination;
	}

	public Date getReExaminationDate() {
		return reExaminationDate;
	}

	public void setReExaminationDate(Date reExaminationDate) {
		this.reExaminationDate = reExaminationDate;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public ExamRoom getExamRoom() {
		return examRoom;
	}

	public void setExamRoom(ExamRoom examRoom) {
		this.examRoom = examRoom;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ExamninationHistory(int id, Date timeDone, String timeExamination, Date reExaminationDate,
			Consultation consultation, ExamRoom examRoom, Patient patient, Doctor doctor, Date createdAt,
			Date updatedAt, Order order) {
		super();
		this.id = id;
		this.timeDone = timeDone;
		this.timeExamination = timeExamination;
		this.reExaminationDate = reExaminationDate;
		this.consultation = consultation;
		this.examRoom = examRoom;
		this.patient = patient;
		this.doctor = doctor;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.order = order;
	}

	public ExamninationHistory() {
		super();
	}
	
}

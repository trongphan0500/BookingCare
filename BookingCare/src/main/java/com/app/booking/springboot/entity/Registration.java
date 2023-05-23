package com.app.booking.springboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registrations")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int priority;

	@Column(name = "time_register")
	private String timeRegister;

	private int status;

	private int type;

	@Column(name = "examination_fee")
	private float examinationFee;

	@Column(name = "cardinal_number")
	private int cardinalNumber;

	@Column(name = "created_at")
	private Date createdAt;

	@ManyToMany(mappedBy = "registrations", fetch = FetchType.LAZY)
	private List<Service> services;
//	@OneToMany(mappedBy = "registration")
//	private List<Service> services;

	@ManyToOne
	@JoinColumn(name = "exam_room_id")
	private ExamRoom examRoom;

<<<<<<< HEAD
=======
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "patient_id")
>>>>>>> 56e256c72034e8d8b93ba34b6cbe18eb83a2831b
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	private int stt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTimeRegister() {
		return timeRegister;
	}

	public void setTimeRegister(String timeRegister) {
		this.timeRegister = timeRegister;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
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

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public Registration(String timeRegister, int status, int type, Date createdAt, Patient patient, int stt) {
		super();
		
		this.timeRegister = timeRegister;
		this.status = status;
		this.type = type;
		this.createdAt = createdAt;
		this.patient = patient;
		this.stt = stt;
	}

	public Registration() {
		super();
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", priority=" + priority + ", timeRegister=" + timeRegister + ", status="
				+ status + ", type=" + type + ", examinationFee=" + examinationFee + ", cardinalNumber="
				+ cardinalNumber + ", createdAt=" + createdAt + ", services=" + services + ", examRoom=" + examRoom
				+ ", patient=" + patient + ", doctor=" + doctor + ", stt=" + stt + "]";
	}
	
	
	
	

}

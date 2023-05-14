package com.example.doctorcareserver.entity;

import java.util.Date;
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

	public Patient( String name, String email, String password, String address, String phone, String avatar,
			int gender, String description, int isActive, int isLogin, int verifyCode, int accessToken, String position,
			Role role, Date createdAt, Date updatedAt, String bloodType, int height, int weight, String job,
			List<ExamninationHistory> examninationHistories, Registration registration) {
		super( name, email, password, address, phone, avatar, gender, description, isActive, isLogin, verifyCode,
				accessToken, position, role, createdAt, updatedAt);
		this.bloodType = bloodType;
		this.height = height;
		this.weight = weight;
		this.job = job;
		this.examninationHistories = examninationHistories;
		this.registration = registration;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public List<ExamninationHistory> getExamninationHistories() {
		return examninationHistories;
	}

	public void setExamninationHistories(List<ExamninationHistory> examninationHistories) {
		this.examninationHistories = examninationHistories;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Patient(int id, String name, String email, String password, String address, String phone, String avatar,
			int gender, String description, int isActive, int isLogin, int verifyCode, int accessToken, String position,
			Role role, Date createdAt, Date updatedAt) {
		super(id, name, email, password, address, phone, avatar, gender, description, isActive, isLogin, verifyCode,
				accessToken, position, role, createdAt, updatedAt);
	}

	public Patient() {
		super();
	}

	@Override
	public String toString() {
		return "Patient [bloodType=" + bloodType + ", height=" + height + ", weight=" + weight + ", job=" + job
				+ ", examninationHistories=" + examninationHistories + ", registration=" + registration
				+ ", toString()=" + super.toString() + "]";
	}

	

	
	
	
	

	
	
	
}

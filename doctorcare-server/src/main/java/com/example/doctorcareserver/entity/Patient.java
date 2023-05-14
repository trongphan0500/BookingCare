package com.example.doctorcareserver.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
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


	public Patient(String name, String email, String password, String address, String phone, byte[] avatar, int gender,
			String description, int isActive, int isLogin, int verifyCode, String accessToken, String refeshToken,
			String position, int roleId, Date createdAt, Date updatedAt) {
		super(name, email, password, address, phone, avatar, gender, description, isActive, isLogin, verifyCode, accessToken,
				refeshToken, position, roleId, createdAt, updatedAt);
		// TODO Auto-generated constructor stub
	}
	
	

	public Patient(String name, String email, String password, String address, String phone, byte[] avatar, int gender,
			String bloodType, int height, int weight, String job) {
		super(name, email, password, address, phone, avatar, gender);
		this.bloodType = bloodType;
		this.height = height;
		this.weight = weight;
		this.job = job;
	}



	@Column(name = "blood_type")
	private String bloodType;
	
	private int height;
	
	private int weight;
	
	private String job;
	
	@OneToMany(mappedBy = "patient")
	private List<ExamninationHistory> examninationHistories;
	
	@OneToOne(mappedBy = "patient")
    private Registration registration;

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



	@Override
	public String toString() {
		return "Patient [bloodType=" + bloodType + ", height=" + height + ", weight=" + weight + ", job=" + job
				+ ", examninationHistories=" + examninationHistories + ", registration=" + registration + "]";
	}

	

	

	
	


	
	
	
}

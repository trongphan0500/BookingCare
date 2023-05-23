package com.app.booking.springboot.entity;

import java.util.Arrays;
import java.util.Date;
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

//	@OneToOne(mappedBy = "patient")
//    private Registration registration;

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

	public Patient(int id, String name, String email, String password, String address, String phone, byte[] avatar,
			int gender, String description, int isActive, int isLogin, int verifyCode, String accessToken,
			String refeshToken, String position, int roleId, Date createdAt, Date updatedAt, String bloodType,
			int height, int weight, String job, List<ExamninationHistory> examninationHistories,
			Registration registration) {
		super(id, name, email, password, address, phone, avatar, gender, description, isActive, isLogin, verifyCode,
				accessToken, refeshToken, position, roleId, createdAt, updatedAt);
		this.bloodType = bloodType;
		this.height = height;
		this.weight = weight;
		this.job = job;
		this.examninationHistories = examninationHistories;

	}

	public Patient() {
		super();
	}

	@Override
	public String toString() {
		return "Patient [bloodType=" + bloodType + ", height=" + height + ", weight=" + weight + ", job=" + job
				+ ", examninationHistories=" + examninationHistories + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getRoleId()=" + getRoleId() + ", getEmail()=" + getEmail() + ", getPassword()="
				+ getPassword() + ", getAddress()=" + getAddress() + ", getPhone()=" + getPhone() + ", getAvatar()="
				+ Arrays.toString(getAvatar()) + ", getGender()=" + getGender() + ", getDescription()="
				+ getDescription() + "]";
	}

}

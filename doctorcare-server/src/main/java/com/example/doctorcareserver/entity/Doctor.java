package com.example.doctorcareserver.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
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
@DiscriminatorValue("DOCTOR")
public class Doctor extends User {

	public Doctor(String name, String email, String password, String address, String phone, byte[] avatar, int gender,
			String description, int isActive, int isLogin, int verifyCode, String accessToken, String refeshToken,
			String position, int roleId, Date createdAt, Date updatedAt) {
		super(name, email, password, address, phone, avatar, gender, description, isActive, isLogin, verifyCode, accessToken,
				refeshToken, position, roleId, createdAt, updatedAt);
		// TODO Auto-generated constructor stub
	}

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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public List<ExamninationHistory> getExamninationHistories() {
		return examninationHistories;
	}

	public void setExamninationHistories(List<ExamninationHistory> examninationHistories) {
		this.examninationHistories = examninationHistories;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	

	
	
}

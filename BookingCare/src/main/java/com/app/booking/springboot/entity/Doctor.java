package com.app.booking.springboot.entity;

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

	public Doctor(int id, String name, String email, String password, String address, String phone, byte[] avatar,
			int gender, String description, int isActive, int isLogin, int verifyCode, String accessToken,
			String refeshToken, String position, int roleId, Date createdAt, Date updatedAt, int experience,
			List<ExamninationHistory> examninationHistories, List<Registration> registrations, List<Schedule> schedules,
			Specialization specialization) {
		super(id, name, email, password, address, phone, avatar, gender, description, isActive, isLogin, verifyCode,
				accessToken, refeshToken, position, roleId, createdAt, updatedAt);
		this.experience = experience;
		this.examninationHistories = examninationHistories;
		this.registrations = registrations;
		this.schedules = schedules;
		this.specialization = specialization;
	}

	public Doctor() {
		super();
	}

	
	
}

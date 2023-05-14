package com.example.doctorcareserver.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User {

	

	public Employee(String name, String email, String password, String address, String phone, byte[] avatar, int gender,
			String description, int isActive, int isLogin, int verifyCode, String accessToken, String refeshToken,
			String position, int roleId, Date createdAt, Date updatedAt) {
		super(name, email, password, address, phone, avatar, gender, description, isActive, isLogin, verifyCode, accessToken,
				refeshToken, position, roleId, createdAt, updatedAt);
		// TODO Auto-generated constructor stub
	}

	private String department;

	private float salary;

	@OneToMany(mappedBy = "employee")
	private List<Order> orders;

	@OneToMany(mappedBy = "employee")
	private List<WarehouseSession> warehouseSessions;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}

package com.app.booking.springboot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends User {

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

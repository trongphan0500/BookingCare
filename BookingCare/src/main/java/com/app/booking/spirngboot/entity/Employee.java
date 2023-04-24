package com.app.booking.spirngboot.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends User {
	
	private String department;
	
	private BigDecimal salary;
	
	@OneToMany(mappedBy = "employee")
	private List<Order> orders;
	
	@OneToMany(mappedBy = "employee")
	private List<WarehouseSession> warehouseSessions;
}

package com.app.booking.spirngboot.entity;

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
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	private float amount;
	
	@Column(name = "discount_percent")
	private int discountPercent;
	
	@Column(name = "discount_amount")
	private int discountAmount;
	
	@Column(name = "total_amount")
	private float totalAmount;
	
	private int type;
	
	private int status;
	
	@Column(name = "receipt_number_no")
	private int receiptNumberNo;
	
	@Column(name = "discount_type")
	private int discountType;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "examnination_history_id")
	private ExamninationHistory examninationHistory;
	
	@ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
	private List<Service> services;
	
	@ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
	private List<Medicine> medicines;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;
}

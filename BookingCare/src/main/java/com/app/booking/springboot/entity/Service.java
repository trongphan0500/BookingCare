package com.app.booking.springboot.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "services")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	private String name;
	
	private String description;
	
	private float price;
	
	@ManyToOne
    @JoinColumn(name = "examnination_history_id")
	private ExamninationHistory examninationHistory;
	
	@ManyToOne
	@JoinColumn(name = "service_type_id")
	private ServiceType serviceType;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "consultation_service_details",
               joinColumns = @JoinColumn(name = "service_id"),
               inverseJoinColumns = @JoinColumn(name = "registration_id"))
    private List<Registration> registrations;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "order_service_details",
               joinColumns = @JoinColumn(name = "service_id"),
               inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "service_details",
//               joinColumns = @JoinColumn(name = "service_id"),
//               inverseJoinColumns = @JoinColumn(name = "examnination_history_id"))
//    private List<ExamninationHistory> examninationHistories;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Service(int id, String code, String name, String description, float price,
			ExamninationHistory examninationHistory, ServiceType serviceType, List<Registration> registrations,
			List<Order> orders, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.examninationHistory = examninationHistory;
		this.serviceType = serviceType;
		this.registrations = registrations;
		this.orders = orders;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Service() {
		super();
	}
	
	
	
	
	
}

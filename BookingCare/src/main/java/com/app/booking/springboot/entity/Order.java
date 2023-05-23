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
	@OneToMany(mappedBy = "order")
	private List<OrderMediceneDetail>orderMediceneDetails;
	@OneToMany(mappedBy = "order")
	private List<OrderServiceDetail> orderServiceDetails;
	
	public List<OrderServiceDetail> getOrderServiceDetails() {
		return orderServiceDetails;
	}


	public void setOrderServiceDetails(List<OrderServiceDetail> orderServiceDetails) {
		this.orderServiceDetails = orderServiceDetails;
	}


	public List<OrderMediceneDetail> getOrderMediceneDetails() {
		return orderMediceneDetails;
	}


	public void setOrderMediceneDetails(List<OrderMediceneDetail> orderMediceneDetails) {
		this.orderMediceneDetails = orderMediceneDetails;
	}


	public Order(String code, float amount, int discountPercent, int discountAmount, float totalAmount,
			int type, int status, int receiptNumberNo, int discountType, String description, Employee employee,
			ExamninationHistory examninationHistory, List<Service> services, List<Medicine> medicines, Date createdAt,
			Date updatedAt) {
		super();
		this.code = code;
		this.amount = amount;
		this.discountPercent = discountPercent;
		this.discountAmount = discountAmount;
		this.totalAmount = totalAmount;
		this.type = type;
		this.status = status;
		this.receiptNumberNo = receiptNumberNo;
		this.discountType = discountType;
		this.description = description;
		this.employee = employee;
		this.examninationHistory = examninationHistory;
		this.services = services;
		this.medicines = medicines;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	

	public Order() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getReceiptNumberNo() {
		return receiptNumberNo;
	}

	public void setReceiptNumberNo(int receiptNumberNo) {
		this.receiptNumberNo = receiptNumberNo;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ExamninationHistory getExamninationHistory() {
		return examninationHistory;
	}

	public void setExamninationHistory(ExamninationHistory examninationHistory) {
		this.examninationHistory = examninationHistory;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", code=" + code + ", amount=" + amount + ", discountPercent=" + discountPercent
				+ ", discountAmount=" + discountAmount + ", totalAmount=" + totalAmount + ", type=" + type + ", status="
				+ status + ", receiptNumberNo=" + receiptNumberNo + ", discountType=" + discountType + ", description="
				+ description + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}


	
	
	
	



	
	
}

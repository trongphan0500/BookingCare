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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse_sessions")
public class WarehouseSession {
	
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "warehouse_session_details",
               joinColumns = @JoinColumn(name = "warehouse_session_id"),
               inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicine> medicines;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;
	
	
}

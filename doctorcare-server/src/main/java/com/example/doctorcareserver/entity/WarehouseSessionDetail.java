package com.example.doctorcareserver.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse_session_details")
public class WarehouseSessionDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int quantity;
	
	private float price;
	
	@Column(name = "total_amount")
	private float totalAmount;
	
	@Column(name = "warehouse_session_status")
	private int warehouseSessionStatus;
	
	@Column(name = "warehouse_session_type")
	private int warehouseSessionType;
	
	@ManyToOne
	@JoinColumn(name = "warehouse_session_id")
	private WarehouseSession warehouseSession;
	
	@ManyToOne
	@JoinColumn(name = "medicine_id")
	private Medicine medicine;
	
	@Column(name = "created_at")
	private Date createdAt;
	
}

package com.app.booking.springboot.entity.model.storeProcedure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicineHistoryModel {

	@Id
	@Column(name = "created_at")
	private String createdAt;

	private int quantity;

	@Column(name = "warehouse_session_status")
	private int warehouseSessionStatus;

	private int id;

	private String name;

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

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

	public int getWarehouseSessionStatus() {
		return warehouseSessionStatus;
	}

	public void setWarehouseSessionStatus(int warehouseSessionStatus) {
		this.warehouseSessionStatus = warehouseSessionStatus;
	}

}

package com.app.booking.springboot.entity.model.storeProcedure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicineHistoryModal {

	@Id
	@Column(name = "medicine_id")
	private int medicineId;

	private String name;

	private String avatar;

	@Column(name = "warehouse_session_status")
	private int warehouseSessionStatus;

	private int quantity;

	@Column(name = "created_at")
	private String createAt;

	private String description;

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWarehouseSessionStatus() {
		return warehouseSessionStatus;
	}

	public void setWarehouseSessionStatus(int warehouseSessionStatus) {
		this.warehouseSessionStatus = warehouseSessionStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

}

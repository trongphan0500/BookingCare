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

	private String description;

	@Column(name = "warehouse_session_status")
	private int warehouseSessionStatus;

	private int quantity;

	@Column(name = "created_at")
	private String createAt;

<<<<<<< HEAD:BookingCare/src/main/java/com/app/booking/springboot/entity/model/storeProcedure/MedicineHistoryModal.java
	public int getMedicineId() {
		return medicineId;
=======
	private String description;

	public String getCreatedAt() {
		return createdAt;
>>>>>>> 56e256c72034e8d8b93ba34b6cbe18eb83a2831b:BookingCare/src/main/java/com/app/booking/springboot/entity/model/storeProcedure/MedicineHistoryModel.java
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

<<<<<<< HEAD:BookingCare/src/main/java/com/app/booking/springboot/entity/model/storeProcedure/MedicineHistoryModal.java
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
=======
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
>>>>>>> 56e256c72034e8d8b93ba34b6cbe18eb83a2831b:BookingCare/src/main/java/com/app/booking/springboot/entity/model/storeProcedure/MedicineHistoryModel.java
	}

}

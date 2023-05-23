package com.app.booking.springboot.response;

import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.model.storeProcedure.MedicineHistoryModal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicineHistoryResponse {

	@JsonProperty("medicine_id")
	private int medicineId;

	private String name;

	private String avatar;

	private String description;

	@JsonProperty("warehouse_session_status")
	private int warehouseSessionStatus;

	private int quantity;

	@JsonProperty("created_at")
	private String createAt;

	private String description;

	public MedicineHistoryResponse() {
	}

	public MedicineHistoryResponse(MedicineHistoryModal entity) {
		this.medicineId = entity.getMedicineId();
		this.name = entity.getName();
<<<<<<< HEAD
		this.avatar = entity.getAvatar();
		this.description = entity.getDescription();
		this.warehouseSessionStatus = entity.getWarehouseSessionStatus();
		this.quantity = entity.getQuantity();
		this.createAt = entity.getCreateAt();
=======
		this.description = entity.getDescription();
>>>>>>> 56e256c72034e8d8b93ba34b6cbe18eb83a2831b
	}

	public List<MedicineHistoryResponse> mapToList(List<MedicineHistoryModal> entiies) {
		return entiies.stream().map(x -> new MedicineHistoryResponse(x)).collect(Collectors.toList());
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

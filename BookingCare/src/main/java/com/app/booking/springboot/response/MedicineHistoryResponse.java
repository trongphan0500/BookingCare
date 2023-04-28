package com.app.booking.springboot.response;

import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.model.storeProcedure.MedicineHistoryModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicineHistoryResponse {

	@JsonProperty("created_at")
	private String createdAt;

	private int quantity;

	@JsonProperty("warehouse_session_status")
	private String warehouseSessionStatus;

	private int id;

	private String name;

	public MedicineHistoryResponse() {
	}

	public MedicineHistoryResponse(MedicineHistoryModel entity) {
		this.createdAt = entity.getCreatedAt();
		this.quantity = entity.getQuantity();
		this.warehouseSessionStatus = entity.getWarehouseSessionStatus() == 1 ? "Xuất kho" : "Nhập kho";
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public List<MedicineHistoryResponse> mapToList(List<MedicineHistoryModel> entiies) {
		return entiies.stream().map(x -> new MedicineHistoryResponse(x)).collect(Collectors.toList());
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getQuantity() {
		return quantity;
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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getWarehouseSessionStatus() {
		return warehouseSessionStatus;
	}

	public void setWarehouseSessionStatus(String warehouseSessionStatus) {
		this.warehouseSessionStatus = warehouseSessionStatus;
	}

}

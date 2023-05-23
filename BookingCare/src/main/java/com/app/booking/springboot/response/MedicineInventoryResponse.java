package com.app.booking.springboot.response;

import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.model.storeProcedure.MedicineInventoryModel;

public class MedicineInventoryResponse {

	private int id;

	private String name;

	private int quantity;

	public MedicineInventoryResponse() {
	}

	public MedicineInventoryResponse(MedicineInventoryModel entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.quantity = entity.getQuantity();
	}

	public List<MedicineInventoryResponse> mapToList(List<MedicineInventoryModel> entiies) {
		return entiies.stream().map(x -> new MedicineInventoryResponse(x)).collect(Collectors.toList());
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

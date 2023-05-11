package com.app.booking.springboot.response;

import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.model.storeProcedure.MedicineInventoryNew;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicineInventoryResponseNew {
	private int id;

	private String name;

	private String avatar;

	@JsonProperty("retail_price")
	private float retailPrice;

	@JsonProperty("cost_price")
	private float costPrice;

	@JsonProperty("inventory_quantity")
	private int inventoryQuantity;

	@JsonProperty("storage_unit")
	private String storageUnit;

	private int inventory;

	public MedicineInventoryResponseNew() {
	}

	public MedicineInventoryResponseNew(MedicineInventoryNew entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.avatar = entity.getAvatar();
		this.retailPrice = entity.getRetailPrice();
		this.costPrice = entity.getCostPrice();
		this.inventoryQuantity = entity.getInventoryQuantity();
		this.storageUnit = entity.getStorageUnit();
		this.inventory = entity.getInventory();
	}

	public List<MedicineInventoryResponseNew> mapToList(List<MedicineInventoryNew> entiies) {
		return entiies.stream().map(x -> new MedicineInventoryResponseNew(x)).collect(Collectors.toList());
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public float getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(float retailPrice) {
		this.retailPrice = retailPrice;
	}

	public float getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}

	public int getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	public String getStorageUnit() {
		return storageUnit;
	}

	public void setStorageUnit(String storageUnit) {
		this.storageUnit = storageUnit;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

}

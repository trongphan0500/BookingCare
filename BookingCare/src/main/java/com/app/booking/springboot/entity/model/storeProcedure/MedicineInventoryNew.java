package com.app.booking.springboot.entity.model.storeProcedure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicineInventoryNew {
	@Id
	private int id;

	private String name;

	private String avatar;

	@Column(name = "retail_price")
	private float retailPrice;

	@Column(name = "cost_price")
	private float costPrice;

	@Column(name = "inventory_quantity")
	private int inventoryQuantity;

	@Column(name = "storage_unit")
	private String storageUnit;

	private int inventory;

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

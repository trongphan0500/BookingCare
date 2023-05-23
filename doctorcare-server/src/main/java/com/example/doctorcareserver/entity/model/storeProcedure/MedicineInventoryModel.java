package com.example.doctorcareserver.entity.model.storeProcedure;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicineInventoryModel {

	@Id
	private int id;

	private String name;

	private int quantity;

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

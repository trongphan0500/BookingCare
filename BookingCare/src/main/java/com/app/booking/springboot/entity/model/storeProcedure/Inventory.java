package com.app.booking.springboot.entity.model.storeProcedure;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {
	@Id
	private int id;

	private String name;

	private float quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

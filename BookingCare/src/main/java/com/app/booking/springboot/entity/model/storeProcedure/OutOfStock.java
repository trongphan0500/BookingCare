package com.app.booking.springboot.entity.model.storeProcedure;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class OutOfStock {
	@Id
	private int id;

	private String name;

	@Column(name = "current_quantity")
	private BigDecimal currentQuantity;

	@Column(name = "out_of_stock")
	private int outOfStock;

	@Column(name = "quantity_need_to_add")
	private BigDecimal quantityNeedToAdd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOutOfStock() {
		return outOfStock;
	}

	public void setOutOfStock(int outOfStock) {
		this.outOfStock = outOfStock;
	}

	public BigDecimal getQuantityNeedToAdd() {
		return quantityNeedToAdd;
	}

	public void setQuantityNeedToAdd(BigDecimal quantityNeedToAdd) {
		this.quantityNeedToAdd = quantityNeedToAdd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(BigDecimal currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

}

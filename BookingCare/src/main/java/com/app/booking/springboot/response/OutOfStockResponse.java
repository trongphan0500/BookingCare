package com.app.booking.springboot.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.model.storeProcedure.OutOfStock;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OutOfStockResponse {
	private int id;

	private String name;

	@JsonProperty("current_quantity")
	private BigDecimal currentQuantity;

	@JsonProperty("out_of_stock")
	private int outOfStock;

	@JsonProperty("quantity_need_to_add")
	private BigDecimal quantityNeedToAdd;

	public OutOfStockResponse() {
		super();
	}

	public OutOfStockResponse(OutOfStock entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.currentQuantity = entity.getCurrentQuantity();
		this.outOfStock = entity.getOutOfStock();
		this.quantityNeedToAdd = entity.getQuantityNeedToAdd();
	}

	public List<OutOfStockResponse> mapToList(List<OutOfStock> entiies) {
		return entiies.stream().map(x -> new OutOfStockResponse(x)).collect(Collectors.toList());
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

	public BigDecimal getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(BigDecimal currentQuantity) {
		this.currentQuantity = currentQuantity;
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

}

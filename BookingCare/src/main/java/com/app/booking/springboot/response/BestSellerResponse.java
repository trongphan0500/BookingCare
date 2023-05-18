package com.app.booking.springboot.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.model.storeProcedure.BestSeller;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BestSellerResponse {
	private int id;

	private String name;

	@JsonProperty("total_quantity")
	private int totalQuantity;

	@JsonProperty("retail_price")
	private BigDecimal retailPrice;

	@JsonProperty("cost_price")
	private BigDecimal costPrice;

	public BestSellerResponse() {
	}

	public BestSellerResponse(BestSeller entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.totalQuantity = entity.getTotalQuantity();
		this.retailPrice = entity.getRetailPrice();
		this.costPrice = entity.getCostPrice();
	}

	public List<BestSellerResponse> mapToList(List<BestSeller> entiies) {
		return entiies.stream().map(x -> new BestSellerResponse(x)).collect(Collectors.toList());
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

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public BigDecimal getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

}

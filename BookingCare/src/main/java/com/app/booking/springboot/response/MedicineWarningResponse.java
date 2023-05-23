package com.app.booking.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.model.storeProcedure.MedicineWaningModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicineWarningResponse {

	private int id;

	private String name;

	private String avatar;

	@JsonProperty("expiry_date")
	private Date expiryDate;

	@JsonProperty("out_stock_alert_quantity")
	private int outStockAlertQuantity;

	@JsonProperty("retail_price")
	private float retailPrice;

	@JsonProperty("cost_price")
	private float costPrice;

	@JsonProperty("inventory_quantity")
	private int inventoryQuantity;

	@JsonProperty("out_expiry_date_alert")
	private int outExpiryDateAlert;

	@JsonProperty("time_left")
	private int timeLeft;

	public MedicineWarningResponse() {
	}

	public MedicineWarningResponse(MedicineWaningModel entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.avatar = entity.getAvatar();
		this.expiryDate = entity.getExpiryDate();
		this.outStockAlertQuantity = entity.getOutStockAlertQuantity();
		this.retailPrice = entity.getRetailPrice();
		this.costPrice = entity.getCostPrice();
		this.inventoryQuantity = entity.getInventoryQuantity();
		this.outExpiryDateAlert = entity.getOutExpiryDateAlert();
		this.timeLeft = entity.getTimeLeft();
	}

	public List<MedicineWarningResponse> mapToList(List<MedicineWaningModel> entiies) {
		return entiies.stream().map(x -> new MedicineWarningResponse(x)).collect(Collectors.toList());
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

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getOutStockAlertQuantity() {
		return outStockAlertQuantity;
	}

	public void setOutStockAlertQuantity(int outStockAlertQuantity) {
		this.outStockAlertQuantity = outStockAlertQuantity;
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

	public int getOutExpiryDateAlert() {
		return outExpiryDateAlert;
	}

	public void setOutExpiryDateAlert(int outExpiryDateAlert) {
		this.outExpiryDateAlert = outExpiryDateAlert;
	}

	public int getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

}

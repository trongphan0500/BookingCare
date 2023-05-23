package com.app.booking.springboot.entity.model.storeProcedure;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicineWaningModel {

	@Id
	private int id;

	private String name;

	private String avatar;

	@Column(name = "expiry_date")
	private Date expiryDate;

	@Column(name = "out_stock_alert_quantity")
	private int outStockAlertQuantity;

	@Column(name = "retail_price")
	private float retailPrice;

	@Column(name = "cost_price")
	private float costPrice;

	@Column(name = "inventory_quantity")
	private int inventoryQuantity;

	@Column(name = "out_expiry_date_alert")
	private int outExpiryDateAlert;

	@Column(name = "time_left")
	private int timeLeft;

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

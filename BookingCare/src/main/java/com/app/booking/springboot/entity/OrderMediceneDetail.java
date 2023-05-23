package com.app.booking.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_medicine_details")
public class OrderMediceneDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private float price;
	
	private int quantity;
	
	@Column(name = "total_amount")
	private float totalAmount;
	
	@Column(name = "total_cost_price_amount")
	private float totalCostPriceAmount;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "medicine_id")
	private Medicine medicine;
	
	@Column(name = "created_at")
	private Date createdAt;

	public OrderMediceneDetail( String name, float price, int quantity, float totalAmount,
			float totalCostPriceAmount, Order order, Medicine medicine, Date createdAt) {
		super();
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.totalCostPriceAmount = totalCostPriceAmount;
		this.order = order;
		this.medicine = medicine;
		this.createdAt = createdAt;
	}

	public OrderMediceneDetail() {
		super();
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public float getTotalCostPriceAmount() {
		return totalCostPriceAmount;
	}

	public void setTotalCostPriceAmount(float totalCostPriceAmount) {
		this.totalCostPriceAmount = totalCostPriceAmount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "OrderMediceneDetail [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", totalAmount=" + totalAmount + ", totalCostPriceAmount=" + totalCostPriceAmount + ", medicine="
				+ medicine + ", createdAt=" + createdAt + "]";
	}

	

	
	
}

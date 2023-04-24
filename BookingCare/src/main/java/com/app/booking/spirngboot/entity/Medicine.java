package com.app.booking.spirngboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicines")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String avatar;

	private String code;

	@Column(name = "expiry_date")
	private Date expiryDate;

	@Column(name = "normalize_name")
	private String normalizeName;

	@Column(name = "prefix_name")
	private String prefixName;

	@Column(name = "out_stock_alert_quantity")
	private int outStockAlertQuantity;

	@Column(name = "retail_price")
	private float retailPrice;

	@Column(name = "cost_price")
	private float costPrice;

	private boolean status;

	private String type;

	private String note;
	
	@Column(name = "storage_unit")
	private String storageUnit;
	
	@Column(name = "use_unit")
	private String useUnit;
	
	@Column(name = "method_of_use")
	private String methodOfUse;

	@Column(name = "original_name")
	private String originalName;

	@Column(name = "out_expiry_date_alert")
	private int outExpiryDateAlert;

	@ManyToMany(mappedBy = "medicines", fetch = FetchType.LAZY)
	private List<Consultation> consultations;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany(mappedBy = "medicines", fetch = FetchType.LAZY)
	private List<WarehouseSession> warehouseSessions;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "order_medicine_details", joinColumns = @JoinColumn(name = "medicine_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Order> orders;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

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

	public String getCode() {
		return code;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getOutExpiryDateAlert() {
		return outExpiryDateAlert;
	}

	public void setOutExpiryDateAlert(int outExpiryDateAlert) {
		this.outExpiryDateAlert = outExpiryDateAlert;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public List<WarehouseSession> getWarehouseSessions() {
		return warehouseSessions;
	}

	public void setWarehouseSessions(List<WarehouseSession> warehouseSessions) {
		this.warehouseSessions = warehouseSessions;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNormalizeName() {
		return normalizeName;
	}

	public void setNormalizeName(String normalizeName) {
		this.normalizeName = normalizeName;
	}

	public String getPrefixName() {
		return prefixName;
	}

	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

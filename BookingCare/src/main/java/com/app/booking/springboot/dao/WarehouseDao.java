package com.app.booking.springboot.dao;

import java.math.BigDecimal;

public interface WarehouseDao {

	void createWarehouseSession(int employeeId, int discountPercent, int type, float discountAmount, String description,
			String warehouseDeitalJson) throws Exception;
}
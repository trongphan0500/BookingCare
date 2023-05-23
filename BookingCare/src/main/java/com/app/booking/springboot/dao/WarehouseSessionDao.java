package com.app.booking.springboot.dao;

import java.util.Date;

public interface WarehouseSessionDao {

	void createWarehouseSession(int employeeId, int discountPercent, int type, float discountAmount,
			Date manufactureDate, Date expiryDate, String description, String warehouseDeitalJson) throws Exception;
}

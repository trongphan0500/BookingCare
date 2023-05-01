package com.app.booking.springboot.service;

import java.math.BigDecimal;

public interface WarehouseSessionService {

	void createWarehouseSession(int employeeId, int discountPercent, int type, float discountAmount, String description,
			String warehouseDeitalJson) throws Exception;
}

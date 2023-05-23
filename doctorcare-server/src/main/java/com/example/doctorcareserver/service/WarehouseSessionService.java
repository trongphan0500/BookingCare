package com.example.doctorcareserver.service;

import java.math.BigDecimal;
import java.util.Date;

public interface WarehouseSessionService {

	void createWarehouseSession(int employeeId, int discountPercent, int type, float discountAmount,
			Date manufactureDate, Date expiryDate, String description, String warehouseDeitalJson) throws Exception;
}

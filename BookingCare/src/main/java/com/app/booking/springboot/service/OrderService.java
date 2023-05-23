package com.app.booking.springboot.service;

public interface OrderService {

	void createMedicneOrder(int employeeId, int discountPercent, int type, float discountAmount, String description,
			String warehouseDeitalJson) throws Exception;

	int checkQuantityMedicine(int medicineId, int quatity) throws Exception;
}

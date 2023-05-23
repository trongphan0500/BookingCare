package com.example.doctorcareserver.service;

public interface OrderService {

	void createMedicneOrder(int employeeId, int discountPercent, int type, float discountAmount, String description,
			String warehouseDeitalJson) throws Exception;

	int checkQuantityMedicine(int medicineId, int quatity) throws Exception;
}

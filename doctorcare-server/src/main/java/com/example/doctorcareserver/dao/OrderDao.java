package com.example.doctorcareserver.dao;

public interface OrderDao {

	void createMedicneOrder(int employeeId, int discountPercent, int type, float discountAmount, String description,
			String warehouseDeitalJson) throws Exception;
	
	int checkQuantityMedicine(int medicineId, int quatity) throws Exception;
}

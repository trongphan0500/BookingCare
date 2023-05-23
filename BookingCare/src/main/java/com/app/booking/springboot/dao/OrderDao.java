package com.app.booking.springboot.dao;

import java.util.List;

import com.app.booking.springboot.entity.Order;

public interface OrderDao {

	void createMedicneOrder(int employeeId, int discountPercent, int type, float discountAmount, String description,
			String warehouseDeitalJson) throws Exception;

	int checkQuantityMedicine(int medicineId, int quatity) throws Exception;

	public Order saveOrderMedicine(Order order);

	public List<Order> getOrderByHistoryId(int id);
}

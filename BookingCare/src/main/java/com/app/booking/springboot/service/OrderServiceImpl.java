package com.app.booking.springboot.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.OrderDao;
import com.app.booking.springboot.dao.WarehouseSessionDao;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private WarehouseSessionDao warehouseDao;

	@Override
	public void createMedicneOrder(int employeeId, int discountPercent, int type, float discountAmount,
			String description, String warehouseDeitalJson) throws Exception {
		orderDao.createMedicneOrder(employeeId, discountPercent, type, discountAmount, description,
				warehouseDeitalJson);
		warehouseDao.createWarehouseSession(employeeId, discountPercent, type, discountAmount,
				Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), description, warehouseDeitalJson);
	}
	
	@Override
	public int checkQuantityMedicine(int medicineId, int quatity) throws Exception {
		return orderDao.checkQuantityMedicine(medicineId, quatity);
	}

}

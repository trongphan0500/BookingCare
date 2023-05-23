package com.example.doctorcareserver.service;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.doctorcareserver.dao.OrderDao;
import com.example.doctorcareserver.dao.WarehouseSessionDao;



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

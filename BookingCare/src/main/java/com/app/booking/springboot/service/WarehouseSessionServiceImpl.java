package com.app.booking.springboot.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.WarehouseDao;

@Service("warehouseSessionService")
@Transactional
public class WarehouseSessionServiceImpl implements WarehouseSessionService {

	@Autowired
	private WarehouseDao warehouseDao;

	@Override
	public void createWarehouseSession(int employeeId, int discountPercent, int type, float discountAmount,
			String description, String warehouseDeitalJson) throws Exception {
		warehouseDao.createWarehouseSession(employeeId, discountPercent, type, discountAmount, description,
				warehouseDeitalJson);
	}

}

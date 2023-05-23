package com.example.doctorcareserver.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.doctorcareserver.dao.WarehouseSessionDao;


@Service("warehouseSessionService")
@Transactional
public class WarehouseSessionServiceImpl implements WarehouseSessionService {

	@Autowired
	private WarehouseSessionDao warehouseDao;

	@Override
	public void createWarehouseSession(int employeeId, int discountPercent, int type, float discountAmount,
			Date manufactureDate, Date expiryDate, String description, String warehouseDeitalJson) throws Exception {
		warehouseDao.createWarehouseSession(employeeId, discountPercent, type, discountAmount, manufactureDate,
				expiryDate, description, warehouseDeitalJson);
	}

}

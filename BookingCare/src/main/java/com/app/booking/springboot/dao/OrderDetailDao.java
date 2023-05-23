package com.app.booking.springboot.dao;

import java.util.List;

import com.app.booking.springboot.entity.OrderMediceneDetail;

public interface OrderDetailDao {
	OrderMediceneDetail saveOrderMedicine(OrderMediceneDetail orderMediceneDetail);
	public List<OrderMediceneDetail> getorderDetailsbyorId(int id);
}

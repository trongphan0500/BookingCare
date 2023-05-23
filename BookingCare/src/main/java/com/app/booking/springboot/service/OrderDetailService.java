package com.app.booking.springboot.service;

import java.util.List;

import com.app.booking.springboot.entity.OrderMediceneDetail;

public interface OrderDetailService {
	public OrderMediceneDetail saveOrderMediceneDetail(OrderMediceneDetail detail);
	public List<OrderMediceneDetail> getorderDetailsbyorId(int id);
}

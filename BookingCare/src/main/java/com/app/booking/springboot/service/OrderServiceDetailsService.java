package com.app.booking.springboot.service;

import java.util.List;

import com.app.booking.springboot.entity.OrderMediceneDetail;
import com.app.booking.springboot.entity.OrderServiceDetail;

public interface OrderServiceDetailsService {
	public OrderServiceDetail saveOrderServiceDetail(OrderServiceDetail detail);
	public OrderServiceDetail getbyId(int id);
	OrderServiceDetail getbyorderId(int id);
}

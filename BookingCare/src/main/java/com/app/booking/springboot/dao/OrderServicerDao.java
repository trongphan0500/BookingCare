package com.app.booking.springboot.dao;

import com.app.booking.springboot.entity.OrderServiceDetail;

public interface OrderServicerDao {
	OrderServiceDetail saveOrderServiceDetail(OrderServiceDetail detail);
	OrderServiceDetail getbyId(int id);
	OrderServiceDetail getbyorderId(int id);
}

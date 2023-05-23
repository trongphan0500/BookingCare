package com.app.booking.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.OrderServicerDao;
import com.app.booking.springboot.entity.OrderMediceneDetail;
import com.app.booking.springboot.entity.OrderServiceDetail;

@Service("orderServiceDetailsService")
@Transactional
public class OrderServiceDetailsServiceImpl implements OrderServiceDetailsService {
	
	@Autowired
	OrderServicerDao dao;
	@Override
	public OrderServiceDetail saveOrderServiceDetail(OrderServiceDetail detail) {
		// TODO Auto-generated method stub
		return dao.saveOrderServiceDetail(detail);
		
	}
	@Override
	public OrderServiceDetail getbyId(int id) {
		// TODO Auto-generated method stub
		return dao.getbyId(id);
	}
	@Override
	public OrderServiceDetail getbyorderId(int id) {
		// TODO Auto-generated method stub
		return dao.getbyorderId(id);
	}
	

}

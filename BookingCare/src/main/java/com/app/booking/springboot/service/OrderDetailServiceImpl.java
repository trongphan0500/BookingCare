package com.app.booking.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.OrderDetailDao;
import com.app.booking.springboot.entity.OrderMediceneDetail;

@Service("OrderDetailService")
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	OrderDetailDao dao;
	@Override
	public OrderMediceneDetail saveOrderMediceneDetail(OrderMediceneDetail detail) {
		// TODO Auto-generated method stub
		return dao.saveOrderMedicine(detail);
	}
	@Override
	public List<OrderMediceneDetail> getorderDetailsbyorId(int id) {
		// TODO Auto-generated method stub
		return dao.getorderDetailsbyorId(id);
	}

}

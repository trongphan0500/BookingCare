package com.app.booking.springboot.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.OrderServicerDao;
import com.app.booking.springboot.entity.OrderServiceDetail;

@Repository("OrderServicerDao")
@Transactional
@SuppressWarnings("unchecked")
public class OrderServicerDaoImpl extends AbstractDao< Integer, OrderServiceDetail> implements OrderServicerDao {

	@Override
	public OrderServiceDetail saveOrderServiceDetail(OrderServiceDetail detail) {
		// TODO Auto-generated method stub
		return (OrderServiceDetail) this.getSession().merge(detail);
	}

	@Override
	public OrderServiceDetail getbyId(int id) {
		// TODO Auto-generated method stub
		return this.getSession().find(OrderServiceDetail.class, id);
	}

	@Override
	public OrderServiceDetail getbyorderId(int id) {
		// TODO Auto-generated method stub
		List<OrderServiceDetail> list = this.getSession().createQuery("SELECT P FROM OrderServiceDetail P WHERE P.order = "+id).list();
		if(list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}

}

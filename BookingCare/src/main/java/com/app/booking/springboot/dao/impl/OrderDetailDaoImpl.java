package com.app.booking.springboot.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.OrderDao;
import com.app.booking.springboot.dao.OrderDetailDao;
import com.app.booking.springboot.entity.OrderMediceneDetail;

@Repository("OrderDetailDao")
@Transactional
@SuppressWarnings("unchecked")
public class OrderDetailDaoImpl extends AbstractDao<Integer, OrderMediceneDetail> implements OrderDetailDao {

	@Override
	public OrderMediceneDetail saveOrderMedicine(OrderMediceneDetail orderMediceneDetail) {
		// TODO Auto-generated method stub
		return (OrderMediceneDetail) this.getSession().merge(orderMediceneDetail);
	}
	
	@Override
	public List<OrderMediceneDetail> getorderDetailsbyorId(int id) {
		// TODO Auto-generated method stub
		
		return this.getSession().createQuery("SELECT P FROM OrderMediceneDetail P WHERE P.order =  " +id).list();
	}

}

package com.app.booking.springboot.dao.impl;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.OrderDao;
import com.app.booking.springboot.entity.Order;
import com.app.bookingcare.enums.StoreProcedureStatusCodeEnum;
import com.app.bookingcare.exceptions.TechresHttpException;

@Repository("orderDao")
@Transactional
@SuppressWarnings("unchecked")
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao {

	@Override
	public void createMedicneOrder(int employeeId, int discountPercent, int type, float discountAmount,
			String description, String warehouseDeitalJson) throws Exception {

		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_create_medecine_order")
				.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountPercent", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("type", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountAmount", float.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("warehouseDeitalJson", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("employeeId", employeeId);
		query.setParameter("discountPercent", discountPercent);
		query.setParameter("type", type);
		query.setParameter("discountAmount", discountAmount);
		query.setParameter("_description", description);
		query.setParameter("warehouseDeitalJson", warehouseDeitalJson);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return;
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public int checkQuantityMedicine(int medicineId, int quatity) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_check_medicine_quantity")
				.registerStoredProcedureParameter("medicineId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("quatity", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("result", Integer.class, ParameterMode.OUT);

		query.setParameter("medicineId", medicineId);
		query.setParameter("quatity", quatity);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		int result = (int) query.getOutputParameterValue("result");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return result;
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public Order saveOrderMedicine(Order order) {
		// TODO Auto-generated method stub
		return (Order) this.getSession().merge(order);
	}

	@Override
	public List<Order> getOrderByHistoryId(int id) {
		// TODO Auto-generated method stub
		List<Order> list = this.getSession().createQuery("FROM Order O WHERE examninationHistory = "+id).list();
		return list;
	}

}

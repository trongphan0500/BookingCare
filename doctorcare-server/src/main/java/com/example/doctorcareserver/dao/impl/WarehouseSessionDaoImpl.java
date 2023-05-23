package com.example.doctorcareserver.dao.impl;

import java.util.Date;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.app.bookingcare.enums.StoreProcedureStatusCodeEnum;
import com.app.bookingcare.exceptions.TechresHttpException;
import com.example.doctorcareserver.dao.AbstractDao;
import com.example.doctorcareserver.dao.WarehouseSessionDao;
import com.example.doctorcareserver.entity.WarehouseSession;

@Repository("warehouseSessionDao")
@Transactional
@SuppressWarnings("unchecked")
public class WarehouseSessionDaoImpl extends AbstractDao<Integer, WarehouseSession> implements WarehouseSessionDao {

	@Override
	public void createWarehouseSession(int employeeId, int discountPercent, int type, float discountAmount,
			Date manufactureDate, Date expiryDate, String description, String warehouseDeitalJson) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_create_warehouse_session")
				.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountPercent", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("type", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountAmount", float.class, ParameterMode.IN)
				.registerStoredProcedureParameter("manufactureDate", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("expiryDate", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("warehouseDeitalJson", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("employeeId", employeeId);
		query.setParameter("discountPercent", discountPercent);
		query.setParameter("type", type);
		query.setParameter("discountAmount", discountAmount);
		query.setParameter("manufactureDate", manufactureDate);
		query.setParameter("expiryDate", expiryDate);
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

}

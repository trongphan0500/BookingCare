package com.app.booking.springboot.dao.impl;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.EmployeeDao;
import com.app.booking.springboot.entity.Employee;
import com.app.booking.springboot.entity.model.storeProcedure.EmployeeModal;
import com.app.bookingcare.enums.StoreProcedureStatusCodeEnum;
import com.app.bookingcare.exceptions.TechresHttpException;

@Repository("employeeDao")
@Transactional
@SuppressWarnings("unchecked")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	@Override
	public List<EmployeeModal> getEmployees(int employeeId, String keySearch, int isLogin, int isActive)
			throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_employees", EmployeeModal.class)
				.registerStoredProcedureParameter("employeeId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("keySearch", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("isLogin", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("isActive", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("employeeId", employeeId);
		query.setParameter("keySearch", keySearch);
		query.setParameter("isLogin", isLogin);
		query.setParameter("isActive", isActive);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return query.getResultList();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

}

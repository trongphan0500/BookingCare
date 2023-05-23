package com.example.doctorcareserver.dao.impl;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.app.bookingcare.enums.StoreProcedureStatusCodeEnum;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
import com.app.bookingcare.exceptions.TechresHttpException;
import com.example.doctorcareserver.dao.AbstractDao;
import com.example.doctorcareserver.dao.SpecializationDao;
import com.example.doctorcareserver.entity.Specialization;
@Repository("specializationDao")
@Transactional
@SuppressWarnings("unchecked")
public class SpecializationDaoImpl extends AbstractDao<Integer, Specialization> implements SpecializationDao {

	@Override
	public StoreProcedureListResult<Specialization> getSpecialization(int id, String keySearch, Pagination pagination)
			throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_specializations", Specialization.class)
				.registerStoredProcedureParameter("specializationId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("keySearch", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("limit", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("offset", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("total_record", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("specializationId", id);
		query.setParameter("keySearch", keySearch);
		query.setParameter("limit", pagination.getLimit());
		query.setParameter("offset", pagination.getOffset());

		int totalRecord = (int) query.getOutputParameterValue("total_record");
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<>(statusCode, messageError, totalRecord, query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

}

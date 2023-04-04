//package com.app.booking.spirngboot.dao.impl;
//
//import java.util.List;
//
//import javax.persistence.ParameterMode;
//import javax.persistence.StoredProcedureQuery;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Repository;
//
//import com.app.booking.spirngboot.dao.AbstractDao;
//import com.app.booking.spirngboot.dao.UserDao;
//import com.app.booking.spirngboot.entity.User;
//import com.app.bookingcare.enums.StoreProcedureStatusCodeEnum;
//import com.app.bookingcare.exceptions.TechresHttpException;
//
//@Repository
//@SuppressWarnings("unchecked")
//public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
//
//	@Override
//	public List<User> getAll() throws Exception {
//		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_employees", User.class)
//
//				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
//				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
//
//		int statusCode = (int) query.getOutputParameterValue("status_code");
//		String messageError = query.getOutputParameterValue("message_error").toString();
//
//		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
//		case SUCCESS:
//			return query.getResultList();
//		case INPUT_INVALID:
//			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
//		default:
//			throw new Exception(messageError);
//		}
//	}
//}

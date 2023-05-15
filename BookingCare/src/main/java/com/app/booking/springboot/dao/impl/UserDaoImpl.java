package com.app.booking.springboot.dao.impl;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.app.booking.springboot.dao.UserDao;
import com.app.booking.springboot.entity.Doctor;
import com.app.booking.springboot.entity.Employee;
import com.app.booking.springboot.entity.Patient;
import com.app.booking.springboot.entity.Role;
import com.app.booking.springboot.entity.User;
import com.app.booking.springboot.entity.model.storeProcedure.UserModal;
import com.app.bookingcare.enums.StoreProcedureStatusCodeEnum;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
import com.app.bookingcare.exceptions.TechresHttpException;

@Repository("userDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User findOne(int id) throws Exception {
//		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_user", User.class)
//				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
//
//				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
//				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
//
//		query.setParameter("userId", id);
//
//		int statusCode = (int) query.getOutputParameterValue("status_code");
//		String messageError = query.getOutputParameterValue("message_error").toString();
//
//		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
//		case SUCCESS:
//			return (User) query.getResultList().stream().findFirst().orElse(null);
//		case INPUT_INVALID:
//			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
//		default:
//			throw new Exception(messageError);
//		}
		User user = this.getSession().get(User.class, id);
		return user;
	}

	public void update(User entity) {
		getSession().update(entity);
	}

	@Override
	public List<Role> getAllRole(String pre) throws Exception {
		String hql = "FROM Role r WHERE r.keyMap LIKE :prefix";
		Query<Role> query = this.getSession().createQuery(hql, Role.class);
		query.setParameter("prefix", pre + "%");
		return query.getResultList();
	}

	@Override
	public void createDoctor(Doctor doctor) throws Exception {
		this.getSession().save(doctor);
	}

	@Override
	public void createPatient(Patient patient) throws Exception {
		this.getSession().save(patient);

	}

	@Override
	public void createEmployee(Employee employee) throws Exception {
		this.getSession().save(employee);
	}

	@Override
	public Role getRole(int id) throws Exception {
		Role role = this.getSession().get(Role.class, id);
		return role;
	}

	@Override
	public StoreProcedureListResult<UserModal> getUsers(int userId, String keySearch, int sortBy, int isActive,
			int userDefine, Pagination pagination) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_user", UserModal.class)
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("keySearch", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sortBy", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("isActive", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("userDefine", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("limit", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("offset", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("total_record", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", userId);
		query.setParameter("keySearch", keySearch);
		query.setParameter("sortBy", sortBy);
		query.setParameter("isActive", isActive);
		query.setParameter("userDefine", userDefine);
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

	@Override
	public void updateDoctor(Doctor doctor) throws Exception {
		this.getSession().update(doctor);
	}

	@Override
	public void updatePatient(Patient patient) throws Exception {
		this.getSession().update(patient);
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		this.getSession().update(employee);
	}

	@Override
	public void deleteDoctor(Doctor doctor) throws Exception {
		this.getSession().remove(doctor);
	}

	@Override
	public void deletePatient(Patient patient) throws Exception {
		this.getSession().remove(patient);
	}

	@Override
	public void deleteEmployee(Employee employee) throws Exception {
		this.getSession().remove(employee);
	}

	@Override
	public Doctor findDoctor(int id) throws Exception {
		return this.getSession().get(Doctor.class, id);
	}

	@Override
	public Patient findPatient(int id) throws Exception {
		return this.getSession().get(Patient.class, id);
	}

	@Override
	public Employee findEmployee(int id) throws Exception {
		return this.getSession().get(Employee.class, id);
	}


}

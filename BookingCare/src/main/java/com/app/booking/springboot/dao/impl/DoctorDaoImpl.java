package com.app.booking.springboot.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.EmployeeDao;
import com.app.booking.springboot.entity.Employee;
import com.app.booking.springboot.entity.model.storeProcedure.EmployeeModal;

@Repository("doctorDao")
@Transactional
@SuppressWarnings("unchecked")
public class DoctorDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	@Override
	public List<EmployeeModal> getEmployees(int employeeId, String keySearch, int isLogin, int isActive)
			throws Exception {
		return null;
	}

}

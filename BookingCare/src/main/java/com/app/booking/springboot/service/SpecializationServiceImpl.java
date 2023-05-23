package com.app.booking.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.SpecializationDao;
import com.app.booking.springboot.entity.Specialization;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

@Service("specializationService")
@Transactional
public class SpecializationServiceImpl implements SpecializtionService {

	@Autowired
	private SpecializationDao dao;
	
	@Override
	public StoreProcedureListResult<Specialization> getSpecialization(int id, String keySearch, Pagination pagination)
			throws Exception {
		return dao.getSpecialization(id, keySearch, pagination);
	}

}

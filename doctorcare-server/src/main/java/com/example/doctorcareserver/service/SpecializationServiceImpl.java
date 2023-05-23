package com.example.doctorcareserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
import com.example.doctorcareserver.dao.SpecializationDao;
import com.example.doctorcareserver.entity.Specialization;


@Service("specializationService")
@Transactional
public class SpecializationServiceImpl implements SpecializtionService {

	@Autowired
	private SpecializationDao dao;

	@Override
	public StoreProcedureListResult<Specialization> getSpecialization(int id,
			String keySearch, Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return dao.getSpecialization(id, keySearch, pagination);
	}
	
	

}

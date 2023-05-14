package com.example.doctorcareserver.service;


import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
import com.example.doctorcareserver.entity.Specialization;

public interface SpecializtionService {

	StoreProcedureListResult<Specialization> getSpecialization(int id, String keySearch, Pagination pagination)
			throws Exception;
}

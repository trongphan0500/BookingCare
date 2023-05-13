package com.app.booking.springboot.service;

import com.app.booking.springboot.entity.Specialization;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

public interface SpecializtionService {

	StoreProcedureListResult<Specialization> getSpecialization(int id, String keySearch, Pagination pagination)
			throws Exception;
}

package com.app.booking.springboot.dao;

import com.app.booking.springboot.entity.Specialization;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

public interface SpecializationDao {

	StoreProcedureListResult<Specialization> getSpecialization(int id, String keySearch, Pagination pagination)
			throws Exception;
}

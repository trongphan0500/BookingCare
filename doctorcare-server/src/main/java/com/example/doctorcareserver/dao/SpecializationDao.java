package com.example.doctorcareserver.dao;


import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
import com.example.doctorcareserver.entity.Specialization;

public interface SpecializationDao {

	StoreProcedureListResult<Specialization> getSpecialization(int id, String keySearch, Pagination pagination)
			throws Exception;
}

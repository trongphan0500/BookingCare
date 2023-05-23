package com.app.booking.springboot.service;

import java.util.List;

import com.app.booking.springboot.entity.Patient;

public interface DoctorService {

	List<Patient> getHistoryExamination(int patentId, String keySearch) throws Exception;
}

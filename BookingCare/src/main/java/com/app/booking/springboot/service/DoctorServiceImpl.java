package com.app.booking.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.entity.Patient;

@Service("doctorService")
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Override
	public List<Patient> getHistoryExamination(int patentId, String keySearch) throws Exception {
		return null;
	}

}

package com.example.doctorcareserver.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.doctorcareserver.entity.Patient;



@Service("doctorService")
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Override
	public List<Patient> getHistoryExamination(int patentId, String keySearch) throws Exception {
		return null;
	}

}

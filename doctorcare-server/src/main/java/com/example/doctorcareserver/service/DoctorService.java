package com.example.doctorcareserver.service;

import java.util.List;

import com.example.doctorcareserver.entity.Patient;



public interface DoctorService {

	List<Patient> getHistoryExamination(int patentId, String keySearch) throws Exception;
}

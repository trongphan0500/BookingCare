package com.app.booking.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.entity.ExamninationHistory;
import com.app.booking.springboot.entity.Patient;
import com.app.booking.springboot.entity.Registration;
import com.app.booking.springboot.service.ExaminitionHistoryService;
import com.app.booking.springboot.service.PatientSerivce;
import com.app.booking.springboot.service.RegistrationService;
import com.app.booking.springboot.service.UserService;
import com.app.booking.springboot.entity.Role;
import com.app.booking.springboot.entity.User;
import com.app.booking.springboot.*;
import com.app.booking.springboot.dao.UserDao;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController()
@RequestMapping("api/supports")
@CrossOrigin
public class SupportController {
	@Autowired
	PatientSerivce patientSerivce;
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	UserService service;
	
	@Autowired
	ExaminitionHistoryService examinitionHistoryService;
	@GetMapping("/test")
	public void test() throws Exception {
//       userDao.savePatient();
	}

	@PostMapping("/sendPaitent")
	public Patient sendPaitent(@RequestBody Patient pt) throws Exception {
		int stt = registrationService.getSTTDate() + 1;
		MyQSender sender = new MyQSender();
		System.out.println(pt.getVerifyCode());
		pt.setCreatedAt(new Date());

		Date date = new Date();
		Patient ptTim = (Patient) service.findPatient(pt.getPhone());
		
		if(ptTim == null)
		{
			
			Patient patient = patientSerivce.savePatient(pt);
			sender.sendMessage(patient);
			Registration registration = new Registration(null, 0, 0, date, patient, stt);
			registrationService.saveRegistration(registration);
		
			return patient;
		}
		else
		{
			ptTim.setExamninationHistories(null);
			sender.sendMessage(ptTim);	
			Registration registration = new Registration(null, 0, 0, date, ptTim, stt);
			registrationService.saveRegistration(registration);
			return ptTim;
		}
		

	}

	@GetMapping("/getPatientByName")
	public List<Patient> getPatientByName(@RequestParam String name) throws Exception {
		List<Patient> list = service.findPatientByName(name);
		List<Patient> ptTam = new ArrayList<>();
		for (Patient patient : list) {
			Patient pt = new Patient();
			pt.setId(patient.getId());
			pt.setName(patient.getName());
			pt.setAddress(patient.getAddress());
			pt.setWeight(patient.getWeight());
			pt.setHeight(patient.getHeight());
			pt.setPhone(patient.getPhone());
			ptTam.add(pt);
		}
		return ptTam;
	}
	@GetMapping("/getSTT")
	public int getSTT() throws Exception {
		int stt = registrationService.getSTTDate() + 1;
		return stt;
	}
	@GetMapping("/getExById")
	public List<ExamninationHistory> getExById(@RequestParam int id) throws Exception {
		List<ExamninationHistory> ex= examinitionHistoryService.getAllex(id);
		List<ExamninationHistory> exTam = new ArrayList<>();
		for (ExamninationHistory examninationHistory : ex) {
			ExamninationHistory e= new ExamninationHistory();
			e.setId(examninationHistory.getId());
			e.setCreatedAt(examninationHistory.getCreatedAt());
			e.setDoctor(examninationHistory.getDoctor());
			Patient pt = new Patient();
			pt.setId(examninationHistory.getPatient().getId());
			pt.setName(examninationHistory.getPatient().getName());
			pt.setAddress(examninationHistory.getPatient().getAddress());
			pt.setWeight(examninationHistory.getPatient().getWeight());
			pt.setHeight(examninationHistory.getPatient().getHeight());
			pt.setPhone(examninationHistory.getPatient().getPhone());
			e.setPatient(pt);
			exTam.add(e);
		}
		return exTam;
	}
	@GetMapping("/getRegistration")
	public List<Registration> getRegistration() throws Exception {
		List<Registration> list = registrationService.getRegistration();
		List<Registration> list1 = new ArrayList<>();
		for (Registration registration : list) {
			Registration re = new Registration();
			re.setId(registration.getId());
			re.setStatus(registration.getStatus());
			re.setStt(registration.getStt());
			Patient patient = registration.getPatient();
			Patient pt = new Patient();
			pt.setId(patient.getId());
			pt.setName(patient.getName());
			pt.setAddress(patient.getAddress());
			pt.setWeight(patient.getWeight());
			pt.setHeight(patient.getHeight());
			pt.setPhone(patient.getPhone());
			re.setPatient(pt);
			list1.add(re);
		}
	
		return list1;
	}
	

	@PostMapping("/sendPaitentSA")
	public Patient sendPaitentSA(@RequestBody Patient pt) throws Exception {
		int stt = registrationService.getSTTDate() + 1;
		SenderSA sender = new SenderSA();

		pt.setCreatedAt(new Date());

		Date date = new Date();
		Patient ptTim = (Patient) service.findPatient(pt.getPhone());
		
		if(ptTim == null)
		{
			Patient patient = patientSerivce.savePatient(pt);
			sender.sendMessage(patient);
			Registration registration = new Registration(null, 0, 0, date, patient, stt);
			registrationService.saveRegistration(registration);
		
			return patient;
		}
		else
		{
			ptTim.setExamninationHistories(null);
			sender.sendMessage(ptTim);	
			Registration registration = new Registration(null, 0, 0, date, ptTim, stt);
			registrationService.saveRegistration(registration);
			return ptTim;
		}
	}
}

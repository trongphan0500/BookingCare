package com.example.doctorcareserver.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctorcareserver.MyReceiver;
import com.example.doctorcareserver.ReceiverSA;
import com.example.doctorcareserver.dao.ExaminitionHistoryDao;
import com.example.doctorcareserver.dao.MedicineDao;
import com.example.doctorcareserver.dao.UserDao;
import com.example.doctorcareserver.entity.Doctor;
import com.example.doctorcareserver.entity.ExamRoom;
import com.example.doctorcareserver.entity.ExamninationHistory;
import com.example.doctorcareserver.entity.Medicine;
import com.example.doctorcareserver.entity.Patient;

@RestController
@CrossOrigin
public class DoctorController {
	@Autowired
	MedicineDao medicineDao ;
	@Autowired
	ExaminitionHistoryDao examinitionHistoryDao;
	@Autowired
	UserDao userDao;
	MyReceiver buong1;
	MyReceiver buong2;
	ReceiverSA buong1SA;
	ArrayList<Patient> dsbn = new ArrayList<>();
	@PostMapping("/openBuong1")
	public void openBuong1() throws NamingException, JMSException
	{
		buong1= new MyReceiver();
	}
	@PostMapping("/openBuong")
	public int openBuong() throws NamingException, JMSException
	{
		if(buong1==null)
		{
			System.out.println("mo buong 1");
			buong1= new MyReceiver();
			return 1;
		}
		else if(buong2==null)
		{
			System.out.println("mo buong 2");
			buong2= new MyReceiver();
			return 2;
		}
		else {
			System.out.println("full buong");
			return 3;
		}
		
	}
	@PostMapping("/openbuong1SA")
	public void buong1SA() throws NamingException, JMSException
	{
		buong1SA= new ReceiverSA();
	}
	
	
	@GetMapping("/getBuong1")
	public ArrayList<Patient>getAllBNBuong1()
	{
		return buong1.getAllBN();
	}
	@GetMapping("/getBuong1SA")
	public ArrayList<Patient>getBuong1SA()
	{
		return buong1SA.getAllBN();
	}
	@GetMapping("/getBNBuong1")
	public Patient getBNBuong1(@RequestParam int index)
	{
		System.out.println("idex: "+ index);
		return buong1.getBN(index);
	}
	@GetMapping("/getBNBuong1SA")
	public Patient getBNBuong1SA(@RequestParam int index)
	{
		System.out.println("idex: "+ index);
		return buong1SA.getBN(index);
	}
	@PostMapping("/openBuong2")
	public void openBuong2() throws NamingException, JMSException
	{
		buong2= new MyReceiver();
	}
	@GetMapping("/getBuong2")
	public ArrayList<Patient>getAllBNBuong2()
	{
		return buong2.getAllBN();
	}
	@PostMapping("/saveLich")
	public String saveLich(String lich)
	{
		return "ok";
	}
	@GetMapping("/getMedia")
	public List<Medicine> getMedia(@RequestParam String name)
	{
		List<Medicine> ds = medicineDao.getMediasfrom(name);
		System.out.println(ds);
		List<Medicine> dsTam = new ArrayList<>();
		for (Medicine medicine : ds) {
			Medicine test = new Medicine();
			test.setId(medicine.getId());
			test.setName(medicine.getName());
			test.setCostPrice(medicine.getCostPrice());
			
			dsTam.add(test);
		}
		
		return dsTam;
	}
	@PostMapping("/saveEx")
	public ExamninationHistory saveEx(@RequestBody Patient pt)
	{
		Doctor doc = userDao.getDoctorById(0);
//		Patient patient = userDao.getPatientById(0);
//		ExamRoom examRoom = new ExamRoom();
//		examRoom.setId(1);
//		examRoom.setCode("1");
//		examRoom.setDesciption("1");
//		examRoom.setMaxPatient(15);
//		examRoom.setName("Buong1");
		ExamninationHistory ex = new ExamninationHistory();
		ex.setDoctor(doc);
//		ex.setExamRoom(examRoom);
		ex.setPatient(pt);
		System.out.println(pt.getId());
		ex.setCreatedAt(new Date());
		examinitionHistoryDao.addExamninationHistory(ex);
	
		return null;
	}

}

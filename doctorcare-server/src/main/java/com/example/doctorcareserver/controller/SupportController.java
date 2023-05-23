package com.example.doctorcareserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctorcareserver.MyQSender;
import com.example.doctorcareserver.SenderSA;
import com.example.doctorcareserver.dao.PaitentDao;
import com.example.doctorcareserver.dao.UserDao;
import com.example.doctorcareserver.entity.Patient;
import com.example.doctorcareserver.entity.Role;
import com.example.doctorcareserver.entity.User;

@RestController()
@CrossOrigin
public class SupportController  {
	@Autowired
	UserDao userDao ;
	
    @GetMapping("/test")
    public void test() throws Exception
    {
//       userDao.savePatient();
    }
    @PostMapping("/sendPaitent")
    public Patient sendPaitent(@RequestBody Patient pt) throws Exception
    {
    	MyQSender sender = new MyQSender();
    	Role role = new Role(1,"","","Paitent");
    	sender.sendMessage(pt);
    	Patient patient = userDao.savePatient(pt);
    	System.out.println("id : "+patient.getId());
    
//    	System.out.println(pt);
    	return patient;
    }
    @PostMapping("/sendPaitentSA")
    public Patient sendPaitentSA(@RequestBody Patient pt) throws Exception
    {
    	SenderSA sender = new SenderSA();
    	Role role = new Role(1,"","","Paitent");
    	sender.sendMessage(pt);
    	Patient patient = userDao.savePatient(pt);
    	return patient;
    }
}

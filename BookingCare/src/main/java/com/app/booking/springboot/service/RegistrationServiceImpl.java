package com.app.booking.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.RegistrationDao;
import com.app.booking.springboot.entity.Registration;

@Service("registrationService")
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	RegistrationDao registrationDao;
	@Override
	public Registration saveRegistration(Registration registration) throws Exception {
		// TODO Auto-generated method stub
		return registrationDao.saveRegistration(registration);
	}
	@Override
	public int getSTTDate() throws Exception {
		// TODO Auto-generated method stub
		return registrationDao.getSTTDate();
	}
	@Override
	public List<Registration> getRegistration() {
		// TODO Auto-generated method stub
		return registrationDao.getRegistration();
	}
	

}

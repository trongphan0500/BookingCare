package com.app.booking.springboot.dao;

import java.util.List;

import com.app.booking.springboot.entity.Registration;

public interface RegistrationDao {
	public Registration saveRegistration(Registration registration) throws Exception;
	public int getSTTDate();
	public List<Registration> getRegistration();
}

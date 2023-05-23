package com.app.booking.springboot.service;

import java.util.List;

import com.app.booking.springboot.entity.Registration;

public interface RegistrationService {
	public Registration saveRegistration(Registration registration) throws Exception;
	public int getSTTDate () throws Exception;
	public List<Registration> getRegistration();
}

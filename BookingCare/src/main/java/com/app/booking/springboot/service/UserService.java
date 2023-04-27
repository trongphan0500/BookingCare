package com.app.booking.springboot.service;

import java.util.List;

import com.app.booking.springboot.entity.User;


public interface UserService {
	
	User findOne(int id) throws Exception;
}

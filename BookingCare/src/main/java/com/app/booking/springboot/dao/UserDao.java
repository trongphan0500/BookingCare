package com.app.booking.springboot.dao;

import com.app.booking.springboot.entity.User;

public interface UserDao {
	
	User findOne(int id) throws Exception;
	
	void update(User entity);
}

package com.app.booking.springboot.service;

import com.app.booking.springboot.entity.User;

public interface UserService {

	User findOne(int id) throws Exception;

	void update(User entity);
}

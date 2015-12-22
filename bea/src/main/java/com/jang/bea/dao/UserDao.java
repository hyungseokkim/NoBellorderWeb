package com.jang.bea.dao;

import java.util.List;

import com.jang.bea.model.User;

public interface UserDao {

	
	List<User> getAll();
	
	User getUser(int user_number);
	void insertUser(int user_number, String user_phone);
	
	
	
}

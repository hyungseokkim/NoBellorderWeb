package com.jang.bea.dao;

import java.util.List;

import com.jang.bea.model.Identify;
import com.jang.bea.model.Manager;
import com.jang.bea.model.Order;

public interface ManagerDao {

	
	List<Manager> getAll();
	
	Manager getManager(String m_id, String m_password);
	void insertManager(Manager manager);
	
	void update(Order order);
	
}

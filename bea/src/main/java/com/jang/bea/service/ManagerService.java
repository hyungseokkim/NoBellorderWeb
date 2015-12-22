package com.jang.bea.service;

import java.util.List;

import com.jang.bea.model.Manager;
import com.jang.bea.model.Order;

public interface ManagerService {
	
	List<Manager> getAll();
	
	Manager getManager(String m_id, String m_password);
	void insertManager(Manager manager);
	
	void update(Order order);
	

}

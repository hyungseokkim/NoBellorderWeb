package com.jang.bea.service;

import java.util.List;

import com.jang.bea.dao.ManagerDao;
import com.jang.bea.model.Identify;
import com.jang.bea.model.Manager;
import com.jang.bea.model.Order;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;

	public void setManagerDao(ManagerDao managerDaoImpl) {
		this.managerDao = managerDaoImpl;
	}
	@Override
	public List<Manager> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager getManager(String m_id, String m_password){
		System.out.println("getmanagerService");
		return this.managerDao.getManager(m_id, m_password);
	}

	@Override
	public void insertManager(Manager manager) {
		// TODO Auto-generated method stub
		this.managerDao.insertManager(manager);
	}
	
	@Override
	public void update(Order order) {
		System.out.println("Manager service Update");
		// TODO Auto-generated method stub
		this.managerDao.update(order);
	}

}

package com.jang.bea.service;

import java.util.List;

import com.jang.bea.dao.IdentifyDao;
import com.jang.bea.dao.MenuDao;
import com.jang.bea.model.Identify;
import com.jang.bea.model.Notice;

public class IdentifyServiceImpl implements IdentifyService {

	private IdentifyDao identifyDao;

	public void setIdentifyDao(IdentifyDao identifyDaoImpl) {
		this.identifyDao = identifyDaoImpl;
	}

	@Override
	public List<Identify> getAll() {
		// TODO Auto-generated method stub
		System.out.println("IdentifyServiceImpl");
		return this.identifyDao.getAll();
	}

	@Override
	public List<Identify> getIdentify(int table_number) {
		// TODO Auto-generated method stub
		System.out.println("IdentifyServiceImpl");
		return this.identifyDao.getIdentify(table_number);
	}
	
	@Override
	public List<Identify> getIdentify2(int table_number) {
		// TODO Auto-generated method stub
		System.out.println("IdentifyServiceImpl22");
		return this.identifyDao.getIdentify2(table_number);
	}
	
	
	@Override
	public void insert(Identify identify){
		// TODO Auto-generated method stub
		this.identifyDao.insert(identify);
	}
	
	@Override
	public void delete(Identify identify){
		// TODO Auto-generated method stub
		this.identifyDao.delete(identify);
	}


	@Override
	public void update(Identify identify) {
		System.out.println("serviceUpdate");
		// TODO Auto-generated method stub
		this.identifyDao.update(identify);
	}
	
	@Override
	public int checkmenu(int menu_number, int table_number) {
		// TODO Auto-generated method stub
		System.out.println("IdentifyService = " + menu_number);
		return this.identifyDao.checkmenu(menu_number, table_number);
	}
	
	@Override
	public Identify findmenu(int menu_number) {
		// TODO Auto-generated method stub
		return this.identifyDao.findmenu(menu_number);
	}


}


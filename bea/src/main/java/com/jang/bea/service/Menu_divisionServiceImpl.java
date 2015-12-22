package com.jang.bea.service;

import java.util.List;

import com.jang.bea.dao.MenuDao;
import com.jang.bea.dao.Menu_divisionDao;
import com.jang.bea.model.Menu_division;

public class Menu_divisionServiceImpl implements Menu_divisionService {

	
	
private Menu_divisionDao  menu_divisionDao;
	
	public void setMenuDao(Menu_divisionDao Menu_divisionDaoImpl) {
	this.menu_divisionDao = Menu_divisionDaoImpl;
}
	
	@Override
	public List<Menu_division> getAll() {
		// TODO Auto-generated method stub
		System.out.println("MenuServiceImpl 컨트롤러");
		return this.menu_divisionDao.getAll();
	}

	@Override
	public Menu_division getMenu_division(int division_code) {
		// TODO Auto-generated method stub
		return this.menu_divisionDao.getMenu_division(division_code);
	}

}

package com.jang.bea.service;


import java.util.List;

import com.jang.bea.dao.MenuDao;
import com.jang.bea.model.Menu;


public class MenuServiceImpl implements MenuService {

	
private MenuDao  menuDao;
	
	public void setMenuDao(MenuDao menuDaoImpl) {
	this.menuDao = menuDaoImpl;
}
	
	
	@Override
	public List<Menu> getAll() {
		// TODO Auto-generated method stub
		System.out.println("MenuServiceImpl");
		return this.menuDao.getAll();
	}

	@Override
	public List<Menu> getMenu(int menu_number) {
		// TODO Auto-generated method stub
		System.out.println("getMenuService" + menu_number);
		return this.menuDao.getMenu(menu_number);

	}
	
	@Override
	public  List<Menu> getMenu_division1() {
		// TODO Auto-generated method stub
		return this.menuDao.getMenu_division1();
	}
	
	@Override
	public List<Menu> getMenu_division2() {
		// TODO Auto-generated method stub
		return this.menuDao.getMenu_division2();
	}
	
	@Override
	public  List<Menu> getMenu_division3() {
		// TODO Auto-generated method stub
		return this.menuDao.getMenu_division3();
	}
	@Override
	public  List<Menu> getMenu_division4() {
		// TODO Auto-generated method stub
		return this.menuDao.getMenu_division4();
	}
	@Override
	public  List<Menu> getMenu_division5() {
		// TODO Auto-generated method stub
		return this.menuDao.getMenu_division5();
	}
	
	@Override
	public  List<Menu> getbenefit() {
		// TODO Auto-generated method stub
		System.out.println("menuService");
		return this.menuDao.getbenefit();
	}


}

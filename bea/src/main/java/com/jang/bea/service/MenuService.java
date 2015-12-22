package com.jang.bea.service;


import java.util.List;

import com.jang.bea.model.Menu;

public interface MenuService {

	List<Menu> getAll();
	
	List<Menu> getMenu (int menu_number);
	

	List<Menu> getMenu_division1();
	
	List<Menu> getMenu_division2();
	
	List<Menu> getMenu_division3();
	
	List<Menu> getMenu_division4();
	
	List<Menu> getMenu_division5();
	
	List<Menu> getbenefit ();
	

}

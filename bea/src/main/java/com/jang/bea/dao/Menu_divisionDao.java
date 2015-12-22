package com.jang.bea.dao;

import java.util.List;

import com.jang.bea.model.Menu_division;

public interface Menu_divisionDao {

	


	List<Menu_division> getAll();
	
	Menu_division getMenu_division (int division_code);
}

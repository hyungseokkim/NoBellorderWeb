package com.jang.bea.service;

import java.util.List;


import com.jang.bea.model.Menu_division;

public interface Menu_divisionService {


	List<Menu_division> getAll();
	
	Menu_division getMenu_division (int division_code);
	
}

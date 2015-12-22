package com.jang.bea.service;

import java.util.List;

import com.jang.bea.model.Identify;
import com.jang.bea.model.Notice;


public interface IdentifyService {
	
	List<Identify> getAll();
	
	List<Identify> getIdentify(int table_number);
	
	List<Identify> getIdentify2(int table_number);

	void insert(Identify identify);
	
	void delete(Identify identify);
	
	void update(Identify identify);
	
	int checkmenu(int menu_number, int table_number);
	

	Identify findmenu(int menu_number);
	
}

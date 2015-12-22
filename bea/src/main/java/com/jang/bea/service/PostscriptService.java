package com.jang.bea.service;

import java.util.List;

import com.jang.bea.model.Postscript;

public interface PostscriptService {

	List<Postscript> getAll(int shop_number);
	
	Postscript getPostscript(int postscript_number);
	
	void UpdatePostscript(Postscript postscript);
	
	void insertPostscript(Postscript postscript); 
	
	void deletePostscript(int postscript_number);
	
}

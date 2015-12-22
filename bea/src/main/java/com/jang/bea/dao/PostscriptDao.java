package com.jang.bea.dao;

import java.util.List;

import com.jang.bea.model.Postscript;

public interface PostscriptDao {

	

	List<Postscript> getAll(int shop_number);
	
	Postscript getPostscript(int postscript_number);
	
	void UpdatePostscript(Postscript postscript);
	
	void insertPostscript(Postscript postscript); 
	
	void deletePostscript(int postscript_number);
	
}

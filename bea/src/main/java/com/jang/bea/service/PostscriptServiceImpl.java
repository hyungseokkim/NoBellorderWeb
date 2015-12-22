package com.jang.bea.service;

import java.util.List;

import com.jang.bea.dao.PostscriptDao;
import com.jang.bea.model.Postscript;

public class PostscriptServiceImpl implements PostscriptService {
	
	private PostscriptDao postscriptDao;

	public void setPostscriptDao(PostscriptDao postscriptDaoImpl) {
		this.postscriptDao = postscriptDaoImpl;
	}
	
	
	@Override
	public List<Postscript> getAll(int shop_number) {
		// TODO Auto-generated method stub
		return this.postscriptDao.getAll(shop_number);
	}

	@Override
	public Postscript getPostscript(int postscript_number) {
		// TODO Auto-generated method stub
		return this.postscriptDao.getPostscript(postscript_number);
	}

	@Override
	public void UpdatePostscript(Postscript postscript) {
		// TODO Auto-generated method stub
		this.postscriptDao.UpdatePostscript(postscript);

	}

	@Override
	public void insertPostscript(Postscript postscript) {
		// TODO Auto-generated method stub
		this.postscriptDao.insertPostscript(postscript);
		System.out.println("postscriptinsertService" + postscript);
	}

	@Override
	public void deletePostscript(int postscript_number) {
		// TODO Auto-generated method stub

	}

}

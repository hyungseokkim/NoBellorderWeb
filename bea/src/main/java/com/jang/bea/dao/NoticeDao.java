package com.jang.bea.dao;

import java.util.List;

import com.jang.bea.model.Notice;


public interface NoticeDao {

	List<Notice> getAll(int shop_number);
	List<Notice> getSpecial(int shop_number);
	
	
	Notice getNotice(int notice_number);
	
	void update(Notice notice);
	void insert(Notice notice);
	void delete(Notice notice);
	
}

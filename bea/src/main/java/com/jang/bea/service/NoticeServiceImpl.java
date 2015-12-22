package com.jang.bea.service;

import java.util.List;

import com.jang.bea.dao.NoticeDao;
import com.jang.bea.model.Notice;


public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDao noticeDao;

	public void setNoticeDao(NoticeDao noticeDaoImpl) {
		this.noticeDao = noticeDaoImpl;
	}

	@Override
	public List<Notice> getAll(int shop_number) {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl" + "getAll()");
		return this.noticeDao.getAll(shop_number);
	}
	
	@Override
	public List<Notice> getSpecial(int shop_number) {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl2" + "getAll()");
		return this.noticeDao.getSpecial(shop_number);
	}

	@Override
	public Notice getNotice(int notice_number) {
		// TODO Auto-generated method stub
		return this.noticeDao.getNotice(notice_number);
	}

	@Override
	public void insert(Notice notice){
		// TODO Auto-generated method stub
		this.noticeDao.insert(notice);
	}

	@Override
	public void update(Notice notice) {
		System.out.println("serviceUpdate");
		// TODO Auto-generated method stub
		this.noticeDao.update(notice);
	}

	@Override
	public void delete(Notice notice) {
		// TODO Auto-generated method stub
		this.noticeDao.delete(notice);
	}

}

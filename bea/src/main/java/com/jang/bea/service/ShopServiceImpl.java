package com.jang.bea.service;

import java.util.List;

import com.jang.bea.dao.NoticeDao;
import com.jang.bea.dao.ShopDao;
import com.jang.bea.model.Postscript;
import com.jang.bea.model.Shop;

public class ShopServiceImpl implements ShopService {
	private ShopDao shopDao;

	public void setShopDao(ShopDao shopDaoImpl) {
		this.shopDao = shopDaoImpl;
	}

	@Override
	public List<Shop> getAll() {
		// TODO Auto-generated method stub
		return this.shopDao.getAll();
	}

	@Override
	public Shop getShop(int shop_number) {
		// TODO Auto-generated method stub
		return this.shopDao.getShop(shop_number);
	}
	

}

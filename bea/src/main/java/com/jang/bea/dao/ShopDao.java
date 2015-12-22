package com.jang.bea.dao;

import java.util.List;

import com.jang.bea.model.Postscript;
import com.jang.bea.model.Shop;

public interface ShopDao {

	
List<Shop> getAll();
	
	Shop getShop(int shop_number);
	
}

package com.jang.bea.service;

import java.util.List;

import com.jang.bea.model.Postscript;
import com.jang.bea.model.Shop;

public interface ShopService {

	List<Shop> getAll();
	
	Shop getShop(int shop_number);

}

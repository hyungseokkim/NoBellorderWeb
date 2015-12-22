package com.jang.bea.service;

import java.util.List;

import com.jang.bea.model.Order;

public interface OrderService {
	
	List<Order> getAll();
	
	List<Order> getlist(int table_number);
	
	List<Order> getorder(int table_number);
	
	Order getOrder_list (int order_num);
	
	void insert(Order order);
	
	void update(Order order);
	
	int checktable(int table_number);

	int checkstate(int order_state);
	
	List<Order> getkitchen();
}

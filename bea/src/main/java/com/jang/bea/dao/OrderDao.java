package com.jang.bea.dao;

import java.util.List;

import com.jang.bea.model.Identify;
import com.jang.bea.model.Order;

public interface OrderDao {

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

package com.jang.bea.service;

import java.util.List;

import com.jang.bea.dao.IdentifyDao;
import com.jang.bea.dao.OrderDao;
import com.jang.bea.model.Identify;
import com.jang.bea.model.Menu;
import com.jang.bea.model.Order;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	
	public void setOrderDao(OrderDao orderDaoImpl) {
		this.orderDao = orderDaoImpl;
	}
	
	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		System.out.println("Order_listService");
		return this.orderDao.getAll();
		
	}
	
	@Override
	public  List<Order> getorder(int table_number) {
		// TODO Auto-generated method stub
		System.out.println("orderService123" );
		return this.orderDao.getorder(table_number);
	
	}
	
	@Override
	public  List<Order> getlist(int table_number) {
		// TODO Auto-generated method stub
		System.out.println("orderService" );
		return this.orderDao.getlist(table_number);
	
	}
	/*@Override
	public List<Identify> getAll() {
		// TODO Auto-generated method stub
		System.out.println("IdentifyServiceImpl");
		return this.identifyDao.getAll();
	}*/

	@Override
	public Order getOrder_list(int order_num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insert(Order order){
		// TODO Auto-generated method stub
		System.out.println("Order_listServiceinsert"+order);
		this.orderDao.insert(order);
	}
	

	@Override
	public void update(Order order) {
		System.out.println("serviceUpdate");
		// TODO Auto-generated method stub
		this.orderDao.update(order);
	}

	@Override
	public int checktable(int table_number) {
		// TODO Auto-generated method stub
		System.out.println("IdentifyService = " + table_number);
		return this.orderDao.checktable(table_number);
	}

	@Override
	public  List<Order> getkitchen() {
		// TODO Auto-generated method stub
		System.out.println("orderServicekitchen" );
		return this.orderDao.getkitchen();
	
	}
	
	@Override
	public int checkstate(int order_state) {
		// TODO Auto-generated method stub
		System.out.println("orderService = " + order_state);
		return this.orderDao.checkstate(order_state);
	}

}

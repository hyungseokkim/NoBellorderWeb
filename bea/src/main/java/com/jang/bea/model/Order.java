package com.jang.bea.model;

public class Order {

	private int order_number;
	private int table_number;
	private int order_state;
	private int order_grossvalue;  
	private String order_date;
	private int menu_number;
	private String menu_name;
	private String check_price;
	private int check_amount;
	private int check_discount;
	private int test;
	private int sum;
	private String order_etc;
	
	

	public String getOrder_etc() {
		return order_etc;
	}
	public void setOrder_etc(String order_etc) {
		this.order_etc = order_etc;
	}
	public int getTest() {
		return test;
	}
	public void setTest(int test) {
		this.test = test;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getCheck_amount() {
		return check_amount;
	}
	public void setCheck_amount(int check_amount) {
		this.check_amount = check_amount;
	}
	public String getCheck_price() {
		return check_price;
	}
	public void setCheck_price(String check_price) {
		this.check_price = check_price;
	}
	public int getTable_number() {
		return table_number;
	}
	public void setTable_number(int table_number) {
		this.table_number = table_number;
	}
	public int getMenu_number() {
		return menu_number;
	}
	public void setMenu_number(int menu_number) {
		this.menu_number = menu_number;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public int getCheck_number() {
		return table_number;
	}
	public void setCheck_number(int table_number) {
		this.table_number = table_number;
	}
	
	
	public int getCheck_discount() {
		return check_discount;
	}
	public void setCheck_discount(int check_discount) {
		this.check_discount = check_discount;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public int getOrder_grossvalue() {
		return order_grossvalue;
	}
	public void setOrder_grossvalue(int order_grossvalue) {
		this.order_grossvalue = order_grossvalue;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	
	
}

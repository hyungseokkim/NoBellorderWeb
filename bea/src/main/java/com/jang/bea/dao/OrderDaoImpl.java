package com.jang.bea.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jang.bea.model.Identify;
import com.jang.bea.model.Menu;
import com.jang.bea.model.Notice;
import com.jang.bea.model.Order;
import com.jang.bea.model.User;


public class OrderDaoImpl implements OrderDao {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);

}
		//-- 최종 주문내역 불러오기
		@Override
		public List<Order> getAll() {
			// TODO Auto-generated method stub
			
			String SQL = "SELECT order_number, check_number, order_state, order_grossvalue, order_date "
					+ "FROM order_list join identify using (check_number)";
			
			BeanPropertyRowMapper<Order> mapper = new BeanPropertyRowMapper<Order>(Order.class);
			
			System.out.println("Order_list DaoImpl" + "getAll()"+ getAll());
			
			List<Order> oList = (List<Order>) this.jdbcTemplate.query(SQL, mapper);
			
			return oList;
		}
		
		
		//-- 최종 주문 내역 불러오기(조인해서 해당 테이블의 임시 주문 목록에있는 메뉴 불러옴)
		@Override
		public List<Order> getorder(int table_number) {
			String SQL = "select distinct table_number, order_number,order_grossvalue, menu_number, menu_name,   order_state, to_char(order_date, 'yyyy-mm-dd hh12:mi')as order_date, check_amount, order_etc "
					+ ",check_price, check_price * check_amount as check_discount"
					+ " from (shop_menu join identify using(menu_number)) "
					+ "join order_list on(identify.table_number = order_list.table_number)"
					+ " where table_number = ?"
					+ "order by order_number desc";

			
			BeanPropertyRowMapper<Order> mapper = new BeanPropertyRowMapper<Order>(Order.class);
			
			System.out.println("OrderDaoImpl 컨트롤러" + "getOrder()");
			
			List<Order> cList = (List<Order>) this.jdbcTemplate.query(SQL, mapper, table_number);
			
			return cList;
		}

	
		//-- 최종 주문 내역 불러오기 

	@Override
	public List<Order> getlist(int table_number) {
		String SQL = "SELECT order_number, table_number, order_state, order_grossvalue, order_date "
				+ "FROM order_list join identify using(table_number)";
		
		BeanPropertyRowMapper<Order> mapper = new BeanPropertyRowMapper<Order>(Order.class);
		
		System.out.println("Order_listDaoImpl" + "getlist()");
		
		List<Order> oList = (List<Order>) this.jdbcTemplate.query(SQL, mapper, table_number);
		
		return oList;
	}

	
	//--최종 주문 내역 불러오기
	@Override
	public Order getOrder_list(int order_number) {
		String SQL = "SELECT * FROM order_list WHERE order_number = ?";

		System.out.println("Order_listDaoImpl 컨트롤러" + "getOrder_list(order_number)");

		RowMapper<Order> mapper = new BeanPropertyRowMapper<Order>(Order.class);
		return this.jdbcTemplate.queryForObject(SQL, mapper, order_number);
	}
	

	//-- 최종 주문내역에 담기
	@Override
	public void insert(Order order){
		String SQL = "INSERT INTO order_list (order_number,table_number,order_state, order_grossvalue, order_date, order_etc)"
				+ " VALUES (order_seq.nextval,:table_number,1,:order_grossvalue,sysdate,:order_etc)";
		
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(order);
				this.jdbcTemplate2.update ( SQL, parameterSource );
				System.out.println("orderDaoinsert"+order);
	}
	
	//--최종 주문 내역 업데이트
	@Override
	public void update(Order order){
		System.out.println("OrderDaoImpl " + "Update");
		String SQL = "update order_list set  table_number = :table_number, order_etc = :order_etc , order_grossvalue = :order_grossvalue "
				+ " where table_number = :table_number ";
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(order);
				this.jdbcTemplate2.update ( SQL, parameterSource );
	}

	//--테이블 중복검사
	@Override
	public int checktable(int table_number ) {
		System.out.println("identifyDaoImpl = " + table_number + "=check_table");
		String checktable = "Select count(*) table_number from order_list where table_number = ?";
		int count = this.jdbcTemplate.queryForObject(checktable, new Object[] {table_number}, Integer.class);
		return count;
		
	}
	
	//--주방에서 테이블별 주문 메뉴 불러오기
	@Override
	public List<Order> getkitchen() {

		String SQL = " select table_number, menu_name,  to_char(order_date, 'yyyy-mm-dd hh12:mi')as order_date, check_amount, order_etc "
				+ "	from (shop_menu join identify using(menu_number))"
				+ " join order_list on(identify.table_number = order_list.table_number) "
				+ " where table_number = ?";

		BeanPropertyRowMapper<Order> mapper = new BeanPropertyRowMapper<Order>(Order.class);
		
		System.out.println("OrderDaoImpl 컨트롤러" + "getOrder()");
		
		List<Order> cList = (List<Order>) this.jdbcTemplate.query(SQL, mapper);
		
		return cList;
	}
	
	//-- 상태 불러오기(상태 체크)
	@Override
	public int checkstate(int order_state ) {
		System.out.println("orderDaoImpl = " + order_state + "=check_state");
		String checkstate = "Select order_state from order_list where table_number = ?";
		int count = this.jdbcTemplate.queryForObject(checkstate, new Object[] {order_state}, Integer.class);
		return count;
		
	}
	
}

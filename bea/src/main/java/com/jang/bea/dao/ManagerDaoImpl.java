package com.jang.bea.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jang.bea.model.Identify;
import com.jang.bea.model.Manager;
import com.jang.bea.model.Order;
import com.jang.bea.model.User;

public class ManagerDaoImpl implements ManagerDao {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;
	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
	}

	//-- 매니저 정보 모두 불러오기
	@Override
	public List<Manager> getAll() {
		
		String SQL = "SELECT * FROM manager_tb";
		
		RowMapper mapper = new BeanPropertyRowMapper<User>(User.class);
		
		System.out.println("UserDaoImpl 컨트롤러" + "getAll()");
		List<Manager> uList = (List) this.jdbcTemplate.query(SQL, mapper);
		return uList;
	}

	//--아이디/비밀번호 찾기
	@Override
	public Manager getManager(String m_id, String m_password) {
	String GETIDPASS = "SELECT * FROM manager_tb WHERE m_id=? AND m_password=?";
		
		RowMapper<Manager> mapper = new BeanPropertyRowMapper<Manager>(Manager.class);
		System.out.println("getManager"+ m_id+m_password);
		
		try{
			return jdbcTemplate.queryForObject(GETIDPASS, mapper, m_id, m_password);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
		
		
	}
	//--매니저 등록
	@Override
	public void insertManager(Manager manager) {
		
	}
	
	//-- 주문승인하기(주문상태 업데이트)
	@Override
	public void update(Order order){
		System.out.println("ManagerDaoImpl " + "Update");
		String SQL = "update order_list set order_state = :order_state +1 "
				+ " where order_number = :order_number";
		System.out.println("orderstate"+order.getOrder_state());
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(order);
				this.jdbcTemplate2.update ( SQL, parameterSource );
	}
	
	

}

package com.jang.bea.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jang.bea.model.Discount_benefit;



public class Discount_benefitDaoImpl implements Discount_benefitDao {

	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
}
	
	
	@Override
	public List<Discount_benefit> getAll() {
		// TODO Auto-generated method stub
	String SQL = "SELECT * FROM discount_benefit where benefit_price>0";
		
		RowMapper mapper = new BeanPropertyRowMapper<Discount_benefit>(Discount_benefit.class);
		
		System.out.println("Discount_benefitrDaoImpl 컨트롤러" + "getAll()");
		List<Discount_benefit> dList = (List) this.jdbcTemplate.query(SQL, mapper);
		return dList;
	}

	@Override
	public Discount_benefit getBenefit(int benefit_number) {
		// TODO Auto-generated method stub
	String SQL = "SELECT * FROM discount_benefit WHERE benefit_number = ?";
		
		System.out.println("Discount_benefitrDaoImpl 컨트롤러" + "getBenefit(benefit_number)");
		
		RowMapper<Discount_benefit> mapper = new BeanPropertyRowMapper<Discount_benefit>(Discount_benefit.class);
		return this.jdbcTemplate.queryForObject(SQL, mapper, benefit_number);
	}
}

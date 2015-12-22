package com.jang.bea.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jang.bea.model.Menu;
import com.jang.bea.model.Menu_division;

public class Menu_divisionDaoImpl implements Menu_divisionDao {
	

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
}

	@Override
	public List<Menu_division> getAll() {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM menu_division ORDER BY division_code desc";
		
		RowMapper mapper = new BeanPropertyRowMapper<Menu_division>(Menu_division.class);
		
		System.out.println("Menu_divisionDaoImpl 00" + "getAll()");
		List<Menu_division> mdList = (List) this.jdbcTemplate.query(SQL, mapper);
		return mdList;
	}

	@Override
	public Menu_division getMenu_division(int division_code) {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM menu_division WHERE division_code = ?";
		
		System.out.println("Menu_divisionDaoImpl 컨트롤러" + "Menu_division(division_code)");
		
		RowMapper<Menu_division> mapper = new BeanPropertyRowMapper<Menu_division>(Menu_division.class);
		return this.jdbcTemplate.queryForObject(SQL, mapper, division_code);
	}

}

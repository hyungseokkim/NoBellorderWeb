package com.jang.bea.dao;


import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jang.bea.model.Menu;

public class MenuDaoImpl implements MenuDao {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
}

	@Override
	public List<Menu> getAll() {

	String SQL = "SELECT * from shop_menu";
	RowMapper mapper = new BeanPropertyRowMapper<Menu>(Menu.class);
		
		System.out.println("MenuDaoImpl 00" + "getAll()");
		List<Menu> mList = (List) this.jdbcTemplate.query(SQL, mapper);
		return mList;
	}

	@Override
	public List<Menu> getMenu(int menu_number) {
		
		String SQL = "SELECT * FROM shop_menu WHERE menu_number = ?";
		
	RowMapper mapper = new BeanPropertyRowMapper<Menu>(Menu.class);
		
		System.out.println("MenuDaoImpl" + "getmenu()");
		List<Menu> mdList = (List) this.jdbcTemplate.query(SQL, mapper, menu_number);
		System.out.println("MenuDaoImpl" + "getmenu()" + menu_number);
		return mdList;
	}
	
	
	@Override
	public List<Menu> getMenu_division1() {
		String SQL = "select menu_number, menu_name, menu_photo, menu_price, benefit_price, menu_price - (menu_price * benefit_price) as discount_price "
				+ "from shop_menu join discount_benefit using (benefit_number)"
				+ " WHERE division_code = 1";

		RowMapper mapper = new BeanPropertyRowMapper<Menu>(Menu.class);
		
		System.out.println("MenuDaoImpl" + "division1()");
		List<Menu> mdList = (List) this.jdbcTemplate.query(SQL, mapper);
		return mdList;
	}

	@Override
	public List<Menu> getMenu_division2() {
		String SQL = "select menu_number, menu_name, menu_photo, menu_price, benefit_price, menu_price - (menu_price * benefit_price) as discount_price "
				+ "from shop_menu join discount_benefit using (benefit_number)"
				+ " WHERE division_code = 2";

		RowMapper mapper = new BeanPropertyRowMapper<Menu>(Menu.class);
		
		System.out.println("MenuDaoImpl " + "division2()");
		List<Menu> mdList = (List) this.jdbcTemplate.query(SQL, mapper);
		return mdList;
	}
	
	@Override
	public List<Menu> getMenu_division3() {
		String SQL = "select menu_number, menu_name, menu_photo, menu_price, benefit_price, menu_price - (menu_price * benefit_price) as discount_price "
				+ "from shop_menu join discount_benefit using (benefit_number)"
				+ " WHERE division_code = 3";

		RowMapper mapper = new BeanPropertyRowMapper<Menu>(Menu.class);
		
		System.out.println("MenuDaoImpl " + "division3()");
		List<Menu> mdList = (List) this.jdbcTemplate.query(SQL, mapper);
		return mdList;
	}
	
	@Override
	public List<Menu> getMenu_division4() {
		String SQL = "select menu_number, menu_name, menu_photo, menu_price, benefit_price, menu_price - (menu_price * benefit_price) as discount_price "
				+ " from shop_menu join discount_benefit using (benefit_number)"
				+ " WHERE division_code = 4";

		RowMapper mapper = new BeanPropertyRowMapper<Menu>(Menu.class);
		
		System.out.println("MenuDaoImpl " + "division4()");
		List<Menu> mdList = (List) this.jdbcTemplate.query(SQL, mapper);
		return mdList;
	}
	
	@Override
	public List<Menu> getMenu_division5() {
		String SQL = "select menu_number, menu_name, menu_photo, menu_price, benefit_price, menu_price - (menu_price * benefit_price) as discount_price "
				+ " from shop_menu join discount_benefit using (benefit_number)"
				+ " WHERE division_code = 5";

		RowMapper mapper = new BeanPropertyRowMapper<Menu>(Menu.class);
		
		System.out.println("MenuDaoImpl " + "division5()");
		List<Menu> mdList = (List) this.jdbcTemplate.query(SQL, mapper);
		return mdList;
	}


	@Override
	public List<Menu> getbenefit() {
		String SQL = "select menu_number, menu_name, menu_photo, menu_price, benefit_price, menu_price - (menu_price * benefit_price) as discount_price "
				+ "from shop_menu join discount_benefit using (benefit_number)";

		BeanPropertyRowMapper<Menu> mapper = new BeanPropertyRowMapper<Menu>(Menu.class);
		
		System.out.println("MenuDaoImpl 컨트롤러" + "getbenefit()");
		
		List<Menu> cList = (List<Menu>) this.jdbcTemplate.query(SQL, mapper);
		
		return cList;
	}

	
	
}

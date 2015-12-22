package com.jang.bea.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jang.bea.model.Identify;
import com.jang.bea.model.Postscript;
import com.jang.bea.model.Shop;
import com.jang.bea.model.User;

public class ShopDaoImpl implements ShopDao {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
}

	@Override
	public List<Shop> getAll() {
		// TODO Auto-generated method stub

		String SQL = "SELECT * FROM shop";
		
		RowMapper mapper = new BeanPropertyRowMapper<Shop>(Shop.class);
		
		System.out.println("ShopDaoImpl" + "getAll()");
		List<Shop> sList = (List) this.jdbcTemplate.query(SQL, mapper);
		return sList;
	}

	@Override
	public Shop getShop(int shop_number) {
		// TODO Auto-generated method stub
		String SQL = "select shop_number, shop_name, shop_introduction, shop_logo, avg(postscript_grade) as shop_grade "
				+ " from shop join postscript using (shop_number)"
				+ " where shop_number=? "
				+ " group by shop_number, shop_name, shop_introduction, shop_logo";
   
		System.out.println("ShopDaoImpl" + "getUser(shop_number)");
		
		RowMapper<Shop> mapper = new BeanPropertyRowMapper<Shop>(Shop.class);
		
		try{
		return this.jdbcTemplate.queryForObject(SQL, mapper, shop_number);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

/*	@Override
	public int getShopGrade(int shop_number){
		String SQL = "select AVG(postscript_grade) as shop_grade from postscript where shop_number=?";
		
		System.out.println("getSHopgrade");
		int shop_grade =  this.jdbcTemplate.queryForObject(SQL, new Object[] {shop_number}, Integer.class );


		System.out.println("IdentifyDaoImpl" + "getIdentify()" + shop_number);
		
		
		return shop_grade;
	}*/

}

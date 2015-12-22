package com.jang.bea.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jang.bea.model.User;

public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		
		String SQL = "SELECT * FROM user";
		
		RowMapper mapper = new BeanPropertyRowMapper<User>(User.class);
		
		System.out.println("UserDaoImpl 컨트롤러" + "getAll()");
		List<User> uList = (List) this.jdbcTemplate.query(SQL, mapper);
		return uList;
	}

	@Override
	public User getUser(int user_number) {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM user WHERE user_number = ?";
		
		System.out.println("UserDaoImpl 컨트롤러" + "getUser(user_number)");
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemplate.queryForObject(SQL, mapper, user_number);
	}

	@Override
	public void insertUser(int user_number, String user_phone) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into user (user_number, user_phone) values (user_seq.nextval, ? ) ", user_phone );
		
	}

}

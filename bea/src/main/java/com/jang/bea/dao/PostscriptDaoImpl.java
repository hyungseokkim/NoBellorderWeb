package com.jang.bea.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jang.bea.model.Postscript;


public class PostscriptDaoImpl implements PostscriptDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
}
	
	@Override
	public List<Postscript> getAll(int shop_number) {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM postscript where shop_number = ?";
		
		System.out.println("postscriptDaoImpl ��Ʈ�ѷ�" + "getAll()");
		
		RowMapper mapper = new BeanPropertyRowMapper<Postscript>(Postscript.class);
		List<Postscript> pList = (List) this.jdbcTemplate.query(SQL, mapper, shop_number);
		return pList;
		
	}
	@Override
	public Postscript getPostscript(int postscript_number) {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM postscript WHERE postscript_number = ?";

		System.out.println("PostscriptDaoImpl ��Ʈ�ѷ�" + "getPostscript(postscript_number)");
		
		RowMapper<Postscript> mapper = new BeanPropertyRowMapper<Postscript>(Postscript.class);
		return this.jdbcTemplate.queryForObject(SQL, mapper, postscript_number);
	}

	@Override
	public void UpdatePostscript(Postscript postscript) {
		// TODO Auto-generated method stub
		String SQL_UP = "UPDATE postscript";
    SqlParameterSource  parameterSource = new BeanPropertySqlParameterSource(postscript);
     jdbcTemplate2.update(SQL_UP,  parameterSource );
     
     System.out.println("PostscriptDaoImpl ��Ʈ�ѷ�" + "UpdatePostscript(postscript)");
}

	@Override
	public void insertPostscript(Postscript postscript) {
		// TODO Auto-generated method stub
		String SQL ="insert into postscript(postscript_number, shop_number, member_phone, "
				+ "postscript_content,postscript_picture, postscript_date, postscript_grade) "
				+ "values (seq_post.nextval, :shop_number, :member_phone, :postscript_content, :postscript_picture, "
				+ "sysdate, :postscript_grade)";
		   
	    System.out.println("PostscriptDaoImpl ��Ʈ�ѷ�" + "insertPostscript(postscript)");
	    
	    SqlParameterSource  parameterSource = new BeanPropertySqlParameterSource(postscript);
	     jdbcTemplate2.update(SQL,  parameterSource );
	}
	

	@Override
	public void deletePostscript(int postscript_number) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("DELETE FROM postscript WHERE postscript_number = ?", postscript_number);
		
		System.out.println("PostscriptDaoImpl ��Ʈ�ѷ�" + "deletePostscript(postscript_number)");
	}
}

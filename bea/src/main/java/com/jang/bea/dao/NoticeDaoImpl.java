package com.jang.bea.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jang.bea.model.Notice;

public class NoticeDaoImpl implements NoticeDao {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
}

	@Override
	public List<Notice> getAll(int shop_number) {
		// TODO Auto-generated method stub
		
	String SQL = "SELECT notice_number, notice_title,  to_char(notice_date, 'yyyy-mm-dd hh12:mi')as notice_date"
			+ " FROM notice"
			+ " where shop_number = ?";
		
		RowMapper mapper = new BeanPropertyRowMapper<Notice>(Notice.class);
		
		System.out.println("NoticeDaoImpl list" + shop_number);
		List<Notice> nList = (List) this.jdbcTemplate.query(SQL, mapper, shop_number);
		return nList;
	}
	
	@Override
	public List<Notice> getSpecial(int shop_number) {
		// TODO Auto-generated method stub
		
	String SQL = "SELECT notice_number, notice_title,  to_char(notice_date, 'yyyy-mm-dd hh12:mi')as notice_date"
			+ " FROM notice"
			+ " where shop_number = ? and notice_important = 1";
		
		RowMapper mapper = new BeanPropertyRowMapper<Notice>(Notice.class);
		
		System.out.println("NoticeDaoImpl" + shop_number);
		List<Notice> sList = (List) this.jdbcTemplate.query(SQL, mapper, shop_number);
		return sList;
	}

	
	@Override
	public Notice getNotice(int notice_number) {
		// TODO Auto-generated method stub
String SQL = "SELECT * FROM notice WHERE notice_number = ?";
		
		System.out.println("NoticeDaoImpl " + "getNotice(notice_number)");
		
		RowMapper<Notice> mapper = new BeanPropertyRowMapper<Notice>(Notice.class);
		return this.jdbcTemplate.queryForObject(SQL, mapper, notice_number);
	}
	
	@Override
	public void update(Notice notice){
		System.out.println("NoticeDaoImpl " + "Update");
		String SQL = "update NOTICE set notice_title=:notice_title, shop_number=:shop_number, notice_number= :notice_number, notice_important=:notice_important, notice_content =:notice_content, notice_date=sysdate"
				+ " where notice_number=:notice_number";
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);
				this.jdbcTemplate2.update ( SQL, parameterSource );
	}

	
	@Override
	public void insert(Notice notice){
		String SQL = "INSERT INTO NOTICE (notice_number,shop_number,notice_important,notice_title,notice_content,notice_date)"
				+ " VALUES (seq_not.nextval,:shop_number,:notice_important,:notice_title,:notice_content,sysdate)";
		
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);
				this.jdbcTemplate2.update ( SQL, parameterSource );
	}
	
	@Override
	public void delete(Notice notice){
		String SQL = "delete from notice where notice_number = :notice_number";
			
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);
				this.jdbcTemplate2.update ( SQL, parameterSource);
	}
	
}


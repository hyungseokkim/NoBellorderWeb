
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

public class IdentifyDaoImpl implements IdentifyDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
	}

	//-- 임시주문 목록 불러오기
	@Override
	public List<Identify> getAll() {

		String SQL = "SELECT * from identify";
		RowMapper mapper = new BeanPropertyRowMapper<Identify>(Identify.class);

		System.out.println("IdentifyDaoImpl" + "getAll()");
		List<Identify> iList = (List) this.jdbcTemplate.query(SQL, mapper);
		return iList;
	}

	//-- 임시주문 목록 불러오기(조인해서 테이블 메뉴에 해당하는 주문 메뉴들 불러옴)
	@Override
	public List<Identify> getIdentify(int table_number) {

		String SQL = "SELECT check_number, menu_number, table_number, check_amount,"
				+ " check_price, menu_name, check_price * check_amount as check_discount"
				+ " from identify join shop_menu using(menu_number)" + " where table_number = ?";

		RowMapper mapper = new BeanPropertyRowMapper<Identify>(Identify.class);

		List<Identify> iList = (List) this.jdbcTemplate.query(SQL, mapper, table_number);

		System.out.println("IdentifyDaoImpl" + "getIdentify()" + table_number);

		return iList;
	}

	//-- 테이블 번호에 해당하는 주문메뉴 불러오기
	@Override
	public List<Identify> getIdentify2(int table_number) {
		String SQL = "SELECT check_number, menu_number, table_number, check_amount, check_price, menu_name, check_price * check_amount as check_discount, check_state, check_total, check_date "
				+ "from identify join shop_menu using(menu_number) where table_number = ?";

		RowMapper mapper = new BeanPropertyRowMapper<Identify>(Identify.class);

		List<Identify> iList = (List) this.jdbcTemplate.query(SQL, mapper, table_number);

		System.out.println("IdentifyDaoImpl222" + "getIdentify()" + table_number);

		return iList;
	}

	//--임시 주문 목록에 메뉴 담기
	@Override
	public void insert(Identify identify) {
		String SQL = "INSERT INTO identify (check_number,table_number,menu_number,check_amount,check_price)"
				+ " VALUES (seq_check.nextval,:table_number,:menu_number,:check_amount,:check_price)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(identify);
		this.jdbcTemplate2.update(SQL, parameterSource);
	}

	//--임시 주문 목록에서 메뉴 삭제하기
	@Override
	public void delete(Identify identify) {
		String SQL = "delete from identify where check_number = :check_number";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(identify);
		this.jdbcTemplate2.update(SQL, parameterSource);
	}

	//-- 임시 주문 목록에서 해당 메뉴  업데이트 하기
	@Override
	public void update(Identify identify) {
		System.out.println("IdentifyeDaoImpl " + "Update");
		String SQL = "update identify set  check_number = :check_number, check_amount=:check_amount "
				+ " where check_number = :check_number";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(identify);
		this.jdbcTemplate2.update(SQL, parameterSource);
	}

	//-- 메뉴 중복검사
	@Override
	public int checkmenu(int menu_number, int table_number) {
		System.out.println("identifyDaoImpl = " + menu_number + "=check_menu");
		String checkmenu = "select count(*) from identify where menu_number = ? and table_number = ?";
		int count = this.jdbcTemplate.queryForObject(checkmenu, new Object[] { menu_number, table_number },
				Integer.class);
		return count;
		
	}

	//-- 메뉴 중복검사
	@Override
	public Identify findmenu(int menu_number) {
		String GETID = "select menu_number name from identify where menu_number=?";
		RowMapper<Identify> mapper = new BeanPropertyRowMapper<Identify>(Identify.class);
		return jdbcTemplate.queryForObject(GETID, mapper, menu_number);

	}

}

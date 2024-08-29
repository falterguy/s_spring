package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.CoffeeDto;

@Repository
public class CoffeeDAO {
	private final JdbcTemplate db;
	
	@Autowired
	public CoffeeDAO(JdbcTemplate jdbc) {
		this.db= jdbc;
	}
	
	public void delete(int bid) {
		String sql="delete from coffee where coffee_id=?";
		
		db.update(sql,bid);
		
	}
	
	public List<CoffeeDto> select(){
		String sql="select * from coffe";
		
		List<CoffeeDto> list = db.query(sql , new CoffeDtoRowMapper() );
		
		return list;
	}
	
	
	public void save(CoffeeDto coffeDto) {
		String sql="insert into coffe(item_name, price, decaffein) "+
				" values(?,?,?)";
		
		db.update(sql , coffeDto.getCoffeemenu(), coffeDto.getCoffeeprice(),
				coffeDto.isCoffeedecaffein() );
	}
	
	public class CoffeDtoRowMapper implements RowMapper<CoffeeDto>{

		@Override
		public CoffeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CoffeeDto dto = new CoffeeDto();
			dto.setCoffeedecaffein(rs.getBoolean("decaffein"));
			dto.setCoffeeprice( rs.getInt("price"));
			dto.setCoffeemenu( rs.getString("item_name"));
			dto.setCoffeId( rs.getInt("coffe_id"));
			return dto;
		}
		
	}
}

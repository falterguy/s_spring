package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.BookinDto;
import com.example.bookTest.Dto.BookinDto;

@Repository
public class BookDAO {
	
	private final JdbcTemplate jt;
	
	@Autowired
	public BookDAO( JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}
	
	// 도서 삭제
	public void delete(int bid) {
		String sql="delete from book where book_id=?";
		
		jt.update(sql,bid);
	}
	
	
	//도서 상세 정보 가져오기 - 1권에 대해서만 (book_id 컬럼으로 조회)
	//book_id 컬럼이 중복데이터를 가질수 없는 유일값이기 때문에
	public BookinDto findId(int id) {
		String sql="select * from book where book_id=?";
		
		//jt.queryForObject(쿼리문, mapper, ?에 넣어줄값 );
		
		BookinDto data = jt.queryForObject(sql,new RowMapper<BookinDto>() {
			
			@Override
			public BookinDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				BookinDto bookinDto = new BookinDto();
				bookinDto.setBookAuthor(rs.getString("book_author"));
				bookinDto.setBookCost(rs.getInt("book_cost"));
				bookinDto.setBookPage( rs.getInt("book_page"));
				bookinDto.setBookTitle( rs.getString("book_title"));
				bookinDto.setPublisher( rs.getString("publisher"));
				bookinDto.setBookId( rs.getInt("book_id"));
				return bookinDto;
			}
			
		}
				 
		, id );
		
		return data;
	}
	
	
	// book 테이블 전체 데이터 가져오기 - 첫화면에 목록으로 출력하기위해
	public List<BookinDto> select(){
		String sql="select * from book";
		
		List<BookinDto> list = jt.query(sql , new BookinDtoRowMapper() );
		
		return list;
	}
	
	
	public void insert(BookinDto bookinDto) { // 도서정보 데이터베이스에 저장
		String sql="insert into book(book_title , book_author, "+
				"book_cost, book_page, publisher) values(?,?,?,?,?)";
		
		jt.update(sql , bookinDto.getBookTitle() , bookinDto.getBookAuthor(),
				bookinDto.getBookCost(), bookinDto.getBookPage(), 
				bookinDto.getPublisher() );
	}
	
	
	public class BookinDtoRowMapper implements RowMapper<BookinDto>{

		@Override
		public BookinDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookinDto bookinDto = new BookinDto();
			bookinDto.setBookAuthor(rs.getString("book_author"));
			bookinDto.setBookCost(rs.getInt("book_cost"));
			bookinDto.setBookPage( rs.getInt("book_page"));
			bookinDto.setBookTitle( rs.getString("book_title"));
			bookinDto.setPublisher( rs.getString("publisher"));
			bookinDto.setBookId( rs.getInt("book_id"));
			return bookinDto;
		}
		
	}

	// 수정 도서의 정보를 데이터베이스에 수정하여 저장하기
	public void update(BookinDto bookinDto) {
		
		String sql="update book set book_title=? , book_author=?,"+"book_cost=? , book_page=? , publisher=?"+"where book_id=?";
		
		jt.update(sql,bookinDto.getBookTitle(), bookinDto.getBookAuthor(), bookinDto.getBookCost(), bookinDto.getBookPage(), bookinDto.getPublisher(),bookinDto.getBookId());
	}
	
	
}
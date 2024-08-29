package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.CoffeeDAO;
import com.example.bookTest.Dto.CoffeeDto;

@Service
public class CoffeeService {

	
	@Autowired
	private CoffeeDAO coffeeDao;
	
	public void remove(int id) {
		coffeeDao.delete(id);
	}
	
	
	public void coffeeSave(CoffeeDto coffeeDto) {
		
		return coffeeDao.findById(id);
	}
	
	public List<CoffeeDto> selectAll(){
		return coffeeDao.select();
		
	}
		public void menuInsert(CoffeeDto coffeeDto) {
			if( coffeeDto != null)
				coffeeDao.save(coffeeDto);
		}
	}
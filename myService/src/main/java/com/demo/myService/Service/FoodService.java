package com.demo.myService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.myService.dto.BestFoodDto;

@Service
public class FoodService {
	public List<BestFoodDto> getFoods() {
		
		List<BestFoodDto> bestFoodDtoList = new ArrayList<>();
		
		BestFoodDto bestFoodDto = new BestFoodDto();
		bestFoodDto.setFoodName("파전");
		bestFoodDtoList.add(bestFoodDto);
		
		bestFoodDtoList.add(BestFoodDto.of("김치찌개")); //of 메서드
		bestFoodDtoList.add(BestFoodDto.of("된장찌개"));
		bestFoodDtoList.add(BestFoodDto.of("짜장면"));
		bestFoodDtoList.add(BestFoodDto.of("짬뽕"));
		
		return bestFoodDtoList;
	}

}

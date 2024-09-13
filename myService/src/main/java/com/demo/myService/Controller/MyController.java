package com.demo.myService.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.myService.Service.FoodService;
import com.demo.myService.dto.BestFoodDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyController {
	private final FoodService foodService;
	
	@GetMapping("/food")
	public String main() {
		return "/food";
	}
	@GetMapping("/bestFood")
	public String bestFood(Model model) {
		
		List<BestFoodDto> list=	foodService.getFoods();
			
		model.addAttribute("foodList" , list);
		
		return "/bestFood";
	}
	
	
}

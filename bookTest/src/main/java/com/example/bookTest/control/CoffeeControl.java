package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.CoffeeDto;
import com.example.bookTest.service.CoffeeService;

@Controller
public class CoffeeControl{

@Autowired
	private CoffeeService coffeeService;

@GetMapping("/coffe")
public ModelAndView home() {
	ModelAndView mv = new ModelAndView("coffee/index");
	
	List<CoffeeDto> list=coffeeService.selectAll();
	mv.addObject("list",list);
	
	return mv;
}
	
@GetMapping("/coffeeReg")
	private String write() {
	return "coffee/coffeeForm";
}
@PostMapping("/coffeeSave")
public String menuSave(@ModelAttribute CoffeeDto coffeeDto) {
	//coffeeService.menyInsert(coffeeDto);
	return "redirect:/coffee";
}

	@GetMapping("/coffee/view")
	public ModelAndView view(@RequestParam("id") int id) {
		
		coffeeDto dto=coffeeService.getMenu(id);
		return new ModelAndView("coffee/view").addObject("menu",dto);
		
	}
	@GetMapping("/coffee/delete")
	public String remove(@RequestParam("id") int id) {
		coffeeService.remove(id);
		return "redirect:/coffee";
	}
}
	
	
	


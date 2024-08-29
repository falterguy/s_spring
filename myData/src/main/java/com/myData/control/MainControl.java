package com.myData.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControl {

	@GetMapping("/index")
	public String index() {
		return "mainPage";
	}
	@GetMapping("/info")
	public String info() {
		return "info";
	}
	@GetMapping("/infosave")
	public String save(@RequestParam("name") String name, 
			@RequestParam("age") int age, 
			@RequestParam("birth") String birth , Model model) {
		
		
		model.addAttribute("myName",name);
		model.addAttribute("myAge",age);
		model.addAttribute("myBirth",birth);
		
		return "mainPage";
	}
	
	@GetMapping("/favorite")
	public String genre() {
		return "myFavorite";
	}
	
	@PostMapping("/send")
	public String send(@RequestParam("movie")String movie,
			@RequestParam("sports")String sports,
			@RequestParam("music")String music , Model model) {
		
		model.addAttribute("myMovie",movie);
		model.addAttribute("mySports",sports);
		model.addAttribute("myMusic",music);
		return "result";
	}
	
	
			
		
		
	
}

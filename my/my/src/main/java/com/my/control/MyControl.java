package com.my.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyControl {
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	@GetMapping("/gallery")
	public String gallery() {
		return "gallery/List";
	}
	
	@GetMapping("/gallery/update")
	public String update() {
		return "gallery/Write";
	}
	
	
	@GetMapping("/game/write")
	public String write() {
		return "game/gamewrite";
	}
}



package com.demo.myService.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.demo.myService.Service.BaseBallService;
import com.demo.myService.dto.PitcherDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BaseBallController {
	private final BaseBallService baseBallService;

		@GetMapping("/")
		public String main() {
			
			return "main";
		}
		@GetMapping("/bbSearch")
		public String searcch(@ModelAttribute PitcherDto pitcherDto, Model model) {
			
			List<PitcherDto> list=baseBallService.searchPitcher(pitcherDto);
			
			model.addAttribute("pitcherList", list);
			
			//model.addAttribute("pitcher",pitcherDto);
			return "pitcherInfo";
		}
}





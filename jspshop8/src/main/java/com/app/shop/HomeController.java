package com.app.shop;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.shop.vo.BoardVo;



@Controller
public class HomeController{
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/main")
	public @ResponseBody  String main() {
		return "board/main";
	}
	

	@GetMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("qwe", "ddd");
		
		return "board/list";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}

	
	@GetMapping("/home")
	public String de() {
		return "board/home";
	}
	
	@GetMapping("/index2")
	public String index2() {
		return "index2";
	}
	
	
	
}

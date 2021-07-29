package com.app.shop;


import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.shop.Service.MemberService;
import com.app.shop.vo.BoardVo;
import com.app.shop.vo.MemberVo;

import lombok.AllArgsConstructor;



@Controller
@AllArgsConstructor
public class HomeController{
	
	private MemberService MemberService;
	
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

	@GetMapping("/signup")
	public String getsignup() {
		return "member/signup";
	}
	
	@GetMapping("/index2")
	public String index2() {
		return "index2";
	}
	
	
	@PostMapping("/member/signup")
	public String postsignup() {
		
		return "redirect:/";
	}
	
	
	@GetMapping("/member/idConfirm")
	public @ResponseBody String idConfirm(@RequestParam(value="userid", required = false) String userid) {
			
		System.out.print(userid);
		MemberVo membervo = MemberService.idcheck(userid);
		
		if(membervo == null) {
			return "Y";
		}else {	
			return "N";
		}
	}
	
	
	@GetMapping("/user/pswdCheck")
	public @ResponseBody int pwCheck(@RequestParam(value="userid", required = false) String userid, 
									 @RequestParam(value="pw", required = false) String pw) {
		
		boolean result =  MemberService.pswdCheck(pw);
		if(result == true) {
			return 1;
		}else {
			return 2;
		}
		
		
	}
	
	
	
//	@GetMapping("/member/idConfirm/{userid}")
//	public @ResponseBody String idConfirm(@PathVariable String userid) {
//			
//		MemberVo membervo = MemberService.idcheck(userid);
//		
//		if(membervo == null) {
//			return "Y";
//		}else {	
//			return "N";
//		}
//	}
	
	
	
	
//	@PostMapping("/member/idConfirm")
//	public @ResponseBody String idConfirm(@RequestParam String userid) {
//	
//		System.out.print(userid);
//			
//		MemberVo membervo = MemberService.idcheck(userid);
//		
//		if(membervo == null) {
//			return "1";
//		}else {	
//			System.out.println(membervo.getUserid());
//			return "2";
//		}
//	}
	
	
	
}

package com.app.shop;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.shop.Service.BoardService;
import com.app.shop.Service.BoardService2;
import com.app.shop.vo.BoardVo;

import lombok.AllArgsConstructor;


@Controller
public class BoardController {

	public BoardService boardservice;	
	
	@Autowired
	private BoardService2 boardservice2;
	
	
	
	@GetMapping("/board/write")
	public String write() {
		return "board/write";
	}
	
	
	
	@PostMapping("/board/post")
	public String write2(BoardVo boardvo) {

		boardservice2.post(boardvo);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/board/free")
	public String freeboard(Model model) {
		List<BoardVo> boardvo = boardservice2.select();
		model.addAttribute("boardvo", boardvo);

		
		return "board/freeboard";
	}
	
	@GetMapping("/board/suggestion")
	public String suggestion() {
		return "board/suggestion";
	}

	
}

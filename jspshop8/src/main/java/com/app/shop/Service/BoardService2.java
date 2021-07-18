package com.app.shop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.shop.domain.repository.BoardRepository;
import com.app.shop.vo.BoardVo;

import lombok.AllArgsConstructor;

@Service
public class BoardService2 {

	@Autowired
	private BoardRepository boardRepository;
	
	public void post(BoardVo boardvo){
		boardRepository.good(boardvo);
	}
	
	
	public List<BoardVo> select() {
		return boardRepository.selectBoardList();
	}
	
	
	public BoardVo selectqqq() {
		return boardRepository.selectqqqq();
	}
}

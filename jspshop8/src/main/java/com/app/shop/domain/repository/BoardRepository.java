package com.app.shop.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.shop.vo.BoardVo;

@Repository
public interface BoardRepository {

	public void good(BoardVo boardvo);
	
	public List<BoardVo> selectBoardList();
	
	
	public BoardVo selectqqqq();
}


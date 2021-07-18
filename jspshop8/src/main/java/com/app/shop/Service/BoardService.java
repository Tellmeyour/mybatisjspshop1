package com.app.shop.Service;

import com.app.shop.vo.BoardVo;

public interface BoardService {
	// 여기가 컨트롤러에서 사용하는 인터페이스
	// 복잡한건 뒤에서 작업하고 여기서 간단하게 
	// 이름만 알면 사용할수있도록 모듈화? 한거임
	
	public String post(BoardVo boardvo);
	
}

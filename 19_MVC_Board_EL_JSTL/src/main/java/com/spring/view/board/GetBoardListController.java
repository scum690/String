package com.spring.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.view.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
		//System.out.println(">>> 로그인 처리 요청");
		//1. 전달받은 값 추출(값없음)
		//2. DB연동처리
		BoardVO vo = new BoardVO();

		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		//3. 화면네비게이션 목록화면으로 이동
		//3-1. 목록 화면에서 사용할 수 있도록 세션에 저장
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		//3-2. 목록화면으로 이동
		//return "getBoardList.jsp";
		return "getBoardList";
	}

}

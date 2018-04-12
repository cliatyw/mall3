package com.test.mall3.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall3.member.service.MemberService;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	public Map<String, Object> getBoardList(int currentPage,int pagePerRow){
		Map<String, Object> map = new HashMap<String,Object>();
		/*currentPage,pagePerRow(한페이지에서보여줄게시판수)를 이용한 beginRow 구하기*/
		int beginRow = (currentPage-1)*pagePerRow;
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Board> list = boardDao.selectBoardList(map);
		int total = boardDao.totalCountBoard();
		/*total,pagePerRow를 이용한 lastPage구하기*/
		int lastPage = 0;
		if(total%pagePerRow==0) {
			lastPage = total/pagePerRow;
		} else {
			lastPage = total/pagePerRow+1;
		}
		Map<String, Object> returnMap = new HashMap<String,Object>();
		returnMap.put("list",list);
		returnMap.put("lastPage",lastPage);
		return returnMap;
	}
	
	public int addBoard(Board board) {
		int row = boardDao.insertBoard(board);	
		logger.debug("%s","BoardDao.insertBoard()호출");
		return row;
	}
	
	/*매개변수 boardNo를 받아 게시판글 삭제*/
	public int deleteBoard(int boardNo) {
		int row = boardDao.deleteBoard(boardNo);
		return row;
	}
}
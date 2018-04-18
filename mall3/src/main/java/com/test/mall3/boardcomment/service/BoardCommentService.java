package com.test.mall3.boardcomment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall3.board.service.Board;

@Service
public class BoardCommentService {

	@Autowired
	private BoardCommentDao boardCommentDao;
	
	public int insertrBoardComment(BoardComment boardComment) {
		int row = boardCommentDao.insertBoardComment(boardComment);
		return row;
	}
	
	public List<BoardComment> selectBoardComment(int boardNo){
		return boardCommentDao.selectBoardComment(boardNo);
	}
	
	/*댓글등록시 게시판화면을 보여주기위한 검색*/
	public List<Board> selectBoardCommentList(){
		return boardCommentDao.selectBoardCommentList();
	}
}

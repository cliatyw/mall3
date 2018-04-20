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
	/*댓글 수정,삭제시 memberId확인*/
	public List<BoardComment> selectBoardCommentMemberId(){
		return boardCommentDao.selectBoardCommentMemberId();
	}
	/*댓글수정*/
	public int updateBoardComment(BoardComment boardComment) {
		int row = boardCommentDao.updateBoardComment(boardComment);
		return row;
	}
	/*댓글삭제*/
	public int deleteBoardComment(int commentNo) {
		int row = boardCommentDao.deleteBoardComment(commentNo);
		return row;
	}
}

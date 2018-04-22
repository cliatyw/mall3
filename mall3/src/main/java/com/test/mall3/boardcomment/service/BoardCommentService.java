package com.test.mall3.boardcomment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	/*댓글리스트 페이징*/
	public Map<String, Object> getBoardCommentList(int currentPage,int boardNo) {
		Map<String, Object> map = new HashMap<String,Object>();
		int beginRow = (currentPage-1)*10;
		map.put("beginRow",beginRow);
		map.put("boardNo", boardNo);
		List<BoardComment> list = boardCommentDao.selectBoardComment(map);
		Map<String, Object> returnMap = new HashMap<String,Object>();
		returnMap.put("list", list);
		int total = boardCommentDao.totalBoardComment();
		int lastPage = 0;
		if(total%10==0) {
			lastPage = total/10;
		} else {
			lastPage = (total/10)+1;
		}
		returnMap.put("lastPage", lastPage);
		return returnMap;
	}
}

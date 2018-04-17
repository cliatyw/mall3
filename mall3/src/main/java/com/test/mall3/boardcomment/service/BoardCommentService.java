package com.test.mall3.boardcomment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardCommentService {

	@Autowired
	private BoardCommentDao boardCommentDao;
	
	public int insertrBoardComment(BoardComment boardComment) {
		int row = boardCommentDao.insertBoardComment(boardComment);
		return row;
	}
	
}

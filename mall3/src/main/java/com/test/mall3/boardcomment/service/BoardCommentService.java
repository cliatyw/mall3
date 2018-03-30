package com.test.mall3.boardcomment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardCommentService {

	@Autowired
	private BoardCommentDao boardCommentDao;
	public void addBoardComment(BoardComment boardComment) {
		boardCommentDao.insertBoardComment(boardComment);
	}
}

package com.test.mall3.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall3.member.service.MemberService;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	public void addBoard(Board board) {
		boardDao.insertBoard(board);
		logger.info(boardDao.insertBoard(board)+"<--dao호출성공");
	}
	
}

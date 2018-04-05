package com.test.mall3.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall3.member.service.MemberService;

@Repository
public class BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public String insertBoard(Board board) {
		logger.info(board.getBoardTitle()+"<--title");
		logger.info(board.getBoardContent()+"<--content");
		return "insertBoard";
	}
}

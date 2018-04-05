package com.test.mall3.boardcomment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.test.mall3.member.service.MemberService;

@Repository
public class BoardCommentDao {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	public String insertBoardComment(BoardComment boardComment) {
		
		logger.info(boardComment.getCommentContent());
		return "insertBoardComment";
	}
}

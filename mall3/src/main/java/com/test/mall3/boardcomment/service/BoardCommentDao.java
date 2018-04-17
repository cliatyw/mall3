package com.test.mall3.boardcomment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall3.member.service.MemberService;

@Repository
public class BoardCommentDao {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS="com.test.mall3.board.service.BoardCommentMapper.";
	
	public int insertBoardComment(BoardComment BoardComment) {
		int row = sqlSession.insert(NS+"insertBoardComment", BoardComment);
		return row;
	}
}

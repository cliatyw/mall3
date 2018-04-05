package com.test.mall3.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall3.member.service.MemberService;

@Repository
public class BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.mall3.board.service.BoardMapper.";

	public List<Board> selectBoardList(){
		return sqlSession.selectList(NS+"selectBoardList");
	}
	public int insertBoard(Board board) {
		logger.info("insertBoard");
		int row = sqlSession.insert(NS+"insertBoard", board);
		return row;
	}
}

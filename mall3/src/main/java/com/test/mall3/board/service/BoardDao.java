package com.test.mall3.board.service;

import java.util.List;
import java.util.Map;

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

	public List<Board> selectBoardList(Map<String, Object> map){
		return sqlSession.selectList(NS+"selectBoardList", map);
	}
	
	public int insertBoard(Board board) {
		logger.info("insertBoard");
		int row = sqlSession.insert(NS+"insertBoard", board);
		return row;
	}
	
	public int totalCountBoard() {
		return sqlSession.selectOne(NS+"totalCountBoard");
	}
	
	public int deleteBoard(int boardNo) {
		int row = sqlSession.delete(NS+"deleteBoard", boardNo);
		return row;
	}
	
	public int updateBoard(Board board) {
		int row = sqlSession.update(NS+"updateBoard", board);
		return row;
	}
}

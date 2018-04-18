package com.test.mall3.boardcomment.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall3.board.service.Board;
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
	
	public List<BoardComment> selectBoardComment(int boardNo){
		return sqlSession.selectList(NS+"selectBoardComment",boardNo);
	}
	
	/*댓글등록시 게시판화면을 보여주기위한 검색*/
	public List<Board> selectBoardCommentList(){
		return sqlSession.selectList(NS+"selectBoardCommentList");
	}
}

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
	/*댓글 수정,삭제시 memberId확인*/
	public List<BoardComment> selectBoardCommentMemberId(){
		return sqlSession.selectList(NS+"selectBoardCommentMemberId");
	}
	/*댓글수정*/
	public int updateBoardComment(BoardComment boardComment) {
		int row = sqlSession.update(NS+"updateBoardComment", boardComment);
		return row;
	}
	/*댓글삭제*/
	public int deleteBoardComment(int commentNo) {
		int row = sqlSession.delete(NS+"deleteBoardComment", commentNo);
		return row;
	}
}

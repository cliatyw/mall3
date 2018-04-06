package com.test.mall3.member.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall3.member.service.Member;

@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final String NS = "com.test.mall3.member.service.MemberMapper.";
	/*
	 * member를 매개변수로 받아 아이디와 비번이 일치하는 member를 리턴받는 매서드
	 * return member
	 */
	public Member selectMemberById(Member member) {
		return sqlSession.selectOne(NS+"selectMemberById", member);
	}
	/*
	 * member전체 수를 세 리턴을 받는 메서드
	 * return int
	 */
	public int totalCountMember() {
		return sqlSession.selectOne(NS+"totalCountMember");
	}
	/*
	 * member전체 목록을 받아 list로 리턴받는 메서드
	 * return list
	 */
	public List<Member> selectMemberList(Map<String, Integer> map){
		return sqlSession.selectList(NS+"selectMemberList", map);
	}
	/*
	 * Member를 매개변수로 받아 삽입하는 메서드
	 * param member
	 * return row
	 */
	public int insertMember(Member member) {
		logger.info("insertMember");
		int row = sqlSession.insert(NS+"insertMember", member);
		return row;
	}
}

package com.test.mall3.member.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall3.IndexController;

@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final String NS = "com.test.mall3.member.service.MemberMapper.";
	/*
	 * Member를 매개변수로 받아 삽입하는 매서드
	 */
	public int insertMember(Member member) {
		logger.info("insertMember");
		int row = sqlSession.insert(NS + "insertMember", member);
		return row;
	}
}

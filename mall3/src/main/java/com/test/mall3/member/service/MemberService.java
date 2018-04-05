package com.test.mall3.member.service;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	public int addMember(Member member) {
		logger.debug("%s", "member");
		int row = memberDao.insertMember(member);
		return row;
	}

}

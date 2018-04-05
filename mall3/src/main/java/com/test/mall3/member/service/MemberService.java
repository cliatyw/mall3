package com.test.mall3.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	public List<Member> getMemberList() {
		return memberDao.selectMemberList();
	}
	
	public int addMember(Member member) {
		logger.debug("member");
		int row = memberDao.insertMember(member);
		return row;
	}

}

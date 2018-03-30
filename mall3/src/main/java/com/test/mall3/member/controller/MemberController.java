package com.test.mall3.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall3.member.service.Member;
import com.test.mall3.member.service.MemberDao;
import com.test.mall3.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	// addMember get
	// addMember post -> MemberService.addMember() -> MemberDao.insertMember()
	@RequestMapping(value="/addMember", method=RequestMethod.GET)
	public String addMember() {
		return "/member/addMember";
	}
	
	@RequestMapping(value="/addMember", method=RequestMethod.POST)
	public String addMember(Member member) {
		memberService.addMember(member);
		return "/member/getMemberList";
	}
}

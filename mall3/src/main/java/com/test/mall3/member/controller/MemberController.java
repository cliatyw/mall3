package com.test.mall3.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.mall3.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	// addMember get
	// addMember post -> MemberService.addMember() -> MemberDao.insertMember()
}

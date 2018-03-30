package com.test.mall3.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall3.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	// addMember get
	// addMember post -> MemberService.addMember() -> MemberDao.insertMember()
	
	@RequestMapping(value="/getMember", method=RequestMethod.GET)
	public String getMember(Model model, HttpSession session) {
		String name = memberService.getMember();
		// service호출 -> repository
		// service리턴 -> repository
		// return : "jjdev"
		// request.setAttribute("name", "jjdev")
		// view(jsp) : $(name)
		
		
		model.addAttribute("name", name);
		return "getMember";
	}

}

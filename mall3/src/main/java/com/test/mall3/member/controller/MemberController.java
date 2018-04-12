package com.test.mall3.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall3.member.service.Member;
import com.test.mall3.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	/*
	 * delete 매핑
	 */
	@RequestMapping(value= "/deleteMember", method=RequestMethod.GET)
	public String deleteMember(Member member) {
		memberService.deleteMember(member);
		return "redirect:/getMemberList";
	}
	/*
	 * update 매핑
	 * get방식은 한개의 맴버를 받아 model에 셋팅
	 * post방식은 맴버를 수정하고 리스트로 돌아감
	 */
	@RequestMapping(value= "/updateMember", method=RequestMethod.POST)
	public String selectMemberOne(Member member) {
		memberService.updateMember(member);
		return "redirect:/getMemberList";
	}
	
	@RequestMapping(value= "/updateMember", method=RequestMethod.GET)
	public String updateMember(Model model, Member member) {
		model.addAttribute("member", memberService.selectMemberOne(member));
		return "/member/updateMember";
	}
	/*
	 * 로그인 : 로그인 화면으로 가고 성공할시 session에 저장한 후 index로 리다이렉트
	 * 로그아웃 : 세션 종료 하고 index로 리다이렉트
	 */
	@RequestMapping(value= "/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginMember");
		return "redirect:/";
	}
	
	@RequestMapping(value= "/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public String loging(Model model, Member member, HttpSession session) {
		Member returnMember = memberService.selectMemberById(member);
		/*
		 * 로그인이 실패하면 입력받은 값을 requestMember로 세션에 세팅하여 포워드하여 사용하고
		 * 로그인에 성공하면 loginMember로 세션에 세팅하여 리다이렉트 시킨다.
		 */
		if(returnMember == null) {
			model.addAttribute("requestMember", member);
			return "login";
		}
		session.setAttribute("loginMember", member);
		return "redirect:/index";
	}
	/*
	 * get 방식은 바로 jsp로
	 * post 방식은 service에서 addMember 호출하고 Dao에서 insertMember호출
	 */
	@RequestMapping(value="/addMember", method=RequestMethod.GET)
	public String addMember() {
		return "/member/addMember";
	}
	
	@RequestMapping(value="/addMember", method=RequestMethod.POST)
	public String addMember(Member member) {
		memberService.addMember(member);
		return "redirect:/getMemberList";
	}
	/*
	 * currentPage의 기본값을 1로 하고 pagePerRow의 기본값을 10으로 하여 service를 호출한다.
	 * (pagePerRow를 기본값 설정을 안하고 하는 방법이 없을까?)
	 * pagePerRow 를 셋팅하여 jsp에서 사용하도록 하였다.
	 */
	@RequestMapping(value="/getMemberList", method=RequestMethod.GET)
	public String getMemberList(Model model
			, @RequestParam(value="currentPage", defaultValue="1") int currentPage
			, @RequestParam(value="pagePerRow", defaultValue="10", required=true) int pagePerRow) {
		Map<String, Object> map = memberService.getMemberList(currentPage, pagePerRow);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		return "/member/getMemberList";
	}
}

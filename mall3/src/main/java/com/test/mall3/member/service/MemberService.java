package com.test.mall3.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	/*
	 * member를 매개변수로 받아 dao에서 update를 호출하여 수정하는 매서드
	 */
	public int updateMember(Member member) {
		int row = memberDao.updateMember(member);
		return row;
	}
	/*
	 * dao에서 select를 호출하여 한개의 member를 리턴하는 서비스
	 */
	public Member selectMemberOne(Member member) {
		return memberDao.selectMemberOne(member);
	}
	/*
	 * dao 에서 deleteMember 를 호출하여 한개를 삭제하는 서비스
	 */
	public int deleteMember(Member member) {
		int row = memberDao.deleteMember(member);
		return row;
	}
	/*
	 * 로그인을 위해 id, pw 일치 여부를 가져오는 service
	 */
	public Member selectMemberById(Member member){
		return memberDao.selectMemberById(member);
	}
	/*
	 * currentPage, pagePerRow를 매개변수로 받아 list와 lastPage를 구한 후 매핑하여 리턴한다.
	 */
	public Map<String, Object> getMemberList(int currentPage, int pagePerRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		/*
		 * currentPage 와 pagePerRow 활용하여 beginRow를 구한다
		 */
		int beginRow = (currentPage-1)*pagePerRow;
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Member> list = memberDao.selectMemberList(map);
		/*
		 * total 와 pagePerRow 활용하여 lastPage를 구한다
		 */
		int total = memberDao.totalCountMember();
		int lastPage = 0;
		if(total%pagePerRow == 0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow+1;
		}
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		
		return returnMap;
	}
	/*
	 * member 매개변수로 받아 dao에 insert를 호출하여 row로 리턴받는다.
	 */
	public int addMember(Member member) {
		logger.debug("member");
		int row = memberDao.insertMember(member);
		return row;
	}
}

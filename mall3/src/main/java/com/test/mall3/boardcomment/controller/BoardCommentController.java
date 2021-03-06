package com.test.mall3.boardcomment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.test.mall3.board.service.Board;
import com.test.mall3.boardcomment.service.BoardComment;
import com.test.mall3.boardcomment.service.BoardCommentService;
import com.test.mall3.member.service.Member;

@Controller
public class BoardCommentController {
	
	@Autowired
	private BoardCommentService boardCommentService;
	/*게시판, 댓글목록(페이징)*/
	@RequestMapping(value="/getBoardCommentList", method=RequestMethod.GET)
	public String getBoardCommentList(Model model,Board board,
									@RequestParam(value="currentPage",defaultValue="1")int currentPage) {
		model.addAttribute("board", board);
		int boardNo = board.getBoardNo();
		Map<String, Object> map = boardCommentService.getBoardCommentList(currentPage, boardNo);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		List<BoardComment> list2 = boardCommentService.selectBoardCommentMemberId();
		model.addAttribute("memberId", list2);
		return "/boardcomment/getBoardCommentList";
	}
	
	/*댓글등록*/
	@RequestMapping(value="/getBoardCommentList", method=RequestMethod.POST)
	public String insertBoardCommentList(Model model,
										@RequestParam(value="currentPage",defaultValue="1")int currentPage,
										HttpSession session,BoardComment boardComment,Board board) {
		String memberId = (String) session.getAttribute("loginMemberId");
		boardComment.setMemberId(memberId);
		model.addAttribute("board", board);	
		boardCommentService.insertrBoardComment(boardComment);
		int boardNo= board.getBoardNo();
		Map<String, Object> map = boardCommentService.getBoardCommentList(currentPage,boardNo);
		model.addAttribute("list", map.get("list"));
		List<BoardComment> list2 = boardCommentService.selectBoardCommentMemberId();
		model.addAttribute("memberId", list2);
		return "/boardcomment/getBoardCommentList";
	}
	/*댓글수정*/
	@RequestMapping(value="/updateBoardComment", method=RequestMethod.POST)
	public String updateBoardComment(@RequestParam(value="currentPage",defaultValue="1")int currentPage,
									@RequestParam("updateCommentContent") String updateCommentContent,
								     Model model,
									 BoardComment boardComment,
								     Board board) {
		boardComment.setCommentContent(updateCommentContent);
		boardCommentService.updateBoardComment(boardComment);
		model.addAttribute("board", board);	
		int boardNo= board.getBoardNo();
		Map<String, Object> map = boardCommentService.getBoardCommentList(currentPage,boardNo);
		model.addAttribute("list", map.get("list"));
		return "/boardcomment/getBoardCommentList";
	}
	/*댓글삭제*/
	@RequestMapping(value="/deleteBoardComment", method=RequestMethod.POST)
	public String deleteBoardComment(@RequestParam(value="currentPage",defaultValue="1")int currentPage,
									@RequestParam("commentNo") int commentNo,
									Model model, 
									Board board) {
		System.out.println(commentNo+"<--댓글삭제번호");
		boardCommentService.deleteBoardComment(commentNo);
		int boardNo= board.getBoardNo();
		Map<String, Object> map = boardCommentService.getBoardCommentList(currentPage,boardNo);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("board", board);	
		return "/boardcomment/getBoardCommentList";
	}
}

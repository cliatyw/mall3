package com.test.mall3.boardcomment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall3.board.service.Board;
import com.test.mall3.boardcomment.service.BoardComment;
import com.test.mall3.boardcomment.service.BoardCommentService;

@Controller
public class BoardCommentController {
	
	@Autowired
	private BoardCommentService boardCommentService;
	@RequestMapping(value="/getBoardCommentList", method=RequestMethod.GET)
	public String getBoardCommentList(Model model,
									@RequestParam(value="boardTitle") String boardTitle,
									@RequestParam(value="memberId") String memberId,
									@RequestParam(value="boardNo") int boardNo,
									@RequestParam(value="boardContent") String boardContent,
									@RequestParam(value="boardDate") String boardDate) {
		model.addAttribute("boardTitle", boardTitle);
		model.addAttribute("memberId", memberId);
		model.addAttribute("boardNo", boardNo);
		model.addAttribute("boardContent", boardContent);
		model.addAttribute("boardDate", boardDate);
		return "/boardcomment/getBoardCommentList";
	}
	
	/*댓글등록시 댓글목록보여주기*/
	@RequestMapping(value="/getBoardCommentList", method=RequestMethod.POST)
	public String insertBoardCommentList(Model model,
									@RequestParam(value="boardTitle") String boardTitle,
									@RequestParam(value="memberId") String memberId,
									@RequestParam(value="boardNo") int boardNo,
									@RequestParam(value="boardContent") String boardContent,
									@RequestParam(value="boardDate") String boardDate,
									BoardComment boardComment) {
		model.addAttribute("boardTitle", boardTitle);
		model.addAttribute("memberId", memberId);
		model.addAttribute("boardNo", boardNo);
		model.addAttribute("boardContent", boardContent);
		model.addAttribute("boardDate", boardDate);
		
		boardCommentService.insertrBoardComment(boardComment);
		List<BoardComment> list = boardCommentService.selectBoardComment();
		model.addAttribute("list", list);
		model.addAttribute("boardComment", boardComment);
		System.out.println(boardComment);
		return "/boardcomment/getBoardCommentList";
	}
	
	
}
